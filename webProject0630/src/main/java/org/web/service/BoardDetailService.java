package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.BoardDao;
import org.web.dto.BoardDto;

public class BoardDetailService implements BoardService {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�Խñۻ󼼺���");
		
		Long board_id=Long.parseLong(request.getParameter("board_id"));
		
		BoardDao dao= BoardDao.getInstance();
		BoardDto boardDetail= dao.boardDetail(board_id);
		String returnURL ="";
		
		
		if(boardDetail!=null) {
			System.out.println("�Խñ� ����ȸ");
			returnURL="/board/board_detail.jsp";
			request.setAttribute("boardDetail", boardDetail);
		}else {
			System.out.println("��ȸ�� �Խñ��� �����ϴ�");
			returnURL="/board/board_detail.do";
		}
		request.setAttribute("returnURL", returnURL);

	}

}
