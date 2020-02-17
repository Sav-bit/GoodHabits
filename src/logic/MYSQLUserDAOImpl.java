package logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
/**
 * Implementazione dell'interfaccia CustomerDAO per il database MySQL.
 */
public class MYSQLUserDAOImpl implements UserDAO {
	
	/** La query per l'inserimento di un nuovo cliente */
    private static final String INSERT_USER = "INSERT INTO user (username, password, status, nome, cognome, data_nascita, email) VALUES (?,?,\"normal\",NULL,NULL,NULL,?)";
    /** La query per la lettura di un singolo cliente. */
    private static final String READ_QUERY = "SELECT id, first_name, last_name, email, password FROM customers WHERE id = ?";
    /** La query per la lettura di tutti i clienti. */
    private static final String READ_ALL_QUERY = "SELECT id, first_name, last_name, email, password FROM customers";
    /** La query per l'aggiornamento di un singolo cliente. */
    private static final String UPDATE_QUERY = "UPDATE customers SET first_name=? , last_name=? WHERE id = ?";
    /** La query per la cancellazione di un singolo cliente. */
    private static final String DELETE_QUERY = "DELETE FROM customers WHERE id = ?";
    private static final String CHECK_USER ="SELECT status from user where username=? and password=?";
 
	public List<User> getAllCustomers() {
 
		List<User> customers = new ArrayList<User>();
		User customer = null;
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MYSQLDAOFactory.createConnection();            
            preparedStatement = conn.prepareStatement(READ_ALL_QUERY);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            while (result.next()) {            	
            	customer = new User(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
            	customers.add(customer);
            	
            }     
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	
            try {
                result.close();
            } catch (SQLException rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException cse) {
                cse.printStackTrace();
            }
        }
        
        return customers;
	}
 
	public User getCustomer(int id) {
		
		User customer= null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MYSQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(READ_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            result = preparedStatement.getResultSet();
 
            if (result.next() && result != null) {
                customer = new User(result.getInt(1), result.getString(2), result.getString(3),result.getString(4),result.getString(5),result.getString(6));
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (SQLException rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException cse) {
                cse.printStackTrace();
            }
        }
 
        return customer;
	}
	
	
		
 
	public boolean updateCustomer(User customer) {
		
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
        	conn = MYSQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(UPDATE_QUERY);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setInt(3, customer.getId());
            
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException cse) {
                cse.printStackTrace();
            }
        }
        return false;
	}
 
	public boolean deleteCustomer(User customer) {
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = MYSQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(DELETE_QUERY);
            preparedStatement.setInt(1, customer.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (Exception cse) {
                cse.printStackTrace();
            }
        }
        return false;
	}
	
	public static boolean checkUser(String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MYSQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(CHECK_USER);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,  password);
            result = preparedStatement.executeQuery();
            
            if(result.last()) {
            	return true;
            }else {
            	return false;
            }
 
            //return result != null;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                result.close();
            } catch (SQLException rse) {
                rse.printStackTrace();
            }
            try {
                preparedStatement.close();
            } catch (SQLException sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException cse) {
                cse.printStackTrace();
            }
	}
		return false;
 
}
	
	public static boolean insertUser(String username, String password, String email) {
		 
		Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            conn = MYSQLDAOFactory.createConnection();
            preparedStatement = conn.prepareStatement(INSERT_USER);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,  password);
            preparedStatement.setString(3,  email);
            //result = preparedStatement.executeQuery();
            int count = preparedStatement.executeUpdate();
            if(count>0) {
            	return true;
            }else {
            	return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            
            try {
                preparedStatement.close();
            } catch (SQLException sse) {
                sse.printStackTrace();
            }
            try {
                conn.close();
            } catch (SQLException cse) {
                cse.printStackTrace();
            }
	}
		return false;
	}
	
	
}