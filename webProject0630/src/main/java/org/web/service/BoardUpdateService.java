package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.BoardDao;

public class BoardUpdateService implements BoardService {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("�Խñ� ����");
		
		Long board_id=Long.parseLong(request.getParameter("board_id"));
		String board_title=request.getParameter("board_title");
		String board_content=request.getParameter("board_content");

		BoardDao dao= BoardDao.getInstance();
		int rs=dao.update(board_id,board_title,board_content);

		String returnURL="";
		
		if(rs!=1) {
			System.out.println("�Խñۼ��� ����!");
			returnURL="/board_list.bo";
		}else {
			System.out.println("�Խñۼ��� ����!");
			returnURL="/board_list.bo";
//			returnURL="/board/board_detail.bo?board_id="+board_id;
		}
		
		request.setAttribute("returnURL", returnURL);
		
	}

}
