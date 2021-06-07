package com.company.hackathon;

import java.util.List;

public class Validator {
    static void validate(List<Integer> data) throws IllegalArgumentException{
        if (data.size() == 0) {
            throw new IllegalArgumentException("Inputed Data is invalid");
        }
        for (int item : data) {
            if (item < 0) {
                throw new IllegalArgumentException("Inputed Data is invalid");
            }
        }

    }
}
