package com.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientSub {

	private int runId;
	private String patientId;
	private String ibeaconId;
	private String bedId;
	private BigDecimal speed;
	private Date insertTime;
	private String status;
	
	
	
	private String drugId;
	private String drugCc;
	private int drugQuantity;
	
	private List<String> drugIdList = new ArrayList<String>();
	private List<String> drugCcList = new ArrayList<String>();
	
	
	
	
	
	
	
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
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDrugId() {
		return drugId;
	}
	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}
	public String getDrugCc() {
		return drugCc;
	}
	public void setDrugCc(String drugCc) {
		this.drugCc = drugCc;
	}
	public int getDrugQuantity() {
		return drugQuantity;
	}
	public void setDrugQuantity(int drugQuantity) {
		this.drugQuantity = drugQuantity;
	}
	public List<String> getDrugIdList() {
		return drugIdList;
	}
	public void setDrugIdList(List<String> drugIdList) {
		this.drugIdList = drugIdList;
	}
	public List<String> getDrugCcList() {
		return drugCcList;
	}
	public void setDrugCcList(List<String> drugCcList) {
		this.drugCcList = drugCcList;
	}
	
	
	
	
	
}
