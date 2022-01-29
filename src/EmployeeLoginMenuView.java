
import java.util.*;
/**
 *
 * @author nolen
 */
public class EmployeeLoginMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {
                        System.out.println("        EMPLOYEE ");
                        
                        System.out.println("1. Show all of my projects");
			System.out.println("2. Show a project");
                        System.out.println("3. Project status");
                        System.out.println("4. Quit");

			choice = getInteger("Enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 14); //sayıyı değiştir duruma göre
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("employeeLoginMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";               break;
		case 2: operationName = "select.gui";           break;
		case 3: operationName = "projectStatus.gui";	break;
		default: return new ViewData(null, null);
		}
		
		return new ViewData("Employee", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Employee Login Menu View";
	}
}
