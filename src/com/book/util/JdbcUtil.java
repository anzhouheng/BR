

package com.book.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * ClassName:JdbcUtil <br/> Function: TODO ADD FUNCTION. <br/> Reason: TODO ADD
 */
public class JdbcUtil {
//c3p0--连接池-----------------------------------------
	private static ComboPooledDataSource  ds=null;
	static {
		ds=new ComboPooledDataSource();
	}
//c3p0----------------end--------------------------
	/**
	 * 
	 * getConn: <br/> 
	 */
	private static Connection getConn() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return conn;
	}
	
/**
 * 
 * close: <br/>
 *
 */
	private static void close(ResultSet rs, PreparedStatement ps, Connection conn) {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				// TODO Auto-generated catch block
				e.printStackTrace();

			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
	}
	/**
	 * 
	 * getList: <br/>
	 *  
	 * Object...values
	 */
	public static List getList(Class clazz,String sql,Object...values) {
		ArrayList list = new ArrayList();
		Connection conn = getConn();
		PreparedStatement ps = null;
		ResultSet rs =null;
		try {
			ps = conn.prepareStatement(sql);
//			select * from t_tel where name=? and id=?
			for (int i = 0; i < values.length; i++) {
				ps.setObject(i+1, values[i]);
			}
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
//			
			while (rs.next()) {
				Object instance = clazz.newInstance();
				for (int i = 1; i <= columnCount; i++) {
					BeanUtils.copyProperty(instance, metaData.getColumnLabel(i), rs.getObject(i));
				}
				list.add(instance);
			}
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			close(rs, ps, conn);
		}
		return list;
	}
	
	public static boolean execute(String sql,Object...values) {
		Connection conn = getConn();
		PreparedStatement ps =null;
		boolean flag=false;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				ps.setObject(i+1, values[i]);
			}
			int i = ps.executeUpdate();
			flag=(i>0)?true:false;
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			close(null, ps, conn);
		}
		return flag;
		
	}
	public static Object getObjectById(Class clazz,String sql,Object...values) {
		Connection conn = getConn();
		PreparedStatement ps = null;
		ResultSet rs =null;
		Object instance =null;
		try {
			ps = conn.prepareStatement(sql);
//			select * from t_tel where name=? and id=?
			for (int i = 0; i < values.length; i++) {
				ps.setObject(i+1, values[i]);
			}
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
//			
			if (rs.next()) {
				instance = clazz.newInstance();
				for (int i = 1; i <= columnCount; i++) {
					BeanUtils.copyProperty(instance, metaData.getColumnName(i), rs.getObject(i));
				}
			}
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			close(rs, ps, conn);
		}	
		return instance;
	}
	public static int getCount(String sql,Object...values) {
		Connection conn = getConn();
		PreparedStatement ps =null;
		ResultSet rs =null;
		int count =0;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < values.length; i++) {
				ps.setObject(i+1, values[i]);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			close(rs, ps, conn);
		}
		
		return count;
	}
}
