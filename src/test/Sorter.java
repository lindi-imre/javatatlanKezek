package test;

public abstract class Sorter {
	boolean ascending = true;

	public boolean isAscending() {
		return ascending;
	}

	public void setAscending(boolean ascending) {
		this.ascending = ascending;
	}

}
