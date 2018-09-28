package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserDeleteServlet
 */
@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		Object check = session.getAttribute("userInfo");
		if(check == null) {
			response.sendRedirect("LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");
		 String id = request.getParameter("id");

		 UserDao userDao = new UserDao();
			User user = userDao.findByUserDetailInfo(id);

			request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDelete.jsp");
		dispatcher.forward(request, response);

		System.out.println(id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("UTF-8");
		 String id = request.getParameter("id");
		 UserDao userDao = new UserDao();
		try {
			userDao.findByUserDeleteInfo(id);
		}catch(SQLException e){

			request.setAttribute("errMsg", "削除に失敗しました。");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userDelete.jsp");
			dispatcher.forward(request, response);
			return;
		}

		response.sendRedirect("UserListServlet");
	}

}
