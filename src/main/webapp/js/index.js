/**
 * @author Seands
 */
$(function(){
	var pageNum = new Number(1);
	var pageSize = new Number(0);
	$.ajaxSetup({ async : false });
	$.post('msg/frsMsg.do',{},function(result){
		pageSize = result.pageSize;
		createMsgDiv(result);
		
	},'json');
	$.ajaxSetup({ async : true });
	
	/* 点赞  */
	$(".bac1").toggle(function(){
		$(this).css({
			"transition": "all 2.5s",
			"-webkit-transition": "all 2.5s",
			"transform": "rotateY(360deg)",
			"-webkit-transform": "rotateY(360deg)",
		});
		$(".bac1 .iconFont").css({
			"font-size":"35px",
			"color":"#fab27b"
		});
		$(".num1").text(5);
		/*$.post('','',function(result){
		 	if(result.msg){
		 		$(".num1").text(result.num);
		 	}else{
		 		$(".num1").text("1");
		 	}
		 },'json');*/
		
	},function(){
		$(this).css({
			"transition": "all 2.5s",
			"-webkit-transition": "all 2.5s",
			"transform": "rotateY(0deg)",
			"-webkit-transform": "rotateY(0deg)",
		});
		$(".bac1 .iconFont").css({
			"font-size":"20px",
			"color":"#FFF"
		});
		$(".num1").text("人品好");
	});
	
	/* 无感  */
	$(".bac2").toggle(function(){
		$(this).css({
			"transition": "all 2.5s",
			"-webkit-transition": "all 2.5s",
			"transform": "rotateY(360deg)",
			"-webkit-transform": "rotateY(360deg)",
		});
		$(".bac2 .iconFont").css({
			"font-size":"35px",
			"color":"#fab27b"
		});
		$(".num2").text(5);
		/*$.post('','',function(result){
		 	if(result.msg){
		 		$(".num2").text(result.num);
		 	}else{
		 		$(".num2").text("1");
		 	}
		 },'json');*/
		
	},function(){
		$(this).css({
			"transition": "all 2.5s",
			"-webkit-transition": "all 2.5s",
			"transform": "rotateY(0deg)",
			"-webkit-transform": "rotateY(0deg)",
		});
		$(".bac2 .iconFont").css({
			"font-size":"20px",
			"color":"#FFF"
		});
		$(".num2").text("不知道");
	});
	
	/* 点赞  */
	$(".bac3").toggle(function(){
		$(this).css({
			"transition": "all 2.5s",
			"-webkit-transition": "all 2.5s",
			"transform": "rotateY(360deg)",
			"-webkit-transform": "rotateY(360deg)",
		});
		$(".bac3 .iconFont").css({
			"font-size":"35px",
			"color":"#fab27b"
		});
		$(".num3").text(5);
		/*$.post('','',function(result){
		 	if(result.msg){
		 		$(".num3").text(result.num);
		 	}else{
		 		$(".num3").text("1");
		 	}
		 },'json');*/
		
	},function(){
		$(this).css({
			"transition": "all 2.5s",
			"-webkit-transition": "all 2.5s",
			"transform": "rotateY(0deg)",
			"-webkit-transform": "rotateY(0deg)",
			"color":"#FFF"
		});
		$(".bac3 .iconFont").css({
			"font-size":"20px",
			"color":"#FFF"
		});
		$(".num3").text("网页好");
	});
	
	
	
	$("#shuai").click(function(){
		$("#paddr").css("visibility","visible");
	});
	
	$("#Message").click(function(){
		var userName = $("#userName").val();
		var msg = $("#msg").val();
		$.post("msg/addMsg.do",{userName:userName,msg:msg},function(result){
			
			pageSize = result.pageSize;
			createMsgDiv(result);
			
		},'json');
	});
	
	/**
	 * 换一批 留言
	 */
	$("#moreMsg").click(function(){
		pageNum++;
		if(pageNum>pageSize){
			pageNum = 1;
		}
		$.post('msg/selMsg.do',{pageNum: pageNum},function(result){
			
			createMsgDiv(result);
			
		},'json');
	});
	
	
	textChange($("#msg"),"哎哟、不错哦！");
	textChange($("#userName"),"用户名或邮箱");
});


function createMsgDiv(result){
	$("#msgWrapper").empty();
	var array = result.msg;
	$.each(array,function(i,v){
		var str = "<div class=\"messageBoard\">";
			str += "<div>";
			str += v.msg;
			str += "</div><div>--";
			str += v.userName;
			str += "</div></div>";
		var div = $(str);
		$("#msgWrapper").append(div);
	});
	$("#msgWrapper").append("<div style=\"clear: both;\"></div>");
}