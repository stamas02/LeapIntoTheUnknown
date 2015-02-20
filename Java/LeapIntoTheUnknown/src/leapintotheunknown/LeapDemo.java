/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leapintotheunknown;

import com.leapmotion.leap.*;

/**
 *
 * @author Nick
 */

class LeapDemoListener extends Listener {
    
    int lastHands = 0;
    
    public void onConnect(Controller controller) {
        System.out.println("Connected");
    }
    
    public void onFrame(Controller controller) {
        
        // Get the frame
        Frame frame = controller.frame();
        
        // Check how many hands the Leap Motion can see
        int frameHands = frame.hands().count();
        
        // If this has changed...
        if (frameHands != this.lastHands) {
            
            // Keep track of the number of hands
            this.lastHands = frameHands;
            
            // Format a nice string
            String handsString = "";
            if (frameHands == 0) handsString = "Look no hands!";
            if (frameHands == 1) handsString = "Look 1 hand";
            if (frameHands >= 2) handsString = "Look " + Integer.toString(frameHands) + " hands";
            
            System.out.println(handsString);
            
        }
        
    }
    
}

public class LeapDemo {
    
    Controller leapController;
    LeapDemoListener leapDemoListener;
    
    public LeapDemo() {
        
        // Constructor fires up a listener and adds it to a controller
        this.leapDemoListener = new LeapDemoListener();
        this.leapController = new Controller();
        this.leapController.addListener(leapDemoListener);
        
    }
    
    public void unleap() {
        // Remove the listener from the controller
        this.leapController.removeListener(this.leapDemoListener);
    }
    
}
