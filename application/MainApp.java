package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import application.models.Product;
import application.views.InventaryController;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Product> inventaryData = FXCollections.observableArrayList();

    /**
    * Constructor
    */
    public MainApp(){
      inventaryData.add(new Product("C-001", "Toalla", "Limpieza profunda", "cm", 20, 20));
      inventaryData.add(new Product("C-002", "Detergente", "Limpieza profunda", "cm", 20, 20));
      inventaryData.add(new Product("C-003", "Jabón", "Limpieza profunda", "cm", 20, 20));
    }

    /**
    * Returns the data as an observable list of Persons.
    * return
    */
    public ObservableList<Product> getInventaryData() {
        return inventaryData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BeliceApp");

        initRootLayout();

        showInventary();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("./views/root.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the inventary inside the root layout.
     */
    public void showInventary() {
        try {
            // Load inventary overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("./views/inventary.fxml"));
            AnchorPane inventary = (AnchorPane) loader.load();

            // Set inventary overview into the center of root layout.
            rootLayout.setCenter(inventary);

            // Give the controller access to the main app.
            InventaryController controller = loader.getController();
            controller.setMainApp(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
