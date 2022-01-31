
import java.util.*;
/**
 *
 * @author nolen
 */
public class TaskMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {    
                        System.out.println("1. Show all tasks           4. Update task");
                        System.out.println("2. Show a spesific task     5. Delete task");
                        System.out.println("3. Add task");
                        // System.out.println("6. Add employee to a task");
                        //System.out.println("7. Remove employee from task");
                        System.out.println("\n> press 0 to return...");

			choice = getInteger("\nEnter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
		} 
		while (choice == null || choice < 0 || choice > 5); //sayıyı değiştir duruma göre
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("taskMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";               break;
		case 2: operationName = "select.gui";           break;
		case 3: operationName = "insert.gui";           break;
		case 4: operationName = "update.gui";           break;
		case 5: operationName = "delete.gui";           break;
		default: return new ViewData("ManagerLoginMenu", "");
		}
		
		return new ViewData("Task", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Task Menu View";
	}
}
