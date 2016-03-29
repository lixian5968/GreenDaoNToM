package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class StudentClass {
//    public static void main(String[] args) throws Exception {
//
//        Schema schema = new Schema(3, "studen");
//        schema.setDefaultJavaPackageDao("studen.dao");
//
//        Entity student = schema.addEntity("Studen");
//        student.addIdProperty();
//        student.addStringProperty("name").notNull();
//        student.addIntProperty("sex");
//        student.addDateProperty("date");
//
//        Entity Teacher = schema.addEntity("Teacher");
//        Teacher.addIdProperty();
//        Teacher.addStringProperty("name").notNull();
//        Teacher.addIntProperty("sex");
//        Teacher.addDateProperty("date");
//
//        new DaoGenerator().generateAll(schema,"E:\\Android_yjm_black\\Android_github\\Database\\LxGreenDAO\\app\\src\\main\\java-gen");
//    }

    public static void main(String[] args) throws Exception {

        Schema schema = new Schema(2, "school");
        schema.setDefaultJavaPackageDao("school.dao");




        Entity Student = schema.addEntity("Student");
        Student.addIdProperty();
        Student.addStringProperty("name").notNull();
        Student.addIntProperty("sex");
        Student.addDateProperty("date");

        Entity Teacher = schema.addEntity("Teacher");
        Teacher.addIdProperty();
        Teacher.addStringProperty("name").notNull();
        Teacher.addIntProperty("sex");
        Teacher.addDateProperty("date");


        Entity Middle = schema.addEntity("Middle");
        Middle.addIdProperty();
        Property MiddleStudentId = Middle.addLongProperty("MiddleStudentId").notNull().getProperty();
        Property MiddleTeacherId = Middle.addLongProperty("MiddleTeacherId").notNull().getProperty();


        Middle.addToOne(Student, MiddleStudentId);
        Student.addToMany(Middle, MiddleStudentId);

        Middle.addToOne(Teacher, MiddleTeacherId);
        Teacher.addToMany(Middle, MiddleTeacherId);

        new DaoGenerator().generateAll(schema, "E:\\Android_yjm_black\\Android_github\\Database\\LxGreenDAO\\app\\src\\main\\java-gen");


    }


//    public static void main(String[] args) throws Exception {
//
//        Schema schema = new Schema(2, "school");
//        schema.setDefaultJavaPackageDao("school.dao");
//
//        Entity Student = schema.addEntity("Student");
//        Student.addIdProperty();
//        Student.addStringProperty("name").notNull();
//        Student.addIntProperty("sex");
//        Student.addDateProperty("date");
//
//        Entity Teacher = schema.addEntity("Teacher");
//        Teacher.addIdProperty();
//        Teacher.addStringProperty("name").notNull();
//        Teacher.addIntProperty("sex");
//        Teacher.addDateProperty("date");
//
//
//        //1 对多的形成
//        Property TeacherId =  Student.addLongProperty("TeacherId").notNull().getProperty();
//        Student.addToOne(Teacher, TeacherId);
//        Teacher.addToMany(Student, TeacherId);
//
//        Property StudentId =  Teacher.addLongProperty("StudentId").notNull().getProperty();
//        Teacher.addToOne(Student,StudentId);
//        Student.addToMany(Teacher, StudentId);
//
//        new DaoGenerator().generateAll(schema, "E:\\Android_yjm_black\\Android_github\\Database\\LxGreenDAO\\app\\src\\main\\java-gen");
//
//
//    }


//
//    public static void main2(String[] args) throws Exception {
//
//        Schema schema = new Schema(3, "greendao");
//        schema.setDefaultJavaPackageDao("com.guangda.dao");
//
//
//        //下面是我们要建的两个新表，一个上信息类别，一个是信自，它们的关系是1:n.
//        //对于信息类别表，没有什么好说的，和上面一样，直接建立一个表就完了，我们主要来看一下信息表中，如何设置外键
//        Entity infoTypeBean = schema.addEntity("infoType");
//        //此处是用来实现序列化的接口
//        infoTypeBean.implementsSerializable();
//        infoTypeBean.addIdProperty();
//        infoTypeBean.addStringProperty("infoName");
//
//        //信息表进行建立
//        Entity infoBean = schema.addEntity("infos");
//        infoBean.implementsSerializable();
//        infoBean.addIdProperty();
//        infoBean.addStringProperty("infoTitle");
//        infoBean.addStringProperty("infoAuthor");
//        infoBean.addStringProperty("infoContent");
//        //这里我们为信息表，添加一个typeId外键，它就是infoType表的id
//        Property typeId = infoBean.addLongProperty("typeId").getProperty();
//
//        //这里是重点，我们为这两个表建立1:n的关系，并设置关联字段。
//        infoBean.addToOne(infoTypeBean, typeId);
//
//
//        ToMany addToMany = infoTypeBean.addToMany(infoBean, typeId);
//
//
//        addToMany.setName("infoes");
//
//
//    }


}
