import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private String userName;
	private Order order = new Order();
	public static ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Boolean userLogin;
	private Bill bill = new Bill(order);
	
	public Customer(String userName) {
		this.userName = userName;
		customerList.add(this);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public static ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public static void setCustomerList(ArrayList<Customer> customerList) {
		Customer.customerList = customerList;
	}
	
	
	public Boolean getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(Boolean userLogin) {
		this.userLogin = userLogin;
	}
	
	

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public void printCustomerOptions() {
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("<<< Customer Option >>>");
		System.out.println("1. Order");
		System.out.println("2. View Order Status ("+order.getOrderlist().size()+" order(s))");
		System.out.println("3. Payment");
		System.out.println();
		System.out.println("4. <-Back");
		System.out.println("---------------------------------------");
	}
	
	public static Customer authenticateCustomer(String username) {
		for (int i = 0; i< customerList.size();i++) {
			if (username.equals(customerList.get(i).getUserName())) {
				customerList.get(i).setUserLogin(true);
				return customerList.get(i);
			}
		}
		System.out.println("Invalid customer username, Please create user account from waiter!");
		return new Customer("Null");
		
	}
	
	public void getCustomerOption() {
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		
		if (option == 1) {
			Menu.printMenu();
			Menu.getMenuOption(this);
		}
		
		else if (option == 2) {
			order.printOrder();
		}
		
		else if (option == 3) {
			bill.printBill();
			if (bill.getOrder().getOrderlist().size() != 0) {
				System.out.println();
				System.out.println("Do you want to make a payment? [Y/N]");
				scanner = new Scanner(System.in);
				String choice = scanner.nextLine();
				if (choice.equals("y")) {
					System.out.println();
					System.out.println("Payment Successful!!! Please Come to ABC Restaurant Again :)");
					customerList.remove(this);
					userLogin = false;
				}
			}
			
		}
		else {
			userLogin = false;
		}
	}

	@Override
	public String toString() {
		return String.format("Customer [userName=%s, order=%s, userLogin=%s, bill=%s]", userName, order, userLogin,
				bill);
	}
	
	
	
	
}
