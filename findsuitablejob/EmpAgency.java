package exam.findsuitablejob;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class EmpAgency {
	
	public String degree;
	public int contractPeriod;
	public int numOfEmployees ;
	
	ArrayList<Employee> employees = new ArrayList<Employee>();
	
	public EmpAgency(String degree , int contractPeriod , int numOfEmployees ) {
		this.numOfEmployees = numOfEmployees ;
		this.contractPeriod = contractPeriod;
		this.degree = degree;
	}
	
	
	
	public ArrayList<Employee> load(String filePath){
		ArrayList<Employee> employees = new ArrayList<Employee>();
		try {
			List<String> allLines = Files.readAllLines(Paths.get(filePath));
			for (String line : allLines) {
				if(line != null) {
					try {
						employees.add(Employee.make(line));
					}catch(NumberFormatException e) { } 
					
					
				}else {
					continue;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return employees;
	}
	
	public void hire(Position empS) {
		Iterator<Employee> iterator = (this.employees).iterator(); 
  
		ArrayList<Employee> list = new ArrayList<Employee>();
	      while (iterator.hasNext()) {
	          list.add((Employee) iterator.next());
	      }

	      Collections.sort(list);
	      for(int i = 0 ; i < list.size() ; i++) {
	    	  if(list.get(i).getSalary() <= Contract.getGoalSalary()) {
	    		  list.get(i).getHiredAt(empS);
	    		  list.remove(i);
	    		  this.numOfEmployees -= 1;
	    	  }
	      }
	      this.employees = list;
	}
	
	public double getMaxIncrease(double arg) {
		if(employees.size() == 0 ) {
			throw new IllegalStateException();
		}
		double maxIncrease = employees.get(0).getSalary() + arg ;
		for(int i = 1 ; i < employees.size() ; i++ ) {
			if((employees.get(i).getSalary() + arg) > maxIncrease )
				maxIncrease = (employees.get(i).getSalary() + arg) ;
		}
		return maxIncrease;
	}
	
	@Override
    public String toString() {
		Employee s = null ;
		return String.format("The name of the employee is: " + s.getEmployeeName() + "/n" + "The emloyee's salary is: " + s.getSalary());	
	}	
}
