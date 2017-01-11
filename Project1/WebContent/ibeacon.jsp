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
<title>ibeacon配對管理</title>
</head>
<body>

<div class="container" style="margin:20px">
<!-- <div class="container-fluid" style="margin:20px"> -->
<div class="row">

	<jsp:include page="indexForInclude.jsp" />

	<div class="col-xs-8 col-md-8">
		<h1>ibeacon配對管理</h1><br/>
			<s:form action="loadIbeaconHistory" theme="simple">
			<table class="table">
				<thead>
					<tr>
						<th>
							<label>讀取  病患過往資料<font color="red">${searchResult}</font></label>
						</th>
					</tr>
				</thead>
				<tbody>
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
				</tbody>
			</table>
			</s:form>
			
			
			<s:form action="setIbeacon"  theme="simple">
				
			<table class="table">
				<thead>
					<tr>
						<th>
							<label>${ pageType }  ibeancon設定</label>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<label>病號</label><br/>
							<s:textfield name="patientId"  id="patientId"  />
						</td>
						<td>
							<label>ibeacon編號</label><br/>
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
				</tbody>
			</table>
			</s:form>
			
	</div>
</div>
</div>	


</body>
</html>