
public class Product {
	
		private String name;
		private String category ;
		private double price;
		
public Product(String name, String category, double price)
{
	this.name = name;
	this.category = category;
	this.price = price;
	
}

	/*public String getName() {
	return name;
}*/

public void setName(String name) {
	this.name = name;
}

/*public String getCategory() {
	return category;
}*/

public void setCategory(String category) {
	this.category = category;
}

/*public double getPrice() {
	return price;
}*/

public void setPrice(double price) throws IllegalArgumentException
{

	if (price <= 0)
	throw new IllegalArgumentException("Please avoid negative values");
this.price = price;

}

public void displayProductInfo()
{
	System.out.println("Product name " + name);
	System.out.println("Product category  " + category);
	System.out.println("Product price " + price);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product Prod = new Product("Cucumber","Vegetable",15);
		Prod.setName("Hybrid cucumber");
		Prod.setCategory("Vegetable");
		try
		{
		Prod.setPrice(-88);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Negative value "+ e.getMessage());
		}
		
		Prod.setPrice(25);
		Prod.displayProductInfo();

	}

}
