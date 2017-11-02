package Great;

import java.util.Scanner;

import Great.Dinasty_jhs;
import Great.MatchType_jhs;
import Manager.Factory_jhs;
import Manager.Managable_jhs;
import Manager.Manager_jhs;

class Great_jhs implements Managable_jhs {

	String name;
	boolean gender;
	Dinasty_jhs dinasty;
	GreatType_jhs type;
	int birth;
	int death;
	String contents;

	public void read(Scanner in, String check) {
		readAdded(in, check);
	}

	void readAdded(Scanner in, String check) {
		name = check;
		gender = in.next().equals("M");
		dinasty = Dinasty_jhs.map.get(in.nextInt());
		type = GreatType_jhs.map.get(in.next());
		birth = in.nextInt();
		death = in.nextInt();
		contents = in.nextLine();
	}

	public void print() {
		System.out.printf("%s %d ~ %d %s %s ", name, birth, death, dinasty, type);
		printAdded();
	}

	void printAdded() {
		System.out.printf("%s %n", contents);
	}

	int compare(String kwd) {

		if (kwd.equals(name))
			return 1;
		if (GreatDemo_jhs.isInteger(kwd)) {
			int alive = Integer.parseInt(kwd);
			if (alive >= birth && alive <= death)
				return 2;
		}

		if (contents.contains(kwd))
			return 2;

		return 0;
	}

}

class FamousGreat_jhs extends Great_jhs {
	String drama;

	void readAdded(Scanner in, String check) {
		name = in.next();
		gender = in.next().equals("M");
		dinasty = Dinasty_jhs.map.get(in.nextInt());
		type = GreatType_jhs.map.get(in.next());
		birth = in.nextInt();
		death = in.nextInt();
		contents = in.nextLine();
		drama = in.nextLine();
	}

	void printAdded() {
		System.out.printf("%s %n", contents);
		System.out.printf("++ %s %n", drama);
	}
}
