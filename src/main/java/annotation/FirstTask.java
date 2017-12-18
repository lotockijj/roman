package annotation;

/**2.Create your own annotation. Create class with a few fields, 
 * some of which annotate with this annotation. Through reflection print those fields 
 * in the class that were annotate by this annotation.
 * 3.Print annotation value into console (e.g. @Annotation(name = "111"))
 */

public class FirstTask {
	@MyAnnotation(id=111)
	public int id;
	@MyAnnotation(id=222, description="My value in class")
	public String description;
	public boolean notImportantValue;
	
	public FirstTask() {
	}
	
	public FirstTask(int id, String description, boolean notImportantValue) {
		this.id = id;
		this.description = description;
		this.notImportantValue = notImportantValue;
	}

	public int getId() {
		return id;
	}
	
	public boolean isNotImportantValue() {
		return notImportantValue;
	}

	public void setNotImportantValue(boolean notImportantValue) {
		this.notImportantValue = notImportantValue;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public String getIdAndDescription() {
		return id + " " + description;
	}
	
}
