/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediation;

import mediation.database.DatabaseManagement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import mediation.model.CDR;

/**
 *
 * @author nour
 */
public class Main {

    private static boolean newCDR = false;
    private static boolean checking = true;

    private static boolean checkIfNotEmpty(String dir_name) {
        File directory = new File(dir_name);
        File[] files_arr = directory.listFiles();
        if (files_arr.length == 0) {
            return false;
        } else {
            return true;
        }
    }

    private static File getCDR(String dir_name) {
        File directory = new File(dir_name);
        File[] files_arr = directory.listFiles();
        if (files_arr.length == 1) {
            return files_arr[0];
        } else {
            return null;
        }
    }

    public static void main(final String[] args) throws FileNotFoundException, IOException {
        String path = System.getProperty("user.dir");
        Path p = Paths.get(path);
        Path folder_path = Paths.get(p.getParent() + "/CDRs/");
        Path dest_folder = Paths.get(p.getParent() + "/Archived_CDRs/");

        while (checking) {
            boolean check = checkIfNotEmpty(folder_path.toString());
            if (check == true) {
                newCDR = true;
                if (newCDR == true) {
                    System.out.println("new CDR uploaded");
                    File my_cdr = getCDR(folder_path.toString());

                    if (my_cdr != null) {
                        String[] columns;
                        DatabaseManagement data = new DatabaseManagement();
                        BufferedReader in = new BufferedReader(new FileReader(my_cdr));
                        String line;
                        while ((line = in.readLine()) != null) {
                            columns = line.split(",");
//                   for(String c : columns){
//                      System.out.println(c);
//                   }

                            int service_id = Integer.parseInt(columns[2]);
                            int rateplan_id = Integer.parseInt(columns[3]);
                            LocalDate date = LocalDate.parse(columns[4]);
                            LocalTime time = LocalTime.parse(columns[5]);
                            time.truncatedTo(ChronoUnit.SECONDS);
                            CDR cdr = new CDR(columns[0], columns[1], service_id, rateplan_id, date, time);
                            data.insertCDR(cdr);
                        }

                        in.close();
                        Path origin_folder = Paths.get(folder_path.toString(), my_cdr.getName());
                        Files.move(origin_folder, dest_folder.resolve(my_cdr.getName()), StandardCopyOption.REPLACE_EXISTING);

                    } else {
                        System.out.println("Please archive unneeded CDRs first");
                        break;

                    }
                }
            }
        }

    }
}
