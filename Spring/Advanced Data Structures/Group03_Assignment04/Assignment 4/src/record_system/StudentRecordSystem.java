package record_system;

import adt.HashTable;

public class StudentRecordSystem {

    private HashTable<String, Student> studentTable;

    public StudentRecordSystem() {
        this.studentTable = new HashTable<>();
    }

    public void addStudent(String code, Student student) {
        studentTable.put(code, student);
    }

    public Student removeStudent(String code) {
        return studentTable.remove(code);
    }

    public Student findStudent(String code) {
        return studentTable.get(code);
    }

    public int getTotalStudents() {
        return studentTable.size();
    }
}
