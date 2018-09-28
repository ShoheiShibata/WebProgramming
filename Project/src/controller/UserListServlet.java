package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		Object check = session.getAttribute("userInfo");
		if(check == null) {
			response.sendRedirect("LoginServlet");
			return;
		}


			UserDao userDao = new UserDao();
			List<User> userList = userDao.findAll();

			request.setAttribute("userList", userList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
			dispatcher.forward(request, response);

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		String login_id = request.getParameter("login_id");
		String name = request.getParameter("name");
		String birth_datefrom = request.getParameter("birth_datefrom");
		String birth_dateto = request.getParameter("birth_dateto");

		UserDao userDao = new UserDao();
		List<User> user = userDao.findByUserListInfo(login_id,name,birth_datefrom,birth_dateto);

		request.setAttribute("userList", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userList.jsp");
		dispatcher.forward(request, response);
	}

}
