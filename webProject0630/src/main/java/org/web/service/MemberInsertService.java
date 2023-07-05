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
		System.out.println("ȸ����ϼ���");
		
		String member_name=request.getParameter("member_name");
		String member_password=request.getParameter("member_password");
		String email=request.getParameter("email");
		
		MemberDao dao=MemberDao.getInstance();
		int rs=dao.insert(member_name,member_password,email);
		
		String returnURL="";
		
		if(rs!=1) {
			if(rs==2) {
				System.out.println("�̵̹�ϵ� �����");
				returnURL="/member/member_joinView.jsp";
			} else {
				System.out.println("ȸ������ ����");
				returnURL="/member/member_joinView.jsp";
			}
		} else {
			System.out.println("ȸ������ ����");
			returnURL="/member_list.mo";
		}
		
		request.setAttribute("returnURL", returnURL);
		
		
		// ȸ����� ���� -> ȸ�������������̵�
		// ȸ����� ���� -> ȸ������������̵�

	}

}
