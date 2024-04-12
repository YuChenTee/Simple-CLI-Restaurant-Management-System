import java.util.Scanner;

public class Waiter {
	private Boolean waiterLogin;
	
	public Waiter() {
		
	}
	
	
	public Boolean getWaiterLogin() {
		return waiterLogin;
	}


	public void setWaiterLogin(Boolean waiterLogin) {
		this.waiterLogin = waiterLogin;
	}


	public void printWaiterOptions() {
		System.out.println("---------------------------------------");
		System.out.println("<<< Waiter Option >>> ");
		System.out.println("1. Create new customer");
		System.out.println("2. View Customers Info");
		System.out.println("3. Serve Food ("+Food.foodServingQueue.size()+" order(s) pending)");
		System.out.println("4. <-Back");
		System.out.println("---------------------------------------");
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		
		if (option == 1) {
			createCustomer();
		}
		else if (option ==2) {
			printCustomersInfo();
		}
		else if (option == 3) {
			printFoodQueue();
			if (Food.getFoodServingQueue().size()==0) {
				System.out.println("All Food is served!!!");
			}
			else {
				System.out.println("Please select food to prepare (Enter 0 to exit): ");
				scanner = new Scanner(System.in);
				option = scanner.nextInt();
				if (option != 0) {
					Food selectedFood = Food.getFoodServingQueue().get(option-1);
					Food.getFoodServingQueue().remove(selectedFood);
					selectedFood.setPreparationStatus("Served");
					System.out.println(selectedFood.getQuantity()+" <"+selectedFood.getName()+"> served!");
				
				}
			}
		}
		else if (option == 4) {
			waiterLogin = false;
		}
	}
	
	private void createCustomer() {
		System.out.println("Please Enter Customer username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		for (Customer c : Customer.customerList) {
			if (username.equals(c.getUserName())) {
				System.out.println("User has been created!!! Please Login from Customer account");
				return;
			}
		}
		Customer customer = new Customer(username);
		System.out.println("New customer created!!! Please Login from Customer Account");
	}
	
	public void printCustomersInfo() {
		System.out.println("----------------------------------");
		System.out.println("<<< Customer List >>>");
		for (int i = 0; i < Customer.customerList.size();i++) {
			System.out.println(i+1+". "+Customer.customerList.get(i).getUserName());
		}
		System.out.println("----------------------------------");
		if (Customer.customerList.size()==0) {
			System.out.println("No customer yet!!!");
		}
		else {
			System.out.println("Please Select Customer to view info: ");
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			Customer c = Customer.customerList.get(option-1);
			System.out.println("Customer : "+ c.getUserName());
			c.getOrder().printOrder();
			c.getBill().printBill();
		}
		
	}
	
	public void printFoodQueue() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("<<< Serving Food Queue >>>");
		for (int i = 0 ; i < Food.foodServingQueue.size();i++) {
			System.out.println(i+1+". Item: "+Food.foodServingQueue.get(i).getName()+"  Quantity: "+Food.foodServingQueue.get(i).getQuantity());
		}
		System.out.println("-------------------------------------------------------------------------");
	}
}
