package Great;

import java.util.ArrayList;
import java.util.Scanner;

import Great.Dinasty_jhs;
import Great.Great_jhs;
import Manager.Factory_jhs;
import Manager.Managable_jhs;
import Manager.Manager_jhs;

public class GreatDemo_jhs extends Manager_jhs implements Factory_jhs {
	
	ArrayList<Great_jhs> greats = new ArrayList<Great_jhs>();
	Scanner scan = null;
	
	public static void main(String[] args){
		GreatDemo_jhs demo = new GreatDemo_jhs();
		demo.doit();
	}
	
	void doit(){
		readAll("great-inherit.txt", this);
		printAll();
		
	}
	
	public Great_jhs create(){
		return new Great_jhs();
	}
	public Great_jhs create1(){
		return new FamousGreat_jhs();
	}
	static boolean isInteger(String s){
		return s != null && s.matches("\\d+");  
	}
	/*
	void search(){
		scan = new Scanner(System.in);
		
		while(true){
			
			System.out.print("\n검색어를 입력하세요..(종료 y) : ");
			String kwd = scan.nextLine();
		
			if(kwd.equals("y")) break;
		
			for(Managable g : glist){
				int flag = g.compare(kwd);
				switch(flag){
				case 1: g.print(); break;
				case 2: System.out.println(g.name); break;
				default : break;
				}
			}
		}
	}
	*/
}


