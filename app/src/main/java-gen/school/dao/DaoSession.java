package school.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import school.Student;
import school.Teacher;
import school.Middle;

import school.dao.StudentDao;
import school.dao.TeacherDao;
import school.dao.MiddleDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig studentDaoConfig;
    private final DaoConfig teacherDaoConfig;
    private final DaoConfig middleDaoConfig;

    private final StudentDao studentDao;
    private final TeacherDao teacherDao;
    private final MiddleDao middleDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        studentDaoConfig = daoConfigMap.get(StudentDao.class).clone();
        studentDaoConfig.initIdentityScope(type);

        teacherDaoConfig = daoConfigMap.get(TeacherDao.class).clone();
        teacherDaoConfig.initIdentityScope(type);

        middleDaoConfig = daoConfigMap.get(MiddleDao.class).clone();
        middleDaoConfig.initIdentityScope(type);

        studentDao = new StudentDao(studentDaoConfig, this);
        teacherDao = new TeacherDao(teacherDaoConfig, this);
        middleDao = new MiddleDao(middleDaoConfig, this);

        registerDao(Student.class, studentDao);
        registerDao(Teacher.class, teacherDao);
        registerDao(Middle.class, middleDao);
    }
    
    public void clear() {
        studentDaoConfig.getIdentityScope().clear();
        teacherDaoConfig.getIdentityScope().clear();
        middleDaoConfig.getIdentityScope().clear();
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public TeacherDao getTeacherDao() {
        return teacherDao;
    }

    public MiddleDao getMiddleDao() {
        return middleDao;
    }

}
