package others.sorter;

import java.io.File;
import java.util.Comparator;

import others.id3tag.ID3Tag;

public class ArtistSorter extends Sorter implements Comparator<File> {
	@Override
	public int compare(File file1, File file2) {
		ID3Tag tag1 = ID3Tag.parse(file1);
		ID3Tag tag2 = ID3Tag.parse(file2);
		String artist1 = tag1.getArtist();
		String artist2 = tag2.getArtist();
		if (!ascending) {
			artist1 = tag2.getArtist();
			artist2 = tag1.getArtist();
		}
		return artist1.compareToIgnoreCase(artist2);
	}
}
