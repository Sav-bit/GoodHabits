package logic;

import java.util.List;

/**
 * L'interfaccia DAO per le diverse implementazioni di CustomerDAO. Definisce le operazioni CRUD.
 */
public interface UserDAO {
 

	public static boolean checkUser(String username, String password) {
		 
		return true;
	}
	
	public static boolean insertUser(String username, String password, String email) {
		 
		return true;
	}
}