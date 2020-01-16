package models;

public class Album {

	private long albumid;
	private long artistid;
	private String title;

	public Album(long albumid, String title, long artistid) {
		this.artistid = artistid;
		this.albumid = albumid;
		this.title = title;
		
	}
	
	public Album(int albumid, String title) {
		this.albumid = albumid;
		this.title = title;
	}

	public long getAlbumid() {
		return albumid;
	}

	public void setAlbumid(long albumid) {
		this.albumid = albumid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getArtistid() {
		return artistid;
	}

	public void setArtistid(long artistid) {
		this.artistid = artistid;
	}
	
	

}
