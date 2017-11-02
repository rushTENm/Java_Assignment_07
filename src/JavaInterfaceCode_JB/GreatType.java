package JavaInterfaceCode_JB;

import java.util.HashMap;

public enum GreatType
{
	Etc(0, "기타"),
	King(1, "왕"),
	Millitary(2, "무인"),
	Politician(3, "정치인"),
	Artist(4, "예술가"),
	Doctor(5, "의사"),
	Religionist(6, "종교인");
	
	int value;
	String name;
	static HashMap<String, GreatType> map = new HashMap();
	
	static
	{
		for(GreatType gt : values())
		{
			map.put(gt.name, gt);
		}
	}
	
	GreatType(int n, String str)
	{
		this.value = n;
		this.name = str;
	}
	
	String getName()
	{
		return this.name();
	}
	
	static GreatType get(String str)
	{
		return (GreatType)map.get(str);
	}
}
