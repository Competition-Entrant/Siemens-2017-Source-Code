import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * This class takes in a set of values and analyzes/filters it. Based on a given min and max values, the program
 * identifies all the values in the data set within that range. Then, it generates a frequency plot of the data, 
 * displaying each unique data point and the number of times it occurs.
 * 
 * @author Competition-Entrant
 * @version August 12, 2017
 *
 */
public class Organizer 
{
	private ArrayList<Double> values;
	private double max;
	private double min;
	
	/**
	 * Creates a new Organizer class and takes in a list of doubles (the data).
	 * @param vals the ArrayList containing all of the values to analyze.
	 */
	public Organizer(ArrayList<Double> vals)
	{
		values = vals;
	}
	/**
	 * Sets the max value for the filter.
	 * @param max the value above which a data point is considered "noise"
	 */
	public void setMax(double max)
	{
		this.max = max;
	}
	/**
	 * Sets the min value for the filter.
	 * @param max the value below which a data point is considered "noise"
	 */
	public void setMin(double min)
	{
		this.min = min;
	}
	/**
	 * Iterates through the data set, and adds all the data point that fall within the filter's range (less than the maximum value
	 * and greater than the minimum value) to a new list
	 * 
	 * @return a list containing all the valid data points in the data set
	 */
	public ArrayList<Double> filter()
	{
		ArrayList<Double> cleanCopy = new ArrayList<Double>();
		for (int i = 0; i < values.size(); i ++)
		{
			if (values.get(i) < max && values.get(i) > min)
			{
				cleanCopy.add(values.get(i));
			}
		}
		return cleanCopy;
	}
	/**
	 * Generates a HashMap that serves as a frequency plot for each uniquely occurring data point in the set of valid data.
	 * This can be used for determining the mode of the valid data, as well as analyzing the overall distribution of data.
	 * 	
	 * @return a Map with the keys being the valid data points and the values being the number of times each data point is repeated.
	 */
	public Map<Double,Integer> frequency()
	{
		Map<Double,Integer> map = new HashMap<Double,Integer>();
		ArrayList<Double> clean = filter();
		Set<Double> withoutDuplicates = new HashSet<Double>();
		
		for (Double d: clean)
		{
			withoutDuplicates.add(d);
		}
		System.out.println("\n" + "Set Size: " + withoutDuplicates.size());
		for (Double d: withoutDuplicates)
		{
			int count = 0;
			for (int i = 0; i < clean.size(); i++)
			{
				if (d.equals(clean.get(i)))
				{
					count ++;
				}
			}
			map.put(d, count);
		}
		
		return map;
	}
	/**
	 * Creates a new Organizer object and analyzes a given set of data. Prints out the valid data points as well as the frequency plot
	 * to the console.
	 * 
	 * @param args the user command line
	 */
	public static void main(String[] args)
	{
		ArrayList<Double> values = new ArrayList<Double>();
		double[] vals = {//insert data values here};
		for (double d: vals)
		{
			values.add(d);
		}
		Organizer o = new Organizer(values);
		o.setMin(//insert min value here);
		o.setMax(//insert min value here);
		ArrayList<Double> clean = o.filter();
		for (Double d: clean)
		{
			System.out.println(d);
		}
		Map<Double, Integer> map = o.frequency();
		for (Double d: map.keySet())
		{
			System.out.println(d + " " + map.get(d));
		}
		
	
	}

}
