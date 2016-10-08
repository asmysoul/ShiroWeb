/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.realm
 *
 *    Filename:    myRealm.java
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
 *    Create at:   2016��9��27�� ����10:14:23
 *
 *    Revision:
 *
 *    2016��9��27�� ����10:14:23
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.realm;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import top.fzqblog.dao.UserDao;
import top.fzqblog.model.User;


/**
 * @ClassName myRealm
 * @Description ʵ���Զ���realm
 * @author ����
 * @Date 2016��9��27�� ����10:14:23
 * @version 1.0.0
 */
public class myRealm extends AuthorizingRealm{
	private UserDao userDao = new UserDao();

	/**
	 * ��Ȩ
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();  
		authorizationInfo.setRoles(userDao.selectRole(username));
		authorizationInfo.setStringPermissions(userDao.selectPermission(username));
		 return authorizationInfo;
	}

	/**
	 *��֤
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User user = userDao.selectUser(username);
		if(user != null){
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "xx");//������� ���realm�����ֲ���Ϊnull�����дһ����
			return authenticationInfo;
		}
		return null;
	}

}
