package myapp.service;

import myapp.dto.DirectoryContent;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileManagerService {
    public DirectoryContent getDirContent(String path) throws IOException {
        DirectoryContent directoryContent = new DirectoryContent();
        File directory = new File(path);

        if(directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if(files == null) {
                throw new IOException();
            }
            for(File file : files) {
                if(file.isDirectory()) {
                    directoryContent.addDirectory(
                            file.getName(),
                            file.getPath()
                    );
                } else {
                    Path filePath = Paths.get(file.getPath());
                    directoryContent.addFile(
                            file.getName(),
                            file.getPath(),
                            Files.size(filePath),
                            Files.getLastModifiedTime(filePath)
                    );
                }
            }
        }

        return directoryContent;
    }
}
