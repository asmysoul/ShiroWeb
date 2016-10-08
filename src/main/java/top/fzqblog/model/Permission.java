/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.model
 *
 *    Filename:    Permission.java
 *
 *    Description: TODO(用一句话描述该文件做什么)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     抽离
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016年9月27日 下午1:53:27
 *
 *    Revision:
 *
 *    2016年9月27日 下午1:53:27
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.model;

/**
 * @ClassName Permission
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年9月27日 下午1:53:27
 * @version 1.0.0
 */
public class Permission {
	
	private Integer id;
	
	private String permname;

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
	 * @return the permname
	 */
	public String getPermname() {
		return permname;
	}

	/**
	 * @param permname the permname to set
	 */
	public void setPermname(String permname) {
		this.permname = permname;
	}
	
	
}
