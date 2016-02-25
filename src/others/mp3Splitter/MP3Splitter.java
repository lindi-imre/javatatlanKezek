package others.mp3Splitter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MP3Splitter {
	public static List<File> split(File file, int piece) throws IOException {
		List<File> splittedFiles = new ArrayList<File>();
		if (piece <= 1) {
			return null;
		}
		int bytesInPiece = (int) (file.length() / piece);
		int remainder = (int) (file.length() % piece);
		byte[] onePiece = new byte[bytesInPiece];
		byte[] lastPiece = new byte[bytesInPiece + remainder];
		int originalPieces = (int) ((file.length() / bytesInPiece) - 1);

		byte[] temp = new byte[(int) file.length()];

		FileInputStream fileInBytes = new FileInputStream(file);
		fileInBytes.read(temp);

		int number = 0;
		int pieceNumber = 0;
		for (int i = 0; i < originalPieces; i++) {
			for (int j = 0; j < bytesInPiece; j++) {
				onePiece[j] = temp[number];
				number++;
			}
			FileOutputStream fos = new FileOutputStream("D:\\it\\test2\\testmusic" + pieceNumber + ".mp3");
			fos.write(onePiece);
			fos.close();
			pieceNumber++;
		}
		for (int j = 0; j < (bytesInPiece + remainder); j++) {
			lastPiece[j] = temp[number];
			number++;
		}
		FileOutputStream fos = new FileOutputStream("D:\\it\\test2\\testmusic" + pieceNumber + ".mp3");
		fos.write(lastPiece);
		fos.close();

		System.out.println(bytesInPiece + "\n" + remainder + "\n" + (bytesInPiece * piece) + "\n" + file.length() + "\n"
				+ originalPieces);
		return splittedFiles;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("D:\\it\\music3.mp3");
		split(file, 3);
	}
}
