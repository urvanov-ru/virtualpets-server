/**
 * 
 */
package ru.urvanov.virtualpets.fileinfo;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

/**
 * @author Урванов Фёдор Владиславович
 * 
 */
public class FileListGenerator {

    /**
     * 
     */
    public FileListGenerator() {
        // TODO Auto-generated constructor stub
    }

    public static Map<String, FileInfo> generateFileList(Path folder)
            throws IOException {
        FileInfoFileVisitor fileInfoFileVisitor = new FileInfoFileVisitor();
        fileInfoFileVisitor.setFolder(folder);
        Files.walkFileTree(folder, fileInfoFileVisitor);
        return fileInfoFileVisitor.getFileInfos();
    }

    public static int calculateCRC(File file) throws FileNotFoundException,
            IOException {

        DataInputStream instream = new DataInputStream(new BufferedInputStream(
                new FileInputStream(file)));
        try {
            int res = 0;
            while (instream.available() > Integer.SIZE) {
                int x = instream.readInt();
                res ^= x;
            }
            return res;
        } finally {
            instream.close();
        }

    }

}
