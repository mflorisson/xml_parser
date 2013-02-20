package bench;

import com.scireum.open.xml.NodeHandler;
import com.scireum.open.xml.StructuredNode;
import com.scireum.open.xml.XMLReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.xml.sax.SAXException;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
        private int vehicleNumber = 0;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        XMLReader r = new XMLReader();
        // We can add several handlers which are triggered for a given node
        // name. The complete sub-dom of this node is then parsed and made
        // available as a StructuredNode
        r.addHandler("VehicleJourney", new NodeHandler() {

            @Override
            public void process(StructuredNode node) {
                vehicleNumber = vehicleNumber + 1;
                try {
                    // We can now conveniently query the sub-dom of each node
                    // using XPATH:
                    String vehicleXML = null;
                    node.queryNodeList("vehicleJourneyAtStop/order").size();
                    
                    
                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            // Parse our little test file. Note, that this could be easily processed
            // with a DOM-parser and only serves as showcase. Real life input files
            // would be much bigger...
            System.out.println("appel parse");
            r.parse(new FileInputStream("src/main/resources/RATP_S_100110004_stif.xml"));
//            r.parse(new FileInputStream("src/main/resources/RATP_S_100110004_stif.xml"));
            System.out.println("appel parse fin, courses="+vehicleNumber);
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AppTest.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        assertTrue( true );
    }
}
