import java.util.Map;
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
    public void duplicate(Map<String, String> board, String t) {
        while(board.containsKey(t)) {
            System.out.println("이미 존재하는 게시물 제목입니다. 다른 제목을 입력해주세요");
            t = title();
        }
    }
}
