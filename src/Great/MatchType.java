package Great;

public enum MatchType {
    None(0, "없음"),
    Name(1, "이름"),
    Gender(2, "성별"),
    Dynasty(3, "시대"),
    Type(4, "분류"),
    Year(5, "년도"),
    Work(6,"업적");

    int index;
    String name;

    MatchType(int index, String name) {
        this.index = index;
        this.name = name;
    }
}
