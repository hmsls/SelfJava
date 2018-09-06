package InceptorTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Hive2JDBCExample {
	private static String DriverName = "org.apache.hive.jdbc.HiveDriver";
	public static void main(String[] args) throws SQLException {
		try{
			Class.forName(DriverName);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.exit(1);
		}
		
		String jdbcURL = "jdbc:hive2://0.0.0.0:10000/lishuai";
		Connection conn = DriverManager.getConnection(jdbcURL);
		Statement sta = conn.createStatement();
		String sql = "create table testConnection (id string,name string,age string)";
//		ResultSet rs = sta.executeQuery(sql);
//		while(rs.next()){
//			System.out.println(rs.getString(0));
//			
//		}
//		rs.close();
		sta.execute(sql);
		sta.close();
		conn.close();
	}
}
