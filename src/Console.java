import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Eugen
 * Date: 07.04.13
 * Time: 17:13
 */
public class Console {
    private static Scanner scan;

    public Console() {
        scan = new Scanner(System.in);
    }

    public String getString() {
        String temp = scan.nextLine();
        if (scan.hasNext()) {
            temp = scan.nextLine();
        }
        return temp;
    }

    public int getInt() {
        try {
            return Integer.parseInt(scan.next());
        } catch (IllegalArgumentException ex) {

        }
        return 0;
    }
}
