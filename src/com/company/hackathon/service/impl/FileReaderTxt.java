package com.company.hackathon.service.impl;

import com.company.hackathon.service.FileReaderCustom;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class FileReaderTxt implements FileReaderCustom {
    private final String url;

    public FileReaderTxt(String url) {
        this.url = url;
    }

    @Override
    public List<String> getContent() throws FileNotFoundException {
        List<String> lst = new LinkedList<>();
        File file = new File(url);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                lst.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lst;
    }

    @Override
    public List<Integer> getLineNumbers(String toConvert) {
        List<Integer> convertedData = new LinkedList<>();
        String[] data = toConvert.split(" ");

        for (String item : data) {
            convertedData.add(Integer.parseInt(item));
        }
        return convertedData;
    }

}
