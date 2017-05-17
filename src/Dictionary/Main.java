package Dictionary;

/**
 * Created by Dell on 11.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        DictionaryTree<String,Integer> dictionary = new DictionaryTree<String, Integer>("Zero", 0);
        dictionary.put("One",1).put("Two", 2).put("Three", 3).put("Four", 4).put("Five",5)
                .put("Six",6).put("Seven",7).put("Eight",8).put("Nine",9).put("Ten",10);
        dictionary.postOrderPrint().preOrderPrint();
    }
}
