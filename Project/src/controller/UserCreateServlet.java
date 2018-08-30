package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserCreateServlet
 */
@WebServlet("/UserCreateServlet")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao userDao = new UserDao();
		List<User> userList = userDao.findAll();

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  request.setCharacterEncoding("UTF-8");

			String login_id = request.getParameter("login_id");
			String name = request.getParameter("name");
			String birth_date = request.getParameter("birth_date");
			String password = request.getParameter("password");
			String passwordcheck = request.getParameter("passwordcheck");
			UserDao userDao = new UserDao();


			if (password == passwordcheck || login_id == null || name == null || birth_date == null || password == null || passwordcheck == null) {

				request.setAttribute("errMsg", "入力された内容は正しくありません。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userCreate.jsp");
				dispatcher.forward(request, response);
				return;
			}
			try {
				userDao.findByUserCreateInfo(login_id,name,birth_date,password);
			}catch(SQLException e){

				request.setAttribute("errMsg", "入力された内容は正しくありません。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userCreate.jsp");
				dispatcher.forward(request, response);
				return;
			}

			response.sendRedirect("UserListServlet");

	}

}
