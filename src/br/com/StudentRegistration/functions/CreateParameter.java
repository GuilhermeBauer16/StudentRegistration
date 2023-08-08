package br.com.StudentRegistration.functions;

import java.util.Scanner;

import br.com.StudentRegistration.Connection.ConnectionFactory;

public class CreateParameter {
	
	
	public String createString(String mesage) {
		Scanner scanner = new Scanner(System.in);

		System.out.print(mesage);
		return scanner.nextLine();
	}

}
