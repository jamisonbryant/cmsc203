/** This class demonstrates the Television class*/

import java.util.Scanner;

public class TelevisionDemo
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);  // Input scanner
        int channel;                                // Chosen channel

        // Declare new Television object
        Television bigScreen = new Television("Toshiba", 55);
        
        // Power on television
        bigScreen.power();
        
        // Display television information
        System.out.println("A " + bigScreen.getScreenSize() + " inch " +
            bigScreen.getManufacturer()     + " has been turned on.");

        // Prompt user for channel to switch to
        System.out.print("What channel do you want? ");
        channel = keyboard.nextInt();

        // Change channel
        bigScreen.setChannel(channel);
        
        // Increase volume
        bigScreen.increaseVolume();
        
        // Display current channel and volume
        System.out.println("Channel: " + bigScreen.getChannel() +
            "  Volume:  "  + bigScreen.getVolume());
        System.out.println("Too loud! I am lowering the volume.");
        
        // Decrease volume
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();
        bigScreen.decreaseVolume();
        
        // Display current channel and volume
        System.out.println("Channel: " + bigScreen.getChannel() +
            "  Volume: "  + bigScreen.getVolume());
        System.out.println();

        /*************************************
         * TASK #5 BEGINS HERE
         ************************************/
        // Create new Television object
        Television portable = new Television("Sharp", 19);
        portable.setPowerState(Television.ON);  // Could also use portable.power();
        
        // Display television information
        System.out.println("A " + portable.getScreenSize() + " inch " +
            portable.getManufacturer()      + " has been turned on.");
        
        // Prompt user for channel to switch to
        boolean valid = false;
        
        do {
            System.out.print("What channel do you want? ");
            channel = keyboard.nextInt();
            
            if(channel < 0) {
            	System.err.println("Invalid channel. Please enter another channel.");
            } else {
            	valid = true;
            }
        } while(!valid);
        
        // Update TV settings
        portable.setChannel(channel);
        portable.setVolume(portable.getVolume() - 2);
        
        // Display current channel and volume
        System.out.println("Channel: " + portable.getChannel() +
            "  Volume: "  + portable.getVolume());
        System.out.println();
        
        // Close scanner resource
        keyboard.close();
    }
}
