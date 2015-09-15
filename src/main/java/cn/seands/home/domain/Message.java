/**
 * 
 */
package cn.seands.home.domain;

/**
 * @author Seands
 * @date 2015年9月10日
 * @Description TODO
 *
 */
public class Message {

	private String userName;
	private String msg;

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String userName, String msg) {
		super();
		this.userName = userName;
		this.msg = msg;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
