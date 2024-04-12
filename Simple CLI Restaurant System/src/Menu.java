import java.util.ArrayList;
import java.util.Scanner;

public class Menu{
	public static ArrayList<Food> menuItems = new ArrayList<Food>();

	public static ArrayList<Food> getMenuItems() {
		return menuItems;
	}

	public static void setMenuItems(ArrayList<Food> menuItems) {
		Menu.menuItems = menuItems;
	}
	
	public static void printMenu() {
		for (int i =0 ; i< menuItems.size();i++) {
			System.out.println("Item No: "+(i+1));
			System.out.println("Item Name: "+menuItems.get(i).getName()+" ");
			System.out.println("Price: RM "+menuItems.get(i).getPrice()+" ");
			System.out.println("Description: "+menuItems.get(i).getDescription()+" ");
			System.out.println();
		}
	}
	
	public Object clone() throws CloneNotSupportedException 
    { 
        return super.clone(); 
    } 
	
	public static void getMenuOption(Customer c) {
		System.out.println("Select Item No: ");
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		System.out.println("<"+menuItems.get(option-1).toString()+"> - Add This Item to Order? [Y/N]");
		scanner = new Scanner(System.in);
		String comfirm = scanner.nextLine();
		if (comfirm.equals("y")) {
			System.out.println("Please enter quantity: ");
			scanner = new Scanner(System.in);
			int quantity = scanner.nextInt();
			Food orderedFood = new Food();
			orderedFood.setName(menuItems.get(option-1).getName());
			orderedFood.setPrice(menuItems.get(option-1).getPrice());
			orderedFood.setDescription(menuItems.get(option-1).getDescription());
			orderedFood.setQuantity(quantity);
			c.getOrder().getOrderlist().add(orderedFood);
			Food.getFoodPrepareQueue().add(orderedFood);
			System.out.println("Item successfully ordered!!!");
		}
		else {
			
		}
	}
}
