package com.example.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @create 2018-04-29 10:55
 **/
public class FileUtil {
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static void main(String[] args) {

        final HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
        }
        System.out.println(map);

    }


    public static String setUserName(User user) {
        user.setName("曹操");
        return user.getName();
    }


    static class User {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}