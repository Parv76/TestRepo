 


 public class Employee {

	 
		
		public String name;
		double salary;
		
		public void displayDetails()
		{
		System.out.println("Name is" + name +" and salary is "+ salary);
		}

 

	static class Manager extends Employee
	{
	int teamSize ;
	public void displayManagerDetails()
	{
		System.out.println("Name is "+name+". Salary is "+salary+". Team size is "+teamSize);
	}
	public void setSalary(double salary) throws IllegalArgumentException
	{
		
		if(salary < 0)
		{throw new IllegalArgumentException("Salary less than 0");}
		else if (salary < 10000)
		{throw new IllegalArgumentException("Salary less than 10000");}
	
		
		this.salary = salary;
	}}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	Manager mng = new Manager();
	mng.name ="Jagdish";
	mng.teamSize=10;
	try {
	mng.setSalary(-444);
	}
	catch(IllegalArgumentException e)
	{
		System.out.println("Less than 0 "+e.getMessage());

	}

	try {
		mng.setSalary(4000);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Less than 10000 "+e.getMessage());

		}

	try {
		mng.setSalary(25000);
		mng.displayManagerDetails();
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Greater than 10000 "+e.getMessage());
		}
	}
	
	}
