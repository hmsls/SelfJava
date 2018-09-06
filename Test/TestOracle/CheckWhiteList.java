package TestOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



public class CheckWhiteList {
	public static Connection conn ;
	public static PreparedStatement ppst ;
	public static Connection connection (){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521/ODSDB";
			String user = "MSG_USER";
			String passwd = "MSG_USER";
			conn = DriverManager.getConnection(url,user,passwd);
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void selectTest(){
		ResultSet rs ;
		
		ResultSetMetaData rsm  ;
		String sql = "select * from xy_whitelists";
		try {
			ppst = conn.prepareStatement(sql);
			rs = ppst.executeQuery();
//			List<String> vals = new ArrayList<String>();
//			while(rs.next()){
//				for(int i = 1;i<10;i++){
//					vals.add(rs.getString(i));
//				}
//			}
//			Iterator<String> it = vals.iterator();
//			while(it.hasNext()){
//				System.out.println(it.next());
//			}
			rsm = rs.getMetaData();
			int num = rsm.getColumnCount();
			List<String> val = new ArrayList<String>();
			while(rs.next()){
				for(int i = 0;i<num;i++){
					val.add(rs.getString(i+1));
				}
			}
			System.out.println("over--------------");
			Iterator<String> it = val.iterator();
			while(it.hasNext()){
				String v = it.next();
				System.out.println(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertWhiteList() throws SQLException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = sdf.format(new Date());
		String sql = "insert into xy_whitelists values(?,?,?,?,?,?,?,?,?)";
		try {
			conn.setAutoCommit(false);
			ppst = conn.prepareStatement(sql);
			
			ppst.setString(1, "");
			ppst.setString(2, "");
			ppst.setString(3, "");
			ppst.setString(4, "");
			ppst.setString(5, "dateTime");
			ppst.setString(6, "");
			ppst.setString(7, "dateTime");
			ppst.setString(8, "");
			ppst.setString(9, "");
			
			ppst.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}finally{
			conn.close();
		}
	}
	
	public static void main(String[] args) {
		conn = connection();
		selectTest();
	}
}
