<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
 session.invalidate();
response.sendRedirect("index.jsp");
%>
//learnt how to write jsp pages