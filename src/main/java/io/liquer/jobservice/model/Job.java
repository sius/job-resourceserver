package io.liquer.jobservice.model;

import java.util.Date;

public class Job {
	private String id;
	private String ownerId;
	private Date retentionTime;
	private byte[] file;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public Date getRetentionTime() {
		return retentionTime;
	}

	public void setRetentionTime(Date retentionTime) {
		this.retentionTime = retentionTime;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
}


