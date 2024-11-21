package com.example.web_inventory.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {
    
    public static boolean UploadImage(MultipartFile image) {
        
        boolean successfulUpload = false;

        if(!image.isEmpty()) {
            String fileName = image.getOriginalFilename();

            try {

                String folderUpload = "scr/main/resources/static/images/uploads";

                File dir  = new File(folderUpload);

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File serverFile = new File(dir.getAbsolutePath() + File.separator + fileName);

                try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile))) {
                    stream.write(image.getBytes());
                    successfulUpload = true;
                }

                System.out.println("Stored in " + serverFile.getAbsolutePath());
                System.out.println("Upload successful: " + fileName);

            } catch (IOException e) {
                System.out.println("Try again. Error: " + fileName + "=>" + e.getMessage());
                successfulUpload = false;
            }
        } else {
            System.out.println("No file found.");
            successfulUpload = false;
        }

        return successfulUpload;
    }
}
