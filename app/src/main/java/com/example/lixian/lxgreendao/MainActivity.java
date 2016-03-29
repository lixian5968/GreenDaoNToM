package com.example.lixian.lxgreendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


//    private SQLiteDatabase db;
//    private DaoMaster daoMaster;
//    private DaoSession daoSession;
//    private Cursor cursor;
//    public static final String TAG = MainActivity.class.getSimpleName();
//    StudenDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView mTextView = (TextView) findViewById(R.id.mTextView);
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "student-db", null);
//        db = helper.getWritableDatabase();
//        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
//        daoMaster = new DaoMaster(db);
//        daoSession = daoMaster.newSession();
//        dao = daoSession.getStudenDao();


    }
//
//    public void insert(View v) {
//        // 插入操作，简单到只要你创建一个 Java 对象
//        Studen note = new Studen(null, "sr", 1, new Date());
//        dao.insert(note);
//
//    }
//
//    public void query(View v) {
//
//
//        QueryBuilder<Studen> qb = dao.queryBuilder();
//        qb.where(StudenDao.Properties.Name.eq("sr"));
//        qb.orderAsc(StudenDao.Properties.Id);
//        List<Studen> Studens = qb.list();
//        Log.e(TAG, Studens.size() + "");
//
//    }
//
//
//
//    public void queryAll(View v) {
//        QueryBuilder<Studen> qb = dao.queryBuilder();
//        List<Studen> Studens = qb.list();
//        Log.e(TAG, Studens.size() + "");
//    }
//
//    public void querySql(View v) {
//        List<Studen> Studens = dao.queryRaw(" where T.NAME ='sr'");
//        Log.e(TAG, Studens.size() + "");
//        QueryBuilder.LOG_SQL = true;
//        QueryBuilder.LOG_VALUES = true;
//    }
//
//
//    public void update(View v) {
//        QueryBuilder<Studen> qb = dao.queryBuilder();
//        qb.where(StudenDao.Properties.Name.eq("sr"));
//        qb.orderAsc(StudenDao.Properties.Id);
//        List<Studen> Studens = qb.list();
//        Log.e(TAG, Studens.size() + "");
//
//        Studen newStuden = Studens.get(0);
//        newStuden.setName("lj");
//        dao.update(newStuden);
//    }
//
//    public void delete(View v) {
//        QueryBuilder<Studen> qb = dao.queryBuilder();
//        List<Studen> Studens = qb.list();
//        Studen newStuden = Studens.get(0);
//        dao.delete(newStuden);
//    }
//
//    public void deleteAll(View v) {
//        dao.deleteAll();
//    }
//
//
//    public void check(View v) {
//        QueryBuilder<Studen> qb = dao.queryBuilder();
//        List<Studen> Studens = qb.list();
//        Log.e(TAG, Studens.size() + "");
//    }
}
