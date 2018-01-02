package clean_code;

public class GeneratorException {

	public void genExc() {
		if(true) {
			throw new NullPointerException();
		}
	}
	
	public void genExc2() {
		throw new ArrayIndexOutOfBoundsException();
	}
	
	public void genExc3() {
		throw new ClassCastException();
	}
	
	public void genExc4() {
		throw new RuntimeException(); 
	}
}
