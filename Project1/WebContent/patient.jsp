<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="icon" href="/dir/favicon.ico" mce_href="icon/favicon.ico" type="image/x-icon" > 
	<link rel="shortcut icon" href="icon/favicon.ico"" mce_href="icon/favicon.ico" type="image/x-icon"> 
  <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="js/js/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.css">
<title>病患資料</title>
</head>


<body>

<div class="container" style="margin:20px">
<!-- <div class="container-fluid" style="margin:20px"> -->
<div class="row">

	<jsp:include page="indexForInclude.jsp" />

	<div class="col-xs-6 col-md-8">
		<h1>病患資料</h1>
		<s:form action="load_patient" theme="simple">
		<table class="table">
			<thead>
				<tr>
					<th>
						<label>讀取  病患資料<font color="red">${searchResult}</font></label>
					</th>
				</tr>
			</thead>
			<tbody>
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
									
			</tbody>
			</table>
		</s:form>
				
			
		<s:form action="add_patient"  theme="simple">
			<table class="table">
				<thead>
					<label>${ pageType }  病患資料</label>
					編號: <s:label name="id" ></s:label>
				</thead>
				<tbody>
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
				</tbody>
			</table>
		</s:form>
	</div>

</div>					  
</div>					  

</body>


<script type="text/javascript">

</script>
</html>