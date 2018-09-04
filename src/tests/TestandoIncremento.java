package tests;

public class TestandoIncremento {

    public static void main(String[] a) {
        int z = -3;
        System.out.println("VAlor inicial z: " + z);
        for (int i = 0; i < 10; i++) {
            System.out.println(z++);
        }
        System.out.println("valor final de z: " + z);
    }
}
