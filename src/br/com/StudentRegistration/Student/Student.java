package br.com.StudentRegistration.Student;

import br.com.StudentRegistration.functions.CreateParameter;

public class Student {
	
	private Integer id ;
	private String fullName;
	private Integer age ;
	private String email;
	private String graduation;
	private String registrationDate;
	private String address ;
	private String phone;
	
	public Student() {
		
		CreateParameter createParameter = new CreateParameter();
		setFullName(createParameter.createString("Digite o seu nome: "));
		setAge(createParameter.createInt("Digite a sua idade: "));
		setEmail(createParameter.createString("Seu email: "));
		setGraduation(createParameter.createString("Seu curso: "));
		setRegistrationDate(createParameter.createString("data do inicio: "));
		setAddress(createParameter.createString("Seu endereço: "));
		setPhone(createParameter.createString("telefone: "));
	}

	public String getFullName() {
		return this.fullName;
		
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public String getEmail() {
		return this.email;
		
	}
	
	public String getGraduation() {
		return this.graduation;
	}
	
	public String registrationDate() {
		
		return this.registrationDate;
	}
	
	public String getAddress() {
		
		return this.address;
	}
	
	public String getPhone() {
		
		return this.phone;
	}
	
	public void setFullName(String fullName) {
		
		this.fullName = fullName;
	}
	
	public void setAge(Integer age) {
		
		this.age = age;
	}
	
	public void setEmail(String email) {
		
		this.email= email;
	}
	
	public void setGraduation(String graduation) {
		
		this.graduation = graduation;
	}
	
	public void setRegistrationDate(String registrationDate) {
		
		this.registrationDate = registrationDate;
	}
	
	public void setAddress(String address) {
		
		this.address = address;
	}
	
	public void setPhone(String phone) {
		
		this.phone = phone;
	}
	

}



