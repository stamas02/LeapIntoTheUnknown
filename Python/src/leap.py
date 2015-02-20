import os, sys, inspect, thread, time
src_dir = os.path.dirname(inspect.getfile(inspect.currentframe()))
lib_dir = os.path.abspath(os.path.join(src_dir, '../lib'))
sys.path.insert(0, lib_dir)
import Leap


# DemoListener class

class DemoListener(Leap.Listener):

    lasthands = 0

    def on_connect(self, controller) :
        print "Connected"

    def on_frame(self, controller) :

        # get the frame
        frame = controller.frame()

        # get the number of hands visible to the Leap Motion
        hands = len(frame.hands)

        if hands != self.lasthands:

            #print "hand was: " + `self.lasthands` + " is now " + `hands`

            # keep track of number of hands
            self.lasthands = hands

            # format a string
            handsString = ""
            if hands == 0: handsString = "look no hands"
            if hands == 1: handsString = "look 1 hand"
            if hands == 2: handsString = "look " + `hands` + " hands"

            print handsString

# end of DemoListener class

def no_operation():
    # i'm not saying this is elegant
    a = 1 + 1

# create a controller and a listener
listener = DemoListener()
controller = Leap.Controller()

# add the listener to the controller
controller.add_listener(listener);

# infinite loop
while (1 < 2) :
    no_operation()
