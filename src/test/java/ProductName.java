
public class ProductName {
    //Creating properties of Product class
    private int id;
    private String name;
    private int price;

    //Getter and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "\"Product [ProductId " + id + ", ProductName = " + name + ", ProductPrice = " + price + "]";
    }
}

