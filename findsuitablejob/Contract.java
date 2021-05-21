package exam.findsuitablejob;

public class Contract {
	
	protected String degree;
	protected int numberOfEmployees;
	protected int contractPeriod;
	public static int goalSalary = 4000;
	
	public String getDegree() {
		return degree;
	}
	
	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}
	
	public int getContractPeriod() {
		return contractPeriod;
	}
	
	public static int getGoalSalary() {
		return goalSalary;
	}
	
	public static void setGoalSalary(int goalSalary) {
		Contract.goalSalary = goalSalary;
	}
	
	public static boolean isBetween(int number, int min, int max) {
		return (number >= min && number <= max);
	
	}
	
	static final int MIN_Period = 6;
	static final int MAX_Period = 12;
	
	public Contract(String degree , int numberOfEmployees , int contractPeriod) {
		if(isBetween(contractPeriod ,MIN_Period,MAX_Period )) {
			this.contractPeriod = contractPeriod;
		}else {
			throw new IllegalArgumentException();
		}
		if(isBetween(numberOfEmployees , 15 , 40)) {
			this.numberOfEmployees = numberOfEmployees;
		}else {
			throw new IllegalArgumentException();
		}
		this.degree = degree;
	}
	
	public Contract() {
		 this.degree = "Master";
		 this.numberOfEmployees = 20 ;
		 this.contractPeriod = 12 ;
	}
	
	@Override
	public String toString() { 
        return String.format("Degree is: " + this.degree + "/n" + "Number of employees is: " + this.numberOfEmployees + "/n" + "The contract period is: " + this.contractPeriod); 
    }
	
}
