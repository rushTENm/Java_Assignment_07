package JavaInterfaceCode_JB;

import java.util.HashMap;

public enum MatchType 
{
	None(0, "����"),
	Name(1, "�̸�"),
	Gender(2, "����"),
	Age(3, "�ô�"),
	Type(4, "�з�"),
	Year(5, "�⵵"),
	Work(6, "����");
	
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
