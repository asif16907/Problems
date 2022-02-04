import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws NumberFormatException, IOException {
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log",
		"org.apache.commons.logging.impl.NoOpLog");
		
		ItemDAO idao=new ItemDAO();
		do {
			System.out.println("Menu\n1.Remove item\n2.Display items\n3.Exit\nEnter choice");
			switch(Integer.parseInt(br.readLine())) {
			case 1:
				System.out.println("Enter item id");
				int id=Integer.parseInt(br.readLine());
				Item item=idao.find(id);
				if(item==null) {
					System.out.println("Item not found");
				}
				else {
					idao.delete(item);
					System.out.println("Item was Deleted");
				}
				break;
			case 2:
				
				
				List<Item> itemList=new ArrayList<Item>();
				itemList= idao.list();
				if(itemList==null)
				{
					System.out.println("Empty list");
				}
				else
				{
				System.out.printf("%-15s %-15s %-15s %-15s %s\n","Id","Name","Category","Quantity","Price");
				for(Item i:itemList) {
					System.out.printf("%-15s %-15s %-15s %-15s %s\n", i.getId(),i.getName(),i.getCategory(),i.getQuantity(),i.getPrice());
				}
				}
				break;
			case 3:
				System.out.println("Bye");
				System.exit(0);
				
			default:
				System.out.println("Invalid choice");
			}
		}while(true);
//		System.exit(0);
	}
}
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//public class Main {
//    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		//FILL YOUR CODE
//		Logger log = Logger.getLogger("org.hibernate");
//		log.setLevel(Level.OFF);
//		System.setProperty("org.apache.commons.logging.Log",
//		"org.apache.commons.logging.impl.NoOpLog");
//		
//		
//		ItemDAO idao=new ItemDAO();
//		
//		do {
//			System.out.println("Menu\n1.Add item\n2.Change item\n3.Display items\n4.Exit\nEnter choice");
//			switch(Integer.parseInt(br.readLine())) {
//			case 1:
//				System.out.println("Enter item id");
//				int id=Integer.parseInt(br.readLine());
//				System.out.println("Enter name");
//				String name=br.readLine();
//				System.out.println("Enter category");
//				String category=br.readLine();
//				System.out.println("Enter number");
//				int number=Integer.parseInt(br.readLine());
//				System.out.println("Enter price");
//				Float price=Float.parseFloat(br.readLine());
//				
//				Item item=new Item();
//				item.setId(id);
//				item.setName(name);
//				item.setCategory(category);
//				item.setNumber(number);
//				item.setPrice(price);
//				
//				
//				idao.insert(item);
//				System.out.println("Added to the list successfully");
//				break;
//			case 2:
//				System.out.println("Enter item id");
//				int id2=Integer.parseInt(br.readLine());
//				
//				Item item2=idao.find(id2);
//				if(item2==null) {
//					System.out.println("Item not found");
//				}
//				else {
//					System.out.println("Enter name");
//					String name2=br.readLine();
//					System.out.println("Enter category");
//					String category2=br.readLine();
//					System.out.println("Enter number");
//					int number2=Integer.parseInt(br.readLine());
//					System.out.println("Enter price");
//					Float price2=Float.parseFloat(br.readLine());
//					
//				
//					item2.setId(id2);
//					item2.setName(name2);
//					item2.setCategory(category2);
//					item2.setNumber(number2);
//					item2.setPrice(price2);
//					
//					idao.update(item2);
//				System.out.println("Changes are updated successfully");
//				}
//				
//				break;
//			
//			case 3:
//				List<Item> itemList=new ArrayList<Item>();
//				itemList= idao.list();
//				if(itemList==null)
//				{
//					System.out.println("Empty list");
//				}
//				else
//				{
//					
//				System.out.printf("%-15s %-15s %-15s %-15s %s\n","Id","Name","Category","Number","Price");
//				for(Item i:itemList) {
//					System.out.printf("%-15s %-15s %-15s %-15s %s\n", i.getId(),i.getName(),i.getCategory(),i.getNumber(),i.getPrice());
//				}
//				}
//				break;
//			case 4:
//				System.out.println("Bye");
//				System.exit(0);
//			default:
//				System.out.println("Invalid choice");
//			}
//		}while(true);
//	}
//}