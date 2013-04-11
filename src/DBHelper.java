import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.logger.LocalLog;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Eugen
 * Date: 11.04.13
 * Time: 8:38
 */
public class DBHelper {
    private final static String db = "jdbc:sqlite:list.db";
    private Dao<List, String> daoList;
    private ConnectionSource connectionSource;
    private Console console = new Console();

    public void createDB() throws SQLException {
        System.setProperty(LocalLog.LOCAL_LOG_FILE_PROPERTY, "log.out");
        connectionSource = new JdbcConnectionSource(db);
        daoList = DaoManager.createDao(connectionSource, List.class);
        TableUtils.createTableIfNotExists(connectionSource, List.class);
    }

    public void addList() throws SQLException{
        List listTask = new List(console.getString());
        daoList.create(listTask);
    }

    public void showList() throws SQLException{
        CloseableIterator<List> iterator = daoList.closeableIterator();
        try {
            while (iterator.hasNext()) {
                List list = iterator.next();
                System.out.println(list.getId() + " " + list.getList());
            }
        } finally {
            iterator.close();
        }
    }

    public void deleteList() throws SQLException {
        String s = console.getString();
        daoList.deleteById(s);
    }
}
