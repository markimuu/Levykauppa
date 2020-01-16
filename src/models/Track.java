package models;

import java.math.BigDecimal;

public class Track {
	
	private long trackId;
	private String name;
	private long albumId;
	private long mediaTypeId;
	private long genreId;
	private String composer;
	private long milliseconds;
	private long bytes;
	private BigDecimal unitPrice;
	
	public Track(long trackId, String name, long albumId, long mediaTypeId, long genreId, String composer, long ms, long bytes, BigDecimal UP) {
		this.trackId = trackId;
		this.name = name;
		this.albumId = albumId;
		this.mediaTypeId = mediaTypeId;
		this.genreId = genreId;
		this.composer = composer;
		this.milliseconds = ms;
		this.bytes = bytes;
		this.unitPrice = UP;
	}

	public long getTrackId() {
		return trackId;
	}

	public void setTrackId(long trackId) {
		this.trackId = trackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public long getMediaTypeId() {
		return mediaTypeId;
	}

	public void setMediaTypeId(long mediaTypeId) {
		this.mediaTypeId = mediaTypeId;
	}

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public long getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(long milliseconds) {
		this.milliseconds = milliseconds;
	}

	public long getBytes() {
		return bytes;
	}

	public void setBytes(long bytes) {
		this.bytes = bytes;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
		
}


