package Student;

import Manager.Manageable;
import Manager.Manager;
import Manager.Factory;

import java.util.Scanner;

public class StudentDemo extends Manager implements Factory {

    public void run() {
        readAll("students.txt", this);
        readScores();
        printAll();
    }

    void readScores() {
        Scanner keyin = new Scanner(System.in);
        System.out.println("학생 아이디와 점수 입력 (점수 끝은 0)");
        String id;
        Student st = null;
        while (true) {
            System.out.print("... ");
            id = keyin.next();
            st = (Student) find(id);
            if (st == null)
                break;
            ((Student) st).readScores(keyin);
        }
    }

    Manageable find(String kwd) {
        for (Manageable s : mList)
            if (s.compare(kwd))
                return s;
        return null;
    }

    void printAll() {
        for (Manageable s : mList)
            s.print();
    }

    @Override
    public Student create() {
        return new Student();
    }
}