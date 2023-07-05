package org.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.web.dbconnect.DBConnect;
import org.web.dto.MemberDto;

public class MemberDao {
	private MemberDao() {
		System.out.println("MemberDao <- 싱글톤");
	}

	private static class SingletonClass {
		private static final MemberDao INSTANCE = new MemberDao();
	}

	public static MemberDao getInstance() {
		return SingletonClass.INSTANCE;
	}

	public int insert(String member_name, String member_password, String email) {
		int rs = 0;
		if (emailChecked(email) != 1) {
			System.out.println("이미등록된 사용자 입니다");
			rs = 2;
			return rs;
		} else {
			Connection conn = null;
			PreparedStatement pstm = null;
			String query = "";
			try {
				conn = DBConnect.getConnection();
				query = "insert into member0630(member_name, member_password, email)" + "values(?,?,?)";
				pstm = conn.prepareStatement(query);
				pstm.setString(1, member_name);
				pstm.setString(2, member_password);
				pstm.setString(3, email);
				rs = pstm.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (pstm != null)
						pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return rs;
		}
	}

	private int emailChecked(String email) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rss = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "select count(*) from member0630 where email=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, email);
			rss = pstm.executeQuery();
			if (rss != null) {
				while (rss.next()) {
					rs = rss.getInt(1); // 작성자가 존재하면1
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rss != null)
					rss.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;

	}

	public ArrayList<MemberDto> memberList() {
		ArrayList<MemberDto> members = new ArrayList<MemberDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "select * from member0630";
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					members.add(new MemberDto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getTimestamp(5)));
					// rs.getTimestamp.
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return members;
	}

	public int delete(Long member_id) {
		int rs = 0;
		
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "delete from member0630 where member_id=?";
			pstm = conn.prepareStatement(query);
			pstm.setLong(1, member_id);
			rs = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstm != null)
					pstm.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rs;
	}
}
