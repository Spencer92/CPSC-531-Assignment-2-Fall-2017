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
		String [] serviceNames = new String[4];//"Deterministic.txt","Exponential.txt","HyperEx.txt","CorrEx.txt"];
		String [] arrivalNames = new String[4];
		serviceNames[0] = "Deterministic.txt";
		serviceNames[1] = "Exponential.txt";
		serviceNames[2] = "HyperEx.txt";
		serviceNames[3] = "CorrEx.txt";
		arrivalNames[0] = "0.5 Lambda.txt";
		arrivalNames[1] = "0.55 Lambda.txt";
		arrivalNames[2] = "0.6 Lambda.txt";
		arrivalNames[3] = "0.65 Lambda.txt";
		LinkedList<double[]> serviceMethods = new LinkedList<double[]>();
		LinkedList<double[]> arrivalRate = new LinkedList<double[]>();
/*		double lowestLamb[] = getFile("0.5 Lambda.txt");
		double sLowestLamb[] = getFile("0.55 Lambda.txt");
		double sHighestLamb[] = getFile("0.6 Lambda.txt");
		double highestLamb[] = getFile("0.65 Lambda.txt");*/
		
		for(int i = 0; i < serviceNames.length; i++)
		{
			serviceMethods.add(getFile(serviceNames[i]));
		}
		
		for(int i = 0; i < serviceNames.length; i++)
		{
			arrivalRate.add(getFile(arrivalNames[i]));
		}
		
/*		double deterministic[] = getFile("Deterministic.txt");
		double expoential[] = getFile("Exponential.txt");
		double hyperEx[] = getFile("HyperEx.txt");
		double corrEx[] = getFile("CorrEx.txt");*/
		
		
		
		for(double [] arrival : arrivalRate)
		{
			for(double [] service : serviceMethods)
			{
				runSimulation(arrival,service);
			}
		}
		
//		runSimulation(lowestLamb,hyperEx);
		
	}
	
	public void runSimulation(double[] lamda, double[] method)
	{
		double arrival = 0;
		double departure = 0;
		double delay;
		double service;
		double wait;
		double sumDelay = 0;
		double sumWait = 0;
		double sumService = 0;
		double interarrival;
		
		for(int i = 0; i < lamda.length && i < method.length; i++)
		{
			arrival = lamda[i];
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
			sumWait += wait;
			sumService += service;
			
		}
		
		System.out.println(" average interarrival time: " + arrival/lamda.length);
		System.out.println("average service time: " + sumService/method.length);
		System.out.println("average delay: " + sumDelay/lamda.length);
		System.out.println("average wait: " + sumWait/lamda.length + "\n");
		
	}
	
	public double[] getFile(String file) throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new FileReader("..\\" + file));
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
