package br.com.StudentRegistration.DAO;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
				
				connection.setAutoCommit(false);
				preparedStatement.setString(1 ,student.getFullName() );
				preparedStatement.setInt(2, student.getAge());
				preparedStatement.setString(3, student.getEmail());
				preparedStatement.setString(4, student.getGraduation());
				preparedStatement.setString(5, student.getRegistrationDate());
				preparedStatement.setString(6 , student.getAddress());
				preparedStatement.setString(7 , student.getPhone());
				
				preparedStatement.execute();
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
							+ "phone VARCHAR(16))";
					
					try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
						
						connection.setAutoCommit(false);
						preparedStatement.execute();
						connection.commit();
						
					}catch (SQLException e) {
						System.out.println("erro ao criar a tabela " + e.getMessage());
						connection.rollback();
					
				}
			
	}
			
			
			public void SelectTables(Connection connection) throws SQLException {
				String sql = "SELECT * FROM student";
				try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
					preparedStatement.execute();
					try(ResultSet resultSet = preparedStatement.getResultSet()){
						System.out.println("=".repeat(172));
						System.out.println("ID  |            Nome completo           | idade |            email                 |     graduação      | data inicio |             endereço             | telefone     |");
						System.out.println("=".repeat(172)); 
						
						while (resultSet.next()) {
			                int id = resultSet.getInt("id");
			                String fullName = resultSet.getString("fullName");
			                int age = resultSet.getInt("age");
			                String email = resultSet.getString("email");
			                String graduation = resultSet.getString("graduation");
			                String registrationDate = resultSet.getString("registrationDate");
			                String address = resultSet.getString("address");
			                String phone = resultSet.getString("phone");
			                
			                System.out.printf("%-4d|%-36s|%-7d|%-34s|%-20s|%-13s|%-34s|%-12s|%n",
	                                  id, fullName, age, email, graduation, registrationDate, address, phone);
	            }
						System.out.println("=".repeat(172)); 

						
	              } catch (SQLException e) {
	                  System.out.println("erro ao consultar a tabela " + e.getMessage());
	              }
						
						
					}
				
			}
			
		public void DeleteTable(Connection connection , int id) throws SQLException {
			
			String sql = "DELETE FROM student WHERE ID = ? ";
			try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
				
				connection.setAutoCommit(false);
				preparedStatement.setInt(1, id);
				preparedStatement.executeUpdate();
				connection.commit();
			}catch (SQLException e) {
				System.out.println("erro ao deletar a tabela" + e.getMessage());
				connection.rollback();
		}}
			
			public void EditStudent(Connection connection , int id , String newFullName ,int newAge ,String newEmail ,
					String newGraduation , String registrationDate , String newAddress ,String newPhone) throws SQLException {
				
				String sqlUpdate = "UPDATE student SET "
						+ "fullName = ? ,"
						+ "age = ?,"
						+ "email = ?,"
						+ "graduation = ?,"
						+ "registrationDate = ?,"
						+ "address = ? ,"
						+ "phone = ? "
						+ "WHERE id = ?";

				try(PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate))
						{
					
					connection.setAutoCommit(false);
					
					preparedStatement.setString(1,newFullName);
					preparedStatement.setInt(2,newAge);
					preparedStatement.setString(3,newEmail);
					preparedStatement.setString(4,newGraduation);
					preparedStatement.setString(5, registrationDate);
					preparedStatement.setString(6, newAddress);
					preparedStatement.setString(7 , newPhone);
					preparedStatement.setInt(8,id);
					preparedStatement.executeUpdate();
					connection.commit();
				}catch (SQLException e) {
					System.out.println("erro ao atualizar a tabela" + e.getMessage());
					connection.rollback();
			}
			}
			}
