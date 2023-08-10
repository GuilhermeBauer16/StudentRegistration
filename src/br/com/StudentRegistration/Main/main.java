package br.com.StudentRegistration.Main;

import java.sql.Connection;

import java.sql.SQLException; 

import br.com.StudentRegistration.Connection.ConnectionFactory;


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
				System.out.println(createParameter.title("Cadastro de aluno", 40)); 
				System.out.println("[1]novo aluno");
				System.out.println("[2]editar dados aluno");
				System.out.println("[3]deletar aluno");
				System.out.println("[4]Visualizar alunos");
				System.out.println("[5]sair");
				System.out.println(createParameter.line(40));
				int option = createParameter.createInt("sua opção: ");
				
				if (option == 1) {
					System.out.println(createParameter.title("Novo aluno", 40));
					Student newStudent = new Student();
					studentDAO.InsertDB(newStudent);
			
				}else if (option == 2) {
					System.out.println(createParameter.title("Edição de aluno", 40));
					studentDAO.SelectTables(connection);
					int editId = createParameter.createInt("Digite o ID do aluno: ");
					String newFullName = createParameter.createString("Digite o seu nome: ");
					int newAge = createParameter.createInt("Digite a sua idade: ");
					String newEmail = createParameter.createString("Seu email: ");
					String newGraduation = createParameter.createString("Seu curso: ");
					String registrationDate = createParameter.createString("data do inicio: ");
					String newAddress = createParameter.createString("Seu endereço: ");
					String newPhone = createParameter.createString("telefone: ");
					studentDAO.EditStudent(connection, editId , newFullName , newAge , newEmail ,newGraduation ,registrationDate , newAddress , newPhone );
			
				}else if (option == 3 ) {
					System.out.println(createParameter.title("Deleção de aluno", 40));
					studentDAO.SelectTables(connection);
					int deleteId = createParameter.createInt("Digite o ID do aluno: ");
					
					studentDAO.DeleteTable(connection, deleteId);
			
				}else if (option == 4) {
					System.out.println("Visualização dos alunos");
					studentDAO.SelectTables(connection);
				
				}else if (option == 5) {
					
					System.out.println("saindo...");
					Thread.sleep(1000);
					break;
					
					}
				}
		
		
		
		

	}

}  }
