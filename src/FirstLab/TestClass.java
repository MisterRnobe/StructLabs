package FirstLab;

/**
 * Created by Dell on 11.04.2017.
 */
public class TestClass {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = HashMap.createChaining(10);
        hashMap.add("John",123);
        hashMap.add("Will",456);
        hashMap.add("James",798);
        int val = hashMap.remove("Will");
        System.out.println(val);
        System.out.println(hashMap.get("Will"));
        HashMap<String, Integer> openAddressing = HashMap.createAddressing(10);
        openAddressing.add("John", 123);
        openAddressing.add("Will", 456);
        openAddressing.add("James", 789);
        System.out.println(openAddressing.get("John"));
        openAddressing.remove("John");
        System.out.println(openAddressing.get("John"));
        openAddressing.add("John", 123);
        System.out.println(openAddressing.get("John"));
    }
}
