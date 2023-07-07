package org.web.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.MemberDao;
import org.web.dto.MemberDto;

public class MemberlistService implements MemberService {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("ȸ�����");

		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberDto> memberList = dao.List();
		String returnURL = "";

		if (memberList.isEmpty()) {
			System.out.println("��ȸ�� ȸ���� �����ϴ�");
			returnURL = "/jsp0706/index.do";
		} else {
			System.out.println("ȸ����� ��ȸ");
			returnURL = "/jsp0706/memberlist.jsp";
			request.setAttribute("memberList", memberList);
		}
		request.setAttribute("returnURL", returnURL);
	}

}
