
import java.util.*;
/**
 *
 * @author nolen
 */
public class ProjectMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {    
                        System.out.println("\n1. Show all of the projects         4. Update project");
                        System.out.println("2. Show a spesific project          5. Delete project");
                        System.out.println("3. Add project");
                        
                        System.out.println("\n> press 0 to return...");

			choice = getInteger("\nEnter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
		} 
		while (choice == null || choice < 0 || choice > 5); //sayıyı değiştir duruma göre		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("projectMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";               break;
		case 2: operationName = "select.gui";           break;
		case 3: operationName = "insert.gui";           break;
		case 4: operationName = "update.gui";           break;
		default: return new ViewData("ManagerLoginMenu", "");
		}
		
		return new ViewData("Project", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Project Menu View";
	}
}
