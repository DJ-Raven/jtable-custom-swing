package table;

public class CSVData {

    public int Id;
    public String name;
    public String category;
    public int quantity;
    public int amount;

    public CSVData(int Id, String name, String category, int quantity, int amount){
        this.Id = Id;
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.amount = amount;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ID: " + Id + " name: " + name + " category: " + category + " quantity: " + quantity + " amount: " + amount;
    }
}
