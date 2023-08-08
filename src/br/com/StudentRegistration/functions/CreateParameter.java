package br.com.StudentRegistration.functions;

import java.util.Scanner;

import br.com.StudentRegistration.Connection.ConnectionFactory;

public class CreateParameter {
	
	
	public String createString(String mesage) {
		Scanner scanner = new Scanner(System.in);
		System.out.print(mesage);
		return scanner.nextLine();
	}
	
	public int createInt(String mesage) {
		Scanner scanner = new Scanner(System.in);
		int numero = 0; 
		while (true) {
			System.out.print(mesage);
			if (scanner.hasNextInt()) {
				numero = scanner.nextInt();
				break;
			}else {
				System.out.println("Por favor digite um número!");
				scanner.nextLine();
			}
		}
		return numero;
	}
	
	public double createDouble(String mesage) {
		Scanner scanner = new Scanner(System.in);
		double numero = 0.0; 
		while (true) {
			System.out.print(mesage);
			if (scanner.hasNextDouble()) {
				numero = scanner.nextDouble();
				break;
			}else {
				System.out.println("Por favor digite um número!");
				scanner.nextLine();
			}
		}
		return numero;
	}

}
