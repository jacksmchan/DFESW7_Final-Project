package practical.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import practical.project.Utils;

/**
 * The Entity class defined for Invoice 
 *
 * <ul>
 * <li>id: Auto generated Long</li>
 * <li>cId: customer id</li>
 * <li>pId: product id</li>
 * <li>quantity: the product quantity involved</li>
 * <li>created: the date this invoice created</li>
 * <li>updated: the date this invoice updated</li>
 * </ul>
 *
 * @author jacksmchan
 * @see javax.persistence.Entity
 */
@Entity
public class Invoice {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long id;
  private Long cId;
  private Long pId;
  private Integer quantity;
  private Date created;
  private Date updated;

  /**
   * Constructor with params
   * 
   * @param cId        customer id
   * @param pId        product id
   * @param quantity   product quantity involved
   * @param created    the date this invoice created
   * @param updated    the date this invoice updated
   */
  public Invoice(Long cId, Long pId, Integer quantity, Date created, Date updated) {
    this.pId = pId;
    this.cId = cId;
    this.quantity = quantity;
    this.created = created;
    this.updated = updated;
  }

  /**
   * Default constructor without param
   */
  Invoice() {
  }

  /**
   * Getter for invoice id
   * 
   * @return invoice id
   */
  public Long getId() {
    return id;
  }

  /**
   * Setter for invoice id
   * 
   * @param id invoice id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Getter for customer id
   * 
   * @return customer ID
   */
  public Long getcId() {
    return cId;
  }

  /**
   * Setter for customer id
   * 
   * @param cId    customer id
   */
  public void setcId(Long cId) {
    this.cId = cId;
  }

  /**
   * Getter for product id
   * 
   * @return product id
   */
  public Long getpId() {
    return pId;
  }

  /**
   * Setter for product id
   * 
   * @param pId     product id
   */
  public void setpId(Long pId) {
    this.pId = pId;
  }

  /**
   * Getter for the date when this invoice created
   * 
   * @return created date
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Setter for the date when this invoice created
   * 
   * @param created   created date
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Getter for product's quantity
   * 
   * @return product's quantity
   */
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * Setter for product quantity
   * 
   * @param quantity   product's quantity
   */
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  /**
   * Getter for the date when this invoice updated
   * 
   * @return updated date
   */
  public Date getUpdated() {
    return updated;
  }

  /**
   * Setter for the date when this invoice updated
   * 
   * @param updated   the date when this invoice updated
   */
  public void setUpdated(Date updated) {
    this.updated = updated;
  }

  public String toString() {
    StringBuilder value = new StringBuilder("InvoiceEntry(");
    value.append("Id: ");
    value.append(id);
    value.append(",Customer ID: ");
    value.append(cId);
    value.append(",Product ID: ");
    value.append(pId);
    value.append(",Quantity: ");
    value.append(quantity);
    value.append(",Created: ");
    value.append(Utils.convertDateToString(created));
    value.append(",Updated: ");
    value.append(Utils.convertDateToString(updated));
    value.append(")");
    return value.toString();
  }
}
