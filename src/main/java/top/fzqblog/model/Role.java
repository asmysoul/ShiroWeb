
package top.fzqblog.model;

/**
 * @ClassName Role
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年9月27日 下午1:48:47
 * @version 1.0.0
 */
public class Role {
	
	private Integer id;
	
	private  String rolename;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the rolename
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * @param rolename the rolename to set
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	
}
