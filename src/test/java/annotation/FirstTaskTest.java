package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FirstTaskTest {
	private FirstTask task;

	@Before
	public void setUp() throws Exception {
		task = new FirstTask();
	}

	@Test
	public void testGetId() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Class<? extends FirstTask> firstClass = task.getClass();
		Field[] fields = firstClass.getFields();
		for(Field f : fields) {
			if(f.isAnnotationPresent(MyAnnotation.class)) {
				MyAnnotation myAnnotation = f.getAnnotation(MyAnnotation.class);
				System.out.println("Field: " + f.getName() + ": " + 
						myAnnotation.id() + " " + myAnnotation.description());
			} else {
				System.out.println("Fields without annotation: " + f.getName());
			}
		}
		//Arrays.asList(fields).forEach(s -> System.out.println(s.getName()));
		Field fId = firstClass.getField("id");
		Field fDesc = firstClass.getField("description");
		System.out.println("Before: id=" + task.getId() + ", description=" + task.getDescription());
		fId.set(task, 5);
		fDesc.set(task, "new value");
		System.out.println("After: id=" + task.getId() + ", description=" + task.getDescription());
	}

	@Test
	public void testGetDescription() {
		String myClass = "annotation.FirstTask";
		Class<?> cl;
		try {
			cl = Class.forName(myClass);
			Object nTask = cl.newInstance();

			Method setDescription = nTask.getClass().getMethod("setDescription", String.class);
			setDescription.invoke(nTask, "My description :) " );

			Method getDescription = nTask.getClass().getMethod("getDescription");
			String des = (String) getDescription.invoke(nTask);
			System.out.println(des);
		} catch ( InstantiationException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	@Test
//	public void testGetIdAndDescription() {
//		System.out.println("*****\n Info about class: \ngetName(): " + task.getClass().getName() +
//				"\nClass getSimpleName(): " + task.getClass().getSimpleName() + 
//				"\ngetCanonicalName(): " + task.getClass().getCanonicalName() +
//				"\ngetComponentType(): " + task.getClass().getComponentType() +  
//				"\ngetModifiers(): " + task.getClass().getModifiers() + 
//				"\ngetTypeName(): " + task.getClass().getTypeName() + 
//				"\ngetSuperclass(): " + task.getClass().getSuperclass() + 
//				"\ngetAnnotatedInterfaces(): " + task.getClass().getAnnotatedInterfaces() +
//				"\ngetAnnotations(): " + task.getClass().getAnnotations() + 
//				"\ngetTypeParameters(): " + task.getClass().getTypeParameters());
//	}

}
