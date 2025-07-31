package org.pdfdemo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, allowCredentials = "true")
public class PDFController {
    private static final String UPLOAD_DIR = "./uploads/";
    @PostMapping("/upload")
    public String uploadPDF (@RequestParam("file") MultipartFile file) {
        try {
            Path uploadPath = Paths.get(UPLOAD_DIR);
            if(!Files.exists(uploadPath)) {
                Files.createDirectory(uploadPath);
            }

            if(!file.getContentType().equals("application/pdf")) {
                return "Error: Only PDF files alowed";
            }

            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            Files.write(filePath, file.getBytes());

            return "PDF uploaded: " + fileName;
        } catch (IOException e) {
            return "Error uploading PDF: " + e.getMessage();
        }
    }
}
