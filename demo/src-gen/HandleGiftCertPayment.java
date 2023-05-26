import java.util.ArrayList;

public class HandleGiftCertPaymentUsecase {

	// Properties
	private Sale _sale;
	private GiftCertificate _giftCert;
	private Sale sale;
	private GiftCertPayment giftCertPayment;
	private Real giftPaymentAmount;
	private GiftCertificate giftCert;
	private String giftCertId;
	private GiftCertPayment _giftCertPayment;

	// Constructor
	public HandleGiftCertPaymentUsecase() {}

	// ucPrecondition
	public boolean ucPrecondition() {
		return (
			this.sale.getTrack() == this._sale &&
			this.sale.getIsComplete() == false
		);
	}
	

	// ucPostcondition
	public boolean ucPostcondition() {
		return (
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (sale, giftCertPayment): PaidBy &&
			this.giftCertPayment.getGiftCert() == this.giftCertPayment.getGiftCert@pre() - this.giftCertPayment.getAmount()
		);
	}
	

	// Step
	// --------------------- step01 ---------------------
	public boolean step01_pre(String $giftCertId) {
		return (
			this.giftCertId == $giftCertId
			this._giftCert.getId() == this.giftCertId
		);
	}
	
	public boolean step01_post() {
		return (	
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (_sale, _giftCertPayment): PaidBy && 
			this._giftCertPayment.getGiftCert() == this._giftCert
		);
	}
	
	public void step01() {}
	
	// --------------------- step02 ---------------------
	public boolean step02_pre(GiftCertificate $giftCert) {
		return (
			this.giftCert == $giftCert &&
			this.giftCert.getTrack() == this._giftCert
		);
	}
	
	public boolean step02_post() {
		return true;
	}
	
	public Object[] step02() {
		Object[] giftCertInfor = { 'Cashier', this.giftCert.getId(), this.giftCert.getAmount() }
		return new Object[] { giftCertInfor };
	}
	
	// --------------------- step03 ---------------------
	public boolean step03_pre(Real $giftPaymentAmount) {
		return (
			this.giftPaymentAmount == $giftPaymentAmount
			this.giftPaymentAmount <= this.giftCert.getAmount()
		);
	}
	
	public boolean step03_post() {
		return true;
	}
	
	public void step03() {}
	
	// --------------------- step04 ---------------------
	public boolean step04_pre() {
		return true;
	}
	
	public boolean step04_post() {
		return (	
			this.giftCertPayment.getGiftCert() == this.giftCert && 
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (sale, giftCertPayment): PaidBy &&
			this.giftCertPayment.getAmount() == this.giftPaymentAmount && 
			this.giftCert.getAmount() == this.giftCert@pre.getAmount() - this.giftPaymentAmount
		);
	}
	
	public Object[] step04() {
		Object[] giftCertInfor = { 'Cashier', this.giftCert.getId(), this.giftCert.getAmount() }
		return new Object[] { giftCertInfor };
	}
	
	

	// AltFlow

	// Extension Point
}
