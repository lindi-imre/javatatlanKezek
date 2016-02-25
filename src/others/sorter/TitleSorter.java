package others.sorter;

import java.io.File;
import java.util.Comparator;

import others.id3tag.ID3Tag;

public class TitleSorter extends Sorter implements Comparator<File> {

	@Override
	public int compare(File file1, File file2) {
		ID3Tag tag1 = ID3Tag.parse(file1);
		ID3Tag tag2 = ID3Tag.parse(file2);
		String title1 = tag1.getTitle();
		String title2 = tag2.getTitle();
		if (!ascending) {
			title1 = tag2.getTitle();
			title2 = tag1.getTitle();
		}
		return title1.compareToIgnoreCase(title2);
	}

}
