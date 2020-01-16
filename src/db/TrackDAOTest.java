package db;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import models.Album;
import models.Track;

public class TrackDAOTest {

	
	private TrackDAO dao;
	private AlbumDAO dao2;
	
	@Before
	public void setUp() throws Exception {
		dao = new TrackDAO();
	}
	
	@Before
	public void setUp2() throws Exception {
		dao2 = new AlbumDAO();
	}
	
	@Test
	public void testFindTracksByAlbum() {
	    Album fakeAlbum = dao2.findAlbum(1);
	    List<Track> tracks = dao.findTracksByAlbum(fakeAlbum);

	    assertEquals(10, tracks.size());
	    assertEquals("For Those About To Rock (We Salute You)", tracks.get(0).getName());
	}
}
