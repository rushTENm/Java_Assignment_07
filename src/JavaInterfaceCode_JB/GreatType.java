package JavaInterfaceCode_JB;

import java.util.HashMap;

public enum GreatType
{
	Etc(0, "��Ÿ"),
	King(1, "��"),
	Millitary(2, "����"),
	Politician(3, "��ġ��"),
	Artist(4, "������"),
	Doctor(5, "�ǻ�"),
	Religionist(6, "������");
	
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
