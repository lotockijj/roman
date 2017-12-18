package arrays;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ContainerTest {
	public static final int N = 10000;

    static List<Integer> sourceList = new ArrayList<>();
    static {
        for (int i = 0; i < N; i++) {
            sourceList.add(i);
        }
    }
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
	}

	@Test
	public void testGet() {
	}

}
