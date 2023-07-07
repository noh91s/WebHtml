package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.MemberDao;

public class MemberupdateService implements MemberService {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("회원정보수정");

		Long member_id = Long.parseLong(request.getParameter("member_id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");

		MemberDao dao = MemberDao.getInstance();
		int rs = dao.update(member_id, name, password, phone, address, city);

		String returnURL = "";

		if (rs != 1) {
			System.out.println("회원정보수정 실패!");
			returnURL = "/jsp0706/memberlist.do";
		} else {
			System.out.println("회원정보수정 성공!");
			returnURL = "/jsp0706/memberlist.do";
		}

		request.setAttribute("returnURL", returnURL);

	}

}
