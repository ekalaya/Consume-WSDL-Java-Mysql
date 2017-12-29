package cellulanttest;

/**
 *
 * @author Ernest
 *  NAME: Calculations
 * 
 * Description: Class that connects to THE WSDL proxy class
 * 
 * List Of Methods:
 * 1) ConvertData
 */
public class Calculations 
{
  public Double ConvertData(Double lengthValue) 
    {
        //Start Creating Objects of classes
       WriteLog writeLogObject=new WriteLog();
       
       Double Result=0.0; 
try
{
    // Call Web Service 
   
    net.webservicex.LengthUnit service = new net.webservicex.LengthUnit();
    net.webservicex.LengthUnitSoap port = service.getLengthUnitSoap();
    
    // initialize arguments here
    net.webservicex.Lengths fromLengthUnit = net.webservicex.Lengths.MILES;
    net.webservicex.Lengths toLengthUnit = net.webservicex.Lengths.KILOMETERS ;
    // Get Response
    
     Result= port.changeLengthUnit(lengthValue, fromLengthUnit, toLengthUnit);
}
catch (Exception ex)
{
    ex.printStackTrace();
     //Write to log
    writeLogObject.LogNow("Error:" +  ex.getMessage() , "severe"); 
    //  handle exceptions 
}
return Result;
  }
}
