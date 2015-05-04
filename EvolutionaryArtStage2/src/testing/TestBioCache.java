package testing;

import static org.junit.Assert.*;
import model.BioCache;

import org.junit.Before;
import org.junit.Test;

public class TestBioCache {
	
	private BioCache cache;
	private Object data;
	
	@Before
	public void before(){
		cache = new BioCache();
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPush(){
		assertEquals(cache.getNumberOfItemsOnStack(), -1);
		Object data = null;
		cache.push(data);
		assertEquals(cache.getNumberOfItemsOnStack(), 0);
		cache.push(data);
		cache.push(data);
		assertEquals(cache.getNumberOfItemsOnStack(), 2);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testPop(){
		for(int i = 0; i < 10; i++){
			cache.push(data);
		}
		assertEquals(cache.getNumberOfItemsOnStack(), 9);
		cache.pop();
		cache.pop();
		assertEquals(cache.getNumberOfItemsOnStack(), 7);
	}
}
