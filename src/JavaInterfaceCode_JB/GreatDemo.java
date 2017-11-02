package JavaInterfaceCode_JB;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GreatDemo
{
	ArrayList<Great> greats = new ArrayList();
	Scanner scan = null;
	
	public static void main(String[] args)
	{
		GreatDemo demo = new GreatDemo();
		demo.doit();
	}
	
	void doit()
	{
		readAll();
		printAll();
		search();
	}
	
	void openFile(String fileName)
	{
		try
		{
			scan = new Scanner(new File(fileName));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	void readAll()
	{
		openFile("great-inherit.txt");
		Great great = null;
		
		String tmp = null;
		while(scan.hasNext())
		{
			if(tmp.equals("m"))
			{
				tmp = scan.next();
				great = new WellKnownGreat(tmp);
			}
			else
			{
				great = new Great(tmp);
			}
			great.read(scan);
			greats.add(great);
		}
	}
	
	void printAll()
	{
		for(Great g : greats)
		{
			g.print();
		}
	}
	
	static boolean isInteger(String s)
	{
		return (s!= null) && (s.matches("\\d+"));
	}
	
	void search()
	{
		scan = new Scanner(System.in);
		Iterator localIterator;
		for(; ; localIterator.hasNext())
		{
			System.out.print("검색어 입력 : ");
			String kwd = scan.nextLine();
			kwd = kwd.trim();
			if(kwd.equals("y"))
			{
				break;
			}
			localIterator = this.greats.iterator();
			continue;
		}
	}
}
