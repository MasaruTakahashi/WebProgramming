
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

/**
 * Servlet implementation class userListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("userinfo");

		if (u == null) {
			response.sendRedirect("LoginServlet");
		}
		else {
		UserDao userdao = new UserDao();
		List<User> userList = userdao.findAll();

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String login_id = request.getParameter("login_id");
		String name = request.getParameter("name");
		String birth_dateS = request.getParameter("birth_dateS");
		String birth_dateE = request.getParameter("birth_dateE");

		UserDao userdao = new UserDao();
		List<User> userList = userdao.findSearch(login_id, name, birth_dateS, birth_dateE);

		request.setAttribute("userList", userList);

		RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/jsp/UserList.jsp");
		dispacher.forward(request, response);

	}

}
