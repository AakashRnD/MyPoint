package com.example.linetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.util.Log;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

	/**
	 * An array of sample (dummy) items.
	 */
	
	
	
	public List<DummyItem> ITEMS;

	/**
	 * A map of sample (dummy) items, by ID.
	 */
	public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>(com.example.linetest.LaunchScreen.number_questions);
	

	public DummyContent(){
		
		ITEMS =  new ArrayList<DummyItem>(com.example.linetest.LaunchScreen.number_questions);
	}
	
	public void remove(){
		Log.d("removing",ITEMS.size()+"");
		for(int i=1; i<=ITEMS.size() ; i++){
			removeItem(new DummyItem(i+"","Question"+i));			
		}
		
	}

	public void add() {
		// add items to list
		Log.d("inserting",com.example.linetest.LaunchScreen.number_questions+"");
		for(int i=1; i<=com.example.linetest.LaunchScreen.number_questions ; i++){
			addItem(new DummyItem(i+"","Question"+i));			
		}
		
	}

	private void addItem(DummyItem item) {
		ITEMS.add(item);
		ITEM_MAP.put(item.id, item);
	}
	
	private void removeItem(DummyItem item) {
		ITEMS.remove(item);
		ITEM_MAP.remove(item.id);
	}

	/**
	 * A dummy item representing a piece of content.
	 */
	public static class DummyItem {
		public String id;
		public String content;

		public DummyItem(String id, String content) {
			this.id = id;
			this.content = content;
		}

		@Override
		public String toString() {
			return content;
		}
	}
}
