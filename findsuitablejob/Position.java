package exam.findsuitablejob;

public enum Position {
	
	
	FREELANCER(7000), 
	UNIVERSITY(400),
	HOSPITAL(5000),
	ITCOMPANY(2700);
	
	public final int salary;
	Position(int salary) {
		this.salary = salary;
	}
}
