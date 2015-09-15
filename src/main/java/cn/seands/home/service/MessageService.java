/**
 * 
 */
package cn.seands.home.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.seands.home.dao.MessageDao;
import cn.seands.home.domain.Message;

/**
 * @author Seands
 * @date 2015年9月10日
 * @Description TODO
 *
 */
@Service("messageService")
public class MessageService {

	@Autowired
	private MessageDao messageDao;
	
	
	public int addMessage(Message msg){
		return this.messageDao.addMessage(msg);
	}
	
	public List<Message> selectMsg(int pageNum){
		return this.messageDao.selectMsg(pageNum);
	}
	
	/**
	 * 第一次页面加载  顺带查出msg的页数
	 * @return
	 */
	public Map<String,Object> findFrist(){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Message> list = this.messageDao.selectMsg(1);
		int pageSize = this.messageDao.getMsgPageSize();
		map.put("pageSize", pageSize);
		map.put("msg", list);
		return map;
	}
	
}
