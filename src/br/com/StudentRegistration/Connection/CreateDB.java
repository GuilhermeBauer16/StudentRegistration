package br.com.StudentRegistration.Connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class CreateDB {
		
		public CreateDB() throws SQLException{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try(Connection connection = connectionFactory.recoverConnection()){
			
	    	String sql = "CREATE DATABASE IF NOT EXISTS studentregistration"
	    			+ "DEFAULT CHARACTER SET utf8mb4 \r\n"
	    			+ "DEFAULT COLLATE utf8mb4_general_ci";
	    	
	    	try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
	    		
	    		connection.setAutoCommit(false);
	    		preparedStatement.execute();
	    		connection.commit();
	    		System.out.println("connectou");
    	}	catch (SQLException e) {
				System.out.println("erro ao criar a banco de dados" + e.getMessage());
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
    
    }
		}
	

}

}
