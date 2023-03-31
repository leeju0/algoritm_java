import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {
    public static void main(String[] args) {

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("주석",50,50000));
        items.add(new Item("백금",10,600000));
        items.add(new Item("은",25,100000));
        items.add(new Item("금",15,750000));


        Collections.sort(items);
        System.out.println(items);
    }
}
class Item implements Comparable<Item>{
    String name;
    int weight;
    int value;
    double unitValue;

    public Item(String name, int weight, int value){
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.unitValue = (double)value / weight;
    }


    @Override
    public int compareTo(Item o){
        return -(int)(unitValue - o.unitValue);
    }

    @Override
    public String toString(){
        return String.format("[%s] weight=%d, value=%d, "+"unit value=%.2f\n",name,weight,value,unitValue);
    }
}