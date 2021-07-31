package com.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.admin.ManagerProductDao;
import com.entity.Product;
import com.model.Classroom;
import com.model.ClassroomModel;
import com.model.Specialized;
import com.model.SpecializedModel;

/**
 * Servlet implementation class ManagerProductController
 */
@WebServlet("/admin/ManagerProduct")
public class ManagerProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UFT-8");
		request.setAttribute("listSP", new ManagerProductDao().getListProduct());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/admin/ManagerProduct.jsp");
		dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
