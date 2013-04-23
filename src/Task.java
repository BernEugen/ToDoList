import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created with IntelliJ IDEA.
 * User: Eugen
 * Date: 11.04.13
 * Time: 8:33
 */
@DatabaseTable(tableName = "taskList")
public class Task {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String newTask;

    @DatabaseField(canBeNull = false)
    private int priority;

    public Task() {}

    public Task(String newTask, int priority) {
        this.newTask = newTask;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return newTask;
    }

    public int getPriority() {
        return priority;
    }

    public void setTask(String newTask) {
        this.newTask = newTask;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
