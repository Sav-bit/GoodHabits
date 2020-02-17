package logic;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
    void Handler(ActionEvent event) throws Exception {
    	String myuser = username.getText();
		boolean Bool = myuser.equals("");
		String pass = password.getText();
		boolean BoolP = pass.equals("");
		
		// se tutti i campi sono stati compilati procedi
		if(Bool || BoolP ) {
			/*String pass = password.getText();
			*/
			
			if(Bool) 	
				fail.setText("Login failed: You need an email");
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
			else
				fail.setText("YEEEEEEEEEEEE");
		}
    }
}
