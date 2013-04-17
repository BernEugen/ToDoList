import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Eugen
 * Date: 14.04.13
 * Time: 11:09
 */
public class TestTask {
    private DaoHelper testDaoHelper;
    private Task testTask;


    @Before
    public void setUp() throws SQLException {
        testDaoHelper = new DaoHelper();
        testDaoHelper.createDB();
    }

    @Test
    public void testCreateAndDeleteTask() throws SQLException {
        String testText = "Test create Task";
        int testPriority = 5;
        testTask = new Task(testText, testPriority);
        int id = testDaoHelper.addList(testTask);

        List<Task> testList = testDaoHelper.getQuery();
        Assert.assertEquals(testText, testList.get(testList.size() - 1).getTask());
        Assert.assertEquals(testPriority, testList.get(testList.size() - 1).getPriority());

        testDaoHelper.deleteTask(id);
        Assert.assertFalse(testDaoHelper.isIdExist(id));
    }
}






































