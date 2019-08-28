package com.ho.practice.downloader.dto;

public class Rawdata {
	private String pk;
	private String dataId;
	private String sennsorId;
	private String timekey;
	private String raw;
	private String ttlDate;
	
	public Rawdata() {
	}
	public Rawdata(Rawdata rd) {
		this.pk = rd.getPk();
		this.setDataId(rd.getDataId());
		this.sennsorId = rd.getSennsorId();
		this.timekey = rd.getTimekey();
		this.raw = rd.getRaw();
		this.ttlDate = rd.getTtlDate();
	}
	
	public String getTimekey() {
		return timekey;
	}
	public void setTimekey(String timekey) {
		this.timekey = timekey;
	}
	public String getRaw() {
		return raw;
	}
	public void setRaw(String raw) {
		this.raw = raw;
	}
	public String getSennsorId() {
		return sennsorId;
	}
	public void setSennsorId(String sennsorId) {
		this.sennsorId = sennsorId;
	}
	public String getTtlDate() {
		return ttlDate;
	}
	public void setTtlDate(String ttlDate) {
		this.ttlDate = ttlDate;
	}
	
	public String toString() {
		return dataId + ";" + sennsorId + ";" + timekey + ";" + raw + ";" + ttlDate;
	}
	public String getPk() {
		return pk;
	}
	public void setPk(String pk) {
		this.pk = pk;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	
}
