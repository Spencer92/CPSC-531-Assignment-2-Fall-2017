package workloads;

import java.util.LinkedList;

import equalikely.Equalikely;

public class Deterministic extends AWorkload
{
	private int serviceTime = 90; //time in seconds;
	private LinkedList<Double> queue;

	
	public Deterministic()
	{
		this.arrival = 0;
		queue = new LinkedList<Double>();
	}
	
	public void runSim(int probability)
	{
		Equalikely prob = new Equalikely();
		if(prob.finalAnswer() < probability)
		{
			//do something;
		}
	}


	@Override
	public double getArrivalTime() 
	{
	
		return 0;
	}

	@Override
	public double getServiceTime() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}


/*
	car comes to station
	after coming to station, it takes time for car to be serviced
	if next car comes and initial car is still being serviced, then there is delay
	for this car always comes every 90 seconds
	
*/