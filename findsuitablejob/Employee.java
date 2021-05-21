package exam.findsuitablejob;

public class Employee implements Employable , Comparable<Employee>{
	
	private String employeeName ;
	private int salary = 0;
	
	public String getEmployeeName() {
		return employeeName;
	}

	public int getSalary() {
		return salary;
	}

	
	private Employee(String employeeName , int salary ) {
		if(employeeName == null ) {
			throw new IllegalArgumentException();
		}
		
		this.employeeName = employeeName ;
		this.salary = salary;
	}
	
	public static Employee make(String data) {
		Employee result = null;
		String[] processedDate =data.split(",");
		if(processedDate.length != 2) {
			return null;
		}else {
			try {
				int salary = Integer.parseInt(processedDate[1]);
				String name = processedDate[0];
				
				result = new Employee(name,salary);
				return result;
			}catch(java.lang.NumberFormatException e) {
				e.addSuppressed(e);
			}
		}
		return result;
	}
	@Override
	public boolean equals(Object emp) {
		return this.getEmployeeName() == ((Employee) emp).getEmployeeName() && this.getSalary() == ((Employee) emp).getSalary(); 
	}
	
	@Override
    public int hashCode() {
		return this.getSalary();
	}
	@Override
    public String toString() {
		return String.format("The name of the employee is: " + this.getEmployeeName() 
							+ "/n" + "The emloyee's salary is: " + this.getSalary());	
	}

	@Override
	public void getHiredAt(Position p) {
		this.salary+= p.salary;
		
	}

	@Override
	public double getSalaryIncrease(double increaseRate) {
		if(increaseRate < 1.1) {
			throw new IllegalArgumentException();
		}
		
		return (this.getSalary() * increaseRate );
		
	}
	
	@Override
	public int compareTo(Employee emp) {
		if(this.getSalary() >= emp.getSalary()) {
			return 1;
		}else {return 0;}
	}
	

}
