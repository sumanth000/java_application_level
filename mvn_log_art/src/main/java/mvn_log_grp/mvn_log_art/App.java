package mvn_log_grp.mvn_log_art;

/**
 * Hello world!
 *
 */
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class App 
{
	
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args )
    {
    	
    	  logger.info("This is an informational message.");
          logger.error("This is an error message.");
    }
}
