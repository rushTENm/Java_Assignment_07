package Manager;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager_jhs {
	ArrayList<Managable_jhs> gList = new ArrayList<>();

	protected void readAll(String fileName, Factory_jhs fac) {
		Scanner scan = openFile(fileName);
		String NULL = scan.nextLine();
		Managable_jhs m = null;
		while (scan.hasNext()) {
			String check = scan.next();
			if(check.equals("m"))
				m = fac.create1();
			else 
				m = fac.create();
			m.read(scan, check);
			gList.add(m);
		}
		scan.close();
	}
	protected void printAll() {
		for (Managable_jhs m : gList)
			m.print();
	}
	private Scanner openFile(String filename) {
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
}
