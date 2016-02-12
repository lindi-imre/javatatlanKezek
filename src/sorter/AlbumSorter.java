package sorter;

import java.io.File;
import java.util.Comparator;

import id3tag.ID3Tag;

public class AlbumSorter extends Sorter implements Comparator<File> {

	@Override
	public int compare(File file1, File file2) {
		ID3Tag tag1 = ID3Tag.parse(file1);
		ID3Tag tag2 = ID3Tag.parse(file2);
		String album1 = tag1.getAlbum();
		String album2 = tag2.getAlbum();
		if (!ascending) {
			album1 = tag2.getAlbum();
			album2 = tag1.getAlbum();
		}
		return album1.compareToIgnoreCase(album2);
	}

}
