/**
 *公用js文件代码
 */
(function(){
	window.Common = {
			tpls:{},
			init	:function(){
				this.setTpls();
			},
			setTpls:function(){
				var me=this;
				if($("script[type='text/html']").length==0){
					return ;
				}
				$("script[type='text/html']").each(function(){
					var id=$(this).attr("id");
					var html=$(this).prop("innerHTML");
					me.tpls[id]=template.compile(html);
				});
			},
			/***
			 * 传入参数进行渲染
			 * @param {Object} id 渲染的模板id
			 * @param {Object} cfg 渲染的参数
			 * @param {Object} appendId 需要渲染的位置
			 */
			render:function(id,cfg,appendId){
				if(!id){
					throw new Error("要渲染的id不存在");
					return ;
				}
				if(typeof cfg=="undefined"|| !cfg){
					cfg = {};
				}
				var html=this.getHtml(id,cfg);
				if(!appendId){
					$("#container").prop("innerHTML",html);
					return ;
				}
				if($("#"+appendId+"").length==0){
					throw new Error("要渲染的id在页面上不存在");
					return ;
				}
				$("#"+appendId+"").prop("innerHTML",html);
					this.afterRender();
				},
				getTpl:function(id){
					if(!id){
						return ;
					}
					return this.tpls[id];
				},
				getHtml:function(id,cfg){
					if(!id){
						return ;
					}
				if(typeof cfg=="undefined"){
					return ;
				}
				var html =this.getTpl(id)(cfg);
					return html;
				},
				afterRender	:function(){
						
				}
	};
	window.Common.init();
})();