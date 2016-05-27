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
							<h4>科目信息</h4>
							<div class="captions">

								<button type="button" class="btn btn-primary btn-sm" id="add">
									<i class="glyphicon glyphicon-plus"></i> 添加科目</button>
							</div>

						</div>
					</div>

				</div>



			</div>

		</div>
		<div class="row row-offset-top">
			<div class="col-sm-12">
				<div class="table-container">
					<table class="table table-hover table-bordered js-table" id="subjectTable">
						<thead>
							<tr>

								<th>科目名</th>
								<th>操作</th>


							</tr>
						</thead>
						<tbody id="tbody">
<!-- 							<tr> -->

<!-- 								<td>科目</td> -->
<!-- 								<td align="center"><button class="btn btn-primary btn-sm">删除</button> -->
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
    var doType = "1";
	var id = "";
	$(document).ready(function() {
                sendData("");
		});
    $("#add").on("click",function() {
      show_prompt(null);
    });
    
    function deleteSubject(e){
       var p = e.parentNode.parentNode.children;
       var a =[] ;
       for(var i=0;i<p.length;i++){
           a.push(p[i]);
       }
       id = a[2].innerHTML;
       var json = new Object();
       json.id = id;
       json.doType ="3";
       var str = JSON.stringify(json);
			sendData1(str,e);
        
       }

   function update(e) {
       var p = e.parentNode.parentNode.children;
       var a =[] ;
       for(var i=0;i<p.length;i++){
           a.push(p[i]);
       }
       id = a[2].innerHTML;
       doType ="2";
       show_prompt(e);
	}
    function show_prompt(e){  
    var value = prompt('班级名字：', '');  
    if(value == null){  
        // alert('班级名不能为空，请重新输入！');    
    }else if(value == ''){  
        alert('班级名不能为空，请重新输入！');  
        show_prompt(e);  
    }else{  
        var json = new Object();
        json.doType = doType;
        json.name =value;
        if(doType =="1"){
        }else if(doType =="2"){
         json.id =id;
        }
        var str = JSON.stringify(json);
			sendData1(str,e);
     }  
    }   
    
    function sendData1(str,e) {
		//	$.block();
			setTimeout(
					function() {
						$
								.ajax({
									type : 'post',
									url : ipVal
											+ 'web/webAction!updateSubject',
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
														var subject = userback.subject;
														 var tbody = $("#tbody");
														 var tr =  $("<tr></tr>");
															     tr.append('<td>'+subject.name+'</td>');
															     tr.append('<td align="center"><button class="btn btn-primary btn-sm" name="delete" onclick="deleteSubject(this)">删除</button> <button class="btn btn-primary btn-sm" name="update" onclick="update(this)">修改</button></td>');
															     tr.append('<td style="visibility:hidden">'+subject.id+'</td>');
														alert("添加成功");  
													    tbody.append(tr);    
												//	$.unblock();
												} else if(status != null
														&& status.indexOf("2") != -1){
														var subject = userback.subject;
														alert("修改成功"); 
														e.parentNode.parentNode.children[0].innerHTML =subject.name;
												}else if(status != null
														&& status.indexOf("3") != -1){
													    var i=e.parentNode.parentNode.rowIndex;
                                                       document.getElementById('subjectTable').deleteRow(i);
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
						$.ajax({
									type : 'post',
									url : ipVal
											+ 'web/webAction!getAllSubjectInfo',
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
													var subjects = userback.subjects;
													 var tbody = $("#tbody");
													  tbody.html("");
													if (subjects != null
															&& subjects.length > 0) {
														for (var i = 0; i < subjects.length; i++) {
															 var tr =  $("<tr></tr>");
															     tr.append('<td>'+subjects[i].name+'</td>');
															     tr.append('<td align="center"><button class="btn btn-primary btn-sm" name="delete" onclick="deleteSubject(this)">删除</button> <button class="btn btn-primary btn-sm" name="update" onclick="update(this)">修改</button></td>');
															     tr.append('<td style="visibility:hidden">'+subjects[i].id+'</td>');
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

