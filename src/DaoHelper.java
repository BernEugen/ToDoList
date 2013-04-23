import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eugen
 * Date: 11.04.13
 * Time: 8:38
 */
public class DaoHelper {
    private final static String db = "jdbc:sqlite:task_one.db";
    private Dao<Task, Integer> daoList;
    private ConnectionSource connectionSource;

    public void createDB() throws SQLException {
        System.setProperty(LocalLog.LOCAL_LOG_FILE_PROPERTY, "taskInfo.out");
        connectionSource = new JdbcConnectionSource(db);
        daoList = DaoManager.createDao(connectionSource, Task.class);
        TableUtils.createTableIfNotExists(connectionSource, Task.class);
    }

    public int addTask(Task task) throws SQLException {
        daoList.create(task);
        return daoList.extractId(task);
    }

    public List<Task> getList() throws SQLException{
        return daoList.queryForAll();
    }

    public boolean deleteTask(int id) throws SQLException {
        if (daoList.idExists(id)) {
            daoList.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean isIdExist(int id) throws SQLException{
        return daoList.idExists(id);
    }
}
