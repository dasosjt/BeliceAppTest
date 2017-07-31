package application.models;

/**
** This types make it easier to data bind de models to the view
*/
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product{
  private SimpleStringProperty id;
  private SimpleStringProperty name;
  private SimpleStringProperty description;
  private SimpleStringProperty unit;
  private SimpleStringProperty existence;
  private SimpleStringProperty price;

  public Product(String id, String name, String description, String unit, Integer existence, Integer price){
    this.id = new SimpleStringProperty(id);
    this.name = new SimpleStringProperty(name);
    this.description = new SimpleStringProperty(description);
    this.unit = new SimpleStringProperty(unit);
    this.existence = new SimpleStringProperty(String.valueOf(existence));
    this.price = new SimpleStringProperty(String.valueOf(price));
  }

  public StringProperty idProperty() {
        return id;
  }

  public StringProperty nameProperty() {
        return name;
  }

  public StringProperty descriptionProperty() {
        return description;
  }

  public StringProperty unitProperty() {
        return unit;
  }

  public StringProperty existenceProperty() {
        return existence;
  }

  public StringProperty priceProperty() {
        return price;
  }
}
