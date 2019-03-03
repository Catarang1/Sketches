import java.util.*;

public class Test {
    public static void main (String[] parameters) {
        Map map = new RegExMap ();

        map.put ("foo(.+)", "value");

        System.out.println (map.get ("foo"));
        System.out.println (map.get ("foobar"));
    }

    private static class RegExMap extends HashMap {
        public Object get (Object key) {
            String keyAsString = key.toString ();

            String regExKey = null;

            Iterator it = keySet ().iterator ();

            while (it.hasNext () && (regExKey == null)) {
                String keyFromSet = it.next ().toString ();

                if (keyAsString.matches (keyFromSet)) {
                    regExKey = keyFromSet;
                }
            }

            return (regExKey == null) ? null : super.get (regExKey);
        }
    }
}
