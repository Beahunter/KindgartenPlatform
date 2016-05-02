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
  <script type="text/javascript" src="../3party/bootstrap-3.3.5-dist/js/bootstrap.js">
  </script><script src="../3party/blockui-master/jquery.blockUI.js"></script>
  <script src="../3party/jquery.block/jquery.block.js"></script>
  <link href="../3party/bootstrap-3.3.5-dist/css/bootstrap.css" rel="styleSheet" type="text/css"></link>
  <style>
  	@font-face{
  		font-family:Microsoft YaHei;
  		src:url("../font/msyh.ttf") ;
  	}
  	body{
  		font-family:Microsoft YaHei;
  		color: rgb(51,51,51);
  		background-color: #fff;
  	}
  		.pname{
	  font-size:20px
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
  		  background-color: #f6f7fb;
  	}
  	.col-container-color{
  	
  	}
  	.content{
  		border: solid 1px #ddd;
  	}
  	a{
  		text-decoration: none;
  		color:#323232;
		cursor:pointer;
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
   .btn-login{
	   background:#7ba9e4;
	   color:#fff;
	   width:100px;
	}
	.btn-login:hover{
		background:#7BA9FB;
		 color:#fff;
		}
		.panel.panel-default.panel-green{
			border:none;
		}
	.panel-default.panel-green > .panel-heading{
		    color: #fff;
    		background-color: #7ba9e4;
    border-color:#7ba9e4;
	    height: 44px;
	}
	.left{
		    padding-right: 0;
    min-height: 400px;
    
		}
		.right{
		    display: inline-block;
    float: right;
    background: #fff;
    border-radius: 30px;
    padding: 10px 10px 4px 10px;
    margin-top: -15px;		
			}
		.panel-green .panel-body{
			 background-color: #f6f7fb;
		}	
		.form-control:focus{border-width:2px;
		}
  </style>
  <body style="min-height: 768px;">
    <div class="container-fluid">
    	<div class="row">
    		<div class="col-sm-12 col-container-color">
    			<div class="row row-text-padding" style="border:solid 1px #ddd;border-top: none;">
    				<div class="col-sm-5 col-sm-offset-3" style="padding-left:0px; text-align: right;">
    					<div class="pname">幼儿园互动平台后台管理系统</div>
    				</div>
    				<div class="col-sm-5" style="padding-right:0px;">
    					<div class="user">
    						<div class="header">
    							 
    						</div>
    					</div>
    				</div>
    			</div>
    			<div class="row" style="padding-top:100px;">
    				<div class="col-sm-9 col-md-8 col-md-offset-2 col-sm-offset-2">
    					<div class="row">
	    					<div class="col-sm-6 col-md-5" style="padding:0;">
                            	<div class="left" style="float:right;">
                                	<!-- <img src="../images/denglu.png" width="420" height="216"  alt=""/> -->
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-4" style="padding-left:0;">
                            	<div class="panel panel-default panel-green" style="min-height:100px;">
                                	<div class="panel-heading">
                                    	<div style="display:inline-block;    margin-top: -5px;">
                                        	<h5>用户登录</h5>
                                        </div>
                                        <div class="right">
                                        	<img src="../images/head.png" width="30" height="37"  alt=""/>
                                        </div>
                                        <div style="clear:both;"></div>
                                    </div>
                                	<div class="panel-body">
                                    	<div class="row" style="margin-top:15px;">
                                            <div class="form-group">
                                               <div class="col-sm-12">
                                               		<div class="input-group">
                                                    	<span class="input-group-addon">
                                                        	<span class="glyphicon glyphicon-user"></span>
                                                        </span>
                                                    	<input class="form-control" type="text" name="name"/>
                                                    </div>
                                               </div>
                                            </div>
                                        </div>
                                        <div class="row" style="margin-top:30px;">
                                            <div class="form-group">
                                            	<div class="col-sm-12">
                                                    <div class="input-group">
                                                        <span class="input-group-addon">
                                                            <span class="glyphicon glyphicon-lock"></span>
                                                        </span>
                                                        <input class="form-control" type="password" name="password"/>
                                                    </div>
                                                 </div>
                                            </div>
                                        </div>
                                        <div class="row" style="margin-top:20px;">
                                           <!--  <div class="form-group">
                                            	<div class="col-sm-6">
                                                    <input type="checkbox"/>
                                                    <label>记住我?</label>
                                                 </div>
                                                 <div class="col-sm-6">
                                                    <div style="text-align:right;">
                                                    	<a>忘记密码?</a>
                                                    </div>
                                                 </div>
                                            </div> -->
                                        </div>
                                        <div class="row" style="margin-top:20px;">
                                            <div class="form-group">
                                            	<div class="col-sm-6">
                                                	<button class="btn btn-login js-login">登录</button>  
                                                </div>
                                            </div>
                                        </div>
                                        
                                    
                                    </div>
                                </div>
                            </div>
                        </div>
    				</div>
    			</div>
    		</div>
    	</div>
    </div>
     <script src="my.js"></script>
    <script type="text/javascript">
   // alert(ipVal);
    	$(".js-login").on("click",function(){
			var name = $("input[name='name']").val();
			var password = $("input[name='password']").val();
			if(name ==null || name =="" || password ==null || password ==""){
			    alert("用户名或密码不能为空");
			}else {
			  var user = new Object();
			  user.name = name;
			  user.password = password;
			  user.type = "0";
			  var str = JSON.stringify(user);
		     $.block();
			 setTimeout(function(){ 
			    $.ajax({
                type:'post',
                url:ipVal+'web/webAction!login',
                dataType:'text',
                data:"orderJson=" + str,
                success: function(data,requestCode){
             
                // uexWindow.toast(1,5,"正在加载...",5000);   console.log(requestCode);
                if(requestCode.indexOf("success")!=-1){
                if(data!=null && data!=""){
                console.log(data);
               var userback = JSON.parse(data);
                var status = userback.status;
                if(status!=null && status.indexOf("1")!=-1){
                  $.unblock();
                   window.location.href="page01.jsp";
                
                }else{
                $.unblock();
                   alert("帐号和密码不匹配");
                }
                }else{
                $.unblock();
                     alert("帐号和密码不匹配");
                }
                
                }else {
                //  removeLoading();
                //  uexWindow.closeToast();
                $.unblock();
                 alert("登录请求发送失败");
                }
                // var userback = JSON.parse(data);
                //   console.log("nnnnnn"+userback.phoneNumber);
                }
                })
                },1000);
			}
			/* if(name == password){
				$.block();
				setTimeout(function(){
					window.location.href="page01.jsp";
				},2000);
			}else{
				alert("用户名和密码不相等!");
			} */
			
		});
    </script>
  </body>
</html>

