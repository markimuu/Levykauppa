package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Album;
import models.Artist;

public class AlbumDAO {
	
	private final ChinookDatabase db;
	
	public AlbumDAO() {
		db = new ChinookDatabase();
	}
	
	public Album findAlbum(long id) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT * FROM Album WHERE albumId = ?");
			statement.setLong(1, id);
			results = statement.executeQuery();
			
			while (results.next()) {
				String title = results.getString("Title");
				long albumId = results.getLong("AlbumId");
				long artistId = results.getLong("ArtistId");
				return new Album(albumId, title, artistId);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
		
		return null;
	}
	
	public List<Album> findAlbumsByArtist(Artist artist) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> albumsByArtist = new ArrayList<>();
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT * FROM Album al JOIN Artist a ON a.artistId = al.artistId WHERE a.Name = ?");
			statement.setString(1, artist.getName());
			results = statement.executeQuery();
			
			while (results.next()) {
				long albumId = results.getLong("AlbumId");
				String title = results.getString("Title");
				long artistId = results.getLong("ArtistId");
				Album al = new Album(albumId, title, artistId);
				albumsByArtist.add(al);
			}
		} catch (Exception e) {
    		throw new RuntimeException(e);
	} finally {
		db.closeAll(connection, statement, results);
	}
		
		return albumsByArtist;
	}
	
	public List<Album> findAlbumsByTitle(String title) {
		List<Album> albumsByTitle = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT * FROM Album");
			results = statement.executeQuery();
			
			String ekakirjain = title.substring(0,1).toUpperCase();
			String loput = title.substring(1).toLowerCase();
			title = ekakirjain + loput;
			
			while (results.next()) {
				long albumId = results.getLong("AlbumId");
				long artistId = results.getLong("ArtistId");
				String Title = results.getString("Title");
				if (Title.contains(title)) {
					Album al = new Album(albumId, Title, artistId);
					albumsByTitle.add(al);
				}
			} 
		} catch (Exception e) {
    		throw new RuntimeException(e);
	} finally {
		db.closeAll(connection,  statement,  results);
	}
		
		return albumsByTitle;
	}
	
	public Artist findArtistByAlbumId(long albumid) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT a.Name FROM Artist a JOIN Album al ON al.artistId = a.artistId WHERE al.albumId = ?");
			statement.setLong(1, albumid);
			results = statement.executeQuery();
			
		if (results.next()) {
			String name = results.getString("Name");
			return new Artist(name);
		}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
	}
		return null;
	}
}
