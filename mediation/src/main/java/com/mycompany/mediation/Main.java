/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
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
//        System.out.println(folder_path);
//        System.out.println(dest_folder);

        while (checking) {
            boolean check = checkIfNotEmpty(folder_path.toString());
            if (check == true) {
                newCDR = true;
                break;
            }
        }
        if (newCDR == true) {
            System.out.println("new CDR uploaded");
            File my_cdr = getCDR(folder_path.toString());
           
            if(my_cdr != null){
                String[] columns;
                BufferedReader in = new BufferedReader(new FileReader(my_cdr));
                String line;
                while((line = in.readLine()) != null){
                   columns = line.split(",");
//                   for(String c : columns){
//                      System.out.println(c);
//                   }
                   System.out.println(columns[2]);
               
//                   int service_id = Integer.parseInt(columns[2]);
//                   int rateplan_id = Integer.parseInt(columns[3]);
//                   CDR cdr = new CDR(columns[0], columns[1], service_id, rateplan_id, columns[4], columns[5]);
//                   DatabaseManagement data = new DatabaseManagement();
//                   data.insertCDR(cdr);
                }
            
                in.close();
                
            }else{
               System.out.println("Please archive unneeded CDRs first");
            
            }
        }
    }
}
