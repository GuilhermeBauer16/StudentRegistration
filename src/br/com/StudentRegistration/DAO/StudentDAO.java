package br.com.StudentRegistration.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.StudentRegistration.Connection.ConnectionFactory;
import br.com.StudentRegistration.Student.Student;

public class StudentDAO {
	
	private Connection connection;
	
	public StudentDAO(Connection connection) {
		this.connection = connection ;
	}
	
	public void InsertDB(Student student) throws SQLException {
		
			
			String sql = "INSERT INTO student"
					+ " (fullName , age , email , graduation , registrationDate , address , phone)"
					+ "VALUES ( ? , ? , ? , ? , ? , ? , ?)";
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				
				connection.setAutoCommit(false);
				preparedStatement.setString(1 ,student.getFullName() );
				preparedStatement.setInt(2, student.getAge());
				preparedStatement.setString(3, student.getEmail());
				preparedStatement.setString(4, student.getGraduation());
				preparedStatement.setString(5, student.getRegistrationDate());
				preparedStatement.setString(6 , student.getAddress());
				preparedStatement.setString(7 , student.getPhone());
				
				preparedStatement.executeUpdate();
				connection.commit();
				
			}catch (SQLException e) {
				System.out.println("erro ao criar a banco de dados" + e.getMessage());
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			
		}}
			
			public void CreateTable(Connection connection) throws SQLException {
					
					String sql = "CREATE TABLE IF NOT EXISTS student("
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
	
}
