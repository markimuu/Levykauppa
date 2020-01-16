package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter writer = resp.getWriter();
			String eka = req.getParameter("firstName");
			String loppu = req.getParameter("lastName");
			
			
			
			writer.println("<html><body>");
			writer.println("<h1>Hello World</h1>");
			writer.println("Hello " + eka + " " + loppu);
			writer.println("</html></body>");
	}
}
