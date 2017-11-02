package JavaInterfaceCode_JB;

import java.util.HashMap;

public enum Dinasty 
{
	None(0, "없음"),
	GoChosun(1, "고조선"),
	SamKuk(2, "삼국"),
	Silla(3, "통일신라"),
	Koryo(4, "고려"),
	Chosun(5, "조선"),
	Ilge(6, "식민지"),
	KorRep(7, "대한민국");
	
	int value;
	String name;
	static HashMap<Integer, Dinasty> map = new HashMap();
	
	static
	{
		for(Dinasty di : values())
		{
			map.put(Integer.valueOf(di.value), di);
		}
	}
	
	private Dinasty(int n, String name)
	{
		this.value = n;
		this.name = name;
	}
	
	String getName()
	{
		return this.name();
	}
	
	static Dinasty get(int i)
	{
		return (Dinasty)map.get(Integer.valueOf(i));
	}
}
