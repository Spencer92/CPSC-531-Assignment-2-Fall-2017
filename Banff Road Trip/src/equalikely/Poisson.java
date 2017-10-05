package equalikely;

public class Poisson 
{
	private double lamda;
	private double amount;
	
	
	public double getLamda() {
		return lamda;
	}

	public void setLamda(double lamda) {
		this.lamda = lamda;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Poisson(double lamda, double amount)
	{
		this.lamda = lamda;
		this.amount = amount;
	}
	
	public double getProbability()
	{
		return ((Math.pow(this.lamda, this.amount)*Math.exp(-1.0))/Factorial.factorial((int)amount));
	}

}
