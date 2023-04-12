package dedalus.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class TryList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList();
		list.add("Ram");
		list.add(10);
		list.add("Shiva");
		list.add("Ram");
		System.out.println(list);
		
		Iterator i = list.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
/*		Map map = new HashMap();
		map.put(1,"Apple");
		map.put(2,"Orange");
		map.put(2,"Banana");
		map.put(null,"Grapes");
		map.put(3,"Mango");
		System.out.println(map);
		
		Collection c = map.values();
		Iterator ii = c.iterator();
		while(ii.hasNext()) {
			System.out.println(ii.next());
		}
*/	
	}

}
