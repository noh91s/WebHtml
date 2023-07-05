package org.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.MemberDeleteService;
import org.web.service.MemberInsertService;
import org.web.service.MemberListService;
import org.web.service.MemberService;

@WebServlet("*.mo")
public class MemberController extends HttpServlet {
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
		MemberService service=null;
		
		if(basicURL.equals("/member_index.mo")) {
			returnURL="/member/member_index.jsp";
		} else if (basicURL.equals("/member_join.mo")) {
		 	returnURL="/member/member_joinView.jsp";
		} else if (basicURL.equals("/member_delete.mo")) {
			returnURL="/member/member_deleteView.jsp";
		} else if (basicURL.equals("/member_joinOk.mo")) {
			service=new MemberInsertService();
			service.excuteQueryService(request, response);
			returnURL=(String)request.getAttribute("returnURL");	
		} else if (basicURL.equals("/member_list.mo")) {
			service=new MemberListService();
			service.excuteQueryService(request, response);
			returnURL=(String)request.getAttribute("returnURL");
		} else if (basicURL.equals("/member_deleteOk.mo")) {
			service=new MemberDeleteService();
			service.excuteQueryService(request, response);
			returnURL=(String)request.getAttribute("returnURL");	
		
		
		
		}				
		RequestDispatcher dispatcher=request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);
	}
}
