<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%
		String path = request.getContextPath();
	%>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="<%=path %>/js/jquery.min.js"></script>
	<title>test</title>
</head>

<body>

	<div>
		<button id="submit-questionnaire">save questionnarie</button>
		<button id="submit-answer">save answer</button>
		<button id="publish">publish</button>
		<form action="Test">
			<input type="text" name="questionnaireId">
			<input type="submit" >prieview
		</form>
		
		<form action="downloadExcel.action" method="post">
			<input type="text" name="questionnaireId" value="55"/>
			<input type="submit" value="download">
		</form>
		<img src="showDiagram?questionId=85">

		<form action="downloadDiagram.action" method="post">
			<input type="text" name="questionId" value="85"/>
			<input type="submit" value="downloadPicture">
		</form>
		
	</div>
	
	<a href="dataAnalysis.action?questionnaireId=55">数据统计</a>

	<script src="../js/test.js"></script>
</body>
</html>