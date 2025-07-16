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
                generate.duplicate(board, title);
                String text = generate.text();
                board.put(title, text);
                state();
                select = funcscanner.nextInt();
            } else if (select == 2) {
                // 수정
                Modify modify = new Modify();
                System.out.println("1.제목만 수정 2.내용만 수정 3.제목과 내용 모두 수정");
                Scanner optionScanner = new Scanner(System.in);
                int modifyOption = optionScanner.nextInt();
                while (modifyOption < 1 || modifyOption > 3) {
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                    modifyOption = optionScanner.nextInt();
                }
                if (modifyOption == 1) {
                    modify.titleModify(board);
                } else if(modifyOption == 2) {
                    modify.textModify(board);
                } else if(modifyOption == 3) {
                    modify.titleAndTextModify(board);
                } else {
                    // nothing
                }
                state();
                select = funcscanner.nextInt();
            } else if (select == 3) {
                // 삭제
                Delete delete = new Delete();
                String title = delete.deleteTitle(board);
                System.out.println(title+" 을 삭제하시겠습니까?");
                System.out.println("1.네 2.아니오");
                Scanner selectScanner = new Scanner(System.in);
                int selectOption = selectScanner.nextInt();
                if (selectOption == 1) {
                    delete.delete(title, board);
                    System.out.println(title+" 이 삭제되었습니다.");
                } else if(selectOption == 2) {
                    System.out.println("취소되었습니다.");
                }
                state();
                select = funcscanner.nextInt();
            } else if (select == 4) {
                // 조회
                if (board.isEmpty()) {
                    System.out.println("조회할 게시물이 없습니다.");
                } else {
                    System.out.println(board);
                }
                state();
                select = funcscanner.nextInt();
            }
        }
    }
}