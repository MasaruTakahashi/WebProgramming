
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class userRegistrationServlet
 */
@WebServlet("/UserRegistrationServlet")
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserRegistration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String login_id = request.getParameter("login_id");
		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");
		String name = request.getParameter("name");
		String birthdate = request.getParameter("birth_date");

		UserDao userdao = new UserDao();
		User user = userdao.findByloginid(login_id);
		if (user != null) {
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserRegistration.jsp");
			dispatcher.forward(request, response);
			return;

		} else if (!password.equals(passwordRe)) {
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserRegistration.jsp");
			dispatcher.forward(request, response);
			return;

		} else if (login_id.equals("") || password.equals("") || name.equals("") || birthdate.equals("")) {
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserRegistration.jsp");
			dispatcher.forward(request, response);
			return;

		} else {
			userdao.insert(login_id, name, birthdate,password);
			response.sendRedirect("UserListServlet");
		}
	}

}
