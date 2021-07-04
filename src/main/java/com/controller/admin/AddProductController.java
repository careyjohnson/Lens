package com.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryBean;
import com.dao.admin.CategoryDao;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/admin/addnewproduct")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryBean cate=new CategoryBean();
		CategoryDao cateDao=new CategoryDao();
		request.setAttribute("LIST_CATE", cateDao.getAllCategories());
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/admin/addNewProduct.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String cateID=request.getParameter("cateID");
		String description=request.getParameter("description");
		String price=request.getParameter("price");
		String inventory=request.getParameter("inventory");
		String active=request.getParameter("active");
		
		
	}

}
