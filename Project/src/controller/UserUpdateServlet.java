package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
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
			String name = request.getParameter("name");
			String birth_date = request.getParameter("birth_date");
			String password = request.getParameter("password");

			String source = password;
			Charset charset = StandardCharsets.UTF_8;
			String algorithm = "MD5";

			byte[] bytes = null;
			try {
				bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
			} catch (NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			}
			String result = DatatypeConverter.printHexBinary(bytes);

			String passwordcheck = request.getParameter("passwordcheck");
			UserDao userDao = new UserDao();


			if (!password.equals(passwordcheck) || name == null || birth_date == null) {

				request.setAttribute("errMsg", "入力された内容は正しくありません。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
				dispatcher.forward(request, response);
				return;
			}
			try {
				userDao.findByUserUpdateInfo(id,name,birth_date,result);
			}catch(SQLException e){

				request.setAttribute("errMsg", "入力された内容は。");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userUpdate.jsp");
				dispatcher.forward(request, response);
				return;
			}

			response.sendRedirect("UserListServlet");


	}

}
