package com.yangmiemie.ele.common.dao;

import com.yangmiemie.ele.common.vo.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 11:27
 * Description:
 */
public interface IStudentDAO {
    List<Student> findAll();

    Student getUser(Integer id);

    void update(Student user);

    void insert(Student user);

    void insertAll(List<Student> users);

    void remove(Integer id);

    List<Student> findByPage(Student user, Pageable pageable);
}
