package mannafundraising.orderforms.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import mannafundraising.orderforms.domain.ProductJson;

public class RestProductServiceTest {

	@Test
	public void testSortInterleavedByName() {
		ProductJson a = new ProductJson();
		a.setName("a");
		ProductJson b = new ProductJson();
		b.setName("b");
		ProductJson c = new ProductJson();
		c.setName("c");
		ProductJson x = new ProductJson();
		x.setName("x");
		ProductJson y = new ProductJson();
		y.setName("y");
		ProductJson z = new ProductJson();
		z.setName("z");
		
		List<ProductJson> sorted = RestProductService.sortInterleavedByName(Arrays.asList(a,b,c,x,y,z));
		Assert.assertTrue(sorted.get(0).getName().equals(a.getName()));
		Assert.assertTrue(sorted.get(1).getName().equals(x.getName()));
		Assert.assertTrue(sorted.get(2).getName().equals(b.getName()));
		Assert.assertTrue(sorted.get(3).getName().equals(y.getName()));
		Assert.assertTrue(sorted.get(4).getName().equals(c.getName()));
		Assert.assertTrue(sorted.get(5).getName().equals(z.getName()));
	}

}
