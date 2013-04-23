import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eugen
 * Date: 13.04.13
 * Time: 12:56
 */
public class TaskLauncher {

    private Console console;
    private DaoHelper dbHelper;
    private Task task;

    public TaskLauncher() {
        task = new Task();
        console = new Console();
        dbHelper = new DaoHelper();
    }

    public void startTask() throws SQLException {
        dbHelper.createDB();
        while (true) {
            menuInfo();
            mainMenu(console.scanInt());
        }
    }

    private void mainMenu(int readConsole) throws SQLException {
        switch (readConsole) {
            case 1:
                task = createTask();
                int id = dbHelper.addTask(task);
                System.out.println("Added #" + id);
                break;

            case 2:
                System.out.println("Enter ID to delete :");
                int delTask = console.scanInt();
                if (dbHelper.deleteTask(delTask)) {
                    System.out.println("Deleted!");
                } else {
                    System.out.println("ID not found!");
                }
                break;

            case 3:
                getTaskList();
                break;

            default:
                System.out.println("Enter correct value!");
        }

    }

    public Task createTask() {
        task.setTask(console.taskInput());
        task.setPriority(console.priorityInput());
        return new Task(task.getTask(), task.getPriority());
    }

    public void getTaskList() throws SQLException {
        List<Task> taskList = dbHelper.getList();
        for (Task task : taskList) {
            System.out.println("#" + task.getId() + " " + task.getTask() +
                    " (" + task.getPriority() + ")");
        }
    } 

    public void menuInfo() {
        System.out.println("\n" + "1-> Add task");
        System.out.println("2-> Delete task");
        System.out.println("3-> Show All tasks");
    }

    public static void main(String[] args) throws SQLException {
        TaskLauncher taskLauncher = new TaskLauncher();
        taskLauncher.startTask();
    }
}