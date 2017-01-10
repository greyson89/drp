package com.model;

import java.math.BigDecimal;
import java.util.Date;

public class IbeaconLog {
	private int id;
	private String ibeaconId;
	private BigDecimal speed;
	private BigDecimal drip;
	private int timeClock;
	private Date insertTime;
	private String rssiIp;
	private BigDecimal rssi;
	private int historyFlag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIbeaconId() {
		return ibeaconId;
	}
	public void setIbeaconId(String ibeaconId) {
		this.ibeaconId = ibeaconId;
	}
	public BigDecimal getSpeed() {
		return speed;
	}
	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}
	public BigDecimal getDrip() {
		return drip;
	}
	public void setDrip(BigDecimal drip) {
		this.drip = drip;
	}
	public int getTimeClock() {
		return timeClock;
	}
	public void setTimeClock(int timeClock) {
		this.timeClock = timeClock;
	}
	public Date getInsertTime() {
		return insertTime;
	}
	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}
	public String getRssiIp() {
		return rssiIp;
	}
	public void setRssiIp(String rssiIp) {
		this.rssiIp = rssiIp;
	}
	public BigDecimal getRssi() {
		return rssi;
	}
	public void setRssi(BigDecimal rssi) {
		this.rssi = rssi;
	}
	public int getHistoryFlag() {
		return historyFlag;
	}
	public void setHistoryFlag(int historyFlag) {
		this.historyFlag = historyFlag;
	}
	
	
	
	
}
