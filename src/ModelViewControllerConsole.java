
import java.util.*;

public class ModelViewControllerConsole {

    public static void main(String[] args) throws Exception {
        // Connect to database
        connectToDatabase();

        // Model View Controller (MVC)
        // Router knows all the controllers
        Map<String, Controller> router = new HashMap<>(); //*** sonra bak
        router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
        router.put("UserAccount", new Controller(new UserAccountView(), new UserAccountModel()));

       router.put("ManagerLoginMenu", new Controller(new ManagerLoginMenuView(), new NopModel()));
        router.put("Manager", new Controller(new ManagerView(), new ManagerModel()));
        
        router.put("EmployeeLoginMenu", new Controller(new EmployeeLoginMenuView(), new NopModel()));
        router.put("Employee", new Controller(new EmployeeView(), new EmployeeModel()));

        ViewData viewData = new ViewData("MainMenu", "");
        
        do {
            // Model, View, and Controller
            Controller controller = router.get(viewData.functionName);
            ModelData modelData = controller.executeModel(viewData);
            viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);

        } while (viewData.functionName != null); //8 quit       
        
        System.out.println();
        System.out.println();
        System.out.println("Program is ended...");

        // Disconnect from database
        disconnectFromDatabase();
    }

    public static void connectToDatabase() {
        DatabaseUtilities.host = "localhost:49669";
        DatabaseUtilities.databaseName = "Project2";

        try {
            DatabaseUtilities.getConnection();
        } catch (Exception e) {
            System.out.println("Exception occured : " + e);
            return;
        }
    }

    public static void disconnectFromDatabase() {
        try {
            DatabaseUtilities.disconnect();
        } catch (Exception e) {
            System.out.println("Error disconnecting from database : " + e);
            return;
        }
    }

}
