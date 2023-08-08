package br.com.StudentRegistration.Main;

import java.sql.Connection;

import java.sql.SQLException; 

import br.com.StudentRegistration.Connection.ConnectionFactory;
import br.com.StudentRegistration.Connection.CreateDB;

import br.com.StudentRegistration.DAO.StudentDAO;
import br.com.StudentRegistration.Student.Student;
import br.com.StudentRegistration.functions.CreateParameter;

public class main {

	public static void main(String[] args) throws SQLException {
		CreateDB createDb = new CreateDB();
		ConnectionFactory connectionFactory = new ConnectionFactory();

		CreateParameter createParameter = new CreateParameter();
			
		try( Connection connection = connectionFactory.recoverConnection()){
			
			Student student = new Student();
			StudentDAO studentDAO = new StudentDAO(connection);
			studentDAO.CreateTable(connection);
			studentDAO.InsertDB(student);
			
		}
		
		
		
		

	}

}  
