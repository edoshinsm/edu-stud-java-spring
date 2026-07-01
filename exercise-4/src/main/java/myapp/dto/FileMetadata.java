package myapp.dto;

public record FileMetadata (
        String name,
        String path,
        long size,
        String lastModified
) {}
