package com.darshan.FileAdd.Service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import com.darshan.FileAdd.Repository.AttachementRepo;
import com.darshan.FileAdd.entity.Attachment;

@Service
public class ServiceImpl implements AttachementService {

    private final AttachementRepo attachementRepo;

    public ServiceImpl(AttachementRepo attachementRepo) {
        this.attachementRepo = attachementRepo;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (filename.contains("..")) {
                throw new Exception("Filename contains invalid path sequence: " + filename);
            }

            Attachment attachment = new Attachment(filename, file.getContentType(), file.getBytes());
            return attachementRepo.save(attachment);
        } catch (Exception e) {
            throw new Exception("Could not save file: " + filename, e);
        }
    }

	@Override
	public Attachment getAttachement(String fileId) throws Exception {
		
		return attachementRepo.findById(fileId).orElseThrow(()->new Exception("file not found with id :"+fileId));
	}

}
