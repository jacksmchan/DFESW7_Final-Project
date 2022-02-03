package practical.project.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import practical.project.Utils;

/**
 * The Entity class defined for Product 
 *
 * <ul>
 * <li>id: Auto generated Long</li>
 * <li>name: a string contains the name of this product</li>
 * <li>description: a string contains the brief description about this product</li>
 * <li>quantity: the quantity of this product in stock</li>
 * <li>price: the price of this product</li>
 * </ul>
 *
 * @author jacksmchan
 * @see javax.persistence.Entity
 */
@Entity
public class Product {
  @Id
  @GeneratedValue (strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String description;
  private Integer quantity;
  private Double price;

  /**
   * Constructor with params
   * 
   * @param name        product name.
   * @param description product description.
   * @param quantity    product quantity.
   * @param price       product price.
   */
  public Product(String name, String description, Integer quantity, Double price) {
    this.name = name;
    this.description = description;
    this.quantity = quantity;
    this.price = price;
  }

  /**
   * Default constructor without param
   */
  Product() {
  }

  /**
   * Getter for product record id
   * 
   * @return product record id
   */
  public Long getId() {
    return id;
  }

  /**
   * Setter for product record id
   * 
   * @param product record id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Getter for product's name
   * 
   * @return product's name
   */
  public String getName() {
    return name;
  }

  /**
   * Setter for product's name
   * 
   * @param name   product's name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter for product's description
   * 
   * @return product's description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Setter for product description
   * 
   * @param description   product's description
   */
  public void setDescription(String description) {
    this.description = description;
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
   * Getter for product price
   * 
   * @return product price
   */
  public Double getPrice() {
    return price;
  }

  /**
   * Setter for product price
   * 
   * @param price   product price
   */
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
