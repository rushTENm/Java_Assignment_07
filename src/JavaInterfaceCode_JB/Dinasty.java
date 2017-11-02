package JavaInterfaceCode_JB;

import java.util.HashMap;

public enum Dinasty 
{
	None(0, "����"),
	GoChosun(1, "������"),
	SamKuk(2, "�ﱹ"),
	Silla(3, "���ϽŶ�"),
	Koryo(4, "���"),
	Chosun(5, "����"),
	Ilge(6, "�Ĺ���"),
	KorRep(7, "���ѹα�");
	
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
