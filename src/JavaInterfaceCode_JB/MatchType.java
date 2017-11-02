package JavaInterfaceCode_JB;

import java.util.HashMap;

public enum MatchType 
{
	None(0, "없음"),
	Name(1, "이름"),
	Gender(2, "성별"),
	Age(3, "시대"),
	Type(4, "분류"),
	Year(5, "년도"),
	Work(6, "업적");
	
	int value;
	String name;
	static HashMap<Integer, MatchType> map = new HashMap();
	
	static
	{
		for(MatchType mt : values())
		{
			map.put(Integer.valueOf(mt.value), mt);
		}
	}
	
	private MatchType(int n, String str)
	{
		this.value = n;
		this.name = str;
	}
	
	static MatchType get(int i)
	{
		return (MatchType)map.get(Integer.valueOf(i));
	}
}
