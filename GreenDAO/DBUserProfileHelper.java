...
// GreenDAO db helper example
import xxx.common.db.DBManager;
import xxx.common.db.pojo.DBUserProfile;
import xxx.db.pojo.DBUserProfileDao;
import xxx.db.pojo.DaoSession;

import java.util.List;

public class DBUserProfileHelper {
    public static final String TAG = DBUserProfileHelper.class.getSimpleName();

    private static DBManager manager = DBManager.getInstance();
    private static DaoSession mReadSession = manager.getReadSession();
    private static DaoSession mWriteSession = manager.getWriteSession();

    public static List<DBUserProfile> getUser(long userId) {
        mReadSession.clear();
        String where = "where " + DBUserProfileDao.Properties.UserId.columnName + " = " + userId;
        return mReadSession.getDBUserProfileDao().queryRaw(where, null);
    }

    public static void saveUser(DBUserProfile uProfile) {
        if (uProfile == null || uProfile.getUserId() <= 0l) return;

        List<DBUserProfile> userProfiles = getUser(uProfile.getUserId());
        for (DBUserProfile u : userProfiles) {
            uProfile.set_id(u.get_id());
        }
        mWriteSession.getDBUserProfileDao().save(uProfile);
    }
}
