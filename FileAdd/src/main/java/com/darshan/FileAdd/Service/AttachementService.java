package com.darshan.FileAdd.Service;

import org.springframework.web.multipart.MultipartFile;
import com.darshan.FileAdd.entity.Attachment;

public interface AttachementService {
	Attachment saveAttachment(MultipartFile file) throws Exception;

	Attachment getAttachement(String fileId) throws Exception;

}
