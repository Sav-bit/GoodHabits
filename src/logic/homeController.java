package logic;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class homeController {
	
	 @FXML
	  private MenuButton menuButton;
	  
	  @FXML
	  private MenuItem logout_input;
    

    
	 	@FXML
	    void logOut(ActionEvent event) throws Exception {
	    	//return to login page
	 		
	    	Parent logOut_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
	    	Scene logOutViewScene = new Scene(logOut_parent);

	    	Stage window = (Stage) menuButton.getScene().getWindow();
	    	
	    	//Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();   
	    	window.setScene(logOutViewScene);
	    	window.show();
	    }
	
}
