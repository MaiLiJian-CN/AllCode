package com.yichen.printstream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewIODemo {
    public static void main(String[] args) throws IOException {
//        Files.copy(Path.of("D:\\BaiduNetdiskDownload\\牧马人 (1982).mp4"), Path.of("D:\\BaiduNetdiskDownload\\牧马人.mp4"));
        Files.delete(Path.of("D:\\BaiduNetdiskDownload\\牧马人.mp4"));
    }
}
