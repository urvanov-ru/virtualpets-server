package ru.urvanov.virtualpets.fileinfo;

import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;

public class FileInfo {
    public FileTime modified;
    public long size = 0;

    public FileInfo(FileTime modified, long size) {
        this.modified = modified;
        this.size = size;
    }
    
    public FileInfo(long modified, long size) {
        this(FileTime.fromMillis(modified), size);
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof FileInfo))
            return false;
        FileInfo fi = (FileInfo) other;
        long m1 = this.modified == null ? 0 : this.modified.to(TimeUnit.MINUTES);
        long m2 = fi.modified == null ? 0 : fi.modified.to(TimeUnit.MINUTES);
        return (m1 == m2 && size == fi.size);
    }
}