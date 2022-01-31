
import java.util.*;
/**
 *
 * @author nolen
 */
public class GuestMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {    System.out.println("-------------------------------- G --------------------------------");
                        System.out.println("\n              You don't have any permission :(");
                        System.out.println("            Good news ! You can see the employee list.");
                        System.out.println("\nPress 1 to list employees");
                        
                        System.out.println("\n> press 0 to return...");

			choice = getInteger("\nEnter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
		} 
		while (choice == null || choice < 0 || choice > 5); //sayıyı değiştir duruma göre		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("projectMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";               break;
		default: return new ViewData("MainMenu", "");
		}
		
		return new ViewData("UserAccount", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Guest Menu View";
	}
}
