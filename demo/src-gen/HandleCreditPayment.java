import java.util.ArrayList;

public class HandleCreditPaymentUsecase {

	// Properties
	private Customer _customer;
	private Register _pos;
	private Sale _sale;
	private CreditCard _creditCard;
	private Store store;
	private Register pos;
	private AuthService authService;
	private Sale sale;
	private CreditCard creditCard;
	private CreditPayment _creditPayment;
	private CreditPayment creditPayment;
	private Integer pinNumber;

	// Constructor
	public HandleCreditPaymentUsecase() {}

	// ucPrecondition
	public boolean ucPrecondition() {
		return (
			this.authService.getStore() == this.store && 
			this.pos.getStore() == this.store && 
			this._sale.getRegister() == this._pos && 
			this.pos.getTrack() == this._pos && 
			this.sale.getTrack() == this._sale && 
			this.creditCard.getTrack() == this._creditCard &&
			this.sale.getIsComplete() == false
		);
	}
	

	// ucPostcondition
	public boolean ucPostcondition() {
		return (
			this.creditPayment.getCreditCard() == this.creditCard && 
			this.creditPayment.getAuthService() == this.authService && 
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (sale, creditPayment): PaidBy && 
			this.creditPayment.getTrack() == this._creditPayment && 
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (_sale, _creditPayment): PaidBy
		);
	}
	

	// Step
	// --------------------- step01 ---------------------
	public boolean step01_pre(Integer $pinNumber) {
		return (
			this.pinNumber == $pinNumber
		);
	}
	
	public boolean step01_post() {
		return (	
			this._creditPayment.getCreditCard() == this._creditCard
		);
	}
	
	public void step01() {}
	
	// --------------------- step02 ---------------------
	public boolean step02_pre() {
		return (
			this.sale.getIsComplete() == false
		);
	}
	
	public boolean step02_post() {
		return true;
	}
	
	public Object[] step02() {
		Object[] paymentAuth = { 'PaymentAuthServiceSystem', this.authService, this.creditCard, this.pinNumber, this.sale.getTotal() }
		return new Object[] { paymentAuth };
	}
	
	// --------------------- step03 ---------------------
	public boolean step03_pre() {
		return true;
	}
	
	public boolean step03_post() {
		return (	
			this.creditPayment.getCreditCard() == this.creditCard && 
			this.creditPayment.getAuthService() == this.authService &&
			this.creditPayment.getAmount() == this.sale.getTotal()
		);
	}
	
	public Object[] step03() {
		Object[] approvalInfo = { 'Cashier', invalid }
		return new Object[] { approvalInfo };
	}
	
	// --------------------- step04 ---------------------
	public boolean step04_pre() {
		return true;
	}
	
	public boolean step04_post() {
		return (	
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (sale, creditPayment): PaidBy
		);
	}
	
	public void step04() {}
	
	// --------------------- step05 ---------------------
	public boolean step05_pre() {
		return true;
	}
	
	public boolean step05_post() {
		return true;
	}
	
	public Object[] step05() {
		Object[] creditPaymentInfor = { 'Customer', this.sale, this.creditPayment }
		return new Object[] { creditPaymentInfor };
	}
	
	// --------------------- step06 ---------------------
	public boolean step06_pre() {
		return true;
	}
	
	public boolean step06_post() {
		return (	
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (_sale, _creditPayment): PaidBy && 
			this._creditPayment.getTrack() == this.creditPayment &&
			this.creditPayment.getAmount() == _this.creditPayment.getAmount()
		);
	}
	
	public void step06() {}
	
	

	// AltFlow

	// Extension Point
}
