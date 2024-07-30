package com.darshan.FileAdd.fileMngt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponsData {
    private String filename;
    private String downloadUrl;
    private String filetype;
    private long filesize; // Change to long

    public ResponsData(String filename, String downloadUrl, String filetype, long filesize) {
        this.filename = filename;
        this.downloadUrl = downloadUrl;
        this.filetype = filetype;
        this.filesize = filesize;
    }

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
    
}
