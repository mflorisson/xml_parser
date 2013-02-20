/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bench;

import com.ximpleware.AutoPilot;
import com.ximpleware.VTDGen;
import com.ximpleware.VTDNav;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author marc
 */
public class AppVTDTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppVTDTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppVTDTest.class );
    }

    /**
     * Rigourous Test :-)
     */
//    public void testApp()
//    {
//        try {
//            int vehicleNb = 0;
//
//            VTDGen vg = new VTDGen();
//            int i;
//            AutoPilot ap = new AutoPilot();
//            ap.selectXPath("/respPTLineStructTimetable/VehicleJourney");
//            AutoPilot ap2 = new AutoPilot();
//            ap2.selectXPath("vehicleJourneyAtStop/*");
//            if (vg.parseFile("src/main/resources/AMIV_S_014014038.xml", false))
//            {
//                VTDNav vn = vg.getNav();
//                ap.bind(vn);
//                ap2.bind(vn);
//                //XPath eval returns one node at a time
//                while ((i = ap.evalXPath()) != -1)
//                {
//                    System.out.println("i = "+i);
//
//                    vn.push();
//                    // get to the first child 
//                    int j;
//                    while ((j = ap2.evalXPath()) != -1)
//                    {
//                        System.out.println("j = "+j);
//                        System.out.println(" text node ==>" + vn.toString(j));
//
//                        vn.toElement(VTDNav.FIRST_CHILD,"stopPointId");
//                        int pos = vn.getText();
//                        System.out.println("stopPointId = "+vn.toNormalizedString(pos));
//
//                        vn.toElement(VTDNav.NEXT_SIBLING,"arrivalTime");
//                        pos = vn.getText();
//                        System.out.println("arrivalTime = "+vn.toNormalizedString(pos));
//
//                        vn.toElement(VTDNav.NEXT_SIBLING,"order");
//                        pos = vn.getText();
//                        System.out.println("order = "+vn.toNormalizedString(pos));
//                        
//                        vehicleNb += 1;
//                        //System.out.println(" text node ==>" + vn.toString(j));
//                    }
//                    // doesn't forget this since the next iteration will reuse
//                    // ap2's XPath!!! 
//                    ap2.resetXPath();
//                    vn.pop();
//                }
//                ap.resetXPath();
//            }            
//            System.out.println("vehicles = "+vehicleNb);
//            
//        } catch (Exception ex) {
//            Logger.getLogger(AppVTDTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

    /**
     * Rigourous Test :-)
     */
    public void testCompany()
    {
//        try {
//            int vehicleNb = 0;
//
//            VTDGen vg = new VTDGen();
//            int i;
//            AutoPilot ap = new AutoPilot();
//            ap.selectXPath("/respPTLineStructTimetable");
//            AutoPilot ap2 = new AutoPilot();
//            ap2.selectXPath("Company");
//            AutoPilot ap3 = new AutoPilot();
//            ap3.selectXPath("*/registrationNumber");
//            if (vg.parseFile("src/main/resources/AMIV_S_014014038.xml", false))
//            {
//                VTDNav vn = vg.getNav();
//                ap.bind(vn);
//                ap2.bind(vn);
//                ap3.bind(vn);
//                //XPath eval returns one node at a time
//                while ((i = ap.evalXPath()) != -1)
//                {
//                    System.out.println("i = "+i);
//
//                    vn.push();
//                    // get to the first child 
//                    int j;
//                    while ((j = ap2.evalXPath()) != -1)
//                    {
//                        System.out.println("j = "+j);
//                        System.out.println("text node ==>" + vn.toString(j));
//                        
//                        
//                        vn.push();
//                        int k;
//                        while ((k = ap3.evalXPath()) != -1)
//                        {
//                            System.out.println("k = "+k);
//                            System.out.println("text node ==>" + vn.toString(k));
//                            int pos = vn.getText();
//                            System.out.println("registrationNumber = "+vn.toNormalizedString(pos));
//                        }
//                        ap3.resetXPath();
//                        vn.pop();
//                        
//
//                        vn.toElement(VTDNav.FIRST_CHILD,"name");
//                        int pos = vn.getText();
//                        System.out.println("name = "+vn.toNormalizedString(pos));
//                        vn.toElement(VTDNav.PARENT);
////                        
//                        //System.out.println(" text node ==>" + vn.toString(j));
//                    }
//                    // doesn't forget this since the next iteration will reuse
//                    // ap2's XPath!!! 
//                    ap2.resetXPath();
//                    vn.pop();
//                }
//                ap.resetXPath();
//            }            
//            
//        } catch (Exception ex) {
//            Logger.getLogger(AppVTDTest.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }


    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        try {
            int vehicleNb = 0;

            VTDGen vg = new VTDGen();
            int i;
            AutoPilot ap = new AutoPilot();
            ap.selectXPath("/respPTLineStructTimetable/VehicleJourney");
            AutoPilot ap2 = new AutoPilot();
            ap2.selectXPath("*/stopPointId");
            if (vg.parseFile("src/main/resources/RATP_S_100110004_stif.xml", false))
            {
                VTDNav vn = vg.getNav();
                ap.bind(vn);
                ap2.bind(vn);
                //XPath eval returns one node at a time
                while ((i = ap.evalXPath()) != -1)
                {
                    //System.out.println("i = "+i);

                    vn.push();
                    // get to the first child 
                    int j;
                    while ((j = ap2.evalXPath()) != -1)
                    {
//                        System.out.println("j = "+j);
//                        System.out.println("text node ==>" + vn.toString(j));
//
//                        System.out.println("stopPointId = "+vn.getText());
//                        
//                        vn.toElement(VTDNav.NEXT_SIBLING,"order");
//                        int pos = vn.getText();
//                        System.out.println("order = "+vn.toNormalizedString(pos));
//                        
//                        vn.toElement(VTDNav.NEXT_SIBLING,"arrivalTime");
//                        pos = vn.getText();
//                        System.out.println("arrivalTime = "+vn.toNormalizedString(pos));
                        
                        vehicleNb += 1;
                        //System.out.println(" text node ==>" + vn.toString(j));
                    }
                    // doesn't forget this since the next iteration will reuse
                    // ap2's XPath!!! 
                    ap2.resetXPath();
                    vn.pop();
                }
                ap.resetXPath();
            }            
            System.out.println("vehicles = "+vehicleNb);
            
        } catch (Exception ex) {
            Logger.getLogger(AppVTDTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
