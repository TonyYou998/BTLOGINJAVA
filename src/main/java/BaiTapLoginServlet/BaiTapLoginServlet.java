package BaiTapLoginServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaiTapLoginUtils.PathUltil;
import BaiTapLoginUtils.UrlUtil;


@WebServlet(name="BaiTapLogin",urlPatterns = {
		UrlUtil.BAITAPLOGIN_FORM,
		UrlUtil.BAITAPLOGIN_WELCOME,
		UrlUtil.BAITAPLOGIN_ERR
})
public class BaiTapLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String path=request.getServletPath();
    //		request.getRequestDispatcher(PathUltil.BAITAPLOGIN_FORM).forward(request, response);
    		switch (path) {
			case UrlUtil.BAITAPLOGIN_FORM : 
				request.getRequestDispatcher(PathUltil.BAITAPLOGIN_FORM).forward(request, response);
				break;
			case UrlUtil.BAITAPLOGIN_WELCOME:
				request.getRequestDispatcher(PathUltil.BAITAPLOGIN_WELOME).forward(request, response);
				break;
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + path);
			}
    		
	}
    		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName= request.getParameter("username");
		String password=request.getParameter("password");
		if(userName.equals("admin")&& password.equals("123456")) {
			String message = String.format("xin chào %s %s",userName,password);
			request.setAttribute("message",message);
			
			request.getRequestDispatcher(PathUltil.BAITAPLOGIN_WELOME).forward(request, response);
		
		}
			
		else {
			request.setAttribute("message","sai username or pass");
			request.getRequestDispatcher(PathUltil.BAITAPLOGIN_WELOME).forward(request, response);
			
		}
	}
}
