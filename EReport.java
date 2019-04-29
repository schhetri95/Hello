import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Employee{
	int empID;
	String firstName;
	 String lastName;
	 
	 public Employee(int empID, String firstName, String lastName)
	 {
		 this.empID=empID;
	     this.firstName=firstName;
	     this.lastName=lastName;

	 }
}

//IDCompare Class to compare the employee ID
class IDCompare implements Comparator<Employee>
{
    @Override
    public int compare(Employee e1, Employee e2)
    {
        return e1.empID - e2.empID;
    }
}
 
//NameCompare Class to compare the last name
 
class NameCompare implements Comparator<Employee>
{
    @Override
    public int compare(Employee e1, Employee e2)
    {
        return e1.lastName.compareTo(e2.lastName);
    }
}
 


public class EReport {
	public static void main (String args[])throws Exception {
		File file=new File("src/employees.dat");
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<Employee> employeeRecords = new ArrayList<Employee>();
		String line=br.readLine();
		int empID=0;
		String firstName="";
		String lastName="";
		while (line != null) {
			
			if (!line.startsWith("#"))
			{
				StringTokenizer tok=new StringTokenizer(line,",\\ ",false);
				int i=0;
				while(tok.hasMoreTokens())
                {
					
					String t=tok.nextToken();
					if(i==0) {
						 empID = Integer.valueOf(t);
					}
					if(i==1) {
						firstName=t;
					}
					if(i==2) {
						lastName=t;
					}
					i++;
                }
			}
			line = br.readLine();
			if(empID!=0) {
			 employeeRecords.add(new Employee(empID, firstName,lastName));
			  
			}
		}
		//for (Employee s : employeeRecords) { System.out.println(s.empID+","+s.firstName+" "+s.lastName);} 
		Collections.sort(employeeRecords, new IDCompare());
		System.out.println("Processing by employee number...");
	    for (Employee s : employeeRecords) { System.out.println(s.empID+","+s.firstName+" "+s.lastName);} 
	    System.out.println();
	    System.out.println();
	    System.out.println("Processing by last (family) Name...");
	    Collections.sort(employeeRecords, new NameCompare());
	    for (Employee s : employeeRecords) { System.out.println(s.empID+","+s.firstName+" "+s.lastName);} 
		
	}
}

