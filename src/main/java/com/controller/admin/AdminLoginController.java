package com.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.AdminBean;
import com.bean.AdminLoginBean;
import com.dao.admin.AdminLoginDao;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/admin")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action==null) {
			request.getRequestDispatcher("/WEB-INF/admin/admin_login.jsp").forward(request, response);
		} else if(action.equalsIgnoreCase("logout")){
			HttpSession session=request.getSession();
			session.removeAttribute("username");
			request.getRequestDispatcher("/WEB-INF/admin/admin_login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			String email=request.getParameter("email");
			
			AdminLoginBean adminLoginBean=new AdminLoginBean();
			adminLoginBean.setUsername(username);
			adminLoginBean.setPassword(password);
			adminLoginBean.setEmail(email);
			
			AdminLoginDao adminLoginDao=new AdminLoginDao();
			
			AdminBean admin=adminLoginDao.isValidLoginAdmin(adminLoginBean);
			
			if(admin!=null ) {
				HttpSession httpSession=request.getSession();
				
				httpSession.setAttribute("username", username);
				httpSession.setAttribute("admin", admin);
								
				request.setAttribute("loginMessage", "");
				request.getRequestDispatcher("/WEB-INF/admin/admin_index.jsp").forward(request, response);
			} 

			else {
				request.setAttribute("loginMessage", "Sai tên đăng nhập, mật khẩu hoặc email.");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/admin/admin_login.jsp");
				dispatcher.forward(request, response);
			}
	}

}
