<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>

 <style>
nec{color:red}
.box1 {width:70%; float:left; display:inline;}
.box2 {width:30%; float:left; display:inline;}//多个div并排的实现



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



</style>
<title>问卷网</title>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" rel="stylesheet">
  </head>
  
  <body>
   <!-- 头部开始-->
	<div class="leader" align="center">
	<img src="../picture/logo.png" width="120px" height="45px" /></a>&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp 
         	 <a href="#"><font>发布问卷</font></a>&nbsp 
     	 	 <a href = "#"><font  >问卷模板</font></a> &nbsp 
     		 <a href = "#"><font  >问卷广场</font></a> &nbsp 
    	     <a href = "#"><font  >个人中心 </font></a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
             <font size="3"  ><i class="fa fa-user fa-lg">username</font></i> 
   </div>   
 <!-- 头部结束 -->
 <HR style="FILTER: progid:DXImageTransform.Microsoft.Shadow(color:#987cb9,direction:145,strength:15)" width="100%" color=#987cb9 SIZE=1>   <!-- 分割线 -->
 <table border=1 width=80% align="center" hight=80px>
   <tbody>
     <tr style="height:160px" >
         <td>
             <img src="../picture/sgow.png" width="950px" height="145px" />
         
         </td>
        
    </tr>
    <tr>
     <td>
     			<br>
               <div class="box1"><font size="4" > 分类一|分类二|其他</font> </div>
               <div class="box2" font-size:13px>
                            <input  value="请输入关键字" class="input-text"  type="text" colour="white" size="14"/>
                            <button type="button" title="Search"><i class="fa fa-search fa-lg"></i> </button>
                        </div>
         		<br><br> 
         </td>
          </tr>
              <tr>
         <td><br>
      		  <div class="box2"> <img src="../picture/pic.png" width="120px" height="120px" />&nbsp &nbsp </div>
      	   <div class="box1"><font size="4" >问卷1 </font> </div>
      	   <br>  <br>
			<div style="background:#F0FFFF;height:82px" >
					<font size="3" >&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp真正的科学家应当是个幻想家；谁不是幻想家，谁就只能把自己称为实践家。 —— 巴尔扎克 </font>
			 </div>
			 <br>
         </td>
        
    </tr>
      <tr>
         <td><br>
      		  <div class="box2"> <img src="../picture/pic.png" width="120px" height="120px" />&nbsp &nbsp </div>
      	   <div class="box1"><font size="4" >问卷2 </font> </div>
      	   <br>  <br>
			<div style="background:#F0FFFF;height:82px" >
					<font size="3" >&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp真正的科学家应当是个幻想家；谁不是幻想家，谁就只能把自己称为实践家。 —— 巴尔扎克 </font>
			 </div>
			 <br>
         </td>
        
    </tr>
     <tr>
         <td><br>
      		  <div class="box2"> <img src="../picture/pic.png" width="120px" height="120px" />&nbsp &nbsp </div>
      	   <div class="box1"><font size="4" >问卷2 </font> </div>
      	   <br>  <br>
			<div style="background:#F0FFFF;height:82px" >
					<font size="3" >&nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp真正的科学家应当是个幻想家；谁不是幻想家，谁就只能把自己称为实践家。 —— 巴尔扎克 </font>
			 </div>
			 <br>
         </td>
        
    </tr>
  </tbody></table>
</body>
</html>