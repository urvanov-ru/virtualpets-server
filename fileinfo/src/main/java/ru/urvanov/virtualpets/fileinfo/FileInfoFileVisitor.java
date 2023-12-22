/**
 * 
 */
package ru.urvanov.virtualpets.fileinfo;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author fedya
 *
 */
class FileInfoFileVisitor extends SimpleFileVisitor<Path> {

    private Map<String, FileInfo> fileInfos = new HashMap<String, FileInfo>();
    
    private Path folder;
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException {
        System.out.println("VISIT FILE:" + file.toString());
        FileTime lastModifiedTime = attrs.lastModifiedTime();
        //long modified = lastModifiedTime == null ? 0 : lastModifiedTime.to(TimeUnit.MINUTES);
        FileInfo fileInfo = new FileInfo(lastModifiedTime, attrs.size());
        fileInfos.put(folder.relativize(file).toString().replace(file.getFileSystem().getSeparator(), "/"), fileInfo);
        return FileVisitResult.CONTINUE;
    }

    public Map<String, FileInfo> getFileInfos() {
        return fileInfos;
    }

    public Path getFolder() {
        return folder;
    }

    public void setFolder(Path folder) {
        this.folder = folder;
    }

    

}
