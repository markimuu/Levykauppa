package db;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.Album;
import models.Track;

public class TrackDAO {
	
    private final ChinookDatabase db;

    public TrackDAO() {
        db = new ChinookDatabase();
    }
    
    public List<Track> findTracksByAlbum(Album album) {
    	List<Track> tracksByAlbum = new ArrayList<>();
    	Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet results = null;
    	
    	try {
    		connection = db.connect();
    		statement = connection.prepareStatement("SELECT t.TrackId, t.Name, t.AlbumId, t.MediaTypeId, t.GenreId, t.Composer, t.Milliseconds, t.Bytes, t.UnitPrice FROM TRACK t JOIN Album al ON al.AlbumId = t.AlbumId WHERE al.Title = ?");
    		statement.setString(1, album.getTitle());
    		results = statement.executeQuery();
    		
    		while (results.next()) {
    			long TrackId = results.getLong("TrackId");
    			String Name = results.getString("Name");
    			long AlbumId = results.getLong("AlbumId");
    			long MediaTypeId = results.getLong("MediaTypeId");
    			long GenreId = results.getLong("GenreId");
    			String Composer = results.getString("Composer");
    			long Milliseconds = results.getLong("Milliseconds");
    			long Bytes = results.getLong("Bytes");
    			BigDecimal UnitPrice = results.getBigDecimal("UnitPrice");
    			Track tr = new Track(TrackId, Name, AlbumId, MediaTypeId, GenreId, Composer, Milliseconds, Bytes, UnitPrice);
    			tracksByAlbum.add(tr);
    		}
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	} finally {
    		db.closeAll(connection, statement, results);
    	}
    	
    	return tracksByAlbum;
    }

}
