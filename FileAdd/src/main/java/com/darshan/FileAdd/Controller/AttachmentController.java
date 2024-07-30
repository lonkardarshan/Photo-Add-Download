package com.darshan.FileAdd.Controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.darshan.FileAdd.Service.AttachementService;
import com.darshan.FileAdd.entity.Attachment;
import com.darshan.FileAdd.fileMngt.ResponsData;

@RestController
public class AttachmentController {

    private final AttachementService attachementService;

    public AttachmentController(AttachementService attachementService) {
        this.attachementService = attachementService;
    }

    @PostMapping("/upload")
    public ResponsData uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Attachment attachment = attachementService.saveAttachment(file);
        String downloadUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/download/")
                .path(attachment.getId())
                .toUriString();

        return new ResponsData(
                attachment.getFilename(),
                downloadUrl,
                file.getContentType(),
                file.getSize()
        );
    }
    
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        Attachment attachment = attachementService.getAttachement(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(attachment.getFiletype())) // Use correct contentType
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + attachment.getFilename() + "\"")
                .body(new ByteArrayResource(attachment.getData())); // Use correct data field
    }
}
