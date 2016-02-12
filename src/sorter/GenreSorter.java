package sorter;

import java.io.File;
import java.util.Comparator;

import id3tag.ID3Tag;

public class GenreSorter extends Sorter implements Comparator<File> {
	public int compare(File file1, File file2) {
		ID3Tag tag1 = ID3Tag.parse(file1);
		ID3Tag tag2 = ID3Tag.parse(file2);
		String genre1 = tag1.getGenre();
		String genre2 = tag2.getGenre();
		if (!ascending) {
			genre1 = tag2.getGenre();
			genre2 = tag1.getGenre();
		}
		return genre1.compareToIgnoreCase(genre2);
	}
}
