public class Recursion {

    int func(int n) {
        int result;
        if (n == 1)
            return 1;
        result = func(n - 1);
        return result;
    }

    public static void main(String[] args) {
        Recursion obj = new Recursion();
        System.out.print(obj.func(5));

        String c = "Hello i love java";
        boolean var;
        var = c.startsWith("hello");
        System.out.println(var);

    }
}

