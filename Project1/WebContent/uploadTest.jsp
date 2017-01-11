<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>

<head>
  <title>上傳測試</title>
  <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="js/js/jquery-3.1.1.min.js"></script>
  <script src="bootstrap/js/bootstrap.js"></script>
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap-theme.css">
</head>
<body>

<div class="container" style="margin:20px">
<!-- <div class="container-fluid" style="margin:20px"> -->
<div class="row">

	<jsp:include page="indexForInclude.jsp" />

	<div class="col-xs-8 col-md-8">
		<h3>是否存入DB = ${status }</h3>
		<h3>id = ${ id}</h3>
		<h3>time =  ${ time }</h3>
		<h3>drip = ${ drip}</h3>
		<h3>rssi = ${ rssi}</h3>
		<h3>ip = ${ ip}</h3>
	</div>
</div>
</div>

		<td width="500px">
				
				
				<s:form action="uploadConfirm"  >
					ibeaconId = <s:textfield name="ibeaconId"/>
					<s:submit />
				</s:form>
				<br/>
				
				<s:form action="upload"  >
					<table>
					<tr>
						<td>id = <s:textfield name="id"/>	</td>
						<td>drip = <s:textfield name="drip"/></td>
					</tr>
					<tr>
						<td>time = <s:textfield name="time"/></td>
						<td>rssi = <s:textfield name="rssi"/><br/></td>
					</tr>
					<tr>
						<td>ip = <s:textfield name="ip"/></td>
						<td><s:submit /></td>
					</tr>
					</table>
				</s:form>
		</td>
		<td width="224px">
		
		</td>
	</tr>
	</table>
	
</body>
</html>