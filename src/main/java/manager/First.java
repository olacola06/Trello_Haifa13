package manager;

public class First {
    public static void main(String[] args) {
        String first = "REMOVE";
        System.out.println(first);
        String second = first.toLowerCase();
        System.out.println(second);
        System.out.println(second.toUpperCase());


        //remove == Remove
        String third = second.substring(0,1).toUpperCase()+second.substring(1);
        System.out.println(third);
    }
}
