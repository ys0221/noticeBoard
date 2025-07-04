import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void state() {
        System.out.println("기능을 선택해주세요");
        System.out.println("1.생성 2.수정 3.삭제 4.조회");
    }
    public static void main(String[] args) {
        state();
        Scanner funcscanner = new Scanner(System.in);
        int select = funcscanner.nextInt();
        Map<String, String> board = new HashMap<>();
        while(true) {
            while (select < 0 || select > 4) {
                System.out.println("존재하지 않는 기능입니다. 다시 입력해주세요");
                select = funcscanner.nextInt();
            }
            if (select == 1) {
                // 생성
                generate generate = new generate();
                String title = generate.title();
                String text = generate.text();
                board.put(title, text);
                state();
                select = funcscanner.nextInt();
            } else if (select == 2) {
                // 수정
                break;
            } else if (select == 3) {
                // 삭제
                break;
            } else if (select == 4) {
                // 조회
                System.out.println(board);
                break;
            }
        }
    }
}