
import java.util.*;

/**
 *
 * @author nolen
 */
public class MainMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            
            System.out.println("FAB'TASK");

		Integer choice;
		do {
                        System.out.println("1. Sign In");
			System.out.println("2. Sign Up");
                        System.out.println("3. Guest");
			System.out.println("> Press 0 to exit..\n");                        
			choice = getInteger("Enter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
		} 
		while (choice == null || choice < 0 || choice > 3);
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("mainMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "signin.gui";	break;
                case 2: operationName = "signup.gui";	break;
                case 3: operationName = "";	break;
		default: return new ViewData(null, null);
		}
		
                if(choice == 3 ) 
                    return new ViewData("GuestMenu", operationName, new HashMap<>());
                else
                    return new ViewData("UserAccount", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Main Menu View";
	}
    
}
