package test;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class DirectoryScanner {
	List<File> fileList;
	String path;
	String fileType;
	boolean subDirIsAllowed;

	public DirectoryScanner(String path, String fileType, boolean subDirIsAllowed) {
		this.path = path;
		this.fileType = fileType;
		this.subDirIsAllowed = subDirIsAllowed;

		File directory = new File(path);

		if (directory.isDirectory()) {
			fileList = new ArrayList<File>();
			collect(directory);
		}
	}

	public List<File> getFileList() {
		return fileList;
	}

	public void collect(File directory) {
		File[] allFileList = directory.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				if (pathname.isFile()) {
					String extension;
					int lastPointIndex = pathname.getName().lastIndexOf('.');
					if (lastPointIndex > -1) {
						extension = pathname.getName().substring(lastPointIndex + 1);
						return extension.toLowerCase().equals(fileType);
					} else {
						return false;
					}
				}
				return true;
			}
		});
		if (allFileList != null) {
			for (File file : allFileList) {
				if (file.isDirectory() && subDirIsAllowed) {
					collect(file);
				} else {
					if (!file.isDirectory()) {
						fileList.add(file);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		DirectoryScanner files = new DirectoryScanner("D:\\it", "mp3", true);
		List<File> temp = files.getFileList();
		for (File file : temp) {
			System.out.println(file);
		}
	}
}
