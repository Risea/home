/**
 * 
 */
package cn.seands.home.domain;

/**
 * @author Seands
 * @date 2015年9月14日
 * @Description TODO
 *
 */
public class Vote {

	private Integer id;
	private String addr;
	private Integer personality;
	private Integer webPage;
	private Integer notFeel;

	public Vote() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vote(Integer id, String addr, Integer personality, Integer webPage,
			Integer notFeel) {
		super();
		this.id = id;
		this.addr = addr;
		this.personality = personality;
		this.webPage = webPage;
		this.notFeel = notFeel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public Integer getPersonality() {
		return personality;
	}

	public void setPersonality(Integer personality) {
		this.personality = personality;
	}

	public Integer getWebPage() {
		return webPage;
	}

	public void setWebPage(Integer webPage) {
		this.webPage = webPage;
	}

	public Integer getNotFeel() {
		return notFeel;
	}

	public void setNotFeel(Integer notFeel) {
		this.notFeel = notFeel;
	}

}
