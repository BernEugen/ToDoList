import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created with IntelliJ IDEA.
 * User: Eugen
 * Date: 11.04.13
 * Time: 8:33
 */
@DatabaseTable(tableName = "toDoList")
public class List {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String list;

    public List() {}

    public List(String mainList) {
        list = mainList;
    }

    public int getId() {
        return id;
    }

    public String getList() {
        return list;
    }
}
