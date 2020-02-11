package part01;

public class Employee {
	private int empNum;
	private static int nextNum = 1;
	private String name;
	private String address;
	private double salary;
	private Status eStat;
	
	public Employee(String name, String address) {
		this.empNum =  nextNum++;
		this.name = name;
		this.address = address;
		this.salary = 0.0;
		this.eStat = Status.FULL_TIME;
	}
	
	public Employee(String name, String address, double salary) {
		this.name = name;
		this.address = address;
		this.salary = salary;
		this.eStat = Status.FULL_TIME;
	}
	
	public int getEmpNum() {
		return this.empNum;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public Status getStatus() {
		return this.eStat;
	}
	
	public String getDetails() {
		String res = "Number:" + this.getEmpNum()+", ";
		res += "Name:" + this.getName() +", ";
		res += "Address:" + this.getAddress() +", ";
		res += "Salary:" + this.getSalary()+", ";
		res += "Status:" + this.getStatus();
		return res;
	}
	
	public String toString() {
		return this.getDetails();
	}
	
	public double calcGrossWage() {
		return salary/12.0;
	}
	
	public double calcNetWage() {
		return calcGrossWage() - calcTax();
	}
	
	public double calcTax() {
		// flat rate of tax at 20%
		return 0.2 * calcGrossWage() ;
	}
}
