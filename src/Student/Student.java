package Student;

import Manager.Manageable;

import java.util.Scanner;
import java.util.ArrayList;

public class Student implements Manageable {
    String id;
    String name;
    int year;
    boolean bMale;
    private ArrayList<Integer> scores = new ArrayList<>();
    double avg;

    @Override
    public void read(Scanner s) {
        id = s.next();
        name = s.next();
        year = s.nextInt();
        bMale = s.next().equals("m");
    }

    @Override
    public boolean compare(String kwd) {
        return name.equals(kwd) || id.equals(kwd);
    }

    @Override
    public void print() {
        System.out.printf("%s %s %2d %s ",
                id, name, year, bMale?"남":"녀", avg);
        if (avg > 0) System.out.printf("%5.2f%n", avg);
        else System.out.println();
    }

    void readScores(Scanner in) {
        int num, sum=0;
        while (true) {
            num = in.nextInt();
            if (num == 0) break;
            scores.add(num);
            sum += num;
        }
        avg = (double)sum/scores.size();
    }
}
