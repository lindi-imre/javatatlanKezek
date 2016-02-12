package test;

import java.io.File;
import java.io.RandomAccessFile;

public class MP3
{
	private String title;
	private String artist;
	private String album;
	private String comment;
	private int year;
	private byte genre;
	private long size;
	private byte track;
	private String filename;
	private String abspath;
	private byte[] arrayOfID3;
	private String tail;

	public MP3(File file)
	{
		this.abspath = file.getAbsolutePath();
		this.filename = file.getName();
		convertTailtoString(fileTail(file));
		setOriginalTitle(tail);
	}

	private void convertTailtoString(byte[] bajttomb)
	{
		String decoded = new String(bajttomb);
		this.tail = decoded;
	}

	private void setOriginalTitle(String tail)
	{
		String result = "";
		for (int i = 3; i < 32; i++)
		{
			result += tail.charAt(i);
		}
		this.title = result;
	}

	public String getTail()
	{
		return tail;
	}

	public String getTitle()
	{
		return title;
	}

	public String getArrayOfID3()
	{
		String result = "";
		for (byte b : arrayOfID3)
		{
			result += b + " ";

		}
		return result;
	}

	public void setBajttomb(byte[] bajttomb)
	{
		this.arrayOfID3 = bajttomb;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getAbspath()
	{
		return abspath;
	}

	public void setAbspath(String abspath)
	{
		this.abspath = abspath;
	}

	private byte[] fileTail(File file)
	{
		try
		{
			RandomAccessFile handler = new RandomAccessFile(file, "r");
			long fileLength = file.length() - 1;
			byte[] buffer = new byte[128];

			for (int i = 0; i < buffer.length; i++)
			{
				handler.seek(fileLength - 127 + i);
				buffer[i] = handler.readByte();
			}
			handler.close();
			return buffer;
		}

		catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}
}