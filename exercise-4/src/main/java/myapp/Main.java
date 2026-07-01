package myapp;

import myapp.service.FileManagerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner testRunner(FileManagerService fileService) {
        return args -> {
            System.out.println("--- ЗАПУСК ТЕСТА ---");

            var directoryContent = fileService.getDirContent("C:\\Users\\serge\\IdeaProjects\\edu-stud-java-spring");

            System.out.println("--- Директории ---");
            for(var dir : directoryContent.getDirectoryMetadataList()) {
                System.out.println(dir.name());
                Path parentPath = Paths.get(dir.path()).toAbsolutePath();
                System.out.println(parentPath);
            }
            System.out.println("--- Файлы ---");
            for(var file : directoryContent.getFileMetadataList()) {
                System.out.println(file.name() + " " + " " + file.size() + " " + file.lastModified());
            }
        };
    }
}
