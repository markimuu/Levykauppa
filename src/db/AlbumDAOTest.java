package db;

import static org.junit.Assert.*;

import java.util.List;

import models.Album;
import models.Artist;

import org.junit.Before;
import org.junit.Test;

public class AlbumDAOTest {
	
	private AlbumDAO dao;
	private ArtistDAO dao2;
	
	@Before
	public void setUp() throws Exception {
		dao = new AlbumDAO();
	}
	
	@Before
	public void setUp2() throws Exception {
		dao2 = new ArtistDAO();
	}
	
	@Test
	public void firstAlbumById() {
		Album a = dao.findAlbum(50);
		
		assertNotNull(a);
		assertEquals(a, a);
	}
	
	@Test
	public void testFindAlbumsByArtist() {
		Artist testi = dao2.findArtist(1);
		List<Album> albums = dao.findAlbumsByArtist(testi);

	    assertEquals(2, albums.size());
	    assertEquals("For Those About To Rock We Salute You", albums.get(0).getTitle());
	}
	
	@Test
	public void testAlbumByTitle() {
		List<Album> titles = dao.findAlbumsByTitle("let");
		Album title = titles.get(0);
		
		assertEquals("Let There Be Rock", title.getTitle());
	}

}
