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
							<h4>用户信息</h4>
							<div class="captions">

								<button type="button" class="btn btn-primary btn-sm" id="add">
									<i class="glyphicon glyphicon-plus"></i> 添加用户
								</button>
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

								<th>用户名</th>
								<th>电话号码</th>
								<th>权限</th>
								<th>操作</th>


							</tr>
						</thead>
						<tbody id="tbody">
							<!-- 							<tr> -->

							<!-- 								<td>郑宇翔</td> -->
							<!-- 								<td>18380462530</td> -->
							<!-- 								<td>教师</td> -->
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
		function sendData(str) {
			$.block();
			setTimeout(
					function() {
						$
								.ajax({
									type : 'post',
									url : ipVal
											+ 'web/webAction!getAllUserInfo',
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
													var users = userback.users;
													 var tbody = $("#tbody");
													  tbody.html("");
													if (users != null
															&& users.length > 0) {
														for (var i = 0; i < users.length; i++) {
														     var type="";
														     if(users[i].type == 1){
														         type="园长";
														     }else if(users[i].type ==2){
														         type="教师";
														     }
														     else if(users[i].type ==3){
														         type="家长";
														     }
															 var tr =  $("<tr></tr>");
															     tr.append('<td>'+users[i].name+'</td>');
															     tr.append('<td>'+users[i].phoneNumber+'</td>');
															     tr.append('<td>'+type+'</td>');
															     tr.append('<td align="center"><button class="btn btn-primary btn-sm delete" name="delete">删除</button> <button class="btn btn-primary btn-sm update" name="update"  onclick="update(this)" >修改</button></td>');
															     tr.append('<td style="visibility:hidden">'+users[i].type+'</td>');
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
		$("#add").on("click", function() {
			window.location.href = "addUser.jsp";
		});
// 		$(".update").on("click", function() {
// 		    alert(1);
// 		    localStorage.a = 3;
// 			window.location.href = "addUser.jsp";
// 		});
       function update(e) {
       debugger;
       var p = e.parentNode.parentNode.children;
       var a =[] ;
       for(var i=0;i<p.length;i++){
           a.push(p[i]);
       }
       localStorage.name = a[0].innerHTML;
       localStorage.phoneNumber = a[1].innerHTML;
       localStorage.type = a[4].innerHTML;
    //   console.log(a);
//        var e = e;
//        console.log(id);
// 		    localStorage.a = 3;
// 			window.location.href = "addUser.jsp";
	}
	</script>
</body>
</html>

