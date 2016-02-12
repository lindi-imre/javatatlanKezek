package sorter;

import java.io.File;
import java.util.Comparator;

import id3tag.ID3Tag;

public class YearSorter extends Sorter implements Comparator<File> {

	@Override
	public int compare(File file1, File file2) {
		ID3Tag tag1 = ID3Tag.parse(file1);
		ID3Tag tag2 = ID3Tag.parse(file2);
		int year1 = tag1.getYear();
		int year2 = tag2.getYear();
		if (!ascending) {
			year1 = tag2.getYear();
			year2 = tag1.getYear();
		}
		return year1 - year2;
	}

}
