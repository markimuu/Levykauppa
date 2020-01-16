package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import models.Artist;

public class ArtistDAO {

	private final ChinookDatabase db;
	
	public ArtistDAO() {
		db = new ChinookDatabase();
	}
	
	public Artist findArtist(long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT * FROM Artist WHERE ArtistId = ?");
			statement.setLong(1, id);
			results = statement.executeQuery();
			
			if (results.next()) {
				String name = results.getString("Name");
				long artistId = results.getLong("ArtistId");
				return new Artist(artistId, name);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
		
		return null;
	}
	
	public List<Artist> findAllArtists() {
		List<Artist> allArtists = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT * FROM Artist");
			results = statement.executeQuery();
			
			while (results.next()) {
				long id = results.getLong("ArtistId");
				String name = results.getString("Name");
				
				Artist a = new Artist(id, name);
				allArtists.add(a);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
		
		return allArtists;
		
	}	
	
	public void storeArtist(Artist artist) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("INSERT INTO Artist (Name) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			
			statement.setString(1, artist.getName());
			statement.executeUpdate();
			
			results = statement.getGeneratedKeys();
			if (results.next()) {
				long id = results.getLong(1);
				artist.setId(id);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
		
	}
		
	public List<Artist> findArtistByName(String name) {
		List<Artist> names = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement("SELECT * FROM Artist");
			results = statement.executeQuery();
			String ekaKirjain = name.substring(0, 1).toUpperCase();
			String loput = name.substring(1).toLowerCase();
			name = ekaKirjain + loput;
			
			while (results.next()) {
				String nimi = results.getString("Name");
				String eka = nimi.substring(0, 1).toUpperCase();
				String loppu = nimi.substring(1).toLowerCase();
				nimi = eka + loppu;
				long id = results.getLong("artistId");
				if (nimi.contains(name)) {
					Artist a = new Artist(id, nimi);
					names.add(a);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			db.closeAll(connection, statement, results);
		}
		
		return names;
		
	}	
		
				
	
}
