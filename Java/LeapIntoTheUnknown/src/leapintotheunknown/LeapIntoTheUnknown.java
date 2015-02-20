/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leapintotheunknown;

import java.io.IOException;

/**
 *
 * @author Nick
 */
public class LeapIntoTheUnknown {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create a demo instance
        LeapDemo leapDemo = new LeapDemo();
        
        // Keep going until enter
        System.out.println("Press ENTER to quit");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Spin down the demo instance
        leapDemo.unleap();
        
    }
    
}
