/**
 * 
 */
package cn.seands.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import cn.seands.home.dao.VoteDao;
import cn.seands.home.domain.Vote;

/**
 * @author Seands
 * @date 2015年9月14日
 * @Description TODO
 *
 */
public class VoteService {

	@Autowired
	@Qualifier("voteDao")
	private VoteDao vote;
	
	
	public void vote(Vote vote){
		this.vote.vote(vote);
	}
	
	public Vote getCPF(){
		return this.vote.getCPF();
	}
}
