package com.company;

import com.company.hackathon.Solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        final String inputFile = "input.txt";
        final String outputFile = "output.txt";


        Solution hack = new Solution(inputFile,outputFile);
        try {
            hack.solution();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
