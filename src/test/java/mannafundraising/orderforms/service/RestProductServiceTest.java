package mannafundraising.orderforms.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import mannafundraising.common.json.ProductJson;
import mannafundraising.common.json.ProductJson.ProductJsonBuilder;

public class RestProductServiceTest {
	private ProductJson a, b, c, x, y, z;

	@Before
	public void setup() {
		ProductJsonBuilder builder = new ProductJsonBuilder();
		a = builder.withName("a").build();
		b = builder.withName("b").build();
		c = builder.withName("c").build();
		x = builder.withName("x").build();
		y = builder.withName("y").build();
		z = builder.withName("z").build();
	}

	@Test
	public void givenProductList_SortInterleavedAlphabetic() {
		List<ProductJson> sorted = RestProductService.sortInterleavedByName(Arrays.asList(a, b, c, x, y, z));
		Assert.assertTrue(sorted.get(0).getName().equals(a.getName()));
		Assert.assertTrue(sorted.get(1).getName().equals(x.getName()));
		Assert.assertTrue(sorted.get(2).getName().equals(b.getName()));
		Assert.assertTrue(sorted.get(3).getName().equals(y.getName()));
		Assert.assertTrue(sorted.get(4).getName().equals(c.getName()));
		Assert.assertTrue(sorted.get(5).getName().equals(z.getName()));
	}

}
