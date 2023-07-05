package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.MemberDao;

public class MemberInsertService implements MemberService {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("회원등록서비스");
		
		String member_name=request.getParameter("member_name");
		String member_password=request.getParameter("member_password");
		String email=request.getParameter("email");
		
		MemberDao dao=MemberDao.getInstance();
		int rs=dao.insert(member_name,member_password,email);
		
		String returnURL="";
		
		if(rs!=1) {
			if(rs==2) {
				System.out.println("이미등록된 사용자");
				returnURL="/member/member_joinView.jsp";
			} else {
				System.out.println("회원가입 실패");
				returnURL="/member/member_joinView.jsp";
			}
		} else {
			System.out.println("회원가입 성공");
			returnURL="/member_list.mo";
		}
		
		request.setAttribute("returnURL", returnURL);
		
		
		// 회원등록 성공 -> 회원메인페이지이동
		// 회원등록 실패 -> 회원등록페이지이동

	}

}
