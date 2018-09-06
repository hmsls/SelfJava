package Test2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OraTest {
	public static void main(String[] args) {
		Connection conn ;
		PreparedStatement ppst ;
		ResultSet rs;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String user = "MSG_USER";
			String passwd = "MSG_USER";
			String url = "jdbc:oracle:thin:@localhost:1521/ODSDB";
			conn = DriverManager.getConnection(url, user, passwd);
			
			String[] idFields = {"localhost","localhost","localhost"};
			String[] mobFields = {"localhost","localhost","localhost"};
			String[] result = new String[6];
			for(int i = 0;i<idFields.length;i++){
				String sql = "select black_src from r_blaze_list_black_info where black_src = '"+idFields[i]+"'";
				try {
					ppst = conn.prepareStatement(sql);
					rs = ppst.executeQuery();
					while(rs.next()){
						if(rs.getString(1)!=null && rs.getString(1)!=""){
							result[i] = "1";
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			for(int i = 0;i<mobFields.length;i++){
				String sql = "select valid_to_tm from r_blaze_list_black_info where valid_to_tm = '"+mobFields[i]+"'";
				try {
					ppst = conn.prepareStatement(sql);
					rs = ppst.executeQuery();
					while(rs.next()){
						if(rs.getString(1)!=null && rs.getString(1)!=""){
							result[i+3] = "1";
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			for(int i = 0;i<result.length;i++){
				if(result[i] == null){
					result[i] = "0";
				}
				System.out.println(result[i]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
