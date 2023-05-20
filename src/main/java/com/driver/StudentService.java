package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private Map<String, Student> students = new HashMap<>();
    private Map<String, Teacher> teachers = new HashMap<>();
    private Map<String, List<String>> studentTeacherPairs = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.put(teacher.getName(), teacher);
    }

    public void addStudentTeacherPair(String studentName, String teacherName) {
        List<String> teacherStudents = studentTeacherPairs.getOrDefault(teacherName, new ArrayList<>());
        teacherStudents.add(studentName);
        studentTeacherPairs.put(teacherName, teacherStudents);
    }

    public Student getStudentByName(String name) {
        return students.get(name);
    }

    public Teacher getTeacherByName(String name) {
        return teachers.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacherName) {
        return studentTeacherPairs.getOrDefault(teacherName, new ArrayList<>());
    }

    public List<String> getAllStudents() {
        return new ArrayList<>(students.keySet());
    }

    public void deleteTeacherByName(String teacherName) {
        teachers.remove(teacherName);
        studentTeacherPairs.remove(teacherName);
    }

    public void deleteAllTeachers() {
        teachers.clear();
        studentTeacherPairs.clear();
    }
}
