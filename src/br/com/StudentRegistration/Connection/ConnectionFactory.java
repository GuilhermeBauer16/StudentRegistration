package br.com.StudentRegistration.Connection;

import java.sql.Connection; 
import java.sql.SQLException;


import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;


public class ConnectionFactory {

    public DataSource dataSource;

    
    public ConnectionFactory() {
    	
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        String url = "jdbc:mysql://localhost/studentregistration?useTimezone=true&serverTimezone=UTC";
        String user = "root";
        String password = "0910";
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setMaxPoolSize(15);
        this.dataSource = comboPooledDataSource;
    	
    }
    
    public Connection recoverConnection() throws SQLException {
    	return this.dataSource.getConnection();
    }
    

}
