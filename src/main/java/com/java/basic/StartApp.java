package com.java.basic;

public class StartApp {
	
	public static void main(String[] args) {
		
		StudentServiceImpl service=new StudentServiceImpl() ;
			
		service.addNewStudent(new Student(101,"sandesh",43000,23,"solapur",SkillType.JAVA,GendorType.MALE));
		service.addNewStudent(new Student(102, "sakshi", 34000, 21, "solapur", SkillType.SOFTWARETESTING,GendorType.FEMALE));
		service.addNewStudent(new Student(103,"satish",45000,24,"baramati",SkillType.PYTHON,GendorType.MALE));
		
		
		
		
	}

}
