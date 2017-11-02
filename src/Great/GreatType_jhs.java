package Great;

import java.util.HashMap;

public enum GreatType_jhs {
	Etc(0, "기타"),
	King(1, "왕"),
	Millitary(2, "무인"),
	Politician(3, "정치가"),
	Artist(4, "예술가"),
	Doctor(5, "의사"),
	Religionist(6, "종교인");
	
	int value;
	String type;
	
	static HashMap<String, GreatType_jhs> map = new HashMap<String, GreatType_jhs>();
	static HashMap<GreatType_jhs, String> nameMap = new HashMap<GreatType_jhs, String>();
	GreatType_jhs(int value, String type){
		this.value = value;
		this.type = type;
	}
	public String toString(){
		return nameMap.get(this);
	}
	static {
		for(GreatType_jhs d: GreatType_jhs.values()){
			map.put(d.type, d);
			nameMap.put(d, d.type);
		}
	}

}
