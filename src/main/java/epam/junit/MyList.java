package epam.junit;

import java.util.AbstractList;

public class MyList extends AbstractList<String> {
	  
    @Override
    public void add(int index, String element) {
    	System.out.println(index + element);
    }

	@Override
	public String get(int index) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}
}