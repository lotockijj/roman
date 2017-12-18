package collection.part.two;

public class Client {
	
	public static void main(String[] args) {
		ActionCommand act = new ActionCommand();
		act.setCommand(Action.SAVE);
		act.pressButton();
		act.setCommand(Action.EDIT);
		act.pressButton();
		act.setCommand(Action.SEND);
		act.pressButton();
		act.setCommand(Action.UNDO);
		act.pressButton();
	}
}
