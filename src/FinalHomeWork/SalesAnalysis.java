package FinalHomeWork;

/**
 * Класс "Анализ продаж", который содержит информацию о названии товара, его ID и проданном кол-ве
 * @author m.bondarchuk
 * @version 2
 */

public class SalesAnalysis {

    private int ID;
    private String Name;
    private int NumberOfSales;

    public SalesAnalysis(int ID, String Name, int NumberOfSales) {
        this.ID = ID;
        this.Name = Name;
        this.NumberOfSales = NumberOfSales;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID= ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public int getNumberOfSales() {
        return NumberOfSales;
    }

    public void setNumberOfSales(int NumberOfSales) {
        this.NumberOfSales = NumberOfSales;

    }
}
