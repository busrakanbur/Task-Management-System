
import java.util.*;

public class ModelViewControllerConsole {

    public static void main(String[] args) throws Exception {
        // Connect to database
        connectToDatabase();

        // Model View Controller (MVC)
        // Router knows all the controllers
        Map<String, Controller> router = new HashMap<>(); //*** sonra bak
        Map<String, Controller> router2 = new HashMap<>();
        router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
        router.put("UserAccount", new Controller(new UserAccountView(), new UserAccountModel()));

        //main menu çağırıldıktan sonra, mainmenuview kısmında useraccount çağırılıyor!!!!!!!
        //return new ViewData("UserAccount", operationName, new HashMap<>()); şeklinde
        router2.put("ManagerLoginMenu", new Controller(new ManagerLoginMenuView(), new NopModel()));
        router2.put("Manager", new Controller(new ManagerView(), new ManagerModel()));

        ViewData viewData = new ViewData("MainMenu", "");
        ViewData viewData2 = new ViewData("ManagerLoginMenu", "");

        System.out.println("-" + viewData.functionName + "---" + viewData2.functionName);
        /*
        //düşün düşünnn
        //ilk başta giricek sisteme,
        //main menu çalışmaya başlıycak,
        sonra içeri girdi bir fonksiyon çağırdı, eğer managermenuye giderse
        */
        
        
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
                    Controller controller2 = router2.get(viewData2.functionName);
                    ModelData modelData2 = controller2.executeModel(viewData2);
                    viewData2 = controller2.getView(modelData2, viewData2.functionName, viewData2.operationName);

                    System.out.println();
                    System.out.println("-------------------------------------------------");
                    System.out.println();

                System.out.println("-" + viewData.functionName + "---" + viewData2.functionName);

                } while (viewData2.functionName != null);
            }


            
            //viewData.functionName = "select";
            //System.out.println("xxx");
            //System.out.println("-" + viewData.functionName + "---" + viewData2.functionName);

        } while (viewData.functionName != null); //8 quit

        do {
            // Model, View, and Controller
            Controller controller2 = router2.get(viewData2.functionName);
            ModelData modelData2 = controller2.executeModel(viewData2);
            viewData2 = controller2.getView(modelData2, viewData2.functionName, viewData2.operationName);

            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();

        System.out.println("-" + viewData.functionName + "---" + viewData2.functionName);

        } while (viewData2.functionName != null);
        
        
        System.out.println();
        System.out.println();
        System.out.println("Program is ended...");

        // Disconnect from database
        disconnectFromDatabase();
    }

    public static void connectToDatabase() {
        DatabaseUtilities.host = "localhost:49670";
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
