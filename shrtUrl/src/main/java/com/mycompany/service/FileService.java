package com.mycompany.service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * FileService offers method for read and write from file database
 */
class FileService {

    private static final String FILE_PATH = "db.txt";
    private static final String SEPARATOR = ";";

    /**
     * Reads data from file database
     *
     * @return map of values, key is a url-token, value is url
     */
    static Map<String, String> loadData() {

        Map<String, String> data = new HashMap<>();

        //For first run
        if (!Files.exists(Paths.get(FILE_PATH))) {
            File file = new File(FILE_PATH);
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            String values[];

            while ((line = br.readLine()) != null) {
                values = line.split(SEPARATOR);
                if (values.length == 2) {
                    data.put(values[0], values[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * Saves map into file database
     *
     * @param data data to be saved.
     */
    static void writeFile(Map<String, String> data) {

        StringBuilder builder;
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_PATH, false)))) {

            for (Map.Entry<String, String> entry : data.entrySet()) {

                builder = new StringBuilder();
                bw.write(builder.append(entry.getKey())
                        .append(SEPARATOR)
                        .append(entry.getValue())
                        .append("\n")
                        .toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}