package workloads;

public abstract class AWorkload 
{
	protected static final int START = 0;
	protected int index;
	protected double arrival; //lamda
	protected double delay;
	protected double service; 
	protected double wait;
	protected double departure;
	
	
	public abstract double getArrivalTime();
	public abstract double getServiceTime();
	public int getIndex() {
		return index;
	}
	public double getArrival() {
		return arrival;
	}
	public double getDelay() {
		return delay;
	}
	public double getService() {
		return service;
	}
	public double getWait() {
		return wait;
	}
	public double getDeparture() {
		return departure;
	}
	
}
