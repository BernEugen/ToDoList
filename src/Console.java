import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Eugen
 * Date: 07.04.13
 * Time: 17:13
 */
public class Console {

    public String scanInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }


    public int scanInt() {
        while (true) {
            try {
                return Integer.parseInt(scanInput());
            } catch (IllegalArgumentException ex) {
                System.out.println("Enter correct value!");
            }
        }
    }

    public String taskInput() {
        System.out.println("Enter Task :");
        return scanInput();
    }

    public int priorityInput() {
        while (true) {
            System.out.println("Enter Priority :");
            try {
                return Integer.parseInt(scanInput());
            } catch (IllegalArgumentException ex) {
                System.out.println("Must be a number!");
            }
        }
    }
}
