package com.company.hackathon.service;

import java.io.IOException;
import java.util.List;

public interface FileWriterCustom {

    void writeInFile(List<Integer> data) throws IOException;
}
