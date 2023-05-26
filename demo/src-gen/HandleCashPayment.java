import java.util.ArrayList;

public class HandleCashPaymentUsecase {

	// Properties
	private Sale _sale;
	private Sale sale;
	private CashPayment cashPayment;
	private Real amountTendered;
	private CashPayment _cashPayment;

	// Constructor
	public HandleCashPaymentUsecase() {}

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
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (sale, cashPayment): PaidBy &&
			this.cashPayment.getAmountTendered() >= this.sale.getTotal() && 
			this.cashPayment.getAmount() == this.sale.getTotal()
		);
	}
	

	// Step
	// --------------------- step01 ---------------------
	public boolean step01_pre() {
		return true;
	}
	
	public boolean step01_post() {
		return true;
	}
	
	public void step01() {}
	
	// --------------------- step02 ---------------------
	public boolean step02_pre(Real $amountTendered) {
		return (
			this.amountTendered == $amountTendered
		);
	}
	
	public boolean step02_post() {
		return (	
			this._cashPayment.getAmountTendered() == this.amountTendered
		);
	}
	
	public void step02() {}
	
	// --------------------- step3 ---------------------
	public boolean step3_pre() {
		return true;
	}
	
	public boolean step3_post() {
		return true;
	}
	
	public Object[] step3() {
		Object[] balanceDue = { 'Cashier', this._cashPayment.getAmountTendered() }
		return new Object[] { balanceDue };
	}
	
	// --------------------- step4 ---------------------
	public boolean step4_pre() {
		return true;
	}
	
	public boolean step4_post() {
		return (	
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (_sale, _cashPayment): PaidBy
		);
	}
	
	public void step4() {}
	
	// --------------------- step5 ---------------------
	public boolean step5_pre() {
		return true;
	}
	
	public boolean step5_post() {
		return (	
			// TODO: Cần xử lý thủ công quan hệ giữa đối tượng kế thừa (sale, cashPayment): PaidBy &&
			this.cashPayment.getAmountTendered() == _this.cashPayment.getAmountTendered()
		);
	}
	
	public void step5() {}
	
	

	// AltFlow

	// Extension Point
}
