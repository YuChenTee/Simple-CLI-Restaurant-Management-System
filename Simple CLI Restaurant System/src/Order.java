import java.util.ArrayList;

public class Order {
	private ArrayList<Food> orderlist = new ArrayList<Food>();

	public ArrayList<Food> getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(ArrayList<Food> orderlist) {
		this.orderlist = orderlist;
	}
	
	public void printOrder() {
		System.out.println("---------------------------------------------------------------------------------");
		System.out.println("<<< Order Status >>> ");
		if (orderlist.size() == 0) {
			System.out.println("No order yet!");
		}
		else {
			for (int i = 0;i< orderlist.size();i++) {
				System.out.print(i+1+". Item: "+orderlist.get(i).toString()+"  Quantity: "+orderlist.get(i).getQuantity() +"  Status: "+orderlist.get(i).getPreparationStatus());
				System.out.println();
				System.out.println();
			}
		}
		System.out.println("---------------------------------------------------------------------------------");
	}

	@Override
	public String toString() {
		return String.format("Order [orderlist=%s]", orderlist);
	}
	
	
	
}
