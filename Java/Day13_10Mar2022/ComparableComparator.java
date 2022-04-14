import java.util.*;

class Product implements Comparable<Product>{
    private  String name;
    private Double price;
    private Integer quantity;
    
    Product(String name, Double price, Integer quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
    
    public String getName(){
        return this.name;
    }
    
    public Double getPrice(){
        return this.price;
    }
    
    public Integer getQuantity(){
        return this.quantity;
    }
    
    @Override
    public String toString() {
        return "Product Name: "+this.getName() + " , Price: "+this.getPrice()+" ,Quantity: "+this.getQuantity();
    }
    
    public int compareTo(Product p1){
        if(this.quantity==p1.getQuantity())
            return 0;
        else if(this.quantity > p1.getQuantity())
            return 1;
        else
            return -1;
    }
    
}

class ProductPriceCompare implements Comparator<Product>{
     @Override
    public int compare(Product o1, Product o2) {
        
        return o1.getPrice().compareTo(o2.getPrice());
    }
}

public class ComparableComparator
{
	public static void main(String[] args) {
		List<Product> productList = new ArrayList<>(){{ 
		   add(new Product("Notebook",75.35,1));
		   add(new Product("chips",50.48,5));
		   add(new Product("DVD",40.56,3));
		   add(new Product("Oats",65.76,1)); 
		}};
		System.out.println("###############Comparable###################");
		Collections.sort(productList);
		for(Product product:productList){
		    System.out.println(product);
		}
		System.out.println("#################Comparator##################");
		Collections.sort(productList,new ProductPriceCompare());
		for(Product product:productList){
		    System.out.println(product);
		}
		
	}
}
