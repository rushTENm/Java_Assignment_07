package Great;

import java.util.ArrayList;
import java.util.Scanner;

class Great {

    String name;
    boolean gender;
    int birth;
    int death;
    ArrayList<String> contents = new ArrayList<String>();

    void read(Scanner in) {
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

    void print(){
        System.out.printf("\n%s [%s] %d~%d년\n", name, gender?"남":"녀", birth, death);

        for(String content : contents)
            System.out.println("    - "+content);
    }


    int compare(String kwd){

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