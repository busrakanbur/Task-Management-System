
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

        do {
            // Model, View, and Controller
            Controller controller = router.get(viewData.functionName);
            ModelData modelData = controller.executeModel(viewData);
            viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);

            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
        
        } while (viewData.functionName != null); //8 quit

        /*
                if(viewData.functionName != "signin.gui"){ //bu kısım çalışmıyor bile, kimse signin e bakmıyor
                    //şu an signupta menu view değişiyor sadece
                    
                    do {
                            // Model, View, and Controller
                            Controller controller = router.get(viewData.functionName);
                            ModelData modelData = controller.executeModel(viewData);
                            viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);

                            System.out.println();
                            System.out.println("-------------------------------------------------");
                            System.out.println();
                    }
                    while (viewData.functionName != "signin.gui"); //bu kısım hiçbir işe yaramıyor herhalde
                    //yarıyormuş, bunu null yapınca, main menu açılıyor quit diyorum, manager menuye gidiyor orda da quit demem gerekiyor.
                    //bir de manager menuye gidersem 7 diyip, ordan ilk denemede quitle çıkamıyorum, bir de delete her şeyi siliyor onu anlamadım
                    
                
                    do {
                            // Model, View, and Controller
                            Controller controller = router.get(viewData2.functionName);
                            ModelData modelData = controller.executeModel(viewData2);
                            viewData2 = controller.getView(modelData, viewData2.functionName, viewData2.operationName);

                            System.out.println();
                            System.out.println("-------------------------------------------------");
                            System.out.println();
                    }
                    while (viewData2.functionName != null);
                    }
                
                else{
                    do {
			// Model, View, and Controller
			Controller controller = router.get(viewData2.functionName);
			ModelData modelData = controller.executeModel(viewData2);
			viewData2 = controller.getView(modelData, viewData2.functionName, viewData2.operationName);
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println();
                    }
                    while (viewData2.functionName != null);
                    }
         */
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
