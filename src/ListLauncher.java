import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Eugen
 * Date: 11.04.13
 * Time: 8:42
 */
public class ListLauncher {
    List listObj;
    DBHelper dbHelper;
    Console console;

    public ListLauncher() {
        listObj = new List();
        dbHelper = new DBHelper();
        console = new Console();
    }

    public void startList() throws SQLException {
        dbHelper.createDB();
        while (true) {
            menuInfo();
            int readConsole = console.getInt();
            chooseAction(readConsole);
        }
    }

    public void chooseAction(int select) throws SQLException {
        switch (select) {
            case 1:
                System.out.println("Write your task. To Save press Enter.");
                dbHelper.addList();
                System.out.println("Saved. ID #" + listObj.getId());
                break;
            case 2:
                System.out.println("Enter ID which you want ot delete :");
                dbHelper.deleteList();
                break;
            case 3:
                System.out.println("\n" + "--------------------------");
                dbHelper.showList();
                System.out.println("--------------------------");
                break;
            default:
                System.out.println("Enter correct value!");
        }
    }

    public void menuInfo() {
        System.out.println("\n" + "1-> To Add task");
        System.out.println("2-> To Delete task");
        System.out.println("3-> To Show All tasks");
    }

    public static void main(String[] args) throws SQLException {
        ListLauncher listLaunch = new ListLauncher();
        listLaunch.startList();
    }
}
