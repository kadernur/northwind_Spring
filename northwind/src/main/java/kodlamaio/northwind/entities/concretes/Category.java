package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="categories")

//category ile ürün arasındaki döngüyü engelleriz. benim istediğim mappingleri yap gerisine karışma mantığı.
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","products"})

public class Category {
	
	@Id
	@Column(name="category_id")
	private int categoryId;
	
	
	
	@Column(name="category_name")
	private String categoryName;
	
	
	
	//ilişki yapısını kuruyoruz 
	@OneToMany(mappedBy = "category")
	private List<Product> products;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
