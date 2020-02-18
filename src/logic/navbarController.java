import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class PleaseProvideControllerClassName {

  @FXML
  private Text navbarBrand;

  @FXML
  void logOut(ActionEvent event) throws Exception {
  	//return to login page

  	Parent logOut_parent = FXMLLoader.load(getClass().getResource("Login.fxml"));
  	Scene logOutViewScene = new Scene(logOut_parent);

  	Stage window = (Stage) myMenuBar.getScene().getWindow();

  	//Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();   no!!!!
  	window.setScene(logOutViewScene);
  	window.show();
  }
}
