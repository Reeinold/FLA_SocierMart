package facade;

public class ServicePembayaran {
	 private String paymentMethod;

	    public void selectPaymentMethod(String method) {
	        this.paymentMethod = method;
	        System.out.println("Metode pembayaran dipilih: " + method);
	    }

	    public void processPayment(double amount) {
	        System.out.println("Memproses pembayaran sebesar Rp" + amount + " dengan metode " + paymentMethod);
	        System.out.println("Pembayaran berhasil.");
	    }

}
