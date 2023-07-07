package org.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.dao.MemberDao;
import org.web.dto.MemberDto;

public class MemberdetailService implements MemberService {

	@Override
	public void executeQueryService(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("ȸ�������󼼺���");
		
		Long Member_id=Long.parseLong(request.getParameter("member_id"));
		
		MemberDao dao= MemberDao.getInstance();
		MemberDto Memberdetail= dao.detail(Member_id);
		String returnURL ="";
		
		
		if(Memberdetail!=null) {
			System.out.println("ȸ������ȸ");
			returnURL="/jsp0706/memberdetail.jsp";
			request.setAttribute("Memberdetail", Memberdetail);
		}else {
			System.out.println("��ȸ�� ȸ���� �����ϴ�");
			returnURL="/jsp0706/memberlist.do";
		}
		request.setAttribute("returnURL", returnURL);

	}

}
