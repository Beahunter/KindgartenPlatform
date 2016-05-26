<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>addGoods.html</title>

<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">
<script type="text/javascript"
	src="../3party/jquery/jquery-2.2.3.min.js"></script>
<script type="text/javascript"
	src="../3party/bootstrap-3.3.5-dist/js/bootstrap.js">
	
</script>
<script src="../3party/blockui-master/jquery.blockUI.js"></script>
<script src="../3party/jquery.block/jquery.block.js"></script>
<link href="../3party/bootstrap-3.3.5-dist/css/bootstrap.css"
	rel="styleSheet" type="text/css"></link>
<link href="../css/common.css" rel="styleSheet" type="text/css"></link>
<style type="text/css">
.header {
	border-bottom: dotted 1px #ddd;
}

.up-images {
	display: inline-block;
}

.images {
	height: 100px;
	background: #F6F7FB;
	text-align: center;
	color: #C1C2C6;
	border: solid 1px rgba(51, 51, 51, .4);
	padding-top: 50px;
}

.left {
	margin-left: 15px;
}
</style>
</head>

<body style="min-height: 1200px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<div class="header">
					<h4>用户信息</h4>
				</div>
			</div>
		</div>
		<div class="row row-offset-top row-offset-bottom">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="">
					<div class="row">
						<div class="col-sm-3">
							<label>*用户名:</label>
						</div>
						<div class="col-sm-9">
							<div class="form-inline">
								<div class="form-group">

									<input type="text" class="form-control" id="name">
								</div>
							</div>
						</div>
					</div>
					<div class="row row-offset-top">
						<div class="col-sm-3">
							<label>*电话号码:</label>
						</div>
						<div class="col-sm-9">
							<div class="form-inline">
								<div class="form-group">

									<input type="text" class="form-control" id="phoneNumber">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row row-offset-top">
					<div class="col-sm-3">
						<label>&nbsp;*权限:</label>
					</div>
					<div class="col-sm-9">
						<div class="form-inline">
							<div class="form-group">

								<!-- <input type="text" class="form-control "> -->
								家长 <input type="radio" name="type" checked="checked" value="3" />
								教师 <input type="radio" name="type" value="2" /> 园长 <input
									type="radio" name="type" value="1" />
							</div>
						</div>
					</div>
				</div>
				<div class="row row-offset-top">
					<div class="col-sm-3">
						<label>&nbsp;*班级:</label>
					</div>
					<div class="col-sm-9">
						<div class="form-inline">
							<div class="form-group" id="classes">
								<!-- 								<span>小班 </span><input type="checkbox" name="classes" /> <span>中班 </span> <input -->
								<!-- 									type="checkbox" name="classes" /> <span>大班 </span> <input type="checkbox" -->
								<!-- 									name="classes" /> -->
							</div>
						</div>
					</div>
				</div>

				<div class="row row-offset-top ">
					<div class="col-sm-3">
						<label>*密码:</label>
					</div>
					<div class="col-sm-9">
						<div class="form-inline">
							<div class="form-group">

								<input type="text" class="form-control " id="password">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<div class="row row-offset-top row-offset-bottom">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="row row-offset-top ">
					<div class="col-sm-12">
						<div style="text-align: center;">
							<input type="submit" value="确认提交" class="btn btn-pink"
								id="submit" />
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="my.js"></script>
	<script type="text/javascript">
		//alert(1);
		var doType = "1";
		$(document).ready(function() {
			var userId = localStorage.userId;
			if(localStorage.doType !=null && localStorage.doType!=""){
			   doType = localStorage.doType;
			    localStorage.removeItem("doType");
			}
			var json = new Object();
			if (doType == "1") {
				json.type = doType;

			} else if (doType == "2") {
				json.type = doType;
				json.userId = userId;
			}
			var str = JSON.stringify(json);
			sendData(str);
			/*   var name = "xiaoban";
			  var id = 1;
			    $("#classes").html("");
			   $("#classes").append("<span>"+name+"</span>"); 
			   $("#classes").append('<input type="checkbox" name="classes" value='+id+' />'); */
		});
		$(".js-file").on("click", function() {
			$(".js-file-input").trigger("click");
		});
		$("#submit").on("click", function() {
			var name = $("#name").val();
			var pas = $("#password").val();
			var phoneNumber = $("#phoneNumber").val();
			var type = $("input[type='radio']:checked").val();
			var classes = "";
			var classobj = document.getElementsByName('classes');
			var userId = localStorage.userId;
		    if(phoneNumber!=null && phoneNumber!=""&&
		       name!=null && name!=""&&
		       pas!=null && pas!=""&&
		       type!=null && type!=""&&
		       classobj!=null && classobj.length>0
		    ){
		    debugger;
		      for (var i = 0; i < classobj.length; i++) {
				if (classobj[i].checked){
				  classes += classobj[i].value+",";
				 }
			   }
		       var json = new Object();
		       json.phoneNumber =phoneNumber;
		       json.name =name;
		       json.pas = pas;
		       json.type = type;
		       json.classes =classes;
		       json.doType =doType;
		       json.userId =userId;
		       var str = JSON.stringify(json);
			  sendData1(str);
		    }else{
		      alert("用户基本信息都不能为空！");
		    }
		});
     
	    function sendData1(str) {
			  $.block();
			setTimeout(
					function() {
						$
								.ajax({
									type : 'post',
									url : ipVal
											+ 'web/webAction!saveOrUpdateUser',
									dataType : 'text',
									data : "orderJson=" + str,
									success : function(data, requestCode) {
										// uexWindow.toast(1,5,"正在加载...",5000);   console.log(requestCode);
										if (requestCode.indexOf("success") != -1) {
											if (data != null && data != "") {
												console.log(data);
												var userback = JSON.parse(data);
												var status = userback.status;
												if (status != null
														&& status.indexOf("1") != -1) {
													$.unblock();
													alert("更新成功！");
												} else if(status != null
														&& status.indexOf("2") != -1){
												$.unblock();
												alert("用户已存在！");
												}else if(status != null
														&& status.indexOf("3") != -1){
												$.unblock();
												alert("用户不存在！");
												}
												else {
													$.unblock();
													alert("数据请求失败");
												}
											} else {
												$.unblock();
												alert("数据请求失败");
											}

										} else {
											//  removeLoading();
											//  uexWindow.closeToast();
											$.unblock();
											alert("请求发送失败");
										}
										// var userback = JSON.parse(data);
										//   console.log("nnnnnn"+userback.phoneNumber);
									}

								})
					}, 1000);
		}
	 
	
		function sendData(str) {
			 $.block();
			setTimeout(
					function() {
						$
								.ajax({
									type : 'post',
									url : ipVal
											+ 'web/webAction!getAllClassesInfo',
									dataType : 'text',
									data : "orderJson=" + str,
									success : function(data, requestCode) {
										// uexWindow.toast(1,5,"正在加载...",5000);   console.log(requestCode);
										if (requestCode.indexOf("success") != -1) {
											if (data != null && data != "") {
												console.log(data);
												var userback = JSON.parse(data);
												var status = userback.status;
												if (status != null
														&& status.indexOf("1") != -1) {
													var classes = userback.classes;
													$("#classes").html("");
													if (classes != null
															&& classes.length > 0) {
														for (var i = 0; i < classes.length; i++) {
															$("#classes")
																	.append(
																			"<span>"
																					+ classes[i].name
																					+ "</span>");
															$("#classes")
																	.append(
																			'<input type="checkbox" name="classes" value='+classes[i].id+' />');
														}
													}
													if (doType == "2") {
														var user = userback.user;
														var myClasses = userback.myClasses;
														if (user != null) {
															$("#name").val(
																	user.name);
															$("#phoneNumber")
																	.val(
																			user.phoneNumber);
															$("#password")
																	.val(
																			user.password);
															$(
																	"input:radio[value='"
																			+ user.type
																			+ "']")
																	.attr(
																			"checked",
																			true);
															if (user.type == 1) {
																$(
																		'input:checkbox')
																		.each(
																				function() {
																					$(
																							this)
																							.attr(
																									'checked',
																									true);
																				});
															} else {
																if (myClasses != null
																		&& myClasses.length > 0) {
																	for (var i = 0; i < myClasses.length; i++) {
																		$(
																				"input:checkbox[value='"
																						+ myClasses.id
																						+ "']")
																				.attr(
																						'checked',
																						true);
																	}
																}
															}
														}
													}
													$.unblock();
												} else {
													$.unblock();
													alert("数据请求失败");
												}
											} else {
												$.unblock();
												alert("数据请求失败");
											}

										} else {
											//  removeLoading();
											//  uexWindow.closeToast();
											$.unblock();
											alert("请求发送失败");
										}
										// var userback = JSON.parse(data);
										//   console.log("nnnnnn"+userback.phoneNumber);
									}

								})
					}, 1000);
		}
	</script>
</body>
</html>

