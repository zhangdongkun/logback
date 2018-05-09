import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.ConsoleAppender;
import ch.qos.logback.core.joran.spi.JoranException;
import ch.qos.logback.core.util.Loader;
import ch.qos.logback.core.util.StatusPrinter;
import junit.framework.JUnit4TestCaseFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class logTest {
    private  static Logger logger = LoggerFactory.getLogger(logTest.class);
    @Test
    public void printLog(){
        MDC.put("THREAD_ID", String.valueOf(Thread.currentThread().getId()));
        MDC.put("first", "zhang");
        MDC.put("first", "dongkun");

        logger.info("xxxxxxxxxxxxxxxxxxxxxxxx11");
        logger.error("xxxxxxxxxxxxxxxxxxxx");
        logger.debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");

    }

          static void programmaticConfiguration() {
                  // Configure logback
                  LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
                  loggerContext.reset();
                  PatternLayoutEncoder layout = new PatternLayoutEncoder();
                  layout.setContext(loggerContext);
                  layout.setPattern("%X{first} %X{last} - %m%n");
                  layout.start();
                  ConsoleAppender<ILoggingEvent> appender = new ConsoleAppender<ILoggingEvent>();
                  appender.setContext(loggerContext);
                  appender.setEncoder(layout);
                  appender.start();
                  // cast root logger to c.q.logback.classic.Logger so that we can attach
                  // an appender to it
                  ch.qos.logback.classic.Logger root = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger("root");
                  root.addAppender(appender);
              }


            static void configureViaXML_File() {
                  LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
                  try {
                          JoranConfigurator configurator = new JoranConfigurator();
                          configurator.setContext(lc);
                          lc.reset();
                          URL url = Loader.getResourceBySelfClassLoader("chapters/mdc/simpleMDC.xml");
                          configurator.doConfigure(url);
                      } catch (JoranException je) {
                          StatusPrinter.print(lc);
                      }
              }

}
