package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileOperator {
    private final String filePath;
    private final Path path;

    public FileOperator(String filePath) {
        this.filePath = filePath;
        this.path = Paths.get(filePath);
    }

    public void writeFile(String content) {
        try {
            Files.writeString(path, content, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new FileOperatorException("File write problem", e);
        }
    }

    public String readFile() {
        try {
            return Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FileOperatorException("File read problem", e);
        }
    }
}
