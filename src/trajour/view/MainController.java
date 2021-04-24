package trajour.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import trajour.model.User;

public class MainController {
    @FXML
    private ImageView homePageButton;

    @FXML
    private ImageView mapPageButton;

    @FXML
    private Button discoveryPageButton;

    @FXML
    private ImageView profilePageButton;

    @FXML
    private TableView<?> futureJourneysTable;

    @FXML
    private TableView<?> pastJourneysTable;

    @FXML
    private Button shareJourneyButton;

    @FXML
    private Button achievementsButton;

    @FXML
    private Label welcomeMessage;

    private User currentUser;

    /**
     * Initializes the user of the session.
     * @param user Current user of the session
     */
    public void initData(User user) {
        currentUser = user;
        welcomeMessage.setText("Welcome to your main feed " + user.getUsername() + "!");
    }

    /**
     * Opens the profile page
     */
    @FXML
    public void openProfilePage(ActionEvent event) {
        try {
            // Get the parent and create the scene
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/trajour/view/fxml/profile.fxml"));
            Parent profilePageParent = loader.load();
            Scene profilePageScene = new Scene(profilePageParent, Main.APPLICATION_WIDTH, Main.APPLICATION_HEIGHT);

            // Get access to the main windows controller
            ProfileController profileWindowController = loader.getController();
            profileWindowController.initData(currentUser);

            // Get the stage and change the scene
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

            window.setScene(profilePageScene);
            window.show();
        }
        catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    /**
     * Opens the discovery page.
     */
    @FXML
    public void openDiscoveryPage(ActionEvent event) {

    }

    /**
     * Opens the home page.
     */
    @FXML
    public void openHomePage(ActionEvent event) {

    }

    /**
     * Opens map page.
     */
    @FXML
    public void openMapPage(ActionEvent event) {

    }
}