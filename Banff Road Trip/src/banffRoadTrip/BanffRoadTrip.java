package banffRoadTrip;

import equalikely.Factorial;
import equalikely.Poisson;

public class BanffRoadTrip {

	public static void main(String[] args) 
	{
		int factorTest = Factorial.factorial(5);
		int otherTest = 5 * 4 * 3 * 2;
		
		System.out.println(factorTest);
		System.out.println(otherTest);
		
		Poisson probability = new Poisson(0.65,1);
		
		double prob = probability.getProbability();
		System.out.println(prob);
	}
//18.39, 20.23, 22.07, 23.91
}
