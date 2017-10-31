package Great;

import Manager.Manageable;

import java.util.ArrayList;
import java.util.Scanner;

class Great implements Manageable {

    String name;
    boolean gender;
    int birth;
    int death;
    ArrayList<String> contents = new ArrayList<String>();

    public void read(Scanner in) {
        name = in.next();
        gender = in.next().equals("M");
        birth = in.nextInt();
        death = in.nextInt();

        in.nextLine();

        while(in.hasNext()){
            String str = in.nextLine();

            if(str.length() == 0) break;
            contents.add(str);
        }
    }

    public void print(){
        System.out.printf("\n%s [%s] %d~%d년\n", name, gender?"남":"녀", birth, death);

        for(String content : contents)
            System.out.println("    - "+content);
    }

    @Override
    public boolean compare(String kwd) {
        return false;
    }


    int compareGreat(String kwd){

        if(kwd.equals(name))
            return 1;
        if(GreatDemo.isInteger(kwd)){
            int alive = Integer.parseInt(kwd);
            if (alive >= birth && alive <= death)
                return 2;
        }

        for (String content : contents)
            if (content.contains(kwd))
                return 2;

        return 0;
    }
}