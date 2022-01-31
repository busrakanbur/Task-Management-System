
import java.util.*;
/**
 *
 * @author nolen
 */
public class TeamMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            

		Integer choice;
		do {    System.out.println("-------------------------------------------------------------------");
                        System.out.println("\n1. Show all teams");
                        System.out.println("2. Add team");
                        System.out.println("3. Remove team");
                        System.out.println("\n> Press 0 to return...");

			choice = getInteger("\nEnter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
		} 
		while (choice == null || choice < 0 || choice > 3); //sayıyı değiştir duruma göre
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("teamMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";               break;
		case 2: operationName = "insert.gui";           break;
		case 3: operationName = "delete.gui";           break;
		default: return new ViewData("TeamMenu", "");
		}
		
		return new ViewData("Team", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Team Menu View";
	}
}
