import junit.framework.JUnit4TestCaseFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class logTest {
    private  static Logger logger = LoggerFactory.getLogger(logTest.class);
    @Test
    public void printLog(){


        logger.info("xxxxxxxxxxxxxxxxxxxxxxxx11");
        logger.error("xxxxxxxxxxxxxxxxxxxx");
        logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    }
}
