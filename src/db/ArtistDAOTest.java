package db;

import static org.junit.Assert.*;

import java.util.List;

import models.Artist;

import org.junit.Before;
import org.junit.Test;

public class ArtistDAOTest {
	
	private ArtistDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new ArtistDAO();
	}
	
	@Test
	public void testFirstArtistById() {
		Artist a = dao.findArtist(50);
		
		assertNotNull(a);
		assertEquals("Metallica", a.getName());
	}
	
	@Test
	public void testFindingArtistWithNonExistingId() {
		Artist a = dao.findArtist(123456789);
		
		assertEquals(null, a);
	}
	
	@Test
	public void testFirstArtist() {
		List<Artist> artists = dao.findAllArtists();
		Artist first = artists.get(0);
		
		assertEquals("AC/DC", first.getName());
	}
	
	@Test
	public void testDemo() {
		List<Artist> artists = dao.findAllArtists();
		Artist random = artists.get(203);
		
		assertEquals("Temple of the Dog", random.getName());
	}
	
	@Test
	public void testAddingArtistToDatabase() {
		Artist a = new Artist("Testi");
		dao.storeArtist(a);
		
		assertTrue(0 < a.getId());
		
	}

	@Test
	public void testArtistByName2() {
		List<Artist> names = dao.findArtistByName("foo");
		Artist name = names.get(0);
		
		assertEquals("Foo Fighters", name.getName());
	}
}
