package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Artist;
import db.ArtistDAO;

@WebServlet("/artists")
public class ArtistListServlet extends HttpServlet {
	
	private ArtistDAO artistdao = new ArtistDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Artist> artists = artistdao.findAllArtists();
		
		request.setAttribute("artists", artists);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/artistList.jsp");
		dispatcher.include(request, response);
		
	}

}
