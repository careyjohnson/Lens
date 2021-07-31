package com.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.admin.ManagerProductDao;
import com.entity.Product;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/edit")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProduct() {
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
		Product pd = new Product();
		try {
			pd.setId(Integer.parseInt(req.getParameter("id")));
			pd.setName(req.getParameter("name"));
			pd.setDescription(req.getParameter("description"));
			pd.setPrice(Double.parseDouble(req.getParameter("price")));

		} catch (Exception e2) {
		}
		req.setAttribute("pd", pd);
		req.setAttribute("listVT", new ManagerProductDao().getListProduct());
		req.getRequestDispatcher("addNewProduct.jsp").forward(req, resp);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
