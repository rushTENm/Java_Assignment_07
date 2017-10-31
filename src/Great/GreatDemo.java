package Great;

import Manager.Factory;
import Manager.Manager;
import Manager.Manageable;

import java.util.Scanner;

public class GreatDemo extends Manager implements Factory {

    Scanner scan = null;

    public void run() {
        readAll("great1.txt", this);
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

            for (Manageable m : mList) {
                Great g = (Great) m;
                int flag = g.compareGreat(kwd);
                switch (flag) {
                    case 1:
                        g.print();
                        break;
                    case 2:
                        System.out.println(g.name);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public Great create() {
        return new Great();
    }
}

