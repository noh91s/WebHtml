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
		System.out.println("회원목록");

		MemberDao dao = MemberDao.getInstance();
		ArrayList<MemberDto> memberList = dao.List();
		String returnURL = "";

		if (memberList.isEmpty()) {
			System.out.println("조회할 회원이 없습니다");
			returnURL = "/jsp0706/index.do";
		} else {
			System.out.println("회원목록 조회");
			returnURL = "/jsp0706/memberlist.jsp";
			request.setAttribute("memberList", memberList);
		}
		request.setAttribute("returnURL", returnURL);
	}

}
