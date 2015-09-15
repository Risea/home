/**
 * 
 */
package cn.seands.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.seands.home.domain.Message;

/**
 * @author Seands
 * @date 2015年9月10日
 * @Description TODO
 *
 */
@Repository("messageDao")
public class MessageDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private int size = 4;
	
	/**
	 * 添加一条 留言
	 * @param msg
	 * @return
	 */
	public int addMessage(Message msg){
		int result = this.jdbcTemplate.update("insert into message(userName,msg) values (?,?)", msg.getUserName(),msg.getMsg());
		return result;
	}
	
	
	/**
	 * 根据 页面 参数分页查询msg 
	 * 默认 5 条
	 * @param pageNum
	 * @return
	 */
	public List<Message> selectMsg(int pageNum){

		pageNum = (pageNum-1)*size;//从第几条记录开始
		List<Message> list = new ArrayList<Message>();
		list = this.jdbcTemplate.query("select * from message order by id desc limit ?,?", new RowMapper<Message>(){
			
			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message msg = new Message();
				msg.setUserName(rs.getString("userName"));
				msg.setMsg(rs.getString("msg"));
				return msg;
			}
		}, pageNum,size);
		
		return list;
	}
	
	/**
	 * 查询 msg 总页数
	 * @return
	 */
	public int getMsgPageSize(){
		int count = this.jdbcTemplate.queryForInt("select count(*) from message");
		int pageSize = count/size;
		if(count%size==0){
			return pageSize;
		}else{
			return pageSize+1;
		}
	}
}
