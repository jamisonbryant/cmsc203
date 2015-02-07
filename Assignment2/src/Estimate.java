/**  Project 2  
 * Determines estimates for painting and carpeting rooms.
 * 
 * 
 * @author CMSC203 Common
 *
 */
public class Estimate 
{ 		
	/** cost for one hour of labor */
	 final double LABOR = 35.0;
	 
	 	/** square yards covered by one gallon of paint */
	 final double PAINT_SQYD_GAL = 5.0;
	 
	 	/** square yards of carpet laid in one hour */
	 final double CARPET_SQYD_HR = 5.0;
	 
	 	/** hours of labor required for one gallon of paint */
	 final double PAINT_SQYD_HR = 5.0 / 2.0;
	 
	private String task;	// the task to receive an estimate
	private double size;	// the square yards of space
	private double cost;	// the cost per gallon of paint or square yard of carpet
		   
		/** default constructor */
	public Estimate()
	{
		task = "";
		size = cost = 0;
	}
	
		/** constructor initializes task, size, and cost to values input from the driver
		 * 
		 * @param t  the task to receive an estimate -- paint or carpet
		 * @param sqYd the number of square yards to be covered
		 * @param c  the cost of paint per gallon or the cost of carpet per square yard
		 */
	public Estimate(String t, double sqYd, double c)
	{
		//task = t;
		setTask(t);
		
		size = sqYd;
		cost = c;
	}
	
		/** calculates the total job estimate.
		 * @return The estimated total.
		 */
    public double getTotal()
    {
    	if (task.equals("paint"))
    		
    		// cost of paint + labor cost
    		return ((size/PAINT_SQYD_GAL * cost) + (size/PAINT_SQYD_HR * LABOR));
    	
    	else
    		return ((size/CARPET_SQYD_HR * LABOR) + (size * cost));
    }

    	/** change the job to be estimated
    	 * 
    	 * @param t  the task for estimate
    	 */
    public void setTask(String t)
    {
    	if (t.toLowerCase().equals("paint"))
    	{
    		System.out.println("it's a paint job");
    		task = "paint";
    		
    	} else if (t.toLowerCase().equals("carpet")){
    		System.out.println("it's a carpet job");
    		task = "carpet";
    		
    	} else {
    		System.out.println("OUT OF SCOPE TASK REQUESTED");
    		task = "OUT OF SCOPE";
    	}
    	
    }
    
    	/** change the number of square yards in task
    	 * 
    	 * @param s  the number of square yards to be painted or carpeted
    	 */
    public void setSize(double s)
    {
    	size = s;
    }
    
    	/** change the cost of the paint per gallon or the carpet per square yard
    	 *
    	 * @param c cost of paint or carpet per unit 
    	 */
    public void setCost(double c)
    {
    	cost = c;
    }
    
    	/** get the string representing the job to be estimated
    	 * 
    	 * @return the job estimate wanted
    	 */
    public String getTask()
    {
    	return task;
    }
    
    	/** get the number of square yards the job requires
    	 * 
    	 * @return the number of square yards to be painted or carpeted
    	 */
    public double getSize()
    {
    	return size;
    }
    
    	/** get the cost of the paint per gallon or the carpet per square yard
    	 * 
    	 * @return the unit cost of the paint or carpet
    	 */
    public double getCost()
    {
    	return cost;
    }
}

