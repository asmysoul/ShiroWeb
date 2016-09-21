package top.fzqblog.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Subject subject = SecurityUtils.getSubject();
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UsernamePasswordToken currentUser = new UsernamePasswordToken(userName, password);
		String errorMsg = "";
		try {
			subject.login(currentUser);
		}  catch ( UnknownAccountException uae ) { 
			errorMsg = "用户不存在"	;
		} catch ( IncorrectCredentialsException ice ) { 
			errorMsg = "密码错误"	;
		} 
		if(!"".equals(errorMsg)){
			request.setAttribute("errorMsg", errorMsg);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else{
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
