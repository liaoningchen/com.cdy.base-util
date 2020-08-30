package com.cdy.base.util.util;

import java.io.File;


public class FileUtil {

    public static void mkdirIfNotExists(String dirPath) {
        File dir = new File(dirPath);
        if (dir.exists() && !dir.isDirectory()) {
            throw new RuntimeException("create directory failure. dirPath:" + dirPath + " is a file");
        }
        if (!dir.exists() && !dir.mkdir()) {
            throw new RuntimeException("create directory failure. dirPath:" + dirPath);
        }
    }

}
