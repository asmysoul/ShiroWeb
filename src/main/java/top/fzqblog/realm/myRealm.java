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
 *    Create at:   2016年9月27日 上午10:14:23
 *
 *    Revision:
 *
 *    2016年9月27日 上午10:14:23
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
 * @Description 实现自定义realm
 * @author 抽离
 * @Date 2016年9月27日 上午10:14:23
 * @version 1.0.0
 */
public class myRealm extends AuthorizingRealm{
	private UserDao userDao = new UserDao();

	/**
	 * 授权
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
	 *认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User user = userDao.selectUser(username);
		if(user != null){
			AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "xx");//妈的智障 这边realm的名字不能为null得随便写一个。
			return authenticationInfo;
		}
		return null;
	}

}
