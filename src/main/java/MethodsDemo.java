public class MethodsDemo {


    public static void main(String[] args) {

// TODO Auto-generated method stub


        MethodsDemo d = new MethodsDemo();

        String name = d.getData();

        System.out.println(name);
        getData2();

        // using 2nd Class

//        MethodsDemo2 d1 = new MethodsDemo2();
//MethodsDemo2 d2 = new MethodsDemo2();
//        d2.getUserData();
//
        MethodsDemo2.getUserData();

        getData2();

//        getData23();


    }


    public String getData() {

        System.out.println("hello world");

        return "rahul shetty";

    }


    public static void getData2() {

        System.out.println("hello world");

//        return "rahul shetty";

    }

    public void getData23() {
        MethodsDemo2.getUserData();
    }


}

