package com.action;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.model.Ibeacon;
import com.opensymphony.xwork2.ActionSupport;
import com.service.DRPService;
import com.service.IbeaconSerivce;
import com.service.PatientService;

public class IbeaconAction extends ActionSupport {

	private String searchPatientId;
	private int searchRunId;
	private String searchResult;

	private String patientId;
	private String ibeaconId;
	private String bedId;
	private BigDecimal speed;
	private String drugId1;
	private BigDecimal drugCc1;
	private String drugId2;
	private BigDecimal drugCc2;

	private String msg;
	
	public String loadIbeaconHistory() {

		if (searchPatientId.equals("")) {
			searchResult = "未填入病號";
			return "loadIbeaconFail";
		}

		IbeaconSerivce service = new IbeaconSerivce();
		Ibeacon model = service.loadHistory(searchPatientId, searchRunId);
		if (model == null) {
			searchResult = "該資料不存在";
			return "loadIbeaconFail";
		}
		patientId = model.getPatientId();
		speed = model.getSpeed();
		drugId1 = model.getDrugId1();
		drugCc1 = model.getDrugCc1();
		drugId2 = model.getDrugId2();
		drugCc2 = model.getDrugCc2();
		

		return "loadIbeaconSuccess";
	}
	
	
	public String setIbeacon(){
		
		//ibeacon status
		//update patient ibeacon_id,bed_id
		//ibeacon table insert
		
		IbeaconSerivce ibeaconService = new IbeaconSerivce();
		boolean ibeacon = ibeaconService.checkIbeaconStatus(ibeaconId);
		if(ibeacon==false){
			msg = "該ibeacon已配對或使用中";
			return "setIbeaconFail";
		}else{
			PatientService patientService = new PatientService();
			String result1 = ibeaconService.updateIbeaconStatus(ibeaconId);
			DRPService drpService= new DRPService();
			ArrayList<String> drug = new ArrayList<String>();
			ArrayList<BigDecimal> drugCc = new ArrayList<BigDecimal>();
			drug.add(drugId1);
			drug.add(drugId2);
			drugCc.add(drugCc1);
			drugCc.add(drugCc2);
			String result2 = drpService.insertDRP(patientId,ibeaconId,bedId,speed,drug,drugCc);
			if(result1.indexOf("ERROR")!=-1){
				msg=result1;
				return "setIbeaconFail";
			}
			if(result2.indexOf("ERROR")!=-1){
				msg=result1;
				return "setIbeaconFail";
			}
			
		}
		
		
		
		return "setIbeaconSuccess";
//		return "setIbeaconFail";
	}
	
	
	
	
	
	
	
	

	public String getSearchPatientId() {
		return searchPatientId;
	}

	public void setSearchPatientId(String searchPatientId) {
		this.searchPatientId = searchPatientId;
	}

	public int getSearchRunId() {
		return searchRunId;
	}

	public void setSearchRunId(int searchRunId) {
		this.searchRunId = searchRunId;
	}

	public String getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(String searchResult) {
		this.searchResult = searchResult;
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


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
	

}
