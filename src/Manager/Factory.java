package Manager;

import java.util.Scanner;

public interface Factory {
    Manageable create();
    Manageable create(Scanner scan);
}
