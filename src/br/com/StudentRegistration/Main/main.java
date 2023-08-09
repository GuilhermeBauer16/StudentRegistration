package br.com.StudentRegistration.Main;

import java.sql.Connection;

import java.sql.SQLException; 

import br.com.StudentRegistration.Connection.ConnectionFactory;
import br.com.StudentRegistration.Connection.CreateDB;

import br.com.StudentRegistration.DAO.StudentDAO;
import br.com.StudentRegistration.Student.Student;
import br.com.StudentRegistration.functions.CreateParameter;

public class main {

	public static void main(String[] args) throws SQLException, InterruptedException {

		ConnectionFactory connectionFactory = new ConnectionFactory();

		CreateParameter createParameter = new CreateParameter();
			
		try( Connection connection = connectionFactory.recoverConnection()){
			
			StudentDAO studentDAO = new StudentDAO(connection);
			studentDAO.CreateTable(connection);
			
			while (true) {
				System.out.println("[1]novo aluno");
				System.out.println("[2]editar dados aluno");
				System.out.println("[3]editar aluno");
				System.out.println("[4]deletar aluno");
				System.out.println("[5]Visualizar alunos");
				System.out.println("[6]sair");
				int option = createParameter.createInt("sua opção: ");
				
				if (option == 1) {
					Student student = new Student();
					studentDAO.InsertDB(student);
			
				}else if (option == 2) {
			
				}else if (option == 3 ) {
					
			
				}else if (option == 4) {
				
				}else if (option == 5) {
					
					studentDAO.SelectTables(connection);
				
				}else if (option == 6) {
					
					System.out.println("saindo...");
					Thread.sleep(1000);
					break;
					
					}
				}
		
		
		
		

	}

}  }
