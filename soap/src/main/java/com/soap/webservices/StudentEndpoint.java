package com.soap.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;




import org.soapservice.students.StudentRequest;
import org.soapservice.students.StudentResponse;

@Endpoint
public class StudentEndpoint {
	
	private static final String NAMESPACE_URI="http://www.soapservice.org/students";
	
	private StudentRepository StudentRepository;
	
	
	
	@Autowired
	
	public StudentEndpoint(StudentRepository StudentRepository)
	{
		this.StudentRepository=StudentRepository;
	}
	
	
	@PayloadRoot(namespace= NAMESPACE_URI, localPart="StudentRequest")
	@ResponsePayload
	
	public StudentResponse getStudent(@RequestPayload StudentRequest request)
	{
		StudentResponse response=new StudentResponse();
		response.setStudent(StudentRepository.findStudent(request.getName()));
		return response;
	}
	
	
	

}
