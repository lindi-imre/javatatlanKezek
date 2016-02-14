package sorter;

import java.io.File;
import java.util.Comparator;

public abstract class Sorter implements Comparator<File> {

	boolean ascending = true;

	public Sorter() {

	}

	public Sorter(boolean ascending) {
		this.ascending = ascending;
	}

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

}
