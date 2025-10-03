package Strategy;

public class percentage implements Discount{
	private double percent;

    public percentage(double percent) {
        this.percent = percent;
    }

	@Override
	public double applyDiscount(double price) {
		// TODO Auto-generated method stub
		return price * (1-percent);
	}

}
