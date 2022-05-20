import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

//        MapImpl m = new MapImpl<Integer, String>();
//        MapPair<Integer, String> mp = new MapPairImpl(new Integer(1), new String("abc"));
//        m.pairs[0] = mp;
//        System.out.println(m.pairs[0].getKey().get());
//        System.out.println(m.pairs[0].getValue().get());
//        Object ans =  m.get(Integer.valueOf(2));
//        System.out.println(ans);
//        String name = "I love you";
//        name = "Masha";
//        changeName(name);
//        System.out.println(name);
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(null, null);
//        m.put(null, 2);
        System.out.println(m.size());
        System.out.println(m.get(null));
    }

//    public static void changeName(String name) {
//        name = name.replace(' ', '_');
//        System.out.println(name);
//    }
}
