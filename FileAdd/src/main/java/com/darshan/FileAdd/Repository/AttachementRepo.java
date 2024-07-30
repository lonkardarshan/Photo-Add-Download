package com.darshan.FileAdd.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darshan.FileAdd.entity.Attachment;
@Repository
public interface AttachementRepo extends JpaRepository<Attachment, String> {

}
