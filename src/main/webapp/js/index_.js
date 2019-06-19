$(function(){
	
	
	//左侧固定悬浮导航栏
		//设置标杆
		var _line=parseInt($(window).height()/3);
		$(window).scroll(function(){
			//滚动730px，左侧导航固定定位
			if ($(window).scrollTop()>1615) {
				$('.containt_l').css(
				{

					'position':'fixed',
					'top':10
				})
			}else{
				$('.containt_l').css({'position':'','top':''})
			};
			$('.containt_l li').eq(0).addClass('active');
			//滚动到标杆位置,左侧导航加active
			$('.containt_r li').each(function(){
				var _target=parseInt($(this).offset().top-$(window).scrollTop()-_line);
				var _i=$(this).index();
				if (_target<=0) {
					$('.containt_l li').removeClass('active');
					$('.containt_l li').eq(_i).addClass('active');
				}
				//如果到达页面底部，给左侧导航最后一个加active
				else if($(document).height()==$(window).scrollTop()+$(window).height()){
					$('.containt_l li').removeClass('active');
					$('.containt_l li').eq($('.containt_r li').length-1).addClass('active');
				}
			});
		});
		$('.containt_l li').click(function(){
			$(this).addClass('active').siblings().removeClass('active');
			var _i=$(this).index();
			 $('body, html').animate({scrollTop:$('.containt_r li').eq(_i).offset().top-_line},500);
		});
		
		
		
		
		//登录模态事件
		//创建功能菜单
		function creatediv0(){
			var temp=$("#test");

			var parentdiv=$("<div>欢迎您,</div>");
			
			temp.replaceWith(parentdiv);
			parentdiv.attr('class', 'replace');
			parentdiv.attr('id', 'replace');
};
		function creatediv1(){
						

						var parentdiv=$("<div></div>");
						var childdiv0=$("<ul></ul>");
						childdiv0.attr('class', 'addul');
						childdiv0.appendTo(parentdiv);
						var childdiv00=$("<li></li>");
						var childdiv01=$("<li></li>");
						var childdiv02=$("<li></li>");
						var childdiv03=$("<li></li>");
						var childdiv04=$("<li></li>");
						
						childdiv00.appendTo(childdiv0);
						childdiv01.appendTo(childdiv0);
						childdiv02.appendTo(childdiv0);
						childdiv03.appendTo(childdiv0);
						childdiv04.appendTo(childdiv0);
						
						var childdiv000=$("<a href='grade1'>选课管理</a>");
						var childdiv010=$("<a href='grade2'>成绩导入</a>");
						var childdiv030=$("<a href='grade3'>成绩分析</a>");
						var childdiv040=$("<a href='grade4'>成绩预警</a>");
	
						childdiv000.appendTo(childdiv00);
						childdiv010.appendTo(childdiv01);
						childdiv030.appendTo(childdiv03);
						childdiv040.appendTo(childdiv04);
						return parentdiv;
		};
		function creatediv2(){
			var parentdiv=$("<div></div>");
			var childdiv0=$("<ul></ul>");
			childdiv0.attr('class', 'addul');
			childdiv0.appendTo(parentdiv);
			var childdiv00=$("<li></li>");
			var childdiv01=$("<li></li>");
			
			
			childdiv00.appendTo(childdiv0);
			childdiv01.appendTo(childdiv0);
			
			
			var childdiv000=$("<a href='course'>学生选课</a>");
			var childdiv010=$("<a href='choose'>选课结果查看</a>");
			

			childdiv000.appendTo(childdiv00);
			childdiv010.appendTo(childdiv01);
			
			return parentdiv;
						
	
		};
		function creatediv01(){
			var parentdiv1=$("<li></li>");
			parentdiv1.attr('class', 'nav-item');
			var childdiv1=$("<a href='addMedia.html'>课程上传</a>");
			childdiv1.attr('class', 'nav-link');
			childdiv1.appendTo(parentdiv1);
			
			var parentdiv2=$("<li></li>");
			parentdiv2.attr('class', 'nav-item');
			var childdiv2=$("<a href='playMedia'>查看课程视频</a>");
			childdiv2.attr('class', 'nav-link');
			childdiv2.appendTo(parentdiv2);
			
			var aim=$("#navbarSupportedContent");
			console.log(aim);
			parentdiv1.appendTo(aim);
			parentdiv2.appendTo(aim);
			console.log("成功了");			
		};
		function creatediv02(){
			var parentdiv1=$("<li></li>");
			parentdiv1.attr('class', 'nav-item');
			var childdiv1=$("<a href='choose'>成绩查询</a>");
			childdiv1.attr('class', 'nav-link');
			childdiv1.appendTo(parentdiv1);
			
			var parentdiv2=$("<li></li>");
			parentdiv2.attr('class', 'nav-item');
			var childdiv2=$("<a href='playMedia'>查看课程视频</a>");
			childdiv2.attr('class', 'nav-link');
			childdiv2.appendTo(parentdiv2);
			
			var aim=$("#navbarSupportedContent");
			parentdiv1.appendTo(aim);
			parentdiv2.appendTo(aim);
			console.log("成功了");			
		};
		$("#enroll").click(function(){
			window.location.href="enroll.html";
		});

		$("#login").click(function(event) {
			
				/* Act on the event */
//				var $json={'username': $('#name').val(),
//					'userpassword':$('#password').val()};
//				var $postdata=JSON.stringify($json);
//				console.log($postdata);
				var $name=$("#name").val();
				var $no=$("#no").val();
				var $password=$("#password").val();
				
				$.ajax({
					url: 'record',
					type: "post",
					dataType: 'json',
					data: {name:$name,no:$no,password:$password},
					success:function(json){
						var data=json.result;
						alert(data);
						if(data=="登录成功"){
							creatediv0();
							$("#replace").append(json.name);
							var type=json.type;
							console.log(type);
							if(type==1){
								console.log("@@@@@@");
								var menu=creatediv1();
								creatediv01();
							}else{
								console.log("%%%%%%%");
								var menu=creatediv2();
								creatediv02();
							}
							$(".replace").mousemove(function(event) {
								/* Act on the event */
								$(".replace").append(menu);
								menu.addClass('replace');
								menu.addClass('menu0');
							});
						
							$(".replace").mouseleave(function(event) {
								
								menu.remove();
							});
						}
					},
					error:function() {
					/* Act on the event */
						alert("that is wrong!");
					}
						
						
						
//						alert(data);
//						if(data=="登陆成功"){
//						creatediv0();
//						var menu=creatediv1();
//						$(".replace").mousemove(function(event) {
//							/* Act on the event */
//							$(".replace").append(menu);
//							menu.addClass('replace');
//							menu.addClass('menu0');
//						});
//						
//						$(".replace").mouseleave(function(event) {
//							
//							menu.remove();
//						});
//						}
//					
//					
//					},
//					error:function() {
//					/* Act on the event */
//						alert("that is wrong!");
//					}

				
				});
			});
	});