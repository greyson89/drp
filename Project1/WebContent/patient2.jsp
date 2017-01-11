<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="js/js/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.css">
<title>病患資料</title>
</head>
<body>


<table width="100%">
	<tr>
		<td width="300px">
				<jsp:include page="index.jsp"></jsp:include>		
		</td>
		<td width="500px">
							<h1>病患資料</h1><br/>
							<s:form action="load_patient" theme="simple">
							<label>讀取  病患資料								<font color="red">${searchResult}</font></label>
							<table width="50%">
								<tr>
									<td>
										<label>病號</label><br/>
										<s:textfield name="searchPatientId" />
									</td>
<!-- 									<td> -->
<!-- 										<label  class="">姓名</label><br/> -->
<%-- 								      	<s:textfield name="searchPatientName" /> --%>
<!-- 									</td> -->
								</tr>
								<tr>
									<td>
										<label  class="">身分證字號</label><br/>
								      	<s:textfield name="searchIDCardNumber" />
									</td>
<!-- 									<td> -->
<!-- 										<label  class="">電話</label><br/> -->
<%-- 								      	<s:textfield name="searchPhoneNumber" /> --%>
<!-- 									</td> -->
									
								</tr>
								<tr>
									<td>
										<br/>
										<s:submit  value="查詢" />
									</td>
								</tr>				
							
							</table>
							</s:form>
							
							<br/>
							<br/>
						
							<s:form action="add_patient"  theme="simple">
							<label>${ pageType }  病患資料</label>
							編號: <s:textfield name="id" readonly="true" />
							<table width="50%">
								<tr>
									<td>
									
										<label>病號</label><br/>
										<s:textfield name="patientId"  id="patientId"  />
									</td>
									<td>
										<label  class="">姓名</label><br/>
								      	<s:textfield name="patientName" id="patientName" />
									</td>
								</tr>
								<tr>
									<td>
										<label  class="">身分證字號</label><br/>
								      	<s:textfield name="idcardNumber" id="idcardNumber" />
										
									</td>
									<td>
										<label  class="">電話</label><br/>
								      	<s:textfield name="phoneNumber" />
									</td>
									
								</tr>	
								<tr>
									<td>
										<label class="">床號</label><br/>
								      	<s:textfield name="bedId" />
									</td>
									<td>
<!-- 										留空 -->
									</td>
								</tr>		
								<tr>
									<td>
										<label  class="">藥品1</label><br/>
								      	<s:textfield name="drug1" />
									</td>
									<td>
										<label  class="">藥品1容量</label><br/>
										<s:textfield name="drug1cc" />
									</td>
								</tr>	
											
								<tr>
									<td>
										<br/>
										<% if(request.getAttribute("pageType").equals("新增") ){ %>
										<s:submit  value="新增"  method="addPatient"/>
										<% } %>
										<% if(request.getAttribute("pageType").equals("修改") ){ %>
										<s:submit  value="修改"  method="editPatient"/>
										<% } %>
									</td>
									<td>
										<br/>
										<button type="reset" value="清除" >清除</button> 
									</td>
								</tr>
							</table>
							</s:form>
							
							
						
					  
					  
		</td>
		<td width="224px">
<!-- 			保留 -->
		</td>
	</tr>

</table>

</body>


<script type="text/javascript">

</script>
</html>