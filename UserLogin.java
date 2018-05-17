import java.sql.*;

public class UserLogin{
	public static void main(String[] args){
		String uName = args[0];
		String password = args[1];
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/olee","jovi_siddharth","olee311215"
				);
			Statement stmt = con.createStatement();
			ResultSet result = stmt.executeQuery("select name,password from user where name = \""+uName+"\"");
			if (result.next()){
				if(result.getString("password").equals(password)){ 
					System.out.println("true");
				}else{
					System.out.println("false");
				}
			}else{
				System.out.println("user doesnot exist");
			}
		}catch(Exception e){
			System.out.println(e);
		}
	}
}