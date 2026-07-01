package myapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.nio.file.attribute.FileTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class DirectoryContent {
    public final List<DirectoryMetadata> directoryMetadataList = new ArrayList<>();
    public final List<FileMetadata> fileMetadataList = new ArrayList<>();

    public void addFile(String name, String path, long size, FileTime lastModified) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                .withZone(ZoneId.systemDefault());
        fileMetadataList.add(new FileMetadata(name, path, size, formatter.format(lastModified.toInstant())));
    }

    public void addDirectory(String name, String path) {
        directoryMetadataList.add(new DirectoryMetadata(name, path));
    }
}
