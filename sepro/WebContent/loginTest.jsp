<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
			<form action="Login">
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
						
							<div class="form-group">
								<label for="username">Username</label>
								<input class="form-control" type="text" name="identity"/>
							</div>
	
							<div class="form-group">
								<label for="password">Password</label>
								<input class="form-control" type="password" name="password"/>
							</div>
								<%
									if(request.getAttribute("error") != null){//wrong input
								%>
									<div class="form-group" >
										<label for="wrong info">
											<font color="red" style="font-weight:normal">Note: wrong username or password.</font>
										</label>
									</div>
								<%
									}
								%>
	
							<div class="modal-footer">
								<input type="submit" class="btn btn-primary" value="login"/>
							</div>
							
						</div>
					</div>
				</div>
			</form>
</body>
</html>