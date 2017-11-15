package model;

import java.util.Date;

/**
 * When a relative delivers a medicine.
 */
public class MedicineStock {

	private int stockid;
	private int medicineid;
	private Date deliveryDate;
	private Double quantity;
	
	/**
	 * @param stockid Auto generated id.
	 * @param medicineid The id of the medicine.
	 * @param deliveryDate The date in which the medicine was delivered.
	 * @param quantity The quantity that was delivered.
	 */
	public MedicineStock(int stockid, int medicineid, Date deliveryDate, Double quantity) {
		this.setStockid(stockid);
		this.setMedicineid(medicineid);
		this.setDeliveryDate(deliveryDate);
		this.setQuantity(quantity);
	}

	public int getStockid() {
		return stockid;
	}

	public void setStockid(int stockid) {
		this.stockid = stockid;
	}

	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	
	
}
