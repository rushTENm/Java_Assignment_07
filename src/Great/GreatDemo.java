package Great;

import Manager.Factory;
import Manager.Manager;
import Manager.Manageable;

import java.util.Scanner;

public class GreatDemo extends Manager implements Factory {

    Scanner scan = null;

    public void run() {
        readAll("great-inherit.txt", this);
        printAll();
        search();
    }

    void printAll() {
        for (Manageable g : mList)
            g.print();
    }

    static boolean isInteger(String s) {
        return s != null && s.matches("\\d+");
    }

    void search() {
        scan = new Scanner(System.in);

        while (true) {

            System.out.print("\n검색어를 입력하세요..(종료 y) : ");
            String kwd = scan.nextLine();

            if (kwd.equals("y"))
                break;

            compare(kwd);
        }
    }

    private void compare(String kwd) {
        for (Manageable m : mList) {
            Great g = (Great) m;

            if (g.compare(kwd)) {
                g.printMatch(g.match(kwd), kwd);
                if (g instanceof FamousGreat) {
                    System.out.printf("%30s \n", "++"+((FamousGreat) g).movie);
                }
            }
        }
    }

    @Override
    public Great create() {
        return new Great();
    }

    @Override
    public Manageable create(Scanner scan) {
        String name = scan.next();
        if (name.equals("m"))
            return new FamousGreat(scan.next());
        else
            return new Great(name);
    }
}

