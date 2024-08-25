/**
 * Main
 */
public class Main {
    static int fnum = 10_000;
    static MyFunction<Integer, Integer> g = x -> x;
    static MyFunction<Integer, Integer> f = x -> x + 1;

    public static void main(String... args) {
        MyFunction<Integer, Integer> triple = new MyFunction<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg * 3;
            }
        };

        MyFunction<Integer, Integer> square = new MyFunction<Integer, Integer>() {
            @Override
            public Integer apply(Integer arg) {
                return arg * arg;
            }
        };


        System.out.println(triple.apply(3));
        System.out.println(square.apply(4));
        System.out.println(compose(triple, square).apply(3));

        payAttentionToStackOverflow();
    }


    private static void payAttentionToStackOverflow() {
        for (int i = 0; i < fnum; i++) {
            g = compose(f, g);
        };

        System.out.println(g.apply(0));
    }


    static MyFunction<Integer, Integer> compose(
            final MyFunction<Integer, Integer> f1, final MyFunction<Integer, Integer> f2) {
            return new MyFunction<Integer, Integer>() {
                @Override
                public Integer apply(Integer arg) {
                    return f1.apply(f2.apply(arg));
                }
            };
        }
    
}
