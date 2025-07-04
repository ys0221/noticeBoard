import java.util.Scanner;

public class generate {
    public String title() {
        System.out.println("게시판 제목을 입력하세요");
        Scanner titleScanner = new Scanner(System.in);
        String title = titleScanner.nextLine();
        return title;
    }
    public String text() {
        System.out.println("게시판 내용을 입력하세요");
        Scanner textScanner = new Scanner(System.in);
        String text = textScanner.nextLine();
        return text;
    }
}
