package br.com.StudentRegistration.Main;

import java.sql.SQLException; 

import br.com.StudentRegistration.Connection.ConnectionFactory;
import br.com.StudentRegistration.Connection.CreateDB;
import br.com.StudentRegistration.functions.CreateParameter;

public class main {

	public static void main(String[] args) throws SQLException {
		CreateDB createDb = new CreateDB();
//		connectionFactory.recoverConnection();
		CreateParameter createParameter = new CreateParameter();
//		String name = createParameter.createString("seu nome: ");
		
		

	}

}
