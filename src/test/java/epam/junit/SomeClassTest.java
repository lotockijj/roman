package epam.junit;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;  

public class SomeClassTest {  
	
     @Mock  
     private OtherClass otherClass;  
     //Class under test  
     private SomeClass someClass;  
     @Before  
     public void prepareDependencies() {  
          MockitoAnnotations.initMocks(this);       
          someClass = new SomeClass(otherClass);  
     }  
     @Test  
     public void is_the_value_greater_than_zero() {  
          someClass.firstMethod(8);  
          verify(otherClass).someMethod("Yes!");  
     }  
     @Test  
     public void is_the_value_smaller_than_zero() {  
          someClass.firstMethod(-1);  
          verify(otherClass).someMethod("No!");  
     }  
}  