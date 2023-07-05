package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.MemberDao;



public class MemberDeleteService implements MemberService {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Long member_id=Long.parseLong(request.getParameter("member_id"));
		
		MemberDao dao= MemberDao.getInstance();
		int rs=dao.delete(member_id);

		String returnURL="";
		
		if(rs!=1) {
			System.out.println("È¸¿øÅ»Åð ½ÇÆÐ!");
			returnURL="/member_list.mo";
		}else {
			System.out.println("È¸¿øÅ»Åð ¼º°ø!");
			returnURL="/member_list.mo";
		}
		request.setAttribute("returnURL", returnURL);
	}

}
