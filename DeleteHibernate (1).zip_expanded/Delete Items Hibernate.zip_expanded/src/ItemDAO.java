import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ItemDAO {
	public void delete(Item item) {
		Session s =HibernateUtil.getSessionFactory().openSession();
		
		 s.beginTransaction();
		 s.delete(item);
	        s.getTransaction().commit();
	        s.close();
	}

	public List<Item> list(){
		Session s =HibernateUtil.getSessionFactory().openSession();
		Query q=s.createQuery("from Item");
        
		List<Item> item=(List<Item>) q.list();
         s.close();
		return item;
       
		
		
	}
	
	public Item find(int id){
		Session s =HibernateUtil.getSessionFactory().openSession();

		Item item=  (Item) s.get(Item.class,id);
	        s.close();
		return item;
		//FILL YOUR CODE
	}
	
//	public List<Item> list(){
//		//FILL YOUR CODE
//	}
//	
//	public Item find(int id){
//		//FILL YOUR CODE
//	}
}



//public class ItemDAO {
//	public void insert(Item item) {
//		Session s =HibernateUtil.getSessionFactory().openSession();
//		
//		 s.beginTransaction();
//		 s.save(item);
//	        s.getTransaction().commit();
//	        s.close();
//	       
//	}
//	
//	public void update(Item item) {
//		Session s =HibernateUtil.getSessionFactory().openSession();
//		
//		 s.beginTransaction();
//		 s.update(item);
//	        s.getTransaction().commit();
//	        s.close();
//	        
//	        
//	}
	
	

