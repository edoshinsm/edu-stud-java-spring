package myapp.controller;

import myapp.dto.DirectoryContent;
import myapp.service.FileManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileManagerController {
    private FileManagerService fileManagerService;

    FileManagerController(FileManagerService fileManagerService) {
        this.fileManagerService = fileManagerService;
    }

    @GetMapping("/")
    public String fileManager(@RequestParam(required = false) String path, Model model) {
        try {
            if (path != null && !path.isBlank()) {
                DirectoryContent dc = fileManagerService.getDirContent(path);
                model.addAttribute("currentPath", path);
                model.addAttribute("dirs", dc.getDirectoryMetadataList());
                model.addAttribute("files", dc.getFileMetadataList());
                Path parentPath = Paths.get(path).getParent();
                if (parentPath == null) {
                    model.addAttribute("parentPath", null);
                } else {
                    model.addAttribute("parentPath", parentPath.toString());
                }
            } else {
                model.addAttribute("currentPath", "");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Ошибка: " + e.getMessage());
        }
        return "file";
    }
}
