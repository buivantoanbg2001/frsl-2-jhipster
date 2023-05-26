import java.util.ArrayList;

public class ProcessSalesUsecase {

	// Properties
	private Cashier _cashier;
	private Customer _customer;
	private Sale _sale;
	private Register _pos;
	private ArrayList<Item> _items;
	private Store store;
	private Register pos;
	private Cashier cashier;
	private Sale sale;
	private Payment payment;
	private CreditCard _creditCard;
	private Item _item;
	private Item item;
	private ProductDescription prdDesc;
	private SalesLineItem salesLineItem;
	private String itemId;
	private SalesLineItem _salesLineItem;
	private Date curDate;
	private GiftCertificate _giftCert;

	// Constructor
	public ProcessSalesUsecase() {}

	// ucPrecondition
	public boolean ucPrecondition() {
		return (
			this._sale.getCustomer() == this._customer && 
			this._cashier.getRegister() == this._pos && 
			this.pos.getTrack() == this._pos && 
			this.cashier.getTrack() == this._cashier && 
			this.pos.getStore() == this.store &&
			this._sale.getIsComplete() == false && 
			this._items.isEmpty() == false
		);
	}
	

	// ucPostcondition
	public boolean ucPostcondition() {
		return (
			this.sale.getTrack() == this._sale && 
			this.sale.getStore() == this.store && 
			this.sale.getRegister() != this.pos && 
			this._sale.getRegister() != this._pos &&
			this.sale.getIsComplete() == true && 
			this.sale.getTotal().oclIsUndefined() == false && 
			this._sale.getIsComplete() == true
		);
	}
	

	// Step
	// --------------------- step01 ---------------------
	public boolean step01_pre() {
		return (
			this._sale.getCustomer() == this._customer &&
			this._items.isEmpty() == false
		);
	}
	
	public boolean step01_post() {
		return true;
	}
	
	public void step01() {}
	
	// --------------------- step02 ---------------------
	public boolean step02_pre() {
		return (
			this._cashier.getRegister() == this._pos
		);
	}
	
	public boolean step02_post() {
		return (	
			this._sale.getRegister() == this._pos &&
			this._sale.getTotal() == 0 && 
			this._sale.getIsComplete() == false
		);
	}
	
	public void step02() {}
	
	// --------------------- step03 ---------------------
	public boolean step03_pre(Register $pos, Cashier $cashier, Date $curDate) {
		return (
			this.pos == $pos && 
			this.cashier == $cashier && 
			this.curDate == $curDate &&
			this.cashier.getRegister() == this.pos && 
			this.pos.getTrack() == this._pos && 
			this.cashier.getTrack() == this._cashier
		);
	}
	
	public boolean step03_post() {
		return (	
			this.sale.getRegister() == this.pos && 
			this.sale.getTrack() == this._sale &&
			this.sale.oclIsUndefined() == false && 
			this.sale.getTotal() == 0 && 
			this.sale.getDate() == this.curDate
		);
	}
	
	public Object[] step03() {
		Object[] saleInfor = { 'Cashier', this.sale.getId(), this.sale.getTotal() }
		Object[] cashierInfor = { 'Cashier', this.cashier.getName() }
		return new Object[] { saleInfor, cashierInfor };
	}
	
	// --------------------- step04 ---------------------
	public boolean step04_pre(Item $_item, String $itemId) {
		return (
			this._item == $_item && 
			this.itemId == $itemId
			this.this._items.includes(this._item) && 
			this._item.getId() == this.itemId && 
			this._item.getSalesLineItem().isEmpty()
		);
	}
	
	public boolean step04_post() {
		return (	
			this._salesLineItem.getSalesLineItem() == this._sale && 
			this._item.getSalesLineItem() == this._salesLineItem &&
			this._salesLineItem.oclIsUndefined() == false && 
			this._salesLineItem.getQuantity() == 1
		);
	}
	
	public void step04() {}
	
	// --------------------- step05 ---------------------
	public boolean step05_pre(Item $item, ProductDescription $prdDesc) {
		return (
			this.item == $item && 
			this.prdDesc == $prdDesc &&
			this.item.getPrdDesc() == this.prdDesc && 
			this.item.getTrack() == this._item
		);
	}
	
	public boolean step05_post() {
		return (	
			this.salesLineItem.getSalesLineItem() == this.sale && 
			this.item.getSalesLineItem() == this.salesLineItem && 
			this.salesLineItem.getProductDesc() == this.prdDesc && 
			this.salesLineItem.getTrack() == this._salesLineItem &&
			this.salesLineItem.oclIsUndefined() == false && 
			this.salesLineItem.getQuantity() == 1 && 
			this.sale.getTotal() == this.sale@pre.getTotal() + this.prdDesc.getPrice() * this.prdDesc.getTax()
		);
	}
	
	public Object[] step05() {
		Object[] itemInfor = { 'Cashier', this.prdDesc.getDesc(), this.prdDesc.getPrice(), this.prdDesc.getUpc() }
		Object[] saleInfor = { 'Cashier', this.sale.getTotal() }
		return new Object[] { itemInfor, saleInfor };
	}
	
	// --------------------- step6_rejn_step4_1 ---------------------
	public boolean step6_rejn_step4_1_condition(Item $_item) {
		return (
			this._item == $_item
			this.this._items.includes(this._item) && 
			this._item.getSalesLineItem().oclIsUndefined()
		);
	}
	
	public void step6_rejn_step4_1() {}
	// --------------------- step06 ---------------------
	public boolean step06_pre() {
		return true;
	}
	
	public boolean step06_post() {
		return true;
	}
	
	public Object[] step06() {
		Object[] paymentInfor = { 'Cashier', this.sale.getTotal() }
		return new Object[] { paymentInfor };
	}
	
	// --------------------- step07 ---------------------
	public boolean step07_pre() {
		return true;
	}
	
	public boolean step07_post() {
		return (	
			this._sale.getTotal() == this.sale.getTotal()
		);
	}
	
	public void step07() {}
	
	// --------------------- step08 ---------------------
	public void step08() {
		// Chuyển sang use case HandleCashPaymentUseCase
	}
	// --------------------- step09 ---------------------
	public boolean step09_pre(Payment $payment) {
		return (
			this.payment == $payment &&
			this.sale.getRegister() == this.pos && 
			this.sale.getPayment() == this.payment && 
			this.sale.getStore() != this.store &&
			this.sale.getIsComplete() == false
		);
	}
	
	public boolean step09_post() {
		return (	
			this.sale.getRegister() != this.pos && 
			this.sale.getStore() == this.store &&
			this.sale.getIsComplete() == true
		);
	}
	
	public Object[] step09() {
		Object[] saleInfor2AccSys = { 'AccountingSystem', this.sale, this.payment }
		Object[] saleInfor2InvSys = { 'InventorySystem', this.sale, this.payment }
		return new Object[] { saleInfor2AccSys, saleInfor2InvSys };
	}
	
	// --------------------- step10 ---------------------
	public boolean step10_pre() {
		return true;
	}
	
	public boolean step10_post() {
		return (	
			this._sale.getRegister() != this._pos &&
			this._sale.getIsComplete() == true
		);
	}
	
	public void step10() {}
	
	

	// AltFlow
	// --------------------- step9a_alt ---------------------
	public boolean step9a_alt_condition(CreditCard $_creditCard) {
		return (
			this._creditCard == $_creditCard
		);
	}
	
	// --------------------- step08a ---------------------
	public void step08a() {
		// Chuyển sang use case HandleCreditPaymentUseCase
	}
	
	// --------------------- end step9a_alt ---------------------
	

	// Extension Point
	// --------------------- PaidByGiftCert ---------------------
	public boolean paidByGiftCert_condition(GiftCertificate $_giftCert) {
		return (
			this._giftCert == $_giftCert
		);
	}
	
	public void paidByGiftCert() {
		// Chuyển sang use case HandleGiftCertPaymentUseCase
	}
}
