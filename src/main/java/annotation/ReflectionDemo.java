package annotation;

import java.lang.reflect.*;

public class ReflectionDemo {

    public static void main(String[] args) throws Exception {
        String dogClassName = "annotation.Dog";
        Class<?> dogClass = Class.forName(dogClassName); // convert string classname to class
        Object dog = dogClass.newInstance(); // invoke empty constructor

        String methodName = "";

        // with single parameter, return void
        methodName = "setName";
        Method setNameMethod = dog.getClass().getMethod(methodName, String.class);
        setNameMethod.invoke(dog, "Mishka"); // pass arg
        
        // without parameters, return string
        methodName = "getName";
        Method getNameMethod = dog.getClass().getMethod(methodName);
        String name = (String) getNameMethod.invoke(dog); // explicit cast

        methodName = "setBreed";
        Method setBreedMethod = dog.getClass().getMethod(methodName, String.class);
        setBreedMethod.invoke(dog, "bulldog");
        
        methodName = "getBreed";
        Method getBreedMethod = dog.getClass().getMethod(methodName);
        String breed = (String) getBreedMethod.invoke(dog);
        
        // with multiple parameters
        methodName = "printDog";
        Class<?>[] paramTypes = {String.class, int.class, String.class};
        Method printDogMethod = dog.getClass().getMethod(methodName, paramTypes);
        printDogMethod.invoke(dog, name, 3, breed); // pass args
    }
}