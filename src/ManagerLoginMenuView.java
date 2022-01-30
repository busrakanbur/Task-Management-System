
import java.util.*;
/**
 *
 * @author nolen
 */
public class ManagerLoginMenuView implements ViewInterface {
    
    @Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
            
                Integer choice;
		/*do {    System.out.println("\n-------------------------------- M --------------------------------");
                        System.out.println("         Project                            User ");
                        System.out.println("1. Show all of the projects         6.  Show all users");
			System.out.println("2. Show a spesific project          7.  Show a spesific user");
			System.out.println("3. Add project                      8.  Add user");
			System.out.println("4. Update project                   9.  Update user");
			System.out.println("5. Delete project                   10. Delete user");
                        System.out.println("                                    11. Add user to a project");
                        System.out.println("                                    12. Remove user from a project");
                        System.out.println("> Press 0 to exit..\n");

			choice = getInteger("Enter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
                } while (choice == null || choice < 0 || choice > 13); //sayıyı değiştir duruma göre
		
                switch (choice.intValue()) {
		case 1: operationName = "select";                       break;
		case 2: operationName = "select.gui";                   break;
		case 3: operationName = "insert.gui";                   break;
		case 4: operationName = "update.gui";                   break;
		case 5: operationName = "delete.gui";                   break;
                case 6: operationName = "select";                       break;
                case 7: operationName = "select.gui";                   break;
                case 8: operationName = "insert.gui";                   break;
		case 9: operationName = "update.gui";                   break;
		case 10: operationName = "delete.gui";                  break;
		case 11: operationName = "addUserToProject.gui";	break; //yeni
		case 12: operationName = "removeUserFromProject";	break; //yeni
		default: return new ViewData(null, null);
		}
		*/ 
                do {    System.out.println("\n-------------------------------- M --------------------------------");
                        System.out.println("         Project                            User ");
                        System.out.println("1. Show all of the projects         10. Show all users");
			System.out.println("2. Show a spesific project          11. Show a spesific user");
			System.out.println("3. Add project                      12. Add user");
			System.out.println("4. Update project                   13. Update user");
			System.out.println("5. Delete project                   14. Delete user");
                        System.out.println("6. Show all tasks                   15. Show all teams");
                        System.out.println("7. Show a spesific task             16. Show a spesific team");
                        System.out.println("8. Add task to a project            17. Add employee to a team");
                        System.out.println("9. Delete task from project         18. Remove employee from team");
                        System.out.println("                                    19. Add employee to a task");
                        System.out.println("                                    20. Remove employee from task");
                        System.out.println("> Press 0 to exit..\n");

			choice = getInteger("Enter your choice : ", false);
                        System.out.println("\n-------------------------------------------------------------------");
		}
		while (choice == null || choice < 0 || choice > 21); //sayıyı değiştir duruma göre
		
                switch (choice.intValue()) {
                //project
		case 1: operationName = "select";                break;
		case 2: operationName = "select.gui";            break;
		case 3: operationName = "insert.gui";            break;
		case 4: operationName = "update.gui";            break;
		case 5: operationName = "delete.gui";            break;
                //task
                case 6: operationName = "select";                 break;
                case 7: operationName = "select.gui";             break;
                case 8: operationName = "insert.gui";             break;
		case 9: operationName = "update.gui";             break;
                //user
		case 10: operationName = "select";                break;
		case 11: operationName = "select.gui";            break;
		case 12: operationName = "insert.gui";            break; 
		case 13: operationName = "update.gui";            break;
		case 14: operationName = "delete.gui";            break;
                //team
                case 15: operationName = "select";                break;
		case 16: operationName = "select.gui";            break;
		case 17: operationName = "insert.gui";            break; 
		case 18: operationName = "update.gui";            break;
                //project??
		case 19: operationName = "delete.gui";            break;
                case 20: operationName = "delete.gui";            break;
                
		default: return new ViewData(null, null);
		}
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("managerLoginMenuChoice", choice);
		
                
                if(choice >= 1 && choice<=5) {
                    return new ViewData("Project", operationName, new HashMap<>());
                }  
                else if(choice >= 6 && choice<=9) {
                    return new ViewData("Task", operationName, new HashMap<>());
                }
                else
                    return new ViewData("Manager", operationName, new HashMap<>());
		
	}

	@Override
	public String toString() {
		return "Manager Login Menu View";
	}
}
