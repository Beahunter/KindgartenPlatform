<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
  
    <title></title>
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
  </head>
   <script type="text/javascript" src="../3party/jquery/jquery-2.2.3.min.js"></script>
  <script type="text/javascript" src="../3party/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
  <link href="../3party/bootstrap-3.3.5-dist/css/bootstrap.css" rel="styleSheet" type="text/css"></link>
  <style>
  	@font-face{
  		font-family:Microsoft YaHei;
  		src:url("../font/msyh.ttf") ;
  	}
  	body{
  		font-family:Microsoft YaHei;
  		color: rgb(51,51,51);
  		background-color: #f6f7fb;
		/* overflow:hidden; */
  	}
  	.logo{
  		background: url("../images/logo.png") no-repeat;
  		height:44px;
  	}
  	.header,.info{
  		display: inline-block;
  	}
  	.user{
  		float: right;
  	}
  	.row-text-padding{
  		  padding: 15px;
  		  background-color: #fff;
  	}
  	.col-container-color{
  		background: #f6f7fb;
  	}
  	.content{
  		border: solid 1px #ddd;
  		background: #fff;
  	}
  	.item{
  		padding-top:15px;
  		border-bottom: solid 1px #ddd;
  	}
  	.item-last{
  		border-bottom: none;
  	}
  	.item ul{
  		padding-left:0px;
  		margin-bottom: 0;
  	}
  	.item ul li{
  		list-style: none;
  		line-height:40px;
  		padding-left: 40px;
  		cursor: pointer;
  	}
  	.item ul li:hover{
  		background-color: #7ba9e4;
  	}
	.item ul li:hover a{
		color:#FFF;	
	}
  	.item a{
  		text-decoration: none;
  		color:#323232;
  		
  	}
  	.text{
  		display: inline-block;
  		padding-left:5px;
  	}
  	.title{
  		margin-left: 15px;
  		color:#b2b2b2;
  	}
  	.glyphicon{
  		opacity:.5;
  	}
  	li.active{
  		background-color: #7ba9e4;
  	}
	li.active a {
		color:#fff;	
	}
	.pname{
	  font-size:20px
	 }
  </style>
  <body style="min-height: 768px; ">
    <div class="container-fluid">
    	<div class="row">
    		<div class="col-sm-12 col-container-color">
    			<div class="row row-text-padding" style="border:solid 1px #ddd;border-top: none;">
    				<div class="col-sm-5 col-sm-offset-1" style="padding-left:0px;">
    					<div class="pname">幼儿园互动平台后台管理系统</div>
    				</div>
    				<div class="col-sm-5" style="padding-right:0px;">
    					<div class="user">
    						<div class="header">
    							<img style="display:inline-block;margin-top:-20px;" alt="" src="../images/header.png">
    							<div class="info">
    								<span style="display:block;">admin</span>
    								<span>幼儿园互动平台后台管理</span>
    								<span>|</span>
    								<a href="login.jsp">退出</a>
    							</div>
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="row" style="margin-top: 30px;">
    				<div class="col-sm-10 col-sm-offset-1">
    					 <div class="content">
    					 	<div class="row">
	    					 	<div class="col-sm-3 js-menu-bar" style="padding-right:0;border-right:solid 1px #ddd;">
	    					 		<div class="item">
	    					 			<h4 class="title"><i class="glyphicon glyphicon-th-large"></i><span class="text">用户管理</span> </h4>
	    					 			<ul>
	    					 				<li><a data-href="userInfo.jsp" href="javascript:void(0)">用户信息</a></li>
	    					 				<li><a data-href="addUser.jsp" href="javascript:void(0)">更新用户</a></li>
	    					 				<!-- <li><a data-href="updateUser.jsp" href="javascript:void(0)">修改用户</a></li> -->
	    					 			</ul>
	    					 		</div>
	    					 		<div class="item">
	    					 			<h4 class="title"><i class="glyphicon glyphicon-list-alt"></i><span class="text">班级管理</span></h4>
	    					 			<ul>
	    					 				<li><a data-href="classInfo.jsp" href="javascript:void(0)">班级信息</a></li>
	    					 				 
	    					 			</ul>
	    					 		</div>
	    					 		<div class="item item-last" >
	    					 			<h4 class="title"><i class="glyphicon glyphicon-cd"></i><span class="text">科目管理</span></h4>
	    					 			<ul>
	    					 				<li><a data-href='subjectInfo.jsp' href="javascript:void(0)">科目信息</a></li>
	    					 				
	    					 			</ul>
	    					 		</div>
	    					 		
	    					 	</div>
	    					 	<div class="col-sm-9" style="padding-left:0;">
	    					 		<iframe id="iframe" src="userInfo.jsp" width="100%" height="768px" src="" frameborder="no" border="0" marginwidth="0" marginheight="0"></iframe>
	    					 	</div>
	    					 </div>
    					 </div>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
    <script type="text/javascript">
    	var el = "";
    	$(".js-menu-bar").find("li").on("click",function(){
    		el ? $(el).removeClass("active"):"";
    		$(this).hasClass("active")?"":$(this).addClass("active");
    		el = this;
			var href = $(this).find("a").data("href");
			$("#iframe").attr("src",href);
    	});
		$(".js-menu-bar").css("height",$("iframe").attr("height"));
    </script>
  </body>
</html>

