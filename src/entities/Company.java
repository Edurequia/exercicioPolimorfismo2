package entities;

public class Company extends Payers{

	private int numberEmployees;
	
	public Company() {
		super();
	}
	
	public Company(String name, Double anualIncome, int numberEmployees) {
		super(name, anualIncome);
		this.numberEmployees = numberEmployees;
	}

	public int getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(int numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public Double totalTax() {
		double result = 0.0;
		if (numberEmployees > 10) {
			result = getAnualIncome() * 0.14;
		}
		else {
			result = getAnualIncome() * 0.16;
		}
		return result;
	}
	
}
