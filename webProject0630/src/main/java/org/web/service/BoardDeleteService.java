package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.BoardDao;

public class BoardDeleteService implements BoardService {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long board_id=Long.parseLong(request.getParameter("board_id"));
		
		BoardDao dao= BoardDao.getInstance();
		int rs=dao.delete(board_id);

		String returnURL="";
		
		if(rs!=1) {
			System.out.println("게시글삭제 실패!");
			returnURL="/board_list.bo";
		}else {
			System.out.println("게시글삭제 성공!");
			returnURL="/board_list.bo";
		}
		request.setAttribute("returnURL", returnURL);
	}

}
