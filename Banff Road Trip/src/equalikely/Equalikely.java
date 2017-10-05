package equalikely;

import java.util.Random;

public class Equalikely 
{
	float min_num;
	int max;
	int min;
	Random rand;
	
	/**
	 * Equilikely
	 * 
	 * a random seed is generated, and a 
	 * minimum number expressed as a float between
	 * 0 and 1 is created.
	 * 
	 * @param min Minimum value asked for
	 * @param max Maximum value asked for
	 */
	
	public Equalikely(int min, int max)
	{
		this.min = min;
		this.max = max;
		this.rand = new Random();
		this.min_num = (float) min/max;	

	}
	
	/**
	 * Equilikely
	 * 
	 * 	 * a random seed is generated, and a 
	 * minimum number expressed as 0 is created.
	 * 
	 * it is assumed that there isn't a desired
	 * range
	 * 
	 */
	
	public Equalikely()
	{
		this.max = Short.MAX_VALUE;
		this.rand = new Random();
		this.min_num = 0.0f;
	}
	
	/**
	 * If a range wants to be changed, or
	 * there was no range specified, then 
	 * this will give a new range
	 * 
	 * @param min minimum number desired
	 * @param max maximum number desired
	 */
	
	public void setRange(int min, int max)
	{
		this.max = max;
		this.min_num = (float) min/max;

	}
	
	/**
	 * Gets a random value, and divides
	 * the value to get a number between 0 and 1
	 * 
	 * This number is then multiplied by the
	 * max value desired, then truncated in
	 * order to get a value`
	 * 
	 * @return a random number in the desired range
	 */
	
	public int finalAnswer()
	{
		int final_ans;
		float float_num;
		int rand_num;
		
		
		rand_num = rand.nextInt(Short.MAX_VALUE);
		float_num = (float) rand_num / Short.MAX_VALUE;
		float_num += this.min_num;
		float_num *= this.max;
		
		
		final_ans = (int) float_num;
		if(final_ans < this.min)
		{
			//This is in due to rounding issues
			//The number can sometimes go to 0.9999994
			final_ans = this.min;
		}
		
		return final_ans;
		
	}
}
