package com.soap.webservices;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import org.soapservice.students.Student;
import org.springframework.stereotype.Component;


@Component

public class StudentRepository {
	
	private static final Map<String, Student> students=new HashMap<>();
	
	
@PostConstruct
	public void init()
	{
		Student studnt=new Student();
		studnt.setName("selva");
		studnt.setAddress("chittoor");
		studnt.setStandard("MTech");
		
		students.put(studnt.getName(),studnt);
	}


public Student findStudent(String name)
{
	return students.get(name);
}

}
