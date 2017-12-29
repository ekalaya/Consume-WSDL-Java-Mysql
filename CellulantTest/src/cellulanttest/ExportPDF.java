package cellulanttest;

import java.io.*;
import java.sql.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;


/**
 *
 * @author Ernest
 *  NAME: ExportPDF
 * 
 * Description: Class responsible for exporting MYSQL data to PDF
 * 
 * List Of Methods:
 * 1) Export
 * 
 */
public class ExportPDF {
  
   //Start Creating Objects of classes
    WriteLog writeLogObject=new WriteLog();
    ConnectionManager mysqlConnect = new ConnectionManager();
      
    public  void Export()
    {
    try
        {
       Document document=new Document() {};
       
       //File Path to write document make sure the path has full write permissions
       PdfWriter.getInstance(document,new FileOutputStream("C:/Cellulant/cellulant.pdf"));
       document.open();
       PdfPTable table=new PdfPTable(4);
       
       // Creating PDF columns
       table.addCell("LengthID");
       table.addCell("Miles");
       table.addCell("KiloMeters");
       table.addCell("DateModified");
       
       //get table data
  String sql = "SELECT * FROM `practical`";
  PreparedStatement statement = mysqlConnect.connect().prepareStatement(sql);
  ResultSet rs = statement.executeQuery();
  
	while (rs.next())
     {
           table.addCell(rs.getString("LengthID"));
           table.addCell(rs.getString("Miles"));
           table.addCell(rs.getString("KiloMeters"));
           table.addCell(rs.getString("DateModified"));
      }
        
       document.add(table);
       document.close();
       
       mysqlConnect.disconnect();
       }
        
    catch (Exception ex)
{
    ex.printStackTrace();
     //Write to log
     writeLogObject.LogNow("Error:" +  ex.getMessage() , "severe"); 
    //  handle exceptions 
}
   }

}
