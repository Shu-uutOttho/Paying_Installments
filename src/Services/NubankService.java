package Services;

public class NubankService implements OnlinePaymentService {
	
	public static final double PAYMENT_FEE = 0.0;
	public static final double MONTHLY_INTEREST = 0.02;

	@Override
	public double paymentfee(double amount) {
		return amount * PAYMENT_FEE;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * months * MONTHLY_INTEREST;
	}

}
