package com.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.MonitorModel;
import com.model.PatientSub;
import com.opensymphony.xwork2.ActionSupport;
import com.service.IbeaconSerivce;
import com.service.PatientService;
import com.uilts.Log;

public class IbeaconAction extends ActionSupport {
	
	List<PatientSub> list = new ArrayList<PatientSub>();
	
	private String searchResult;

	private String patientId;
	private String ibeaconId;
	private String bedId;
	private BigDecimal speed;
	private String drugQuantity;
	private String drugId_1;
	private BigDecimal drugCc_1;
	private String drugId_2;
	private BigDecimal drugCc_2;
	private String drugId_3;
	private BigDecimal drugCc_3;
	private String drugId_4;
	private BigDecimal drugCc_4;
	private String drugId_5;
	private BigDecimal drugCc_5;
	private String drugId_6;
	private BigDecimal drugCc_6;
	private String drugId_7;
	private BigDecimal drugCc_7;
	private String drugId_8;
	private BigDecimal drugCc_8;
	private String drugId_9;
	private BigDecimal drugCc_9;
	private String drugId_10;
	private BigDecimal drugCc_10;
	
	private String msg;
	
	
	public String loadSelectHistory(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String runId = request.getParameter("runId");
		String patientId = request.getParameter("patientId");
		
		Log.info(getClass(), "runId = "+runId);
		Log.info(getClass(), "patientId = "+patientId);
		
		IbeaconSerivce service = new IbeaconSerivce();
		list.addAll( service.loadHistory(patientId)  );
		
		return "success";
	}
	
	
	public String loadIbeaconHistory() {

		HttpServletRequest request = ServletActionContext.getRequest();
//		Map<String, String[]> param = request.getParameterMap();
//		for(String key : param.keySet()){
//			for(String val : param.get(key)){
//				Log.info(getClass(), key+" "+val);
//				Log.info(getClass(), key+" "+val);
//			}
//		}
		
		String patientId = request.getParameter("patientId");
		IbeaconSerivce service = new IbeaconSerivce();
		list.addAll( service.loadHistory(patientId)  );
		return "success";
		
//		if (searchPatientId.equals("")) {
//			searchResult = "未填入病號";
//			return "loadIbeaconFail";
//		}
//
//		IbeaconSerivce service = new IbeaconSerivce();
//		PatientSub model = service.loadHistory(searchPatientId, searchRunId);
//		if (model == null) {
//			searchResult = "該資料不存在";
//			return "loadIbeaconFail";
//		}
//		patientId = model.getPatientId();
//		speed = model.getSpeed();
//		drugId1 = model.getDrugId1();
//		drugCc1 = model.getDrugCc1();
//		drugId2 = model.getDrugId2();
//		drugCc2 = model.getDrugCc2();
//		
//
//		return "loadIbeaconSuccess";
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
//			PatientService patientService = new PatientService();
			String result1 = ibeaconService.updateIbeaconStatus(ibeaconId,"PENDING","READY");
			PatientService patientService= new PatientService();
			ArrayList<String> drug = new ArrayList<String>();
			ArrayList<BigDecimal> drugCc = new ArrayList<BigDecimal>();
			
			for(int i=0; i<Integer.valueOf(drugQuantity);i++){
				drug.add(drugId_1);
				drugCc.add(drugCc_1);
				drug.add(drugId_2);
				drugCc.add(drugCc_2);
				drug.add(drugId_3);
				drugCc.add(drugCc_3);
				drug.add(drugId_4);
				drugCc.add(drugCc_4);
				drug.add(drugId_5);
				drugCc.add(drugCc_5);
				drug.add(drugId_6);
				drugCc.add(drugCc_6);
				drug.add(drugId_7);
				drugCc.add(drugCc_7);
				drug.add(drugId_8);
				drugCc.add(drugCc_8);
				drug.add(drugId_9);
				drugCc.add(drugCc_9);
				drug.add(drugId_10);
				drugCc.add(drugCc_10);
			}
			
			String result2 = patientService.insertPatientSub(patientId,ibeaconId,bedId,speed,drug,drugCc);
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



	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public List<PatientSub> getList() {
		return list;
	}


	public void setList(List<PatientSub> list) {
		this.list = list;
	}


	public String getDrugQuantity() {
		return drugQuantity;
	}


	public void setDrugQuantity(String drugQuantity) {
		this.drugQuantity = drugQuantity;
	}


	public String getDrugId_1() {
		return drugId_1;
	}


	public void setDrugId_1(String drugId_1) {
		this.drugId_1 = drugId_1;
	}


	public BigDecimal getDrugCc_1() {
		return drugCc_1;
	}


	public void setDrugCc_1(BigDecimal drugCc_1) {
		this.drugCc_1 = drugCc_1;
	}


	public String getDrugId_2() {
		return drugId_2;
	}


	public void setDrugId_2(String drugId_2) {
		this.drugId_2 = drugId_2;
	}


	public BigDecimal getDrugCc_2() {
		return drugCc_2;
	}


	public void setDrugCc_2(BigDecimal drugCc_2) {
		this.drugCc_2 = drugCc_2;
	}


	public String getDrugId_3() {
		return drugId_3;
	}


	public void setDrugId_3(String drugId_3) {
		this.drugId_3 = drugId_3;
	}


	public BigDecimal getDrugCc_3() {
		return drugCc_3;
	}


	public void setDrugCc_3(BigDecimal drugCc_3) {
		this.drugCc_3 = drugCc_3;
	}


	public String getDrugId_4() {
		return drugId_4;
	}


	public void setDrugId_4(String drugId_4) {
		this.drugId_4 = drugId_4;
	}


	public BigDecimal getDrugCc_4() {
		return drugCc_4;
	}


	public void setDrugCc_4(BigDecimal drugCc_4) {
		this.drugCc_4 = drugCc_4;
	}


	public String getDrugId_5() {
		return drugId_5;
	}


	public void setDrugId_5(String drugId_5) {
		this.drugId_5 = drugId_5;
	}


	public BigDecimal getDrugCc_5() {
		return drugCc_5;
	}


	public void setDrugCc_5(BigDecimal drugCc_5) {
		this.drugCc_5 = drugCc_5;
	}


	public String getDrugId_6() {
		return drugId_6;
	}


	public void setDrugId_6(String drugId_6) {
		this.drugId_6 = drugId_6;
	}


	public BigDecimal getDrugCc_6() {
		return drugCc_6;
	}


	public void setDrugCc_6(BigDecimal drugCc_6) {
		this.drugCc_6 = drugCc_6;
	}


	public String getDrugId_7() {
		return drugId_7;
	}


	public void setDrugId_7(String drugId_7) {
		this.drugId_7 = drugId_7;
	}


	public BigDecimal getDrugCc_7() {
		return drugCc_7;
	}


	public void setDrugCc_7(BigDecimal drugCc_7) {
		this.drugCc_7 = drugCc_7;
	}


	public String getDrugId_8() {
		return drugId_8;
	}


	public void setDrugId_8(String drugId_8) {
		this.drugId_8 = drugId_8;
	}


	public BigDecimal getDrugCc_8() {
		return drugCc_8;
	}


	public void setDrugCc_8(BigDecimal drugCc_8) {
		this.drugCc_8 = drugCc_8;
	}


	public String getDrugId_9() {
		return drugId_9;
	}


	public void setDrugId_9(String drugId_9) {
		this.drugId_9 = drugId_9;
	}


	public BigDecimal getDrugCc_9() {
		return drugCc_9;
	}


	public void setDrugCc_9(BigDecimal drugCc_9) {
		this.drugCc_9 = drugCc_9;
	}


	public String getDrugId_10() {
		return drugId_10;
	}


	public void setDrugId_10(String drugId_10) {
		this.drugId_10 = drugId_10;
	}


	public BigDecimal getDrugCc_10() {
		return drugCc_10;
	}


	public void setDrugCc_10(BigDecimal drugCc_10) {
		this.drugCc_10 = drugCc_10;
	}
	
	
	
	

}
