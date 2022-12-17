package util;
import java.sql.*;
public class DBManager {
  private Connection conn=null;
  private Statement stmt =null;
  private ResultSet rs =null;
  /**
   * @return ·µ»ØÊý¾Ý¿âÁ¬½Ó¶ÔÏó
   */
  public Connection  ConnDB() {
	  conn = null;
	  try {  
		  String url="jdbc:mysql://localhost:3306/product?useUnicode=true&character=utf-8";
		  Class.forName("com.mysql.jdbc.Driver").newInstance();
		  conn=DriverManager.getConnection(url,"root","root");
		  return conn;
		}
		catch (Exception fe) {
			System.err.println("ConnDB(): " + fe.getMessage());
			return null;
		}
	}

  /**
   * @return ·µ»Ø×´Ì¬¼¯¶ÔÏó
   */
	public Statement CreatStat() {
		stmt = null;
		try {
			if (conn == null) {
				conn = this.ConnDB();
			}
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			return stmt;
		} catch (Exception fe) {
			System.err.println("CreatStat(): " + fe.getMessage());
			return null;
		}

	}
	/**
	 * »ñÈ¡PreparedStatementµÄ·½·¨
	 * @param sql
	 * @param autoGenereatedKeys
	 * @return
	 */
	public PreparedStatement prepare(String sql, int autoGenereatedKeys) {
		PreparedStatement pstmt = null;
		try {
		if (conn == null){
			conn = this.ConnDB();
		}
		pstmt = conn.prepareStatement(sql, autoGenereatedKeys);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return pstmt;
	}
	/**
	 * 
	 * @param sql
	 * @return ·µ»Ø¼ÇÂ¼¼¯¶ÔÏó
	 */
	public ResultSet getResult(String sql) {
		rs = null;
		try {
			stmt = this.CreatStat();
			rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException ex) {
			System.err.println("getResult: " + ex.getMessage());
			return null;
		}

	}
	/**
	 * Ö´ÐÐ¸üÐÂ É¾³ýÓï¾äµÄ·½·¨
	 * @param sql
	 * @return
	 */
	public int executeSql(String sql) {
		int RowCount;
		try {
			stmt = this.CreatStat();
			RowCount = stmt.executeUpdate(sql);
			if (!conn.getAutoCommit()) {
				conn.commit();
			}
			return RowCount;
		} catch (Exception e) {
			System.err.println("exectueSql: " + e.toString());
			return 0;
		}

	}
	/**
	 * ÊÍ·Å×ÊÔ´µÄ·½·¨
	 * @throws SQLException
	 */
	public void Release() throws SQLException {
		if (rs != null) {
			rs.close();
			rs = null;
		}
		if (stmt != null) {
			stmt.close();
			stmt = null;
		}
		if (conn != null) {
			conn.close();
			conn = null;
		}
	}
}