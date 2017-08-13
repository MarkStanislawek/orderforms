package mannafundraising.orderforms.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import mannafundraising.orderforms.entity.Product;

public class ProductServiceImplTest {

	@Test
	public void testSortInterleavedByName() {
		Product a = new Product();
		a.setName("a");
		Product b = new Product();
		b.setName("b");
		Product c = new Product();
		c.setName("c");
		Product x = new Product();
		x.setName("x");
		Product y = new Product();
		y.setName("y");
		Product z = new Product();
		z.setName("z");
		
		List<Product> sorted = ProductServiceImpl.sortInterleavedByName(Arrays.asList(a,b,c,x,y,z));
		assert(sorted.get(0).getName().equals(a.getName()));
		assert(sorted.get(1).getName().equals(x.getName()));
		assert(sorted.get(2).getName().equals(b.getName()));
		assert(sorted.get(3).getName().equals(y.getName()));
		assert(sorted.get(4).getName().equals(c.getName()));
		assert(sorted.get(5).getName().equals(z.getName()));
	}

}
