package JavaInterfaceCode_JB;

public class WellKnownGreatFilm
{
	boolean bMovie;
	String title;
	
	WellKnownGreatFilm(String tmp, String title)
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
