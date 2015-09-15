/**
 * 
 */
package cn.seands.home.dao;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.seands.home.domain.Vote;

/**
 * @author Seands
 * @date 2015年9月14日
 * @Description TODO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class VoteDaoTest {

	@Autowired
	@Qualifier("voteDao")
	private VoteDao voteDao;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link cn.seands.home.dao.VoteDao#vote(cn.seands.home.domain.Vote)}.
	 */
	@Test
	public void testVote() {
		Vote vote = new Vote(1,"10.10.1.2",1,0,1);
		this.voteDao.vote(vote);
	}

	/**
	 * Test method for {@link cn.seands.home.dao.VoteDao#getCPF()}.
	 */
	@Test
	public void testGetCPF() {
		Vote vote = new Vote();
		vote = this.voteDao.getCPF();
		System.out.println(vote.getPersonality()+","+vote.getWebPage()+","+vote.getNotFeel());
	}

}
