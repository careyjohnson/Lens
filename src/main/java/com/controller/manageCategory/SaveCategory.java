package com.controller.manageCategory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.admin.ManagerCategoryDao;
import com.entity.Category;

/**
 * Servlet implementation class SaveCategory
 */
@WebServlet("/save")
public class SaveCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");
		Category cb = new Category();
		cb.setId(Integer.parseInt(req.getParameter("id")));
		cb.setName(req.getParameter("name"));

		System.out.println(cb);

		if (cb.getId() > 0) {
			new ManagerCategoryDao().editCategory(cb);
		}
		else {
			new ManagerCategoryDao().addCategory(cb);
		}

		resp.sendRedirect("/ECWeb/admin/ManagerCategory");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
