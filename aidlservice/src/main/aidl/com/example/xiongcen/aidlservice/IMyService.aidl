// IMyService.aidl
package com.example.xiongcen.aidlservice;

// Declare any non-default types here with import statements
import com.example.xiongcen.aidlservice.Student;

interface IMyService {
    List<Student> getStudent();
        void addStudent(in Student student);
}
