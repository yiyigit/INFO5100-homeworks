public class DessertShop {
    private double taxRate = 0.065;
    private String storeName = "M & M Dessert Shop";

    public DessertShop(String storenName){
        this.storeName = storeName;
    };

    public double getTaxRate() {
        return taxRate;
    }
    public String getStoreName() {
        return storeName;
    }

    public double cents2dollarsAndCents(int cents){
        return cents/100.0;

     }
}
---------------------------------------------------
public abstract class DessertItem {
    protected String name;
    public String getName(){
        return this.name;
    }
    public abstract int getCost();

    public abstract String receipt();
}


----------------------------------------------
import java.lang.Math;
public class Candy extends DessertItem {
    private String name;
    private double weight;
    private int centPerPound;
    private int price;

    public Candy(String name, double weight, int centPerPound){
        this.name = name;
        this.weight = weight;
        this.centPerPound = centPerPound;
        this.price =(int) Math.round(weight * centPerPound);
    }

    public int getCost(){
        return price;
    }

    public String getName() {
        return name;
    }


    public String receipt(){
        StringBuilder sb = new StringBuilder();
        sb.append(weight);
        sb.append(" lbs. @ ");
        sb.append(centPerPound/100.0);
        sb.append(" /lb. \n");
        sb.append(getName());
        return sb.toString();
    }
}
-----------------------------------------------------------
  public class Cookie extends DessertItem {

    private String name;
    private int num;
    private int centsPerDz;

    public Cookie(String name, int num, int centsPerDz){
        this.name = name;
        this.num = num;
        this.centsPerDz = centsPerDz;
    }
    public int getCost(){
        return centsPerDz * num / 12;
    }

    public String getName() {
        return name;
    }

    public String receipt(){
        return num + " @ " + centsPerDz/100.0 + "/dz. \n" + getName() ;
    }
}
--------------------------------------------------------------------------------
import java.util.ArrayList;
public class Checkout {
    private int num = 0;
    private int cost = 0;
    private DessertShop shop;
    private ArrayList<DessertItem> items;

    public Checkout(){
        items = new ArrayList<>();
        shop = new DessertShop("M & M Dessert Shop");
    }

    public void enterItem(DessertItem d){
        items.add(d);
        num++;
        cost += d.getCost();
    }

    public int numberOfItems(){
        return num;
    }

    public int totalCost(){
        return cost;
    }

    public int totalTax(){
        double tax = shop.getTaxRate();
        int totalTax = (int)Math.round(tax * cost);
        return totalTax;
    }

    public void clear(){
        items.clear();
        num = 0;
        cost = 0;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("      " + shop.getStoreName() +"\n");
        sb.append("      -------------------\n");
        for(DessertItem d: items){
            sb.append(d.receipt() + "   " + shop.cents2dollarsAndCents(d.getCost()) + "\n");
        }
        sb.append("Tax" + "     "+ shop.cents2dollarsAndCents(totalTax())+"\n");
        sb.append("Total Cost" + "     "+ shop.cents2dollarsAndCents(totalCost()+totalTax()));
        return sb.toString();
        }
    }


----------------------------------------------------------------------------------
public class IceCream extends DessertItem {

    private String name;
    private int cost;

    public IceCream(String name, int cost){
        this.name = name;
        this.cost = cost;
    }

    public int getCost(){
        return this.cost;
    }


    public String getName() {
        return name;
    }

    public String receipt(){
        return getName() ;
    }
}

---------------------------------------------------------
  public class Sundae extends IceCream {

    private String sundaeName;
    private int toppingPrice;

    public Sundae(String iceCreamName, int iprice, String name, int price ){
        super(iceCreamName,iprice);
        this.sundaeName = name;
        this.toppingPrice = price;
    }
    public int getCost(){
        return super.getCost() + this.toppingPrice;
    }

    public String getSundaeName() {
        return sundaeName;
    }
    public String receipt(){
        return getSundaeName() + " Sundae with \n" + super.getName();
    }
}
