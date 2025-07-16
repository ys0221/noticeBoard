import java.util.Map;
import java.util.Scanner;

public class Modify {
    public String guide() {
        System.out.println("수정할 게시물의 제목을 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        return title;
    }

    public String findTitle(Map<String, String> board, String title) {
        Scanner scanner = new Scanner(System.in);
        while(!board.containsKey(title)) {
            System.out.println("해당 게시물이 존재하지 않습니다. 다시 입력해주세요");
            title = scanner.nextLine();
        }
        return title;
    }

    public String checkTitle(Map<String, String> board, String title) {
        Scanner scanner = new Scanner(System.in);
        String newTitle = "";
        if (board.containsKey(title)) {
            System.out.println("이미 존재하는 게시물 제목입니다. 다른 제목을 입력해주세요.");
            newTitle = scanner.nextLine();
        }
        return newTitle;
    }

    public void titleModify(Map<String, String> board) {
        System.out.println("수정할 게시물의 제목을 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        title = findTitle(board, title);
        String text = board.get(title);
        board.remove(title);
        System.out.println("게시물의 새로운 제목을 입력해주세요");
        Scanner titleScanner = new Scanner(System.in);
        String newTitle = titleScanner.nextLine();
        newTitle = checkTitle(board, newTitle);
        board.put(newTitle, text);
    }

    public void textModify(Map<String, String> board) {
        String title = guide();
        title = findTitle(board, title);
        board.remove(title);
        System.out.println("게시물의 새로운 내용을 입력해주세요");
        Scanner textScanner = new Scanner(System.in);
        String newText = textScanner.nextLine();
        board.put(title, newText);
    }

    public void titleAndTextModify(Map<String, String> board) {
        System.out.println("수정할 게시물의 제목을 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        title = findTitle(board, title);
        board.remove(title);
        System.out.println("게시물의 새로운 제목을 입력해주세요");
        Scanner titleScanner = new Scanner(System.in);
        String newTitle = titleScanner.nextLine();
        newTitle = checkTitle(board, newTitle);
        System.out.println("게시물의 새로운 내용을 입력해주세요");
        Scanner textScanner = new Scanner(System.in);
        String newText = textScanner.nextLine();
        board.put(newTitle, newText);
    }
}
