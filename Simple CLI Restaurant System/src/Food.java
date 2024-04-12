import java.util.ArrayList;

public class Food {
	private String name;
	private Double price;
	private String description;
	private String preparationStatus = "Preparing";
	private int quantity;
	public static ArrayList<Food> foodPrepareQueue = new ArrayList<Food>();
	public static ArrayList<Food> foodServingQueue = new ArrayList<Food>();
	
	public Food() {
	}
	
	public Food(String name, Double price, String description) {
		Menu.menuItems.add(this);
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPreparationStatus() {
		return preparationStatus;
	}
	public void setPreparationStatus(String preparationStatus) {
		this.preparationStatus = preparationStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public static ArrayList<Food> getFoodPrepareQueue() {
		return foodPrepareQueue;
	}

	public static void setFoodPrepareQueue(ArrayList<Food> foodPrepareQueue) {
		Food.foodPrepareQueue = foodPrepareQueue;
	}

	public static ArrayList<Food> getFoodServingQueue() {
		return foodServingQueue;
	}

	public static void setFoodServingQueue(ArrayList<Food> foodServingQueue) {
		Food.foodServingQueue = foodServingQueue;
	}

	@Override
	public String toString() {
		return String.format("%s", name);
	}
	
	
}
