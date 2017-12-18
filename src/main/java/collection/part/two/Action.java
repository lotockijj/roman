package collection.part.two;

public enum Action implements Command{

	SAVE(){
		public void execute() {
			System.out.println("Save.");
		}
	},
	SEND(){
		public void execute() {
			System.out.println("Send.");
		}
	},
	EDIT(){
		public void execute() {
			System.out.println("Edit.");
		}
	},
	UNDO(){
		public void execute() {
			System.out.println("Undo.");
		}
	}

}
