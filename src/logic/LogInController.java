package logic;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class LogInController {
	
	@FXML
    private TextField username;
    
    @FXML
    private PasswordField password;

    @FXML
    private Button login_input;
    
    @FXML
    private Button register_input;
    
    @FXML
    private Label fail;
    
    @FXML
    private Label label_register;
    


    @FXML
    void login(ActionEvent event) throws Exception {
    	label_register.setText("");
    	String myuser = username.getText();
		boolean Bool = myuser.equals("");
		String pass = password.getText();
		boolean BoolP = pass.equals("");
		
		// se tutti i campi sono stati compilati procedi
		if(Bool || BoolP ) {
			/*String pass = password.getText();
			*/
			
			if(Bool) 	
				fail.setText("Login failed: You need an username");
			else
				fail.setText("Login failed: You need a pass");
		}
		else	{
			//get name and search in the database for the user
			boolean c = MYSQLUserDAOImpl.checkUser(myuser, pass);
			//boolean c = true;
			if(c != true) {
				
					fail.setText("Login failed: Email not found");;
				
		   }
			else {
				Parent home_parent = FXMLLoader.load(getClass().getResource("home.fxml"));
		    	Scene registerViewScene = new Scene(home_parent);
		    	
		    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		    	window.setScene(registerViewScene);
		    	window.show();
			}
		}
    }
    
    @FXML
    void register(ActionEvent event) throws Exception {
    	fail.setText("");
    	label_register.setText("Insert email for registration");
    	
    	Parent register_parent = FXMLLoader.load(getClass().getResource("Register.fxml"));
    	Scene registerViewScene = new Scene(register_parent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(registerViewScene);
    	window.show();
    }
    
}
