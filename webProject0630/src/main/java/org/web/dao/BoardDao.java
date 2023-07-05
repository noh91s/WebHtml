package org.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.web.dbconnect.DBConnect;
import org.web.dto.BoardDto;

public class BoardDao {
	private BoardDao() {
		System.out.println("BoardDao <- 싱글톤");
	}

	private static class SingletonClass {
		private static final BoardDao INSTANCE = new BoardDao();
	}

	public static BoardDao getInstance() {
		return SingletonClass.INSTANCE;
	}

	public int insert(String board_title, String board_content, String board_writer) {
		int rs = 0;
		if (writeChecked(board_writer) != 1) {
			System.out.println("회원등록이 필요한 서비스 입니다");
			rs = 2;
			return rs;
		} else {
			Connection conn = null;
			PreparedStatement pstm = null;
			String query = "";
			try {
				conn = DBConnect.getConnection();
				query = "insert into board0630(board_title, board_content, board_writer)" + "values(?,?,?)";
				pstm = conn.prepareStatement(query);
				pstm.setString(1, board_title);
				pstm.setString(2, board_content);
				pstm.setString(3, board_writer);
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

	private int writeChecked(String board_writer) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rss = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "select count(*) from member0630 where email=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, board_writer);
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

	public ArrayList<BoardDto> boardList() {
		ArrayList<BoardDto> boards = new ArrayList<BoardDto>();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "select * from board0630";
			pstm = conn.prepareStatement(query);
			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					boards.add(new BoardDto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
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
		return boards;
	}

	public BoardDto boardDetail(Long board_id) {
		BoardDto boardDetail = new BoardDto();

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "select * from board0630 where board_id=?";
			pstm = conn.prepareStatement(query);
			pstm.setLong(1, board_id);

			rs = pstm.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					boardDetail = new BoardDto(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getTimestamp(5));
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
		return boardDetail;
	}

	public int update(Long board_id, String board_title, String board_content) {
		int rs = 0;

		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "update board0630 set board_title=?,board_content=? where board_id=?";
			pstm = conn.prepareStatement(query);
			pstm.setString(1, board_title);
			pstm.setString(2, board_content);
			pstm.setLong(3, board_id);
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

	public int delete(Long board_id) {
		int rs = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		String query = "";
		try {
			conn = DBConnect.getConnection();
			query = "delete from board0630 where board_id=?";
			pstm = conn.prepareStatement(query);
			pstm.setLong(1, board_id);
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
