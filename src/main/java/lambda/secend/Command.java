package lambda.secend;

import java.util.Scanner;

/**Implement pattern Command. Each command has its name (with which it is invoked) and one string argument. 
 * You should implement 4 commands with next ways: command as lambda function, as method reference, 
 * as anonymous class, as object of command class. User enters command name and argument into console, 
 * your app invokes corresponding command.
 */

public class Command {
	MyFanctional myLambda = (s) -> System.out.println("Lambda approach(First approach): " + s);

	public void first(String str) {
		myLambda.perform(str);
	}

	public void perform(String str) {
		System.out.println("Method reference(Second approach): " + str);
	}

	interface MyFanctional{
		void perform(String str);
	}

	public void anonymPerform(String str) {
		MyFanctional myF = new MyFanctional() {
			public void perform(String str) {
				System.out.println("Third approach." + str);
			}
		};
		myF.perform("string");
	}

	public static void main(String[] args) {
		Command command = new Command();
		try(Scanner scanner = new Scanner(System.in)){
			String action = scanner.next();
			String str = scanner.next();
			switch(action){
			case "1" : command.first(str);
			break;
			case "2" : command.perform(str);
			break;
			case "3" : command.anonymPerform(str);
			break;
			}
		}

	}
}
