import java.util.Map;
import java.util.Scanner;

public class Modify {
    public String guide() {
        System.out.println("수정할 게시물의 제목을 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        return title;
    }

    public void title(Map<String, String> board) {
        String title = guide();
        String text = board.get(title);
        System.out.println("게시물의 새로운 제목을 입력해주세요");
        Scanner titleScanner = new Scanner(System.in);
        String newTitle = titleScanner.nextLine();
        String removeTitle = board.remove(title);
        if (removeTitle != null) { // 삭제하려는 키가 존재하지 않으면 remove() 메서드는 null을 반환
            board.put(newTitle, text);
        }
    }

    public void text(Map<String, String> board) {
        String title = guide();
        System.out.println("게시물의 새로운 내용을 입력해주세요");
        Scanner textScanner = new Scanner(System.in);
        String newText = textScanner.nextLine();
        String removeText = board.remove(title);
        if (removeText != null) {
            board.put(title, newText);
        }
    }

    public void titleAndText(Map<String, String> board) {
        String title = guide();
        System.out.println("게시물의 새로운 제목을 입력해주세요");
        Scanner titleScanner = new Scanner(System.in);
        String newTitle = titleScanner.nextLine();
        System.out.println("게시물의 새로운 내용을 입력해주세요");
        Scanner textScanner = new Scanner(System.in);
        String newText = textScanner.nextLine();
        String removeText = board.remove(title);
        if (removeText != null) {
            board.put(newTitle, newText);
        }
    }
}
