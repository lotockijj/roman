package eckel.outer;

/**Create a class with a private field and a private method. 
 * Create an inner class with a method that modifies the outer-class field 
 * and calls the outer-class method. In a second outer-class method, 
 * create an object of the inner class and call its method, 
 * then show the effect on the outer-class object.
*/

public class Outer {
	private String str = "Some string ";
	
	private String getStr() {
		return str;
	}
	
	public class Inner{
		@SuppressWarnings("unused")
		private String strInnerPrivate = "Inner string ( Does Outer class has access to Inner class)";
		public  String strInnerPublic = "Public fields in inner class. ";
		public String modify() {
			str = str + "modified";
			return getStr();
		}
	}
}
