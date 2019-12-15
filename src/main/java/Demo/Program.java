package Demo;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class Program
{
    public static void main(String[] args) throws LifecycleException{
        runTomcatWebMvc(); /*This Web Mvc view Renderer Works !!!*/
        while (true);

    }
    /*Tomcat Embedded v.9.0.29*/

    private static void runTomcatWebMvc() throws  LifecycleException {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        String webappDir = new File("web/").getAbsolutePath();

        Context rootCtx = tomcat.addContext("",webappDir);
        rootCtx.setName("root");

        rootCtx.addLifecycleListener(new Tomcat.DefaultWebXmlListener());
        rootCtx.addWelcomeFile("/templates/iot-home.html");
        Wrapper sw = rootCtx.createWrapper();
        rootCtx.addChild(sw);
        sw.setServletClass("org.springframework.web.servlet.DispatcherServlet");
        sw.setName("iot");
        sw.addMapping("/service/*");
        sw.setLoadOnStartup(1);

        tomcat.getConnector();
        tomcat.start();
    }

}
