package com.action;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.model.Patient;
import com.opensymphony.xwork2.ActionSupport;
import com.service.PatientService;
import com.uilts.Log;

public class PatientAction extends ActionSupport {

	private String searchPatientId;
	private String searchPatientName;
	private String searchIDCardNumber;
	private String searchPhoneNumber;

	private int id;
	private String patientId;
	private String patientName;
	private String idcardNumber;
	private String idCardNumber2;
	private String phoneNumber;
	private String bedId;
	private String drug1;
	private BigDecimal drug1cc;
	
	
	private String msg;

	public String loadPatient() {
		HttpServletRequest request = ServletActionContext.getRequest();

		PatientService service = new PatientService();
		Patient model = service.searchPatient( searchPatientId, "", searchIDCardNumber,
				"");
		if (model == null) {
			request.setAttribute("pageType", "新增");
			request.setAttribute("searchResult", "沒有該病患資料!");
			return "notFound";
		}
		patientId = model.getPatientId();
		patientName = model.getPatientName();
		idcardNumber = model.getiDCardNumber();
		phoneNumber = model.getPhoneNumber();
		id = model.getId();

		request.setAttribute("pageType", "修改");
		return "patient";
	}

	public String addPatient() {

		Log.info(getClass().getSimpleName(),"new add patient");
		PatientService service = new PatientService();
		String result = service.addPatient(patientId, patientName, idcardNumber, phoneNumber);
		Log.info(getClass().getSimpleName(),"new add patient result = "+result);
		if(result.indexOf("ERROR")!=-1){
			msg=result;
			return "addPatientFail";
		}
		HttpServletRequest request = ServletActionContext.getRequest();

		return "addPatientSuccess";
	}

	public String editPatient() {

		Log.info(getClass().getSimpleName(),"edit patient");
		HttpServletRequest request = ServletActionContext.getRequest();
		PatientService service = new PatientService();
		Log.info(getClass().getSimpleName(),"edit patient id = "+id);
		String result = service.editPatient(id,patientId, patientName, idcardNumber, phoneNumber);
		if(result.indexOf("ERROR")!=-1){
			msg=result;
			return "editPatientFail";
		}
		return "editPatientSuccess";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getSearchPatientId() {
		return searchPatientId;
	}

	public void setSearchPatientId(String searchPatientId) {
		this.searchPatientId = searchPatientId;
	}

	public String getSearchPatientName() {
		return searchPatientName;
	}

	public void setSearchPatientName(String searchPatientName) {
		this.searchPatientName = searchPatientName;
	}

	public String getSearchIDCardNumber() {
		return searchIDCardNumber;
	}

	public void setSearchIDCardNumber(String searchIDCardNumber) {
		this.searchIDCardNumber = searchIDCardNumber;
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

	public String getIdcardNumber() {
		return idcardNumber;
	}

	public void setIdcardNumber(String idcardNumber) {
		this.idcardNumber = idcardNumber;
	}

	public String getIdCardNumber2() {
		return idCardNumber2;
	}

	public void setIdCardNumber2(String idCardNumber2) {
		this.idCardNumber2 = idCardNumber2;
	}

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public String getDrug1() {
		return drug1;
	}

	public void setDrug1(String drug1) {
		this.drug1 = drug1;
	}

	public BigDecimal getDrug1cc() {
		return drug1cc;
	}

	public void setDrug1cc(BigDecimal drug1cc) {
		this.drug1cc = drug1cc;
	}

	public String getSearchPhoneNumber() {
		return searchPhoneNumber;
	}

	public void setSearchPhoneNumber(String searchPhoneNumber) {
		this.searchPhoneNumber = searchPhoneNumber;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getidCardNumber2() {
		return idCardNumber2;
	}

	public void setidCardNumber2(String idCardNumber2) {
		this.idCardNumber2 = idCardNumber2;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
