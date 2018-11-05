package Util;

import Charactor.Student;

import java.util.List;

public interface StudentManager {
    //增加
    String add(Student student);

    //删除
    String delete(Student student);

    //修改
    String update(Student oldone, Student newone);

    //查询
    List<Student> get(String flag, String argument);

    //获取数据
    List<Student> getstudentList();

    //获取列名
    List<String> getcolumnNames();
}
