package Factory;

public abstract class abstractPlan {
abstract void getRate();
protected double rate;
public void Bill(double out)
{
	System.out.println(rate * out);
}
}
