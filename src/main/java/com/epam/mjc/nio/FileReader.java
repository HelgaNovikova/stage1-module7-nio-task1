package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String name = "";
        int age = 0;
        String email = "";
        long phone = 0L;
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String str;
            List<String> lines = new ArrayList<>();
            while ((str = in.readLine()) != null) {
                lines.add(str);
            }
            name = lines.get(0).substring(6);
            age = Integer.parseInt(lines.get(1).substring(5));
            email = lines.get(2).substring(7);
            phone = Long.parseLong(lines.get(3).substring(7));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Profile(name, age, email, phone);
    }
}
