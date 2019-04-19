
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
 * Servlet implementation class UserInfoUpdateServlet
 */
@WebServlet("/UserInfoUpdateServlet")
public class UserInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserInfoUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		UserDao userdao = new UserDao();
		User user = userdao.findByReference(Integer.parseInt(id));

		request.setAttribute("userinfo2", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserInfoUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String passwordRe = request.getParameter("passwordRe");
		String name = request.getParameter("name");
		String birth_date = request.getParameter("birth_date");

		UserDao userdao = new UserDao();

		if (!password.equals(passwordRe)) {
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			String Id = request.getParameter("id");
			User user = userdao.findByReference(Integer.parseInt(Id));
			request.setAttribute("userinfo2", user);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserInfoUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}

		else if (name.equals("") || birth_date.equals("")) {
			request.setAttribute("errMsg", "入力された内容は正しくありません。");

			String Id = request.getParameter("id");
			User user = userdao.findByReference(Integer.parseInt(Id));
			request.setAttribute("userinfo2", user);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserInfoUpdate.jsp");
			dispatcher.forward(request, response);
			return;
		}

		else if (password.equals("")) {
			userdao.updateNopass(Integer.parseInt(id), name, birth_date);
			response.sendRedirect("UserListServlet");
		} else {
			userdao.update(Integer.parseInt(id), password, name, birth_date);
			response.sendRedirect("UserListServlet");
		}

	}

}
