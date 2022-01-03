public class Test {
    public static void main(String[] args) {
        String id = "admin";
        int len = id.length()*2/3;
        String fill = "";
        for (int i = len; i < id.length(); i++) {
            fill+='*';
        }
        System.out.println(id.substring(0,len)+fill);
    }
}
