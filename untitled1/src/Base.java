public class Base extends BaseClass {
    public Base() {}
    {
        System.out.println("I’m Base class");
    }
    static {
        System.out.println("static Base");
    }
    public static void main(String[] args) {
        new Base();
    }
}