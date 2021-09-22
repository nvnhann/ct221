public class test {
    public static void main(String[] args) {
        String hoten = new String("Nguyen Van Nhan");
        int last_space = hoten.lastIndexOf(' ');
        System.out.println(hoten.substring(last_space + 1));
    }
}