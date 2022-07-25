package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Contract;
import Entities.Installment;
import Services.ContractService;
import Services.MercadoPagoService;
import Services.NubankService;
import Services.PagSeguroService;
import Services.PayPalService;
import Services.PicPayService;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		try {

			System.out.println("Enter contract Data:");
			System.out.println("Enter with Payiment Service: ");
			System.out.println("Paypal / PicPay / PagSeguro / Mercado / Nubank");
			String payimentService = sc.nextLine();
			System.out.print("Number: ");
			Integer number = sc.nextInt();
			System.out.print("Date dd/MM/yyyy: ");
			Date date = sdf.parse(sc.next());
			System.out.print("Contract Value: ");
			Double totalValue = sc.nextDouble();
			System.out.print("Enter with the Number of installments:");
			int N = sc.nextInt();

			Contract contract = new Contract(number, date, totalValue);
			ContractService cs;
			switch (payimentService.toUpperCase()) {
			case "PAYPAL":
				cs = new ContractService(new PayPalService());
				cs.processContract(contract, N);
				break;
			case "PICPAY":
				cs = new ContractService(new PicPayService());
				cs.processContract(contract, N);
				break;
			case "PAGSEGURO":
				cs = new ContractService(new PagSeguroService());
				cs.processContract(contract, N);
				break;
			case "MERCADO":
				cs = new ContractService(new MercadoPagoService());
				cs.processContract(contract, N);
				break;
			case "NUBANK":
				cs = new ContractService(new NubankService());
				cs.processContract(contract, N);
				break;
			}
			System.out.println("Installments: ");
			for (Installment it : contract.getInstallments()) {
				System.out.println(it);
			}

		} catch (

		ParseException e) {
			System.out.println("Invalid data!");
		}
		sc.close();
	}
}
