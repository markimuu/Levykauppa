package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Album;
import models.Artist;
import db.AlbumDAO;
import db.ArtistDAO;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArtistDAO artistdao = new ArtistDAO();
	private AlbumDAO albumdao = new AlbumDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/search.jsp");
		rd.include(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teksti = request.getParameter("text");
		
		if (teksti == null || "".equals(teksti)) {
			request.setAttribute("error", "Ei nimeä annettu");
			doGet(request, response);
		} else {
			List<Artist> artists = artistdao.findArtistByName(teksti);
			List<Album> albums = albumdao.findAlbumsByTitle(teksti);
			request.setAttribute("artists", artists);
			request.setAttribute("albums", albums);
			doGet(request, response);
		}

	}
		
}