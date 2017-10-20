package banffRoadTrip;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import equalikely.Factorial;
import equalikely.Poisson;

public class BanffRoadTrip {
	

	public BanffRoadTrip(String[] args) throws NumberFormatException, IOException
	{
		String [] serviceNames = new String[4];
		String [] arrivalNames = new String[4];
		serviceNames[0] = "Deterministic";
		serviceNames[1] = "Exponential";
		serviceNames[2] = "HyperEx";
		serviceNames[3] = "CorrEx";
		arrivalNames[0] = "0.5 Lambda";
		arrivalNames[1] = "0.55 Lambda";
		arrivalNames[2] = "0.6 Lambda";
		arrivalNames[3] = "0.65 Lambda";
		LinkedList<double[]> serviceMethods = new LinkedList<double[]>();
		LinkedList<double[]> arrivalRate = new LinkedList<double[]>();
		
		for(int i = 0; i < serviceNames.length; i++)
		{
			serviceMethods.add(getFile(serviceNames[i]));
		}
		
		for(int i = 0; i < serviceNames.length; i++)
		{
			arrivalRate.add(getFile(arrivalNames[i]));
		}
		
		
		
		for(int i = 0; i < arrivalRate.size(); i++)
		{
			for(int j = 0; j < serviceMethods.size(); j++)
			{
				runSimulation(arrivalRate.get(i),serviceMethods.get(j),arrivalNames[i],serviceNames[j]);
			}
		}
		
		
	}
	
	public void runSimulation(double[] arrivals, double[] method, String arrivalRate, String serviceType)
	{
		double arrival = 0;
		double departure = 0;
		double delay;
		double service;
		double wait;
		double sumDelay = 0;
		double [] adjustedTimes = new double[arrivals.length];
		double standardDeviation;
		double adjustedTotal = 0;
		double mean;
		
		System.out.println("Statistics for " + serviceType + " at " + arrivalRate + ":");
		
		
		for(int i = 0; i < arrivals.length && i < method.length; i++)
		{
			arrival = arrivals[i];
			service = method[i];
			if(arrival < departure)
			{
				delay = departure - arrival;
			}
			else
			{
				delay = 0.0;
			}
			
			wait = delay + service;
			departure = arrival + wait;
			sumDelay += delay;
			
		}
		
		mean = sumDelay/method.length;
		
		for(int i = 0; i < adjustedTimes.length && i < method.length; i++)
		{
			adjustedTimes[i] = method[i]-mean;
			adjustedTimes[i] *= adjustedTimes[i];
			adjustedTotal += adjustedTimes[i];
		}
		
		
		
		standardDeviation = adjustedTotal/adjustedTimes.length;
		standardDeviation = Math.sqrt(standardDeviation);
		
		
		System.out.println("mean: " + mean);
		System.out.println("Standard deviation: " + standardDeviation  + "\n");
		
	}
	
	public double[] getFile(String file) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("..\\" + file + ".txt"));
		LinkedList<Double> storage = new LinkedList<Double>();
		String input;
		double convertedList[];
		
		while((input = reader.readLine())!=null)
		{
			storage.add(Double.parseDouble(input));
		}
		
		convertedList = new double[storage.size()];
		
		for(int i = 0; i < convertedList.length; i++)
		{
			convertedList[i] = storage.get(i);
		}
		
		reader.close();
		
		return convertedList;
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		
		new BanffRoadTrip(args);
		
		
		/*
		int factorTest = Factorial.factorial(5);
		int otherTest = 5 * 4 * 3 * 2;
		
		System.out.println(factorTest);
		System.out.println(otherTest);
		
		Poisson probability = new Poisson(0.65,1);
		
		double prob = probability.getProbability();
		System.out.println(prob);*/
	}
//18.39, 20.23, 22.07, 23.91
}
