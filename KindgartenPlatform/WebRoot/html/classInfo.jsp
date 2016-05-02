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
<title></title>

<meta name="keywords" content="keyword1,keyword2,keyword3">
<meta name="description" content="this is my page">
<meta name="content-type" content="text/html; charset=UTF-8">

<script type="text/javascript"
	src="../3party/jquery/jquery-2.2.3.min.js"></script>
<script type="text/javascript"
	src="../3party/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<script src="../3party/template/template_debug_3_0_0.js"></script>
<script src="../3party/blockui-master/jquery.blockUI.js"></script>
<script src="../3party/jquery.block/jquery.block.js"></script>
<link href="../3party/bootstrap-3.3.5-dist/css/bootstrap.css"
	rel="styleSheet" type="text/css"></link>
<link href="../css/common.css" rel="styleSheet" type="text/css"></link>
<style type="text/css">
.title {
	border-bottom: solid 1px #ddd;
}

.title * {
	display: inline-block;
}

.captions {
	float: right;
	padding: 5px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-12">
						<div class="title">
							<h4>班级信息</h4>
							<div class="captions">

								<button type="button" class="btn btn-primary btn-sm" id="add">
									<i class="glyphicon glyphicon-plus"></i> 添加班级</button>
							</div>

						</div>
					</div>

				</div>



			</div>

		</div>
		<div class="row row-offset-top">
			<div class="col-sm-12">
				<div class="table-container">
					<table class="table table-hover table-bordered js-table">
						<thead>
							<tr>

								<th>班级名</th>
								<th>操作</th>


							</tr>
						</thead>
						<tbody id="tbody">
<!-- 							<tr> -->

<!-- 								<td>小班</td> -->
<!-- 								<td align="center"><button class="btn btn-primary btn-sm" id="delete">删除</button> -->
<!-- 									<button class="btn btn-default btn-sm" id="update">修改</button></td> -->
<!-- 							</tr> -->

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script src="my.js"></script>
	<script type="text/javascript">
			$(document).ready(function() {
                sendData("");
		});
	
    $("#add").on("click",function() {
      show_prompt();
    });
    $("#update").on("click",function() {
      show_prompt();
    });
    function show_prompt(){  
    var value = prompt('班级名字：', '');  
    if(value == null){  
        // alert('班级名不能为空，请重新输入！');    
    }else if(value == ''){  
        alert('班级名不能为空，请重新输入！');  
        show_prompt();  
    }else{  
        alert("添加成功");  
    }  
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

										if (requestCode.indexOf("success") != -1) {
										
											if (data != null && data != "") {
												console.log(data);
												var userback = JSON.parse(data);
												var status = userback.status;
												if (status != null
														&& status.indexOf("1") != -1) {
													var classes = userback.classes;
													 var tbody = $("#tbody");
													  tbody.html("");
													if (classes != null
															&& classes.length > 0) {
														for (var i = 0; i < classes.length; i++) {
															 var tr =  $("<tr></tr>");
															     tr.append('<td>'+classes[i].name+'</td>');
															     tr.append('<td align="center"><button class="btn btn-primary btn-sm" name="delete">删除</button> <button class="btn btn-primary btn-sm" name="update">修改</button></td>');
															     tr.append('<td style="visibility:hidden">'+classes[i].id+'</td>');
															     tbody.append(tr);
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

