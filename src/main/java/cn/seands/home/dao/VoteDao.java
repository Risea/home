/**
 * 
 */
package cn.seands.home.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import cn.seands.home.domain.Vote;

/**
 * @author Seands
 * @date 2015年9月14日
 * @Description TODO
 *
 */
@Repository("voteDao")
public class VoteDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 插入投票记录
	 * 如果ip（addr字段）重复、更新记录
	 * @param vote
	 * @return true 插入记录成功   false 插入失败、ip重复
	 */
	public void vote(Vote vote){
		String sql = "select count(*) from vote where addr = ?";
		int num = this.jdbcTemplate.queryForInt(sql, vote.getAddr());
		if(num>0){
			
			sql = "update vote set personality=?,webPage=?,notFeel=? where addr = ?";
			this.jdbcTemplate.update(sql,vote.getPersonality(),vote.getWebPage(),vote.getNotFeel(),vote.getAddr());
		}else {
			
			sql = "insert into vote(addr,personality,webPage,notFeel) values (?,?,?,?)";
			this.jdbcTemplate.update(sql,vote.getAddr(),vote.getPersonality(),vote.getWebPage(),vote.getNotFeel());
		}
	}
	
	
	/**
	 * 查询 各个投票的数量
	 * @return
	 */
	public Vote getCPF(){
		final Vote vote = new Vote();
		String sql = "select sum(case when personality=0 then 0 else 1 end),sum(case when webPage=0 then 0 else 1 end),sum(case when notFeel=0 then 0 else 1 end) from vote";
		this.jdbcTemplate.query(sql,new RowCallbackHandler(){

			@Override
			public void processRow(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				vote.setPersonality(rs.getInt(1));
				vote.setWebPage(rs.getInt(2));
				vote.setNotFeel(rs.getInt(3));
			}
			
		});
		return vote;
	}

}
