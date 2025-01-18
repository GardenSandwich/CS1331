
public class StringOperations {
    public static void main(String[] args) {
        String name = "Hanze Zhang";
        System.out.println(name);

        name = "A" + name.substring(1,11);
        name = name.substring(0,10) + "Z";
        System.out.println(name);

        String address = "www.gatech.edu";
        System.out.println(address);

        address = address.substring(address.indexOf('.')+1);
        address = address.substring(0,address.indexOf('.')) + "1331";
        System.out.println(address);
    }
}
