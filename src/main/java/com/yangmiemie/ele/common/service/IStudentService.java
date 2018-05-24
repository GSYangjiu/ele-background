package com.yangmiemie.ele.common.service;

import com.yangmiemie.ele.common.vo.Student;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 10:10
 * Description:
 */
public interface IStudentService {
    List<Student> findAll();

    Student getUser(Integer id);

    void update(Student user);

    void insert(Student user);

    void insertAll(List<Student> users);

    void remove(Integer id);

    List<Student> findByPage(Student user, Pageable pageable);
}
