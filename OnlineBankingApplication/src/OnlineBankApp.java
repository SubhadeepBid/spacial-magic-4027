import java.util.Scanner;

import com.obapp.usecases.SignInAccountant;

public class OnlineBankApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===============================================");
		System.out.println("|    Welcome to Online Banking Application    |");
		System.out.println("===============================================");
		
		boolean i1 = true;
		
		while(i1) {
			
			System.out.println("\nPlease select correct option\n");
			System.out.println("	1 - Accountant Login");
			System.out.println("	2 - Customer Login");
			System.out.println("	3 - Exit\n");
			
			System.out.print("Enter your choice : ");
			
			int ch1 = sc.nextInt();
			
			switch(ch1) {
			
			case 1: System.out.println("\n\nAccountant Login");
			        System.out.println("================");
				
					if(SignInAccountant.signInAcct()) {
			        	
						boolean i2 = true;
						while(i2) {
							
							System.out.println("\nPlease select correct option\n");
							System.out.println("	1 - Add Customer");
							System.out.println("	2 - Update Customer");
							System.out.println("	3 - Remove Customer");
							System.out.println("	4 - Show Customer");
							System.out.println("	5 - Show All Customers");
							System.out.println("	6 - Exit\n");
							
							System.out.print("Enter your choice : ");
							
							int ch2 = sc.nextInt();
							
							switch(ch2) {
							
							case 1: System.out.println("Add Customer");
							        System.out.println("============");
							        break;
							        
							case 2: System.out.println("Update Customer");
							        System.out.println("===============");
							        break;
							        
							        System.out.println("Remove Customer");
							        System.out.println("===============");
							        break;
							
							}
							
						}
			        	System.out.println("Opts");
			        	
			        }
				
			        break;
			        
			case 2: System.out.println("\n\nCustomer Login");
			        System.out.println("==============");
			        break;
			        
			case 3: System.out.println("\n\nThank You for using our Online Banking Application!");
			        i1 = false;
		            break;
		            
		    default: System.out.println("\n\nWrong Choice!");
			
			}
			
		}
		
		
	}

}
