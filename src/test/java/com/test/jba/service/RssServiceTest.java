package com.test.jba.service;

import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.test.jba.entity.Item;
import com.test.jba.exception.RssException;

public class RssServiceTest {

	private RssService rssService;
	
	@Before
	public void setUp() throws Exception {
		rssService = new RssService();
	}

	@Test
	public void testGetItemsFile() throws RssException {
		//fail("Not yet implemented");
		//List<Item> items = rssService.getItems(new File("test-rss/test.xml"));
		List<Item> items = rssService.getItems("http://scripting.com/rss.xml");
		//List<Item> items = rssService.getItems("http://www.tomcatexpert.com/blog/feed");
		
		assertEquals(25, items.size());
		Item firstItem = items.get(0);
		assertEquals("Great \"Blue Sky\" platforms", firstItem.getTitle()); //当地址为网址时注意内容会变化
		//assertEquals("Imagine all the people", firstItem.getTitle());
		//assertEquals("23 04 2015 10:39:07", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
		assertEquals("27 04 2015 14:16:21", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
	}

}
