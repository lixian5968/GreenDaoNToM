package com.example.lixian.lxgreendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import school.Middle;
import school.Student;
import school.Teacher;
import school.dao.DaoSession;
import school.dao.MiddleDao;
import school.dao.StudentDao;
import school.dao.TeacherDao;

public class Main2Activity extends AppCompatActivity {
    DaoSession session;
    StudentDao studentDao;
    TeacherDao teacherDao;
    MiddleDao middleDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        session = ((BaseApplication) this.getApplicationContext()).getDaoSession();
        studentDao = session.getStudentDao();
        teacherDao = session.getTeacherDao();
        middleDao = session.getMiddleDao();


    }


    public void addTeacher(View v) {


        String[] teachersName = new String[]{"李老师", "明老师", "王老师"};
        String[] studentsName = new String[]{"小李", "小明", "小王"};
        for (int i = 0; i < 3; i++) {
            Teacher tch1 = new Teacher(null, teachersName[i], 1, new Date());
            teacherDao.insert(tch1);
            Student stu1 = new Student(null, studentsName[i], 1, new Date());
            studentDao.insert(stu1);
        }


        QueryBuilder<Student> studentBuilder = studentDao.queryBuilder();
        List<Student> students = studentBuilder.list();
        QueryBuilder<Teacher> teacherBuilder = teacherDao.queryBuilder();
        List<Teacher> teachers = teacherBuilder.list();


        for (Student stu : students) {
            for (Teacher tch : teachers) {
                Middle middle = new Middle(null, stu.getId(), tch.getId());
                middleDao.insert(middle);
            }
        }


    }

    public void queryStudent(View v) {
        QueryBuilder<Student> builder = studentDao.queryBuilder();
        List<Student> students = builder.list();
        Log.e("", "");
    }

    public void queryTeacher(View v) {
        QueryBuilder<Teacher> builder = teacherDao.queryBuilder();
        List<Teacher> teachers = builder.list();
        Log.e("", "");
    }

    public void queryGroupTeacher(View v) {

        QueryBuilder<Student> builder = studentDao.queryBuilder();
//        builder.where(StudentDao.Properties.Id.eq(1));
        List<Student> students = builder.list();
        Student mStudent = students.get(0);
        List<Middle> Middles = mStudent.getMiddleList();
        List<Teacher> teachers = new ArrayList<>();
        for (Middle middle : Middles) {
            teachers.add(middle.getTeacher());
        }
        Log.e("", "");

//        List<Student> Studens = studentDao.queryRaw(" where T.NAME ='sr'");
//        Log.e(TAG, Studens.size() + "");
//        QueryBuilder.LOG_SQL = true;
//        QueryBuilder.LOG_VALUES = true;


//        QueryBuilder<Teacher> builder = teacherDao.queryBuilder();
//        List<Teacher> teachers = builder.list();
//        teachers.get(1).getStudentList();
//        Log.e("", "");
    }


}
