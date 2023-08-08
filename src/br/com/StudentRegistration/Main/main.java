package br.com.StudentRegistration.Main;

import java.sql.SQLException; 

import br.com.StudentRegistration.Connection.ConnectionFactory;
import br.com.StudentRegistration.Connection.CreateDB;
import br.com.StudentRegistration.Connection.CreateTable;
import br.com.StudentRegistration.Student.Student;
import br.com.StudentRegistration.functions.CreateParameter;

public class main {

	public static void main(String[] args) throws SQLException {
		CreateDB createDb = new CreateDB();
//		connectionFactory.recoverConnection();
		CreateTable createTable = new CreateTable();
		CreateParameter createParameter = new CreateParameter();
		Student student = new Student();	
		student.setFullName(createParameter.createString("Digite o seu nome: "));
		student.setAge(createParameter.createInt("Digite a sua idade: "));
		student.setEmail(createParameter.createString("Seu email: "));
		student.setGraduation(createParameter.createString("Seu curso: "));
		student.setRegistrationDate(createParameter.createString("data do inicio: "));
		student.setAddress(createParameter.createString("Seu endereço: "));
		student.setPhone(createParameter.createString("telefone: "));
		
		
		
		

	}

}  
