package com.company.hackathon.service.impl;

import com.company.hackathon.service.FileWriterCustom;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriterCustomImpl implements FileWriterCustom {
    private final String url;

    public FileWriterCustomImpl(String url) {
        this.url = url;
    }

    @Override
    public void writeInFile(List<Integer> data) throws IOException {
        FileWriter fileWriter = new FileWriter(url);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (Integer item : data) {
            printWriter.println(item);
        }
        printWriter.close();
    }
}
