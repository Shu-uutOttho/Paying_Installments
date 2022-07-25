package Services;

public interface OnlinePaymentService {

	double paymentfee(double amount);
	double interest(double amount, int months);
}
