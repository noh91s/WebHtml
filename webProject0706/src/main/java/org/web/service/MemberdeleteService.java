package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.MemberDao;

public class MemberdeleteService implements MemberService {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("회원정보삭제");
		
		Long member_id=Long.parseLong(request.getParameter("member_id"));
		
		MemberDao dao= MemberDao.getInstance();
		int rs=dao.delete(member_id);

		String returnURL="";
		
		if(rs!=1) {
			if(rs==2) {
	
				System.out.println("회원정보조회 실패");
				returnURL=".do";
			} else {
				System.out.println("회원정보삭제 실패!");
				returnURL="/jsp0706/memberlist.do";
			}
		}else {
			System.out.println("회원정보삭제 성공!");
			returnURL="/jsp0706/memberlist.do";
		}
		request.setAttribute("returnURL", returnURL);
	}



}
