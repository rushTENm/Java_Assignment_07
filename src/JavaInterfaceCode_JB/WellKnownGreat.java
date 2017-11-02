package JavaInterfaceCode_JB;

import java.util.ArrayList;
import java.util.Scanner;

public class WellKnownGreat extends Great
{
	ArrayList<WellKnownGreatFilm> filmList = new ArrayList();
	WellKnownGreat(String name) 
	{
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	void read(Scanner s)
	{
		super.read(s);
		String line = s.nextLine();
		String[] arr = line.trim().split(" ");
		WellKnownGreatFilm film = null;
		
		for(int i = 0; i < arr.length; i += 2)
		{
			film = new WellKnownGreatFilm(arr[i], arr[(i + 1)]);
			this.filmList.add(film);
		}
	}
	
	void printMovie()
	{
		for(WellKnownGreatFilm f : this.filmList)
		{
			f.print();
		}
		System.out.println();
	}
	
	class Film
	{
		boolean bMovie;
		String title;
		
		Film(String tmp, String title)
		{
			if(tmp.equals("영화"))
			{
				this.bMovie = true;
			}
			this.title = title;
		}
		
		void print()
		{
			System.out.printf("%s %s", new Object[] { this.bMovie ? "영화" : "드라마", this.title});
		}
	}
}
