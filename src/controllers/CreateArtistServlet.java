package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Artist;
import db.ArtistDAO;

@WebServlet("/newartist")
public class CreateArtistServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArtistDAO artistdao = new ArtistDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/new_artist.jsp");
		rd.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String artistName = request.getParameter("artistName");
		if (artistName == null || "".equals(artistName)) {
			request.setAttribute("error", "Ei nimeä annettu");
			doGet(request, response);
		} else {
			Artist artist = new Artist(artistName);
			artistdao.storeArtist(artist);
			response.sendRedirect("/Levykauppa/artist?id=" + artist.getId());
		}
		
	}
}
