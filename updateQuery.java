package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class updateStudentController {

	  public static void main(String[]args) {

		  // step-1 load/register driver

		  Connection connection =null;

		  try {

			  Driver driver = new Driver();

			  DriverManager.registerDriver(driver);
        
			  // create connection

			  String url=("jdbc:mysql://localhost:3306/view");

			  String user= "root";

			  String pass="root";
        
			  connection = DriverManager.getConnection(url, user, pass);
        
			  // create statement

			  Statement statement = connection.createStatement();

			  // execute query 

			  String updateQuery= "update student set name='prashant' WHERE ID=105";

			  int id=statement.executeUpdate(updateQuery);
        
			  if(id==1) {

				  System.out.println("Data.... updated...");

				  }

			  else {

				  System.err.println("Id is not found");

			  }
		  }
		  catch(SQLException e){

			  e.printStackTrace();

		  } finally {

			  try {
				  connection.close();
			  }
			  catch(SQLException e){

				  e.printStackTrace();
			  }
		  }
	  }
}
