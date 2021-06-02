package kodlamaio.northwind.dataAccess.abstracts;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product,Integer> {
	

	//filtreleme yapmamıza yardımcı yapılar.
	//select * from products where product_name=abc
	Product getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
   
    
    
    List< Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);

   //select * from products where category_id in(1,2,3,4)
    
   List<Product> getByCategoryIn(List<Integer> categories);
   
   List<Product> getByProductNameContains(String productName);
   
   List<Product> getByProductNameStartsWith(String productName);
   //get yerine find kullanılabilir.
   
   //jpql
   @Query("From Product where productName=:productName and category.categoryId=:categoryId ")
   List<Product> getByNameAndCategory(String productName,int categoryId);

   
   
   
   
}
