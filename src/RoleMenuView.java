
import java.util.*;
/**
 *
 * @author nolen
 */
public class RoleMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {    System.out.println("-------------------------------------------------------------------");
                        System.out.println("\n1. Show all roles            3. Add a role");
                        System.out.println("2. Show a spesific roles     4. Remove a role");
                        
                        System.out.println("\n> press 0 to return...");

			choice = getInteger("\nEnter your choice : ", false);
                       
		} 
		while (choice == null || choice < 0 || choice > 4); //sayıyı değiştir duruma göre
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("roleMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";               break;
		case 2: operationName = "select.gui";           break;
		case 3: operationName = "insert.gui";           break;
		case 4: operationName = "delete.gui";           break;
		default: return new ViewData("ManagerLoginMenu", "");
		}
		
		return new ViewData("Role", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Role Menu View";
	}
}
