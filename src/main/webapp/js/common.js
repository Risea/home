/**
 * @author Seands
 */

/**
 * 对input里面的值初始化
 * str 初始化值
 */
function textChange(obj,str){
	obj.click(function(){
		if(obj.val()==str){
			obj.val("");
		}
	});
	
	obj.blur(function(){
		if($.trim(obj.val())==""){
			obj.val(str);
		}
	});
}