package com.company.hackathon;

import com.company.hackathon.impl.FileReaderTxt;
import com.company.hackathon.impl.FileWriterCustomImpl;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    private final FileReaderCustom fileReader;
    private final FileWriterCustom fileWriter;
    private List<String> fileContent;
    private final List<List<Integer>> convertedData = new LinkedList<>();
    private final List<Integer> resultData = new LinkedList<>();

    public Solution(String inputFile, String outputFile) {
        String fileBasePath = new File("").getAbsolutePath() + "/src/com/company/hackathon/files/";
        fileReader = new FileReaderTxt(fileBasePath + inputFile);
        fileWriter = new FileWriterCustomImpl(fileBasePath + outputFile);
    }

    public void solution() throws IOException {

        fileContent = fileReader.getContent();
        convertAndValidate();
        for (List<Integer> item : convertedData) {
            resultData.add(process(item));
        }

        fileWriter.writeInFile(resultData);

    }


    private void convertAndValidate() {
        for (String item : fileContent) {
            List<Integer> data = fileReader.getLineNumbers(item);
            try {
                Validator.validate(data);
            } catch (IllegalArgumentException ex) {
                List<Integer> d = new LinkedList<>();
                d.add(-1);
                convertedData.add(d);
                continue;
            }
            convertedData.add(data);
        }
    }


    private int process(List<Integer> data) {
        if (data.size() == 1 && data.get(0)==-1) {
            return -1;
        }
        int incl = data.get(0);
        int excl = 0;
        int excl_new;
        for (int i = 1; i < data.size(); i++) {
            excl_new = Math.max(incl, excl);
            incl = excl + data.get(i);
            excl = excl_new;
        }
        return (Math.max(incl, excl));
    }
}
