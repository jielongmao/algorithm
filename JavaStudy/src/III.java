/**
 * @author DIO的面包店
 * @since 2022/4/19 15:43
 */
class X {
    Y y = new Y();
    static {System.out.println("tttt"); }
    X() { System.out.println("X");}
    public static void main(String[] args) {
        new Z();
    }
}
class Y {
    Y() {
        System.out.println("Y");
    }
}
class Z extends X {
    Y y = new Y();
    static {System.out.println("tt");}
    Z() {
        System.out.println("Z");
    }
}
