
public class Bill {
	Order order;
	double amount = 0;

	public Bill(Order order) {
		this.order = order;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void printBill() {
		System.out.println();
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("<<< Invoice >>>");
		System.out.println();
		if (order.getOrderlist().size() == 0) {
			System.out.println("No bill yet!");
		}
		else {
			setAmount(0);
			for (int i = 0;i< order.getOrderlist().size();i++) {
				double totalPrice = order.getOrderlist().get(i).getPrice()*order.getOrderlist().get(i).getQuantity();
				System.out.print(i+1+". Item: "+order.getOrderlist().get(i).toString()+"  Quantity: "+order.getOrderlist().get(i).getQuantity()+ 
						"  Price: "+ totalPrice);
				System.out.println();
				System.out.println();
				setAmount(getAmount()+totalPrice);
			}
			System.out.println("--------------------------------------------------------------------------------------");
			System.out.println("<<<Net Total: RM "+getAmount()+">>>");
		}
	}
	
	public void makePayment() {
		
	}

	@Override
	public String toString() {
		return String.format("Bill [order=%s, amount=%s]", order, amount);
	}
	
	
}
