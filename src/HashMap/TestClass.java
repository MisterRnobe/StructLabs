package HashMap;

/**
 * Created by Dell on 11.04.2017.
 */
public class TestClass {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap = HashMap.createAddressing(10);
        hashMap.add(0,"a");
        hashMap.add(1,"b");
        hashMap.add(2,"d");
        hashMap.add(3,"d");
        hashMap.add(4,"e");
        hashMap.add(5,"f");
        ((OpenAddressing)hashMap).print();
        hashMap.add(11,"g");
        hashMap.add(12,"g");
        hashMap.add(13,"g");
        hashMap.add(14,"p");

        hashMap.remove(0);
        hashMap.remove(5);
        hashMap.remove(1);
        hashMap.remove(15);
        ((OpenAddressing)hashMap).print();
        hashMap.add(0,"a");
        ((OpenAddressing)hashMap).print();

    }
}
