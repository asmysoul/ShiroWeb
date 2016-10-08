/******************************************************************
 *
 *    Java Lib For Android, Powered By Shenzhen Jiuzhou.
 *
 *    Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 *    http://www.d-telemedia.com/
 *
 *    Package:     top.fzqblog.dao
 *
 *    Filename:    UserDao.java
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
 *    Create at:   2016年9月27日 上午10:16:40
 *
 *    Revision:
 *
 *    2016年9月27日 上午10:16:40
 *        - first revision
 *
 *****************************************************************/
package top.fzqblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import top.fzqblog.model.User;
import top.fzqblog.util.DbUtil;

/**
 * @ClassName UserDao
 * @Description 用户数据库操作
 * @author 抽离
 * @Date 2016年9月27日 上午10:16:40
 * @version 1.0.0
 */
public class UserDao {
	DbUtil dbUtil = new DbUtil();
	
	public User selectUser(String username) {
		String sql = "select * from users where username =?";
		User user = new User();
		try {
			Connection connection = dbUtil.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setUsername(resultSet.getString("username"));
				user.setPassword(resultSet.getString("password"));
			}
	
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Set<String> selectRole(String username){
		Set<String> roleNames = new HashSet<String>();
		String sql = "select * from users u, roles r where u.role_id = r.id and u.username=?";
		try {
			Connection connection = dbUtil.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				roleNames.add(resultSet.getString("rolename"));
			}
			return roleNames;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Set<String> selectPermission(String username){
		Set<String> permsissionsSet = new HashSet<String>();
		String sql = "SELECT * FROM users u, roles r, permissions p WHERE p.role_id= r.id AND u.role_id = r.id AND username =?";
		try {
			Connection connection  = dbUtil.getCon();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				permsissionsSet.add(resultSet.getString("permname"));
			}
	
			return permsissionsSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
