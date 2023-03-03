package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.Payers;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Payers> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or Company (i/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual income: ");
			Double anualIncome = sc.nextDouble();
				if(ch == 'i') {
					System.out.print("Health expenditures: ");
					Double healthExpenditures = sc.nextDouble();
					list.add(new Individual(name, anualIncome, healthExpenditures));
				}
				else {
					System.out.print("Number of employees: ");
					Integer numberEmployees = sc.nextInt();
					list.add(new Company(name, anualIncome, numberEmployees));
				}	
		}
		
		Double tax = 0.0;
		
		System.out.println("");
		System.out.println("TAXES PAID: ");
		for (Payers p : list) {
			tax += p.totalTax();
			System.out.println(p.getName() + ": $ " + String.format("%.2f", p.totalTax()));
		}
		
		System.out.println("");
		System.out.print("TOTAL TAXES: " + tax);
		
		
		sc.close();
	}

}
