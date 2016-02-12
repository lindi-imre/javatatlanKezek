package test;

import java.io.File;

public class MP3_2 extends File
{

	private ID3Tag tag;

	public MP3_2(String filepath)
	{
		super(filepath);
	}

	public ID3Tag getTag()
	{
		return tag;
	}

	public void setTag(ID3Tag tag)
	{
		this.tag = tag;
	}

}
