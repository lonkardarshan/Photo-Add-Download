package com.darshan.FileAdd.entity;

import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;

@Entity
@Data
public class Attachment {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String filename;
    private String filetype;

    @Lob
    private byte[] data;

    public Attachment(String filename, String filetype, byte[] data) {
        this.filename = filename;
        this.filetype = filetype;
        this.data = data;
    }
    

	/**
	 * 
	 */
	public Attachment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}



	 

}
