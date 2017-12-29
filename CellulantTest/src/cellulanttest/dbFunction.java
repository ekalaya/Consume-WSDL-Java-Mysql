package cellulanttest;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author Ernest
 * 
 * NAME: dbFuntion Class
 * 
 * Description: Database operation will be handled within this class
 * 
 * List Of Methods:
 * 
 * 1) UpdateTable
 *      Updating The practical Table 
 * 
 * 
 */
public class dbFunction 
{
    public void UpdateTable(int LengthID,Double Kilometers)
    {
        
     //Start Creating Objects of classes
        WriteLog writeLogObject=new WriteLog();
        
       //Start Creating Objects of classes and connect
	ConnectionManager mysqlConnect=new ConnectionManager();
	Connection connection=mysqlConnect.connect();
	PreparedStatement ps=null;
	try 
        {
		String query="update practical set Kilometers=?,DateModified=now() where LengthID=?";
		ps=connection.prepareStatement(query);
		ps.setDouble(1, Kilometers);
                ps.setInt(2, LengthID);
		
		ps.executeUpdate();
	} 
        catch (Exception ex) 
        {
		 ex.printStackTrace();
            //Write to log
            writeLogObject.LogNow("Error:" +  ex.getMessage() , "severe"); 
	}
}
}
