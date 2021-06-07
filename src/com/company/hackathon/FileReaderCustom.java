package com.company.hackathon;

import java.io.FileNotFoundException;
import java.util.List;

public  interface FileReaderCustom {



    List<String> getContent() throws FileNotFoundException;

    List<Integer> getLineNumbers(String toConvert);

}
