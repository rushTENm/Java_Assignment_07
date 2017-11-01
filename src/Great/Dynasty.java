package Great;

import java.util.HashMap;

public enum Dynasty {
    None(0, "없음"),
    GoChosun(1, "고조선"),
    SamKuk(2, "삼국"),
    Silla(3, "통일신라"),
    Koryo(4, "고려"),
    Chosun(5, "조선"),
    Ilje(6, "식민지"),
    KorRep(7, "대한민국");

    int value;
    String name;

    Dynasty(int value, String name) {
        this.value = value;
        this.name = name;
    }

    @Override
    public String toString() {
        return nameMap.get(this);
    }

    static HashMap<Integer, Dynasty> map = new HashMap<Integer, Dynasty>();
    static HashMap<Dynasty, String> nameMap = new HashMap<Dynasty, String>();

    static {
        for (Dynasty dynasty : Dynasty.values()) {
            map.put(dynasty.value, dynasty);
            nameMap.put(dynasty, dynasty.name);
        }
    }
}
