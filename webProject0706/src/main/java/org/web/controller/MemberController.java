package org.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.service.MemberInsertService;
import org.web.service.MemberService;
import org.web.service.MemberdeleteService;
import org.web.service.MemberdetailService;
import org.web.service.MemberlistService;
import org.web.service.MemberupdateService;

@WebServlet("*.do")
public class MemberController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET");
		doPost(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST");
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String basicURL = uri.substring(path.length());

		String returnURL = "";
		MemberService memberService=null;
		
		if(basicURL.equals("/jsp0706/index.do")) {
			returnURL="/jsp0706/index.jsp";
		} else if(basicURL.equals("/jsp0706/join.do")) {
			returnURL="/jsp0706/join.jsp";
		} else if(basicURL.equals("/jsp0706/login.do")) {
			returnURL="/jsp0706/login.jsp";
		} else if(basicURL.equals("/jsp0706/update.do")) {
			returnURL="/jsp0706/memberupdate.jsp";
		} else if(basicURL.equals("/jsp0706/memberlist.do")) {
			memberService = new MemberlistService();
			memberService.executeQueryService(request, response);
			returnURL = (String) request.getAttribute("returnURL");
//			returnURL="/jsp0706/memberlist.jsp";
		}  else if(basicURL.equals("/jsp0706/memberdetail.do")) {
			memberService = new MemberdetailService();
			memberService.executeQueryService(request, response);
			returnURL = (String) request.getAttribute("returnURL");
		}  else if(basicURL.equals("/jsp0706/memberupdate.do")) {
			memberService = new MemberupdateService();
			memberService.executeQueryService(request, response);
			returnURL = (String) request.getAttribute("returnURL");	
		}  else if(basicURL.equals("/jsp0706/memberdelete.do")) {
			memberService = new MemberdeleteService();
			memberService.executeQueryService(request, response);
			returnURL = (String) request.getAttribute("returnURL");	
			

		} else if(basicURL.equals("/jsp0706/joinOk.do")) {
			memberService = new MemberInsertService();
			memberService.executeQueryService(request, response);
			returnURL = (String) request.getAttribute("returnURL");				
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(returnURL);
		dispatcher.forward(request, response);

	}
}
