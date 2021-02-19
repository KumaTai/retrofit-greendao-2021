...
// GreenDAO db manager
import android.database.sqlite.SQLiteDatabase;

import xxx.common.db.pojo.DaoMaster;
import xxx.common.db.pojo.DaoSession;
import xxx.iHealthAdvanceApp;

import org.greenrobot.greendao.database.Database;

public class DBManager {
    public static final String dbName = "iHealthAdvance.db";

    private static DBManager mInstance;

    private DaoMaster.DevOpenHelper openHelper;

    public DBManager() {
        openHelper = new DaoMaster.DevOpenHelper(iHealthAdvanceApp.getInstance(), dbName, null);
    }

    public static DBManager getInstance() {
        if (mInstance == null) {
            synchronized (DBManager.class) {
                if (mInstance == null) {
                    mInstance = new DBManager();
                }
            }
        }
        return mInstance;
    }

    public DaoSession getReadSession() {
        SQLiteDatabase db = openHelper.getReadableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }

    public DaoSession getWriteSession() {
        SQLiteDatabase db = openHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        return daoSession;
    }

    public void clear() {
        Database database = openHelper.getWritableDb();
        DaoMaster.dropAllTables(database, true);
        DaoMaster.createAllTables(database, true);
    }
}
