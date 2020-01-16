package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.AlbumDAO;
import db.ArtistDAO;
import models.Album;
import models.Artist;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArtistDAO artistdao = new ArtistDAO();
	private AlbumDAO albumdao = new AlbumDAO();
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  	PrintWriter writer = response.getWriter();
	        long artistId = Long.parseLong(request.getParameter("id"));

	        Artist artist = artistdao.findArtist(artistId);
	        List<Album> albums = albumdao.findAlbumsByArtist(artist);
	        
	        
	        if (artist != null) {
	        	request.setAttribute("artist", artist);
		        request.setAttribute("albums", albums);
		        
		        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/artist.jsp");
		        dispatcher.include(request, response);
	        } else {
	        	response.setStatus(404);
	        	writer.println("Not found");
	        }
	        
	  }
}
