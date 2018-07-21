package com.kodilla.exception.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.lang.String;

public class FileReaderWithoutHandling { public void readFile() {

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("file/names.txt").getFile());


        }
}


