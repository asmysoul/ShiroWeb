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
 *    Description: TODO(��һ�仰�������ļ���ʲô)
 *
 *    Copyright:   Copyright (c) 2001-2014
 *
 *    Company:     Digital Telemedia Co.,Ltd
 *
 *    @author:     ����
 *
 *    @version:    1.0.0
 *
 *    Create at:   2016��9��27�� ����10:32:37
 *
 *    Revision:
 *
 *    2016��9��27�� ����10:32:37
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.dao.test;

import top.fzqblog.dao.UserDao;

/**
 * @ClassName UserDaoTest
 * @Description TODO(������һ�仰��������������)
 * @author ����
 * @Date 2016��9��27�� ����10:32:37
 * @version 1.0.0
 */
public class UserDaoTest {
	public static void main(String[] args) {
		UserDao userDao = new UserDao();
		System.out.println(userDao.selectPermission("������"));
	}
}
