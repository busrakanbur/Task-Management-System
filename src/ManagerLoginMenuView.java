
import java.util.*;
/**
 *
 * @author nolen
 */
public class ManagerLoginMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            
                Integer choice;
		do {    System.out.println("\n-------------------------------- M --------------------------------");
                        System.out.println("\n1. User Operations              4. Team Member Operations");
                        System.out.println("2. Project Operations           5. Team Operations");
                        System.out.println("3. Task Operations              6. Role Operations");
                        
                        System.out.println("\n> Press 0 to logout..\n");

			choice = getInteger("Enter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
		}
		while (choice == null || choice < 0 || choice > 22); //sayıyı değiştir duruma göre
		
                switch (choice.intValue()) {
                //project
		case 1: operationName = "";   break;
		case 2: operationName = "";   break;
		case 3: operationName = "";   break;
		case 4: operationName = "";   break;
		case 5: operationName = "";   break;
                case 6: operationName = "";   break;
                
                default: return new ViewData("MainMenu", null);
		}
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("managerLoginMenuChoice", choice);
		
                
                if(choice == 1) {
                    return new ViewData("UserMenu", operationName, new HashMap<>());
                }
                else if(choice == 2) {
                    return new ViewData("ProjectMenu", operationName, new HashMap<>());
                }
                else if(choice == 3) {
                    return new ViewData("TaskMenu", operationName, new HashMap<>());
                }
                else if(choice == 4) {
                    return new ViewData("TeamMemberMenu", operationName, new HashMap<>());
                }
                else if(choice == 5) {
                    return new ViewData("TeamMenu", operationName, new HashMap<>());
                }
                else {
                    return new ViewData("RoleMenu", operationName, new HashMap<>());
                }
		
	}

	@Override
	public String toString() {
		return "Manager Login Menu View";
	}
}
