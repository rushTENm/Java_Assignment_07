package JavaInterfaceCode_JB;

import java.util.Scanner;

public class Great 
{
	String name;
	int birth;
	int death;
	String work = null;
	boolean gender;
	Dinasty age;
	GreatType Gtype;
	
	Great(String name)
	{
		this.name = name;
	}
	
	void read(Scanner in)
	{
		gender = in.next().equals("M");
		GreatType gt = null;
		int tmp = 0;
		tmp = in.nextInt();
		age = Dinasty.get(tmp);
		String typeStr = in.next();
		Gtype = GreatType.get(typeStr);
		birth = in.nextInt();
		death = in.nextInt();
		work = in.nextLine();
	}
	
	void print()
	{
		printMatch(MatchType.None, null);
	}
	
	void printMatch(MatchType t, String kwd)
	{
		if(t == MatchType.Name)
		{
			System.out.printf("%10s", new Object[] { "이 위인은"});
		}
		else
		{
			System.out.printf("%s\t", name);
		}
		if((t != MatchType.Gender) && (!gender))
		{
			System.out.printf("[F]", new Object[0]);
		}
		else
		{
			System.out.printf("   ", new Object[0]);
		}
		if(birth < 0)
		{
			System.out.printf(" BC  %d", birth);
		}
		else
		{
			System.out.printf("  %d", birth);
		}
		if(death < 0)
		{
			System.out.printf(" BC %d", death);
		}
		else
		{
			System.out.printf("  %d", birth);
		}
		if(t != MatchType.Age)
		{
			System.out.printf("%s", age.getName());
		}
		if(t != MatchType.Type)
		{
			System.out.printf("%s", Gtype.getName());
		}
		if (t == MatchType.Work)
		{
			String tmp = work.replace(kwd, "<" + kwd + ">");
			System.out.printf("%s", tmp);
		}
		else
		{
			System.out.printf("%s", work);
		}
		System.out.println();
	}
	
	boolean compare(String kwd)
	{
		if(kwd.equals(this.name))
		{
			return true;
		}
		if(GreatDemo.isInteger(kwd))
		{
			int alive = Integer.parseInt(kwd);
			if((alive >= this.birth) && (alive <= this.death))
			{
				return true;
			}
		}
		return work.contains(kwd);
	}
	
	MatchType match(String kwd)
	{
		MatchType mt = MatchType.None;
		if(GreatDemo.isInteger(kwd))
		{
			int year = Integer.parseInt(kwd);
			if((this.birth <= year) && (this.death >= year))
			{
				mt = MatchType.Year;
			}
			else if(this.name.equals(kwd))
			{
				mt = MatchType.Name;
			}
			else if(this.age.getName().equals(kwd))
			{
				mt = MatchType.Age;
			}
			else if(this.Gtype.getName().equals(kwd))
			{
				mt = MatchType.Type;
			}
			else if((kwd.equals("M")) && (this.gender))
			{
				mt = MatchType.Gender;
			}
			else if((kwd.equals("F")) && (!this.gender))
			{
				mt = MatchType.Gender;
			}
		}
		return mt;
	}
	
}
