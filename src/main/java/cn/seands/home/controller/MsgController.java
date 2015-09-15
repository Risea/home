/**
 * 
 */
package cn.seands.home.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.seands.home.domain.Message;
import cn.seands.home.service.MessageService;

/**
 * @author Seands
 * @date 2015年9月10日
 * @Description TODO
 *
 */
@RequestMapping("/msg")
@Controller
public class MsgController {

	@Autowired
	private MessageService messageService;
	
	
	/**
	 * 添加 留言
	 * @param msg
	 */
	@RequestMapping("/addMsg")
	public ModelAndView addMassage(@RequestParam("userName") String userName,
			@RequestParam("msg") String msg){
		System.out.println(userName+","+msg);
		Message message = new Message(userName,msg);
		this.messageService.addMessage(message);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/msg/frsMsg.do");
		return mav;
	}
	
	
	/**
	 * 查询 留言板 msg
	 * @param pageNum
	 * @return
	 */
	@RequestMapping("/selMsg")
	public @ResponseBody Map<String,List<Message>> selectMsg(@RequestParam("pageNum")int pageNum){
		List<Message> list = this.messageService.selectMsg(pageNum);
		Map<String,List<Message>> map = new HashMap<String, List<Message>>();
		map.put("msg", list);
		return map;
	}
	
	@RequestMapping("/frsMsg")
	public @ResponseBody Map<String,Object> findFrist(){
		Map<String,Object> map = this.messageService.findFrist();
		return map;
	}
}
