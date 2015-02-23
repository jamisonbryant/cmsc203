/**
 * A class that models a television to demonstrate object construction.
 * 
 * @author Jamison Bryant <jbryan46@montgomerycollege.edu>
 * @date   2/19/2015
 */
public class Television {
	/*
	 * Constants
	 */
	private static String MANUFACTURER;  // The television manufacturer
	private static int SCREEN_SIZE;      // The television screen size (in)
	public static boolean ON = true;
	public static boolean OFF = false;
	
	/*
	 * Fields
	 */
	private boolean powerState;  // The power state of the television (true|false)
	private int channel;         // The channel the television is on (0-100)
	private int volume;          // The volume the television is at (0-100)
	
	/**
	 * Instantiates a Television object with a given manufacturer and screen
	 * size, and sets it's power state, volume, and channel.
	 * 
	 * @param  manufacturer The television manufacturer
	 * @param  screenSize   The screen size of the television
	 * @return              A Television object
	 */
	public Television(String manufacturer, int screenSize) {
		Television.MANUFACTURER = manufacturer;
		Television.SCREEN_SIZE = screenSize;
		this.powerState = false;
		this.volume = 20;
		this.channel = 2;
	}
	
	/**
	 * Returns the television's power state (true = on, false = off)
	 * 
	 * @return The television's power state
	 */
	public boolean getPowerState() {
		return powerState;
	}
	
	/**
	 * Sets the television's power state (true = on, false = off)
	 * 
	 * @param powerState The power state to set
	 */
	public void setPowerState(boolean powerState) {
		this.powerState = powerState;
	}
	
	/**
	 * Toggles the television's power state from its current value
	 */
	public void togglePowerState() {
		powerState = !powerState; 
	}
	
	/**
	 * Returns the television's channel
	 * 
	 * @return The channel the television is on (0-100)
	 */
	public int getChannel() {
		return channel;
	}
	
	/**
	 * Sets the television's channel
	 * 
	 * @param channel The channel to set
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}
	
	/**
	 * Returns the television's volume
	 * 
	 * @return The volume the television is at (0-100)
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * Sets the television's volume
	 * 
	 * @param volume The volume to set
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	/**
	 * Increases the television's volume by 1
	 */
	public void increaseVolume() {
		this.volume++;
	}
	
	/**
	 * Decreases the television's volume by 1
	 */
	public void decreaseVolume() {
		this.volume--;
	}
	
	/**
	 * Returns the television's manufacturer
	 * 
	 * @return The television's manufacturer
	 */
	public String getManufacturer() {
		return MANUFACTURER;
	}
	
	/**
	 * Returns the television's screen size
	 * 
	 * @return The television's screen size
	 */
	public int getScreenSize() {
		return SCREEN_SIZE;
	}
	
	/**
	 * Toggles the television's power state
	 * 
	 * Alias for Television.togglePowerState
	 */
	public void power() {
		this.togglePowerState();
	}
}
