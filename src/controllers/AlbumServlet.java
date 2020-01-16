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
import models.Track;
import db.AlbumDAO;
import db.ArtistDAO;
import db.TrackDAO;


@WebServlet("/album")
public class AlbumServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArtistDAO artistdao = new ArtistDAO();
	private AlbumDAO albumdao = new AlbumDAO();
	private TrackDAO trackdao = new TrackDAO();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  	long albumId = Long.parseLong(request.getParameter("id"));
	  	
	  	Artist artist = albumdao.findArtistByAlbumId(albumId);
	  	Album album = albumdao.findAlbum(albumId);
	  	List<Track> tracks = trackdao.findTracksByAlbum(album);

	  	request.setAttribute("artist", artist);
	  	request.setAttribute("album", album);
	  	request.setAttribute("tracks", tracks);
	  	
	  	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/albumi.jsp");
		dispatcher.include(request, response);

    	
    }
}

