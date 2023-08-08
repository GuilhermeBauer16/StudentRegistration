package br.com.StudentRegistration.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTable {
	
	public CreateTable() throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try(Connection connection = connectionFactory.recoverConnection()){
			
			String sql = "CREATE TABLE student("
					+ "id INT AUTO_INCREMENT PRIMARY KEY ,"
					+ "fullName VARCHAR(150) NOT NULL,"
					+ "age TINYINT,"
					+ "email VARCHAR(200),"
					+ "graduation VARCHAR(80),"
					+ "registrationDate DATE,"
					+ "address VARCHAR(255),"
					+ "phone VARCHAR(15))";
			
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				
				connection.setAutoCommit(false);
				preparedStatement.execute();
				connection.commit();
				System.out.println("tabela criada ");
			}catch (SQLException e) {
				System.out.println("erro ao criar a tabela " + e.getMessage());
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			
		}
	}

}}
