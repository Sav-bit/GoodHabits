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


public class RegisterController {
	
	@FXML
    private TextField username, email;
    
    @FXML
    private PasswordField password;

    @FXML
    private Button login_input;
    
    @FXML
    private Button register_input;
    
    @FXML
    private Label label_register;
    
   
    
    @FXML
    void register(ActionEvent event) throws Exception {
    	//confirm registration into db
    	
    	String myuser = username.getText();
		boolean Bool = myuser.equals("");
		String pass = password.getText();
		boolean BoolP = pass.equals("");
		String mail = email.getText();
		boolean BoolM = mail.contentEquals("");
		
		// se tutti i campi sono stati compilati procedi
		if(Bool || BoolP || BoolM) {
			/*String pass = password.getText();
			*/
			
			if(Bool) 	
				label_register.setText("Registration failed: You need an username");
			else if(BoolP)
				label_register.setText("Registration failed: You need a pass");
			else
				label_register.setText("Registration failed: You need an email");
		}
		else	{
			//get name and search in the database for the user
			String passmd5 = md5Generator.md5(pass);

			
			boolean c = MYSQLUserDAOImpl.insertUser(myuser, passmd5, mail);
			//boolean c = true;
			if(c) {
				Parent home_parent = FXMLLoader.load(getClass().getResource("home.fxml"));
		    	Scene registerViewScene = new Scene(home_parent);
		    	
		    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		    	window.setScene(registerViewScene);
		    	window.show();
			}else {
				label_register.setText("Qualcosa è andato storto");
			}
		}
			
    }
    
    @FXML
    void login(ActionEvent event) throws Exception {
    	//return to login page
    	Parent register_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
    	Scene registerViewScene = new Scene(register_parent);
    	
    	Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	window.setScene(registerViewScene);
    	window.show();
    }

}
