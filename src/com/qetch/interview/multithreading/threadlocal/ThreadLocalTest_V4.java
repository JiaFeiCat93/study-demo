package com.qetch.interview.multithreading.threadlocal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 最常见的ThreadLocal使用场景为：用来解决数据库连接、session管理等。
 * @ClassName: ThreadLocalTest_V4
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月17日 下午6:48:30
 */
public class ThreadLocalTest_V4 {
	/**
	 * 数据库连接
	 */
	private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "root";
	
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
		
		@Override
		protected Connection initialValue() {
			try {
				return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}
	};
	
	public static Connection getConnection() {
		Connection conn = connectionHolder.get();
		try {
			if (null == conn || conn.isClosed()) {
				// 创建新的connection（代码略）
				connectionHolder.set(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close() {
		Connection conn = connectionHolder.get();
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				connectionHolder.remove();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println(getConnection());
	}
	
	/**
	 * session管理：hibernate中典型的ThreadLocal应用
	 */
	/*private static final ThreadLocal threadSession = new ThreadLocal();
	
	public static Session getSession() throws InfrastructureException {
		Session s = (Session) threadSession.get();
		try {
			if (null == s) {
				s = getSessionFactory().openSession();
				threadSession.set(s);
			}
		} catch (HibernateException e) {
			throw new InfrastructureException(e);
		}
		return s;
	}*/
}
