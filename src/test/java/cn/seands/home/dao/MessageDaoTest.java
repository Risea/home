/**
 * 
 */
package cn.seands.home.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.seands.home.domain.Message;

/**
 * @author Seands
 * @date 2015年9月11日
 * @Description TODO
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationContext.xml")
public class MessageDaoTest {

	@Autowired
	private MessageDao messageDao;
	
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
	 * Test method for {@link cn.seands.home.dao.MessageDao#addMessage(cn.seands.home.domain.Message)}.
	 */
	//@Test
	public void testAddMessage() {
		Message msg = new Message("Risea","测试类编写、！");
		int result = this.messageDao.addMessage(msg);
		System.out.println(result);
		assertTrue(result>0);
	}

	/**
	 * Test method for {@link cn.seands.home.dao.MessageDao#selectMsg(int)}.
	 */
	//@Test
	public void testSelectMsg() {
		List<Message> list = this.messageDao.selectMsg(3);
		for (Message message : list) {
			System.out.println(message.getMsg());
		}
		assertTrue(list.size()>=0);
	}
	
	@Test
	public void testGetMsgPageSize(){
		int pageSize = messageDao.getMsgPageSize();
		System.out.println(pageSize);
		assertTrue(pageSize==6);
	}

}
