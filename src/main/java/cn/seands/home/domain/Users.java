/**
 * 
 */
package cn.seands.home.domain;

/**
 * @author Seands
 * @date 2015年8月24日
 * @Description Users实体类
 *
 */
public class Users {

	private String id;
	private String name;
	private String pswd;
	private String mail;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String id, String name, String pswd, String mail) {
		super();
		this.id = id;
		this.name = name;
		this.pswd = pswd;
		this.mail = mail;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
