
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

        //main menu çağırıldıktan sonra, mainmenuview kısmında useraccount çağırılıyor!!!!!!!
        //return new ViewData("UserAccount", operationName, new HashMap<>()); şeklinde
        router.put("ManagerLoginMenu", new Controller(new ManagerLoginMenuView(), new NopModel()));
        router.put("Manager", new Controller(new ManagerView(), new ManagerModel()));

        ViewData viewData = new ViewData("MainMenu", "");
        ViewData viewData2 = new ViewData("ManagerLoginMenu", "");

        System.out.println("-" + viewData.functionName + "---" + viewData2.functionName);
        
        do {
            // Model, View, and Controller
            Controller controller = router.get(viewData.functionName);
            ModelData modelData = controller.executeModel(viewData);
            viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);

            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
            
            
            if(viewData.functionName == "signin.gui"){
                do {
                    // Model, View, and Controller
                    controller = router.get(viewData.functionName);
                    modelData = controller.executeModel(viewData);
                    viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);

                    System.out.println();
                    System.out.println("-------------------------------------------------");
                    System.out.println();

                System.out.println("-" + viewData.functionName + "---" + viewData2.functionName);

                } while (viewData.functionName != null);
            }


            
            //viewData.functionName = "select";
            //System.out.println("xxx");
            //System.out.println("-" + viewData.functionName + "---" + viewData2.functionName);

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
