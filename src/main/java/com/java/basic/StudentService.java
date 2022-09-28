package com.java.basic;

import java.util.List;

public interface StudentService {

	public String STUDENT_SUCESS = "Student Added Sucessfully";
	public String STUDENT_ERROR = "Problem in Studetn Add";
	public String DUPLICATE_STUDENT = "Duplicate Student";

	public String addNewStudent(Student std);

	public List<Student> listOfStudent();

	public List<Student> searchStudentByCategoryType(CategoriesType type, String val);

	public boolean deleteStudentById(int stdId);

	public Student updateStudent(int stdId, Student std);

	public List<Student> checkRangeStudentFess(double startRange, double endEnd);
}

enum CategoriesType {

	Id, Name, Skill, Fess, Address

}

enum SkillType {
	JAVA, PYTHON, C, CYBERSECURITY, SOFTWARETESTING

}


