package ch.jassapp.gui;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Load" );
        
        JassAppStarter start = new JassAppStarter("jassapp.config");
        
        start.start();

    }
}
