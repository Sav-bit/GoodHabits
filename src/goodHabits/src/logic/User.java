package logic;


	public class User {
		 
		/** L'id del record */
		private int id;
		/** Il nome del cliente */
		private String firstName;
		/** Il cognome del cliente */
		private String lastName;
		
		private String password;
		private String email;
		private String username;
			
		public User(int id, String firstName, String lastName, String email, String password, String username) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.password = password;
			this.username = username;
		}
		
		
		/**
	     * @return l'id del cliente
	     */
		public int getId() {
			return id;
		}
	 
		/**
	     * @param id
	     *            l'id del cliente da impostare
	     */
		public void setId(int id) {
			this.id = id;
		}
	 
		/**
	     * @return il nome del cliente
	     */
		public String getFirstName() {
			return firstName;
		}
	 
		/**
	     * @param firstName
	     *            il nome del cliente da impostare
	     */
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
	 
		/**
	     * @return il nome del cliente
	     */
		public String getLastName() {
			return lastName;
		}
	 
		/**
	     * @param lastName
	     *            il cognome del cliente da impostare
	     */
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		
		public void setPassword(String password) {
			
			this.password = password;
		}
		public  String getPassword() {
			return password;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		public String getEmail() {
			return email;
		}
		
		
	}

