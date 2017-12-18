package epam.junit;

public class SomeClass {  
    private OtherClass otherClass;  
   
    public SomeClass(OtherClass otherClass) {  
         this.otherClass = otherClass;  
    }  
    
    protected void firstMethod(int value) {  
         if(value > 0) {  
              secondMethod("Yes!");  
         }  
         else {  
              secondMethod("No!");  
         }  
    }  
    
    private void secondMethod(String value) {  
         otherClass.someMethod(value);  
    }       
}  