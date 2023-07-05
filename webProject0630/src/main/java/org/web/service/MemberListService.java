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
		System.out.println("회원목록 조회");

		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberDto> members = dao.memberList();

		String returnURL = "";

		if (members.isEmpty()) {
			System.out.println("회원정보가 없습니다");
			returnURL = "/member_index.jsp";
		} else {
			System.out.println("회원목록조회");
			returnURL = "/member/member_listView.jsp";
			request.setAttribute("members", members);
		}
		request.setAttribute("returnURL", returnURL);

	}

}
