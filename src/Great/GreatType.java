package Great;

import java.util.HashMap;

public enum GreatType {
    Etc(0, "기타"),
    King(1, "왕"),
    Military(2, "무인"),
    Politician(3, "정치가"),
    Artist(4, "예술가"),
    Doctor(5, "의사"),
    Religionist(6, "종교인");

    int value;
    String type;

    GreatType(int value, String type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public String toString() {
        return nameMap.get(this);
    }

    static HashMap<String, GreatType> map = new HashMap<String, GreatType>();
    static HashMap<GreatType, String> nameMap = new HashMap<GreatType, String>();

    static {
        for (GreatType greatType : GreatType.values()) {
            map.put(greatType.type, greatType);
            nameMap.put(greatType, greatType.type);
        }
    }
}
