package Great;

import java.util.HashMap;

public enum MatchType_jhs {
	None(0, "없음"),
	Name(1, "이름"),
	Gender(2, "성별"),
	Age(3, "시대"),
	Type(4, "분류"),
	Year(5, "년도"),
	Work(6, "업적");
	
	int value;
	String match;
	
	static HashMap<String, MatchType_jhs> map = new HashMap<String, MatchType_jhs>();
	static HashMap<MatchType_jhs, String> nameMap = new HashMap<MatchType_jhs, String>();
	MatchType_jhs(int value, String name){
		this.value = value;
		this.match = name;
	}
	public String toString(){
		return nameMap.get(this);
	}
	static {
		for(MatchType_jhs d: MatchType_jhs.values()){
			map.put(d.match, d);
			nameMap.put(d, d.match);
		}
	}
}
