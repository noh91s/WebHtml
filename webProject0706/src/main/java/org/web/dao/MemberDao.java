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
//		System.out.println("MemberDao <- ½Ì±ÛÅæ");
	}

	private static class SingletonClass {
		private static final MemberDao INSTANCE = new MemberDao();
	}

	public static MemberDao getInstance() {
		return SingletonClass.INSTANCE;
	}

	public int insert(String name, String password, String email, String phone, String address, String city) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "insert into member0705(name, password, email, phone, address, city, create_time)"
					+ "values(?,?,?,?,?,?,now())";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, password);
			pstm.setString(3, email);
			pstm.setString(4, phone);
			pstm.setString(5, address);
			pstm.setString(6, city);
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

	public ArrayList<MemberDto> List() {
		ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "select * from member0705";
			pstm = conn.prepareStatement(query);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					memberList.add(new MemberDto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8),
							rs.getTimestamp(9).toLocalDateTime()));
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
		return memberList;
	}

	public MemberDto detail(Long Member_id) {
		MemberDto Memberdetail = new MemberDto();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "select * from member0705 where member_id=?";
			pstm = conn.prepareStatement(query);
			pstm.setLong(1, Member_id);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Memberdetail = new MemberDto(
							rs.getLong(1),
							rs.getString(2),
							rs.getString(3),
							rs.getString(4),
							rs.getString(5),
							rs.getString(6),
							rs.getString(7),
							rs.getString(8),
							rs.getTimestamp(9).toLocalDateTime());
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
		return Memberdetail;
		
		
	}

	public int update(Long member_id, String name, String password, String phone, String address,
			String city) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "update member0705 set name=?, password=?, phone=? , address=?, city=? where member_id=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, password);	
			pstm.setString(3, phone);
			pstm.setString(4, address);
			pstm.setString(5, city);
			pstm.setLong(6, member_id);
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

	public int delete(Long member_id) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "delete from member0705 where member_id=?";
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
