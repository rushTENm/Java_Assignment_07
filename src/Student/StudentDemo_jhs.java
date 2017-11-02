package Student;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import manager.Factory;
import manager.Managable;
import manager.Manager;

public class StudentDemo_jhs extends Manager implements Factory {
	public static void main(String[] args) {
		StudentDemo_jhs demo = new StudentDemo_jhs();
		demo.doit();
	}
	public Student create(){
		return new Student();
	}
	void doit() {
		readAll("students.txt",this);
		readScores();
		printAll();
	}
	
	void readScores() {
		Scanner keyin = new Scanner(System.in);
		System.out.println("�л� ���̵�� ���� �Է� (���� ���� 0)");
		String id;
		Student st = null;
		while (true) {
			System.out.print("... ");
			id = keyin.next();
			st = (Student)find(id);
			if (st == null) break;
			((Student)st).readScores(keyin);;
		}
		
	}
	
}

class Student implements Managable {
	String id;
	String name;
	int year;
	boolean bMale;
	private ArrayList<Integer> scores = new ArrayList<>();
	double avg;

	public void read(Scanner s) {
		id = s.next();
		name = s.next();
		year = s.nextInt();
		bMale = s.next().equals("m");
	}
	public void print() {
		System.out.printf("%s %s %2d %s ", 
						id, name, year, bMale?"��":"��", avg);
		if (avg > 0) System.out.printf("%5.2f%n", avg);
		else System.out.println();
	}
	public boolean compare(String kwd) {
		return name.equals(kwd) || id.equals(kwd);
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
