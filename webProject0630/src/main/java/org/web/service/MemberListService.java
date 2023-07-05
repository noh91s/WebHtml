package org.web.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.MemberDao;
import org.web.dto.MemberDto;

public class MemberListService implements MemberService {

	@Override
	public void excuteQueryService(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("ȸ����� ��ȸ");

		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberDto> members = dao.memberList();

		String returnURL = "";

		if (members.isEmpty()) {
			System.out.println("ȸ�������� �����ϴ�");
			returnURL = "/member_index.jsp";
		} else {
			System.out.println("ȸ�������ȸ");
			returnURL = "/member/member_listView.jsp";
			request.setAttribute("members", members);
		}
		request.setAttribute("returnURL", returnURL);

	}

}
