package jdbcproject.dto;

public class UserTable {
        String name;
        String email;
        String password;
        int wallet;
        String gender;
        int age;
        int phno;
		public UserTable(String name, String email, String password, int wallet, String gender, int age,int phno) {
			super();
			this.name = name;
			this.email = email;
			this.password = password;
			this.wallet = wallet;
			this.gender = gender;
			this.age = age;
			this.phno = phno;
		}
		public UserTable() {
			
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public int getWallet() {
			return wallet;
		}
		public void setWallet(int wallet) {
			this.wallet = wallet;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public int getPhno() {
			return phno;
		}
		public void setPhno(int phno) {
			this.phno = phno;
		}
		@Override
		public String toString() {
			return "\n UserTable [name=" + name + ", email=" + email + ", password=" + password + ", wallet=" + wallet
					+ ", gender=" + gender + ", age=" + age + ", phno=" + phno + "]";
		}
        
}
