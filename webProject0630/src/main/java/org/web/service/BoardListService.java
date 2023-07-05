package org.web.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.BoardDao;
import org.web.dto.BoardDto;


public class BoardListService implements BoardService {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�Խñ۸�� ��ȸ");

		BoardDao dao = BoardDao.getInstance();
		ArrayList<BoardDto> boards = dao.boardList();

		String returnURL = "";

		if (boards.isEmpty()) {
			System.out.println("�Խñ��� �����ϴ�");
			returnURL = "/board_index.jsp";
		} else {
			System.out.println("�Խñ���ȸ");
			returnURL = "/board/board_listView.jsp";
			request.setAttribute("boards", boards);
		}
		request.setAttribute("returnURL", returnURL);
	}

}
