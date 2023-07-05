package org.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.BoardDeleteService;
import org.web.service.BoardDetailService;
import org.web.service.BoardInsertService;
import org.web.service.BoardListService;
import org.web.service.BoardService;
import org.web.service.BoardUpdateService;


@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET");
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST");
		request.setCharacterEncoding("UTF-8");
		
		String path=request.getContextPath();
		String uri=request.getRequestURI();
		String basicURL=uri.substring(path.length());
		
		String returnURL="";
		BoardService service=null;
		
		if(basicURL.equals("/board_index.bo")) {
			returnURL="/board/board_index.jsp";
		} else if (basicURL.equals("/board_write.bo")) {
		 	returnURL="/board/board_joinView.jsp";
		} else if (basicURL.equals("/board_writeOk.bo")) {
			service=new BoardInsertService();
			service.excuteQueryService(request, response);
			returnURL=(String)request.getAttribute("returnURL");	
		} else if (basicURL.equals("/board_list.bo")) {
			service=new BoardListService();
			service.excuteQueryService(request, response);
			returnURL=(String)request.getAttribute("returnURL");
		} else if (basicURL.equals("/board_detail.bo")) {
			service=new BoardDetailService();
			service.excuteQueryService(request, response);
			returnURL=(String)request.getAttribute("returnURL");
		} else if (basicURL.equals("/board_update.bo")) {
			service=new BoardUpdateService();
			service.excuteQueryService(request, response);
			returnURL=(String)request.getAttribute("returnURL");
		} else if (basicURL.equals("/board_delete.bo")) {
			service=new BoardDeleteService();
			service.excuteQueryService(request, response);
			returnURL=(String)request.getAttribute("returnURL");
			
		}	
		RequestDispatcher dispatcher=request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
}
