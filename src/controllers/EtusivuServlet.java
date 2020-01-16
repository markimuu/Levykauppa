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

@WebServlet("/index")
public class EtusivuServlet extends HttpServlet  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArtistDAO artistdao = new ArtistDAO();
	private AlbumDAO albumdao = new AlbumDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Artist> artists = artistdao.findAllArtists();
		Artist artist = artists.get(0);
	    List<Album> albums = albumdao.findAlbumsByArtist(artist);
		
		request.setAttribute("artists", artists);
		request.setAttribute("albums", albums);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/etusivu.jsp");
		dispatcher.include(request, response);
		
	}

}
