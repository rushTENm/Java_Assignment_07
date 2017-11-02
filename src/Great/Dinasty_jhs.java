package Great;

import java.util.HashMap;




public enum Dinasty_jhs {
	None(0, "없음"),
	GoChosun(1, "고조선"),
	SamKuk(2, "삼국"),
	Silla(3,"통일신라"),
	Koryo(4, "고려"),
	Chosun(5, "조선"),
	Ilie(6, "식민지"),
	KorRep(7, "대한민국");
	
	int value;
	String name;
	
	static HashMap<Integer, Dinasty_jhs> map = new HashMap<Integer, Dinasty_jhs>();
	static HashMap<Dinasty_jhs, String> nameMap = new HashMap<Dinasty_jhs, String>();
	Dinasty_jhs(int value, String name){
		this.value = value;
		this.name = name;
	}
	public String toString(){
		return nameMap.get(this);
	}
	static {
		for(Dinasty_jhs d: Dinasty_jhs.values()){
			map.put(d.value, d);
			nameMap.put(d, d.name);
		}
	}
}
