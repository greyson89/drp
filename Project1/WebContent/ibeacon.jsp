<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<title>ibeacon配對管理</title>
</head>
<body>

	
	
<table width="100%">
	<tr>
		<td style="width:300px">
				<jsp:include page="index.jsp"></jsp:include>		
		</td>
		<td style="width:500px">
							<h1>ibeacon配對管理</h1><br/>
							<s:form action="loadIbeaconHistory" theme="simple">
							<label>讀取  病患過往資料								<font color="red">${searchResult}</font></label>
							<table width="50%">
								<tr>
									<td>
										<label>病號<br/></label><br/>
										<s:textfield name="searchPatientId" required="true"/>
									</td>
									<td>
										<label  class="">讀取第幾次使用資訊<br/>(填入0將代入最後一次)</label><br/>
								      	<s:textfield name="searchRunId"   />
									</td>
								</tr>
								<tr>
									<td>
										<br/>
										<s:submit  value="讀取資料" />
									</td>
								</tr>				
							
							</table>
							</s:form>
							
							<br/>
							<br/>
						
							<s:form action="setIbeacon"  theme="simple">
							<label>${ pageType }  ibeancon設定</label>
<%-- 							編號: <s:textfield name="id" readonly="true" /> --%>
							<table width="50%">
								<tr>
									<td>
									
										<label>病號</label><br/>
										<s:textfield name="patientId"  id="patientId"  />
									</td>
									<td>
										<label class="">ibeacon編號</label><br/>
								      	<s:textfield name="ibeaconId"  required="true"/>
									</td>
								</tr>
								<tr>
									<td>
										<label class="">床號</label><br/>
								      	<s:textfield name="bedId" />
										
									</td>
									<td>
										<label  class="">流速</label><br/>
								      	<s:textfield name="speed" />
									</td>
									
								</tr>	
								<tr>
								<tr>
									<td>
										<label  class="">藥品1</label><br/>
								      	<s:textfield name="drugId1" />
									</td>
									<td>
										<label  class="">藥品1容量(cc)</label><br/>
										<s:textfield name="drugCc1" />
									</td>
								</tr>
								<tr>
									<td>
										<label  class="">藥品2</label><br/>
								      	<s:textfield name="drugId2" />
									</td>
									<td>
										<label  class="">藥品2容量(cc)</label><br/>
										<s:textfield name="drugCc2" />
									</td>
								</tr>		
											
								<tr>
									<td>
										<br/>
										<s:submit  value="新增"  method="setIbeacon"/>
<%-- 										<s:submit  value="修改"  method="editPatient"/> --%>
									</td>
									<td>
										<br/>
										<button type="reset" value="清除" >清除</button> 
									</td>
								</tr>
							</table>
							</s:form>
							
							
						
					  
					  
		</td>
		<td style="width:224px">
<!-- 			保留 -->
		</td>
	</tr>

</table>

</body>
</html>