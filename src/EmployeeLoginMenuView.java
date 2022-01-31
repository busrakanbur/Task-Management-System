
import java.util.*;
/**
 *
 * @author nolen
 */
public class EmployeeLoginMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {    System.out.println("\n-------------------------------- E --------------------------------");                     
                        System.out.println("\n1. Show all of my tasks"
                                + "\n2. Show a task   \n3. Update task status");
                        System.out.println("\n> Press 0 to logout..\n");

			choice = getInteger("Enter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
		} 
		while (choice == null || choice < 0 || choice > 3); //sayıyı değiştir duruma göre
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("employeeLoginMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";               break;
		case 2: operationName = "select.gui";           break;
		case 3: operationName = "update.gui";	break;
		default: return new ViewData("MainMenu", null);
		}
		
		return new ViewData("Employee", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Employee Login Menu View";
	}
}
