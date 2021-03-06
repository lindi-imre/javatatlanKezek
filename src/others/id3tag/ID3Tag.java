package others.id3tag;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class ID3Tag {
	private String title;
	private String artist;
	private String album;
	private int year;
	private String comment;
	private String genre;

	private ID3Tag() {
	}

	private static byte[] readXBytes(byte[] byteArray, int fromPos, int toPos) {
		byte[] resultArray = new byte[toPos - fromPos];
		for (int i = fromPos; i < toPos; i++) {
			resultArray[i - fromPos] = byteArray[i];
		}
		return resultArray;
	}

	public static ID3Tag parse(File file) {
		byte[] last128 = tail(file);
		byte[] baTitle = readXBytes(last128, 3, 33);
		String title = new String(baTitle).trim();
		byte[] baArtist = readXBytes(last128, 33, 63);
		String artist = new String(baArtist).trim();
		byte[] baAlbum = readXBytes(last128, 63, 93);
		String album = new String(baAlbum).trim();
		byte[] baYear = readXBytes(last128, 93, 97);
		int year = Integer.parseInt(new String(baYear).trim());
		byte[] baComment = readXBytes(last128, 97, 125);
		String comment = new String(baComment).trim();
		byte[] baGenre = readXBytes(last128, 127, 128);
		String genre = new String(baGenre).trim();
		ID3Tag tag = new ID3Tag();
		tag.setTitle(title);
		tag.setArtist(artist);
		tag.setAlbum(album);
		tag.setYear(year);
		tag.setComment(comment);
		tag.setGenre(genre);
		return tag;
	}

	public static byte[] tail(File file) {
		try {
			RandomAccessFile fileHandler = new RandomAccessFile(file, "r");
			long fileLength = fileHandler.length() - 1;
			byte[] buffer = new byte[128];

			for (int i = 0; i < buffer.length; i++) {
				fileHandler.seek(fileLength - 127 + i);
				buffer[i] = fileHandler.readByte();
			}
			fileHandler.close();
			return buffer;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public boolean equals(Object o) {
		ID3Tag tag = (ID3Tag) o;
		return ((title == null && tag.title == null) || title.equals(tag.title))
				&& ((artist == null && tag.artist == null) || artist.equals(tag.artist))
				&& ((album == null && tag.album == null) || album.equals(tag.album)) && (year == tag.year)
				&& ((comment == null && tag.comment == null) || comment.equals(tag.comment)) && (genre == tag.genre);
	}

	@Override
	public int hashCode() {
		return -1;
	}

	@Override
	public String toString() {
		return "Artist: " + (artist == null ? "NULL" : artist).trim() + "\nAlbum: " + album + "\nTitle: " + title.trim()
				+ "\nYear: " + year + "\nComment: " + comment + "\nGenre: " + genre;
	}

	public static void main(String[] args) {
		ID3Tag tag1 = ID3Tag.parse(new File("C:" + File.separator + "Users" + File.separator + "Imre" + File.separator
				+ "Downloads" + File.separator + "mp3" + File.separator + "alienjesus.mp3"));
		List<ID3Tag> tags = new ArrayList<ID3Tag>();
		tags.add(tag1);
		System.out.println(tags);
	}
}