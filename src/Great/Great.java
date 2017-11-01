package Great;

import Manager.Manageable;

import java.util.Scanner;

class Great implements Manageable {

    String name;
    boolean isMale;
    Dynasty dynasty;
    GreatType type;
    int birth;
    int death;
    String work;

    public Great() {

    }

    public Great(String name) {
        this.name = name;
    }

    public void read(Scanner in) {
        isMale = in.next().equals("M");
        dynasty = Dynasty.map.get(in.nextInt());
        type = GreatType.map.get(in.next());
        birth = in.nextInt();
        death = in.nextInt();
        work = in.nextLine();
    }

    public void print() {
        System.out.printf("%s [%s] %d~%d년 %s %s %s\n", name, isMale ? "남" : "녀", birth, death, dynasty, type, work);
    }

    @Override
    public boolean compare(String kwd) {
        if (kwd.equals(name))
            return true;
        if (!isMale && kwd.equals("F"))
            return true;
        if (kwd.equals(dynasty.name))
            return true;
        if (kwd.equals(type.type))
            return true;
        if (GreatDemo.isInteger(kwd)) {
            int alive = Integer.parseInt(kwd);
            if (alive >= birth && alive <= death)
                return true;
        }
        if (work.contains(kwd))
            return true;
        return false;
    }

    int compareGreat(String kwd) {

        if (kwd.equals(name))
            return 1;
        if (GreatDemo.isInteger(kwd)) {
            int alive = Integer.parseInt(kwd);
            if (alive >= birth && alive <= death)
                return 2;
        }
        if (work.contains(kwd))
            return 2;

        return 0;
    }

    MatchType match(String kwd) {
        MatchType mt = MatchType.None;
        if (GreatDemo.isInteger(kwd)) {
            int year = Integer.parseInt(kwd);
            if (birth <= year && death >= year)
                mt = MatchType.Year;
        } else if (name.equals(kwd))
            mt = MatchType.Name;
        else if (kwd.equals(dynasty.name))
            mt = MatchType.Dynasty;
        else if (kwd.equals("F") && !isMale)
            mt = MatchType.Gender;
        else if (kwd.equals(type.type))
            mt = MatchType.Type;
        else if (work.contains(kwd))
            mt = MatchType.Work;
        return mt;
    }

    void printMatch(MatchType t, String kwd) {
        if (t == MatchType.Name)
            System.out.printf("%s", "이 위인은 ");
        else
            System.out.printf("%s ", name);

        if (t != MatchType.Gender && !isMale)
            System.out.printf("[F] ");

        if (t != MatchType.Year)
            System.out.printf("%d~%d ",birth,death);

        if (t != MatchType.Dynasty)
            System.out.printf("%s시대 ", dynasty.nameMap.get(dynasty));

        if (t != MatchType.Type)
            System.out.printf("%s ", type.toString());

        if (t != MatchType.Work)
            System.out.println(work);
        else {
            int begin = work.indexOf(kwd);
            System.out.printf("%s<<%s>>%s\n", work.substring(0, begin), kwd, work.substring(begin + kwd.length()));
        }
    }
}