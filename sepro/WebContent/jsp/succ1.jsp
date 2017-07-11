<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<%@ include file="/public/head.jspf" %>
 <img src="../picture/logo.jpg" width="80px" height="80px" /></div>
  </head>
  
  <body>
  	<div class="wrapper">
        <div class="header">
            <div class="header_container">
                <!--头部开始-->
                        <div class="top_bar clear">
                            <!--头部小导航-->
                            <div class="welcom fl">问卷网</div>
                            <ul class="top_links fr">
                                <li class="highlight"><a href="index.jsp">发布问卷</a></li>
                                <li >  <a href = "register.jsp">问卷模板</a> </li>
								<li >  <a href = "ulogin.jsp">问卷广场</a> </li>
								<li >  <a href = "ulogin.jsp">个人中心</a> </li>
                      
                               
                                
                            </ul>
							 <!-- 搜索框 -->
                    <div class="header_search">
                        <div class="form-search ">
                            <input  value="请输入问卷名称" class="input-text"  type="text" colour="white"/>
                            <button type="submit" title="Search"></button>
                        </div>
                    </div> 
                        </div>
                    
            </div>
        </div>
        <!-- 头部结束 -->

        <!-- 导航栏 -->
        <div class="navigation_container">
        <!---->
         <div class="nav">
            <ul class="primary_nav">
                <li class="active highlight"><a href="#">全部问卷</a>
            </ul>
        </div>
        </div>
        <!--导航栏结束-->

        
        <div class="section_container">
            <!--左侧导航-->
            <div id="side_nav">
                <div class="sideNavCategories">
                    <h1></h1>
                </div>
                
            </div>
            <!-- 右侧焦点图区域 -->
            <div id="main_content ">
                <div > <img src="images/timg.png" /> </div>
            </div>
        </div>


            <!-- 问卷列表 -->
            <c:forEach items="${applicationScope.bigList}" var="list">
	            <div class="products_list products_slider clear">
	            	<!-- 显示类别名称 -->
	                <h2 class="sub_title">${list[0].category.type}</h2>
	                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
	                    <c:forEach items="${list }" var="product">
		                    <li> 
		                    	<a href="${shop}/product_get.action?id=${product.id}" class="product_image"><img src="${shop}/files/${product.pic}" /></a>
		                        <div class="product_info">
		                            <h3><a href="#">问卷名称：${product.name }</a></h3>
		                            <small>简单描述：${product.remark}</small> </div>
		                        <div class="price_info"> 
		                            <a href="${shop}/sorder_addSorder.action?product.id=${product.id}"><button><span class="pr_add">添加购物车</span></button></a>
		                        </div>
		                    </li>
	                    </c:forEach>
	                </ul>
	            </div>
            </c:forEach>
            
            
        <!--产品列表结束  -->

         
        <!-- 导航栏结束 -->
        <div class="footer_container">


 
       </div>
    </div>
  </body>
</html>
