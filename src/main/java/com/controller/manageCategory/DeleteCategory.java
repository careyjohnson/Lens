package com.controller.manageCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.admin.ManagerCategoryDao;
import com.entity.Category;

@WebServlet("/deleteCategory")
public class DeleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		Category c = new Category();
		c.setId(Integer.parseInt(req.getParameter("id")));
		new ManagerCategoryDao().removeCategory(c);
		resp.sendRedirect("admin/managerCategory");

	}
		


}
