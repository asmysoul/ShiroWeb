/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.dao.test
 *
 *    Filename:    UserDaoTest.java
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
 *    Create at:   2016年9月27日 上午10:32:37
 *
 *    Revision:
 *
 *    2016年9月27日 上午10:32:37
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.dao.test;

import top.fzqblog.dao.UserDao;

/**
 * @ClassName UserDaoTest
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author 抽离
 * @Date 2016年9月27日 上午10:32:37
 * @version 1.0.0
 */
public class UserDaoTest {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		System.out.println(userDao.selectPermission("夯大力"));
	}
}
