package test;

public class MP3
{
	String filename;
	String title;
	String artist;
	String album;
	int year;
	String comment;
	byte genre;
	byte track;
	long size;
	String relpath;
	String abspath;

	public MP3(String filename, String title, String artist, String album, int year, String comment, byte genre,
			byte track, long size, String relpath, String abspath)
	{
		super();
		this.filename = filename;
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.comment = comment;
		this.genre = genre;
		this.track = track;
		this.size = size;
		this.relpath = relpath;
		this.abspath = abspath;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getArtist()
	{
		return artist;
	}

	public void setArtist(String artist)
	{
		this.artist = artist;
	}

	public String getAlbum()
	{
		return album;
	}

	public void setAlbum(String album)
	{
		this.album = album;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(String comment)
	{
		this.comment = comment;
	}

	public byte getGenre()
	{
		return genre;
	}

	public void setGenre(byte genre)
	{
		this.genre = genre;
	}

	public byte getTrack()
	{
		return track;
	}

	public void setTrack(byte track)
	{
		this.track = track;
	}

	public long getSize()
	{
		return size;
	}

	public void setSize(long size)
	{
		this.size = size;
	}

	public String getRelpath()
	{
		return relpath;
	}

	public void setRelpath(String relpath)
	{
		this.relpath = relpath;
	}

	public String getAbspath()
	{
		return abspath;
	}

	public void setAbspath(String abspath)
	{
		this.abspath = abspath;
	}

}
