import java.util.ArrayList;

public class MyHashMap {
    private ArrayList<Integer> keys;
    private ArrayList<Integer> values;

    public MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    private int getIndex(int key){
        return keys.indexOf(key);
    }

    public void put(int key, int value){
        if(keys.contains(key)){
            int index = getIndex(key);
            values.set(index, value);
            return;
        }
        keys.add(key);
        values.add(value);
        return;
    }
    public int get(int key){
        int index = getIndex(key);
        if(!keys.contains(key)){
            return -1;
        }return values.get(index);
    }

    public void remove(int key){
        int index = getIndex(key);
        if(!keys.contains(key)){
            return;
        }
        keys.remove(index);
        values.remove(index);
    }




    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));            // returns 1
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 1);          // update the existing value
        System.out.println(hashMap.get(2));          // returns 1
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));          // returns -1 (not found)

    }
}
