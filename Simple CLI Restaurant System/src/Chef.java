import java.util.Scanner;

public class Chef {
	
	private Boolean chefLogin;
	
	public Chef() {
		
	}
	
	
	public Boolean getChefLogin() {
		return chefLogin;
	}


	public void setChefLogin(Boolean chefLogin) {
		this.chefLogin = chefLogin;
	}

	public void printFoodQueue() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("<<< Kitchen Food Queue >>>");
		for (int i = 0 ; i < Food.foodPrepareQueue.size();i++) {
			System.out.println(i+1+". Item: "+Food.foodPrepareQueue.get(i).getName()+"  Quantity: "+Food.foodPrepareQueue.get(i).getQuantity());
		}
		System.out.println("-------------------------------------------------------------------------");
	}
	public void printChefOption() {
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println("<<< Chef Option >>>");
		System.out.println("1. Prepare Food ("+Food.getFoodPrepareQueue().size()+" order(s) pending)");
		System.out.println("2. <-Back");
		System.out.println("---------------------------------------");
		
		Scanner scanner = new Scanner(System.in);
		int option = scanner.nextInt();
		
		if (option == 1) {
			printFoodQueue();
			if (Food.getFoodPrepareQueue().size()==0) {
				System.out.println("All Food is prepared!!!");
			}
			else {
				System.out.println("Please select food to prepare (Enter 0 to exit): ");
				scanner = new Scanner(System.in);
				option = scanner.nextInt();
				if (option != 0) {
					Food selectedFood = Food.getFoodPrepareQueue().get(option-1);
					Food.getFoodPrepareQueue().remove(selectedFood);
					Food.getFoodServingQueue().add(selectedFood);
					selectedFood.setPreparationStatus("Serving");
					System.out.println(selectedFood.getQuantity()+" <"+selectedFood.getName()+"> ready to be served!");
				
				}
			}
			
		}
		if (option ==2) {
			chefLogin = false;
		}
		
	}
}	
