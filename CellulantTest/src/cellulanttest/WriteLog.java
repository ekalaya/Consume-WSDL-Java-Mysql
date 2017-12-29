package cellulanttest;

/**
 *
 * @author Ernest
 * 
 * * @author Ernest
 *  NAME: WriteLog
 * 
 * Description: Class that writes activity
 * 
 * List Of Methods:
 * 1) LogNow
 */
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class WriteLog {
	
	public void LogNow(String Log,String LogType) 
        {
            try
                {               
            boolean append = true;
            //Creating Log File
	    FileHandler handler = new FileHandler("default.log", append);
	    Logger logger = Logger.getLogger(Log);
	    logger.addHandler(handler);
            
            // Log type description
	    if (LogType=="severe")
            {
	    logger.severe(Log);
            }
            else if (LogType=="warning")
            {
             logger.warning(Log);
            }
            else
            {
            logger.info(Log);
            }
		}
 
        catch (Exception ex)
        {
  
    ex.printStackTrace();
         } 
        }
}