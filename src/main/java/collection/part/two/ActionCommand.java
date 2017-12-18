package collection.part.two;

public class ActionCommand {
	private Action action;

	public void setCommand(Action action) {
		this.action = action;
	}
	
	public void pressButton() {
		action.execute();
	}
	
}
