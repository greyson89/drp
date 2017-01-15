package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class MonitorModel {
	private String ibeaconId;
	private String patientId;
	private String patientName;
	private String bedId;
	private String total;
	private String estSpeed;
	private String estEndTime;
	private String remain;
	private String realSpeed;
	private String realEndTime;
	private String difference;
	
	
	//隱藏
	private BigDecimal drip;
	private Date lastInsertTime;
	private String timeClock;
	private Date startTime;
	
	
	
	public String getIbeaconId() {
		return ibeaconId;
	}
	public void setIbeaconId(String ibeaconId) {
		this.ibeaconId = ibeaconId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getBedId() {
		return bedId;
	}
	public void setBedId(String bedId) {
		this.bedId = bedId;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getEstSpeed() {
		return estSpeed;
	}
	public void setEstSpeed(String estSpeed) {
		this.estSpeed = estSpeed;
	}
	public String getEstEndTime() {
		return estEndTime;
	}
	public void setEstEndTime(String estEndTime) {
		this.estEndTime = estEndTime;
	}
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
	public String getRealSpeed() {
		return realSpeed;
	}
	public void setRealSpeed(String realSpeed) {
		this.realSpeed = realSpeed;
	}
	public String getRealEndTime() {
		return realEndTime;
	}
	public void setRealEndTime(String realEndTime) {
		this.realEndTime = realEndTime;
	}
	public BigDecimal getDrip() {
		return drip;
	}
	public void setDrip(BigDecimal drip) {
		this.drip = drip;
	}
	public Date getLastInsertTime() {
		return lastInsertTime;
	}
	public void setLastInsertTime(Date lastInsertTime) {
		this.lastInsertTime = lastInsertTime;
	}
	public String getTimeClock() {
		return timeClock;
	}
	public void setTimeClock(String timeClock) {
		this.timeClock = timeClock;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getDifference() {
		return difference;
	}
	public void setDifference(String difference) {
		this.difference = difference;
	}
	
	
	
}
