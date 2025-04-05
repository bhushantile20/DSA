public class SwappingNumber {
    public static void main(String args[]) {
        int a = 10, b = 20;

        System.out.println("Before swapping:");

        // int t = a;
        // a = b;
        // b = t;

        a = a + b; // 10+20=30
        b = a - b; // 30-20
        a = a - b; // 30-10=20

        // Logic three use * and \

        a = a * b;// a*20 =200
        b = a / b;// 200/20=10
        a = a / b;// 200/10=20

        System.out.println("After swapping are:" + a + " " + b);

    }
}