/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mediation;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 *
 * @author nour
 */
public class Main {
    
    private static boolean newCDR = false;
    private static boolean checkIfNotEmpty(String dir_name) {
        File directory = new File(dir_name);
        File[] files_arr = directory.listFiles();
        if (files_arr.length == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(final String[] args) throws URISyntaxException {
        String path = System.getProperty("user.dir");
        Path p = Paths.get(path);
        Path folder_path = Paths.get(p.getParent() + "/CDRs/");
        System.out.println(folder_path);

        while (true) {
            boolean check = checkIfNotEmpty(folder_path.toString());
            if (check == true) {
                  newCDR = true;

            }
        }
    }
}
