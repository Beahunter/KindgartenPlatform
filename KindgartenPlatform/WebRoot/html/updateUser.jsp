<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>addGoods.html</title>
	 
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
 	<script type="text/javascript" src="../3party/jquery/jquery-2.2.3.min.js"></script>
  	<script type="text/javascript" src="../3party/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
  	<script src="../3party/template/template_debug_3_0_0.js"></script>
 
  	<link href="../3party/bootstrap-3.3.5-dist/css/bootstrap.css" rel="styleSheet" type="text/css"></link>
  	<link href="../css/common.css" rel="styleSheet" type="text/css"></link>
	<style type="text/css">
		.header {
    border-bottom: dotted 1px #ddd;
}
.up-images{
	display: inline-block;
}
.images{
	height: 100px;
	background: #F6F7FB;
	text-align: center;
	color:#C1C2C6;
	border:solid 1px rgba(51,51,51,.4);
	padding-top: 50px;
}
.left{
	margin-left: 15px;
}
	</style>
  </head>
  
  <body style="min-height: 1200px;">
  	<div class="container-fluid">
    	<div class="row">
        	<div class="col-sm-12">
            	<div class="header">
                	<h4>
                        基本信息
                    </h4>
                </div>
            </div>
        </div>
        <div class="row row-offset-top row-offset-bottom">
        	<div class="col-sm-3">
        		<span>商品信息:</span>
        	</div>
        	<div class="col-sm-6">
        		<div class="">
        			<div class="row">
        				<div class="col-sm-3">
        					<label>*商品名称:</label>
        				</div>
	        			 <div class="col-sm-9">
		        				<div class="form-inline">
		        					<div class="form-group">
			        					
			        					<input type="text" class="form-control">
			        				</div>
		        				</div>
		        			</div> 
        			</div>
        		<div class="row row-offset-top">
        			 <div class="col-sm-3">
        			 	<label>*上架日期:</label>
        			 </div>
        			<div class="col-sm-9">
        				<div class="form-inline">
		        					<div class="form-group">
			        					
			        					<input type="text" class="form-control" >
			        				</div>
		        				</div>
		        			</div> 
        			</div>
        		</div>
        		<div class="row row-offset-top">
        			 <div class="col-sm-3">
        			 	<label>&nbsp;商品价格:</label>
        			 </div>
        			<div class="col-sm-9">
        				<div class="form-inline">
		        					<div class="form-group">
			        					
			        					<input type="text" class="form-control ">
			        				</div>
		        				</div>
		        			</div> 
        			</div>
         
        		<div class="row row-offset-top ">
        			 <div class="col-sm-3">
        				 <label>*详细描述:</label>
        			 </div>
        			 <div class="col-sm-9">
	        			<div class="form-inline">
			        					<div class="form-group">
				        					
				        					<input type="text" class="form-control ">
				        				</div>
			        				</div>
			        			</div> 
        			</div>
        		</div>
        		</div>
        	<div class="row">
	        	<div class="col-sm-12">
	            	<div class="header">
	                	<h4>
	                        商品图片
	                    </h4>
	                </div>
	            </div>
	        </div>
        	<div class="row row-offset-top row-offset-bottom">
	        	<div class="col-sm-3">
	        		 
	        	</div>
	        	<div class="col-sm-6">
	        		<div class="row row-offset-top ">
	        			
	        			<div class="col-sm-3">
	        				<label>&nbsp;商品图片:</label>
	        			</div>
        				<div class="col-sm-9">
	        				<div class="form-inline">
			        			<div class="form-group">
				        			
				        			<div class="up-images">
				        				<a class="btn btn-primary btn-sm"> 本地图片</a>
				        				<a class="btn btn-default  btn-sm "> 网络图片</a>
				        			</div>
				        		</div>
			        		</div>
			        	</div> 
        			</div>
	        		<div class="row row-offset-top ">
	        			<div class="col-sm-3">
	        				<label>&nbsp;文件上传:</label>
	        			</div>
        				<div class="col-sm-9">
	        				<div class="form-inline">
			        			<div class="form-group">
				        			
				        			<div class="up-images">
				        				<input type="file" class="js-file-input" style="display: none;"/>
				        				<a class="btn btn-default btn-sm js-file"> 选择文件</a>
				        			</div>
				        		</div>
			        		</div>
			        	</div> 
        			</div>
        			<div class="row row-offset-top">
        				 <div class="col-sm-3">
        				 	<div class="images">
        				 		封面
        				 	</div>
        				 </div>
        				 <div class="col-sm-3">
        				 	<div class="images">
        				 		第二张
        				 	</div>
        				 </div>
        				 <div class="col-sm-3">
        				 	<div class="images">
        				 		第三张
        				 	</div>
        				 </div>
        				 <div class="col-sm-3">
        				 	<div class="images">
        				 		第四张
        				 	</div>
        				 </div>
        			</div>
        			<div class="row" style="margin-top: 10px;">
        				<div class="col-sm-12">
        					<span class="description">&nbsp;说明:第一张图片为商品的默认显示图片</span>
        				</div>
        			</div>
        			
	        	</div>
	        </div>
        	<div class="row">
	        	<div class="col-sm-12">
	            	<div class="header">
	                	<h4>
	                        其他信息
	                    </h4>
	                </div>
	            </div>
	        </div>
        	<div class="row row-offset-top row-offset-bottom">
	        	<div class="col-sm-3">
	        		 
	        	</div>
	        	<div class="col-sm-6">
	        		<div class="row row-offset-top ">
	        			<div class="col-sm-3" >
	        				<label>&nbsp;商品标签:</label>
	        			</div>
        				<div class="col-sm-9">
        					<div class="form-inline">
			        			<div class="form-group">
				        			
				        			<div class="up-images">
				        				<a class="btn btn-primary btn-sm " > 到店付款</a>
				        				<a class="btn btn-primary  btn-sm left"> 过期消费</a>
				        				<a class="btn btn-primary  btn-sm left"> 周末特惠</a>
				        			</div>
				        		</div>
			        		</div>
        				</div>
        			</div>
        		</div>
        	</div>
        	<div class="row row-offset-top row-offset-bottom">
	        	<div class="col-sm-3">
	        		 
	        	</div>
	        	<div class="col-sm-6">
	        		<div class="row row-offset-top ">
        				<div class="col-sm-3" >
        					<div class="form-inline">
			        			<div class="form-group">
				        			<label>&nbsp;菜品罗列:</label>
				        		</div>
			        		</div>
        				</div>
        				<div class="col-sm-9" >
        					 <textarea class="form-control" rows="" cols=""></textarea>
        				</div>
        			</div>
        		</div>
        	</div>
        	<div class="row row-offset-top row-offset-bottom">
	        	<div class="col-sm-3">
	        		 
	        	</div>
	        	<div class="col-sm-6">
	        		<div class="row row-offset-top ">
        				<div class="col-sm-12">
        					 <div style="text-align: right;">
        					 	<input type="submit" value="确认提交" class="btn btn-pink"/>
        					 </div>
        				</div>
        			</div>
        		</div>
        	</div>
       </div>
         <script type="text/javascript">
         	$(".js-file").on("click",function(){
         		$(".js-file-input").trigger("click");
         	});
         </script>
  </body>
</html>

