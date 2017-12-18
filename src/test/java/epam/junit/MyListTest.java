package epam.junit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class MyListTest {

	@Test
	public void whenAddCalledVerfied() {
	    MyList myList = mock(MyList.class);
	    doNothing().when(myList).add(isA(Integer.class), isA(String.class));
	    myList.add(0, "");
	    verify(myList, times(1)).add(0, "");
	}
	
	@Test
	public void whenAddCalledVerfied2() {
	    MyList myList = mock(MyList.class);
	    myList.add(0, "");
	    verify(myList, times(1)).add(0, "");
	}
	
	@Test
	public void whenAddCalledValueCaptured() {
	    MyList myList = mock(MyList.class);
	    ArgumentCaptor<String> valueCapture = ArgumentCaptor.forClass(String.class);
	    doNothing().when(myList).add(any(Integer.class), valueCapture.capture());
	    myList.add(0, "captured");
	    assertEquals("captured", valueCapture.getValue());
	}

	@Test
	public void whenAddCalledRealMethodCalled() {
	    MyList myList = mock(MyList.class);
	    doCallRealMethod().when(myList).add(any(Integer.class), any(String.class));
	    myList.add(1, "real");
	    verify(myList, times(1)).add(1, "real");
	}
	
}
