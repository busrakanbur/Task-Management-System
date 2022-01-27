
import java.util.*;

/**
 *
 * @author nolen
 */
public class MainMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            
            System.out.println("WELCOME TO FAB'TASK!");
            System.out.println("task management system console application");
            System.out.println("------------------------------------------");

		Integer choice;
		do {    System.out.println("1. Sign In");
                        System.out.println("2. Sign Up");
			System.out.println("3. Quit");
			System.out.println();

			choice = getInteger("Enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 9);
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("mainMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "signin.gui";	break;
                case 2: operationName = "signup.gui";	break;
                default: return new ViewData(null, null);
		}
		
		return new ViewData("UserAccount", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Main Menu View";
	}
    
}
