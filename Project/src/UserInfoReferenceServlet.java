

import java.io.IOException;

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
 * Servlet implementation class userReferenceServlet
 */
@WebServlet("/UserReferenceServlet")
public class UserInfoReferenceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoReferenceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("userinfo");

		if(u == null) {
			response.sendRedirect("LoginServlet");
		}
		else {
		String id = request.getParameter("id");

		UserDao userdao = new UserDao();
		User user = userdao.findByReference(Integer.parseInt(id));

		request.setAttribute("userinfo2", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserInfoReference.jsp");
		dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	}

}
