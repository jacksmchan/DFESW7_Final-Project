package practical.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import practical.project.Utils;

@Entity
public class Product {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  private Integer quantity;
  private Double price;

  public Product(String name, String description, Integer quantity, Double price) {
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
  }

  Product() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String toString() {
    StringBuilder value = new StringBuilder("ProductEntry(");
    value.append("Id: ");
    value.append(id);
    value.append(",Name: ");
    value.append(name);
    value.append(",Description: ");
    value.append(description);
    value.append(",Quantity: ");
    value.append(quantity);
    value.append(",Price: ");
    value.append(Utils.convertPriceToString(price));
    value.append(")");
    return value.toString();
  }
}
