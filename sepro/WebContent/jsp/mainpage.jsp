<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="model.user" %>
<%@ page import="model.questionnaire" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.dataTables.min.js"></script>
	<script src="../js/dataTables.bootstrap.min.js"></script>
	<script src="../js/bootbox.min.js"></script>

 <style>
nec{color:red}
.box1 {width:70%; float:left; display:inline;}
.box2 {width:30%; float:left; display:inline;}

.leader{ 
	font-family:"斜体"; 
	font-size:18px;
	color=#000000;
	}//标题所用css
div{
display:inline
}
.logo_img{
position:absolute;
top:50px
}

.form-search {
align="right";
font-size:13px;
}

.fake_link{
 color:#337ab7;
 font-weight:200
}

</style>
<link href="../css/dataTables.bootstrap.css"
	rel="stylesheet">
<link href="../css/dataTables.responsive.css"
	rel="stylesheet">
<link href="../css/font-awesome.min.css"
	rel="stylesheet" type="text/css">


<title>问卷网</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
  </head>

<% %>
  
  <body>
   <!-- 头部开始-->
	<div class="leader" align="center">
	<img src="../picture/logo.png" width="120px" height="45px" /></a>&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp 
         	 <a href="#"><font>发布问卷</font></a>&nbsp 
     	 	 <a href = "#"><font  >问卷模板</font></a> &nbsp 
     		<font><label class="fake_link" data-toggle="modal" data-target="#login">登录 &nbsp </label></font>
    	    <font><label class="fake_link" data-toggle="modal" data-target="#regis">注册 &nbsp </label></font>
  			 
   </div>   
 <!-- 头部结束 -->
 
 <form action="Login">
<div class="modal fade" id="login" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					登录
				</h4>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
							<form role="form" method = post Action="Login">
								<div class="form-group">
									<label>用户名/邮箱/手机号</label><nec><label>*</label></nec> <input class="form-control" name="identity">
								</div>
								<div class="form-group">
									<label>密码</label><nec><label>*</label></nec> <input class="form-control" type="password" name="password">
								</div>
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
								<INPUT TYPE="submit" Value="登录" class="btn btn-default">
							</form>
						</div>
					</div>
				</div>
			<div class="modal-footer">
				
				
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
	</form>


<form action="Register">
<div class="modal fade" id="regis" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					注册
				</h4>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12">
								<div class="form-group">
									<label>用户名</label><nec><label>*</label></nec> <input class="form-control" name="username">
								</div>
								<div class="form-group">
									<label>密码</label><nec><label>*</label></nec> <input class="form-control" type="password" name="password">
								</div>
								<div class="form-group">
									<label>再次输入密码</label><nec><label>*</label></nec> <input class="form-control" type="password" name="password_c">
								</div>
								<div class="form-group">
									<label>邮箱</label> <nec><label>*</label></nec> <input class="form-control" type="mail" name="mail">
								</div>
								<div class="form-group">
									<label>姓名</label> <input class="form-control"
										name="name">
								</div>
								<div class="form-group">
									<label>qq</label> <input class="form-control" 
										name="qq">
								</div>
								<div class="form-group">
									<label>phone</label> <input class="form-control" 
										name="phone">
								</div>
						</div>
					</div>
				</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<INPUT TYPE=SUBMIT Value="注册" class="btn btn-default">
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
 
 
 
<HR style="FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#987cb9,direction:145,strength:15)" width="100%" color=#987cb9 SIZE=1>   <!-- 分割线 -->
							
   
         <div class="nav">
            <ul>
                <div class="box1"><font size="4" color="DarkOrchid">全部问卷</font></a>
                <font size="2">&nbsp &nbsp &nbsp 已发布|未发布</font></li></div>
               <div class="box2" font-size:15px float:right>
                            <input  value="请输入问卷名称" class="input-text"  type="text" colour="white"/>
                            <button type="button" title="Search">搜索</button>
                        </div>
                  
            
            </ul>
        </div>

	   <div class="products_list products_slider clear">

	                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
		                    <li> <div>
		                    	<!--  图片部分 <a href="${shop}/product_get.action?id=${product.id}" class="product_image"><img src="${shop}/files/${product.pic}" /></a>  -->
		                    	  <img src="../picture/questionnaire.png" width="100px" height="140px" />
		        
		                        <div class="product_info">
		                            <small>${product.remark}</small> </div>
		                            
		                            
		                       </div>
		                    </li>
	                
	                </ul>
	     </div>
         
    
