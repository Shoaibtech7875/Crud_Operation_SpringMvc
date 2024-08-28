package productcurdapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import productcurdapp.model.Product;

@Controller
public class ProductDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	//Create
	@Transactional
	public void CreateProduct(Product product) {

		this.hibernateTemplate.save(product);

	}

	//Get All Product
	public List<Product> GetProduct() {

		List<Product> product = this.hibernateTemplate.loadAll(Product.class);

		return product;
	}
	
	//Delete Product
	public void deleteProduct( int pid) {
		
	Product	p=this.hibernateTemplate.load(Product.class, pid);
	
	this.hibernateTemplate.delete(p);
		
	}
	//Get Single Product
	public void getProduct(int pid) {
		
		this.hibernateTemplate.get(Product.class, pid);

	}
		

}
