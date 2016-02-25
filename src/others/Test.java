package others;

import java.io.File;

public class Test
{

	public static void main(String[] args)
	{
		System.out.println("aefewf");
		File fajl = new File("D:\\orinoco1.mp3");
		MP3 zene = new MP3(fajl);
		System.out.println(zene);
		System.out.println(zene.getTitle());

	}

}
