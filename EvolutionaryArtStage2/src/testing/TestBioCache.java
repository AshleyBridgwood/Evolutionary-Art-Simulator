package testing;

import static org.junit.Assert.*;
import model.BioCache;

import org.junit.Before;
import org.junit.Test;

public class TestBioCache {
	
	private Object data;
	
	@Test
	public void testPush(){
		BioCache cache = new BioCache();
		assertEquals(cache.getNumberOfItemsOnStack(), -1);
		Object data = null;
		cache.push(data);
		assertEquals(cache.getNumberOfItemsOnStack(), 0);
		cache.push(data);
		cache.push(data);
		assertEquals(cache.getNumberOfItemsOnStack(), 2);
	}
	
	@Test
	public void testPop(){
		BioCache cache = new BioCache();
		for(int i = 0; i < 10; i++){
			cache.push(data);
		}
		assertEquals(cache.getNumberOfItemsOnStack(), 9);
		cache.pop();
		cache.pop();
		assertEquals(cache.getNumberOfItemsOnStack(), 7);
	}
}
