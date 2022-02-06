package practical.project.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import practical.project.Utils;

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

  public Invoice(Long cId, Long pId) {
    this.pId = pId;
    this.cId = cId;
  }

  Invoice() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getcId() {
    return cId;
  }

  public void setcId(Long cId) {
    this.cId = cId;
  }

  public Long getpId() {
    return pId;
  }

  public void setpId(Long pId) {
    this.pId = pId;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Date getUpdated() {
    return updated;
  }

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
