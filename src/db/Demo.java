package db;

import java.util.List;

import models.Album;
import models.Artist;
import models.Track;

public class Demo {
	
	private static final ArtistDAO dao = new ArtistDAO();
	private static final AlbumDAO dao2 = new AlbumDAO();
	private static final TrackDAO dao3 = new TrackDAO();
	
	public static void main(String[] args) {
		
		Artist artistname = dao2.findArtistByAlbumId(4);
		System.out.println(artistname.getName());
		
		Artist artist = dao.findArtist(1);
		System.out.println(artist.getId() + " " + artist.getName());
		
		Album album = dao2.findAlbum(1);
		System.out.println(album.getAlbumid() + " " + album.getTitle());
		
		
		Artist testi = dao.findArtist(1);
		List<Album> albums = dao2.findAlbumsByArtist(testi);
		
		for (int i = 0; i < albums.size(); i++) {
			Album talbum = albums.get(i);
			System.out.println(talbum.getAlbumid() + " " + talbum.getTitle());
		}
		
		Album fakeAlbum = dao2.findAlbum(1);
	    List<Track> tracks = dao3.findTracksByAlbum(fakeAlbum);
		
		for (int i = 0; i < tracks.size(); i++) {
			Track tracki = tracks.get(i);
			System.out.println(tracki.getTrackId() + " " + tracki.getName() + " " + tracki.getUnitPrice());
		}
		
		System.out.println("\n");
		
		List<Artist> artists = dao.findAllArtists();
		
		for (int i = 0; i < artists.size(); i++) {
			Artist kaikki = artists.get(i);
			System.out.println(kaikki.getId() + " " + kaikki.getName());
		
		}

	}

}
