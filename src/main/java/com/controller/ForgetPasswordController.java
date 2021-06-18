package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.ForgetPasswordDao;

/**
 * Servlet implementation class ForgetPasswordController
 */
@WebServlet("/forget_password")
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/forget_password.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String newPassword=request.getParameter("newPassword");
		String email=request.getParameter("email");
		
		UserBean user=new UserBean();
		user.setUsername(username);
		user.setPassword(newPassword);
		user.setEmail(email);
		
		ForgetPasswordDao forgetPasswordDao=new ForgetPasswordDao();
		UserBean updatePassword=forgetPasswordDao.updatePassword(user);
		if(updatePassword==null) {
			request.setAttribute("forgetPasswordMessage", "Tên đăng nhập hoặc email không đúng.");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/forget_password.jsp");
			dispatcher.forward(request, response);
		}else {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("password", newPassword);
			
			request.setAttribute("forgetPasswordMessage", "");
			response.sendRedirect("/ECWeb/login?msg=done");
		}
	}

}
