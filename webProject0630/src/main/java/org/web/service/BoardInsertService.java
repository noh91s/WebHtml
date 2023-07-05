package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.BoardDao;

public class BoardInsertService implements BoardService {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�Խñ۵�ϼ���");
		
		String board_title=request.getParameter("board_title");
		String board_content=request.getParameter("board_content");
		String board_writer=request.getParameter("board_writer");
		
		BoardDao dao=BoardDao.getInstance();
		int rs=dao.insert(board_title,board_content,board_writer);
		
		String returnURL="";
		
		if(rs!=1) {
			if(rs==2) {
				System.out.println("ȸ������� �ʿ��� ���� �Դϴ�");
				returnURL="/member/member_joinView.jsp";
			} else {
				System.out.println("�Խñ۵�� ����");
				returnURL="/board/board_listView.jsp";
			}
		} else {
			System.out.println("�Խñ� ��� ����");
			returnURL="/board_list.bo";
		}
		
		request.setAttribute("returnURL", returnURL);
		

	}

}
