package Great;

import Manager.Manageable;

import java.util.Scanner;

public class FamousGreat extends Great implements Manageable {
    String movie;

    public FamousGreat(String name) {
        super(name);
    }

    @Override
    public void read(Scanner in) {
        super.read(in);
        movie = in.nextLine();
    }

    @Override
    public void print() {
        super.print();
        if (movie != null)
            System.out.println("                      ++" + movie);
    }
}
