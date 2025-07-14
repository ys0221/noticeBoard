import java.util.Map;
import java.util.Scanner;

public class Delete {
    public String deleteTitle(Map<String, String> map) {
        System.out.println("삭제할 게시물의 제목을 입력하세요: ");
        Scanner titleScanner = new Scanner(System.in);
        String title = titleScanner.nextLine();
        while (!map.containsKey(title) ) {
            System.out.println("해당 게시물이 존재하지 않습니다.");
            title = titleScanner.nextLine();
        }
        return title;
    }

    public void delete(String title, Map<String, String> board) {
        board.remove(title);
    }
}
