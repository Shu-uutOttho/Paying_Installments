package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Contract;
import Entities.Installment;
import Services.ContractService;
import Services.PayPalService;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("Enter contract Data:");
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Date dd/MM/yyyy: ");
			Date date = sdf.parse(sc.next());
			System.out.print("Contract Value: ");
			Double totalValue = sc.nextDouble();
			System.out.print("Enter with the Number of installments:");
			int N = sc.nextInt();

			Contract contract = new Contract(number, date, totalValue);
			ContractService cs = new ContractService(new PayPalService());

			cs.processContract(contract, N);
			System.out.println("Installments: ");
			for (Installment it : contract.getInstallments()) {
				System.out.println(it);
			}

		} catch (ParseException e) {
			System.out.println("Invalid data!");
		}
		sc.close();
	}
}
