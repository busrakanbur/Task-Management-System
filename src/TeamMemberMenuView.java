
import java.util.*;
/**
 *
 * @author nolen
 */
public class TeamMemberMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {    
                        System.out.println("\n1. Show all team members         3. Add team member");
                        System.out.println("2. Show a spesific team member   4. Remove team member");
                        
                        System.out.println("\n> press 0 to return...");

			choice = getInteger("\nEnter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
		} 
		while (choice == null || choice < 0 || choice > 4); //sayıyı değiştir duruma göre
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("teamMemberMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";               break;
		case 2: operationName = "select.gui";           break;
		case 3: operationName = "insert.gui";           break;
		case 4: operationName = "delete.gui";           break;
		default: return new ViewData("ManagerLoginMenu", "");
		}
		
		return new ViewData("TeamMember", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Team Member Menu View";
	}
}
