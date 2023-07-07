package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.MemberDao;

public class MemberInsertService implements MemberService {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("ȸ������");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");

		MemberDao dao = MemberDao.getInstance();
		int rs = dao.insert(name, password, email, phone, address, city);

		String returnURL = "";


		if (rs != 1) {
			if (rs == 2) {
				System.out.println("�̵̹�ϵ� �����");
				returnURL = "/jsp0706/memberlist.do";
			} else {
				System.out.println("ȸ������ ����!");
				returnURL = "/jsp0706/join.do";
			}

		} else {
			System.out.println("ȸ������ ����!");
			returnURL = "/jsp0706/memberlist.do";
		}

		request.setAttribute("returnURL", returnURL);
	}

}
