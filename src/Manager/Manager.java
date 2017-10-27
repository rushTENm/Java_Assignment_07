package Manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    public ArrayList<Manageable> sList = new ArrayList<>();

    Scanner openFile(String filename) {
        File f = new File(filename);
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return fileIn;
    }

    public void readAll(String fileName, Factory fac) {
        Scanner scan = openFile(fileName);
        Manageable manageable = null;
        while (scan.hasNext()) {
            manageable = fac.create();
            manageable.read(scan);
            sList.add(manageable);
        }
        scan.close();
    }
}
