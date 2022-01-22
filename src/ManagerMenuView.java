import java.util.*;
/**
 *
 * @author nolen
 */
public class ManagerMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {
                        System.out.println("manager...");
                        System.out.println("1. Show all users");
			System.out.println("2. Show users");
			System.out.println("3. Add a user");
			System.out.println("4. Update a user");
			System.out.println("5. Delete a user");
                        
			System.out.println("8. Quit");

			choice = getInteger("Enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 9); //sayıyı değiştir duruma göre
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("managerMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";	break;
		case 2: operationName = "select.gui";	break;
		case 3: operationName = "insert.gui";	break;
		case 4: operationName = "update.gui";	break;
		case 5: operationName = "delete.gui";	break;
                case 6: operationName = "signin.gui";	break;
                case 7: operationName = "signup.gui";	break;
		default: return new ViewData(null, null);
		}
		
		return new ViewData("Department", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Maanager Menu View";
	}
}
