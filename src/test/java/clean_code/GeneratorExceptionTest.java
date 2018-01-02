package clean_code;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GeneratorExceptionTest {
	GeneratorException gen;
	
	@Before
	public void setUp() throws Exception {
		gen = new GeneratorException();
	}

	@Test(expected = NullPointerException.class)
	public void testGenExc() {
		gen.genExc();
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGenExc2() {
		gen.genExc2();
	}
	
	@Test(expected = ClassCastException.class)
	public void testGenExc3() {
		gen.genExc3();
	}
	
	@Test(expected = RuntimeException.class)
	public void testGenExc4() {
		gen.genExc4();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testOptional() {
		String nullName = null;
		String name = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
		Assert.assertEquals(2, name);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void givenOptionalWithNullThanThrowException() {
		Optional<String> opt = Optional.ofNullable(null);
		String name = opt.get();
		Assert.assertEquals(2, name);
	}

}
