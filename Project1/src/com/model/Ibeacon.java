package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class Ibeacon {

	private int runId;
	private String patientId;
	private String ibeaconId;
	private String bedId;
	private BigDecimal speed;
	private Date insertTime;
	private int status;
	
	
	private String drugId1;
	private BigDecimal drugCc1;
	private String drugId2;
	private BigDecimal drugCc2;
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int getRunId() {
		return runId;
	}
	public void setRunId(int runId) {
		this.runId = runId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getIbeaconId() {
		return ibeaconId;
	}
	public void setIbeaconId(String ibeaconId) {
		this.ibeaconId = ibeaconId;
	}
	public String getBedId() {
		return bedId;
	}
	public void setBedId(String bedId) {
		this.bedId = bedId;
	}
	public BigDecimal getSpeed() {
		return speed;
	}
	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDrugId1() {
		return drugId1;
	}
	public void setDrugId1(String drugId1) {
		this.drugId1 = drugId1;
	}
	public BigDecimal getDrugCc1() {
		return drugCc1;
	}
	public void setDrugCc1(BigDecimal drugCc1) {
		this.drugCc1 = drugCc1;
	}
	public String getDrugId2() {
		return drugId2;
	}
	public void setDrugId2(String drugId2) {
		this.drugId2 = drugId2;
	}
	public BigDecimal getDrugCc2() {
		return drugCc2;
	}
	public void setDrugCc2(BigDecimal drugCc2) {
		this.drugCc2 = drugCc2;
	}
	
	
	
	
	
}
