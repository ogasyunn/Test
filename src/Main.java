import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        
        HelloWorld hw = new HelloWorld();
        Window wd = new Window();

        Scanner input = new Scanner(System.in);
        int option = input.nextInt();

        if (option == 0) {
            hw.print();
        }
        else if (option == 1) {
            hw.show();
        }
        else if (option == 2) {
            wd.window();
        }

        input.close();

    }
}