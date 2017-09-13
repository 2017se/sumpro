
<%@ page import ="java.io.InputStream" %>
<%@ page import ="java.io.InputStreamReader" %>
<%@ page import ="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<HTML>

<HEAD>

<TITLE></TITLE>

</HEAD>

<BODY>

<%  
String path = request.getContextPath();
try {
Runtime rt = Runtime.getRuntime();
// TODO 路径
Process child = rt.exec("D:\\PHP\\mysql\\bin\\mysqldump -uroot -p123456 -R -c --set-charset=utf8 survey");

InputStream in = child.getInputStream();

InputStreamReader xx = new InputStreamReader(in, "utf8");

String inStr;
StringBuffer sb = new StringBuffer("");
String outStr;

BufferedReader br = new BufferedReader(xx);
while ((inStr = br.readLine()) != null) {
sb.append(inStr + "\r\n");
}
outStr = sb.toString();

// TODO 路径
FileOutputStream fout = new FileOutputStream("D:\\Web Cache\\backup.sql");
OutputStreamWriter writer = new OutputStreamWriter(fout, "utf8");
writer.write(outStr);
writer.flush();
in.close();
xx.close();
br.close();
writer.close();
fout.close();
} catch (Exception e) {
e.printStackTrace();
}

%>  
	<div style="font-size:18px">
		备份完成。
	</div>
	<a href="quesAdmin">点此返回</a>
</BODY>

</HTML>