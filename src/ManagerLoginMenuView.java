
import java.util.*;
/**
 *
 * @author nolen
 */
public class ManagerLoginMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {
                        System.out.println("manager...");
                        
                        System.out.println("1. Show all of my projects");
			System.out.println("2. Show a project");
			System.out.println("3. Add a project");
			System.out.println("4. Update a project");
			System.out.println("5. Delete a project");
                        System.out.println("----------------------------");
                        System.out.println("6. Show all users");
			System.out.println("7. Show users");
			System.out.println("8. Add a user");
			System.out.println("9. Update a user");
			System.out.println("10. Delete a user");
                        System.out.println("11. Add user to a project");
                        System.out.println("12. Remove user from a project");
                        System.out.println("13. Quit");

			choice = getInteger("Enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 14); //sayıyı değiştir duruma göre
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("managerLoginMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";	break;
		case 2: operationName = "select.gui";	break;
		case 3: operationName = "insert.gui";	break;
		case 4: operationName = "update.gui";	break;
		case 5: operationName = "delete.gui";	break;
                case 6: operationName = "signin.gui";	break;
                case 7: operationName = "signup.gui";	break;
                case 8: operationName = "select";	break;
		case 9: operationName = "select.gui";	break;
		case 10: operationName = "insert.gui";	break;
		case 11: operationName = "update.gui";	break;
		case 12: operationName = "delete.gui";	break;
                default: return new ViewData(null, null);
		}
		
		return new ViewData("Manager", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Manager Login Menu View";
	}
}
