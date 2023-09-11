import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //        // 숫자 비교
//        int a = 10;
//        System.out.println(a == 10);
//
//        // 문자열 비교
//        String str = "hello";
//        System.out.println(str.equals("hello"));


        // 이름 짓는 규칙
        // 변수, 클래스 -> 명사
        // 함수 -> 동사
        // 단어 조합시 단어 의미가 바뀔 때마다 대문자 표현
        // -> 카멜 표기법
        // 클래스 이름 지을 때는 첫글자 무조건 대문자
        // 누가 봐도. 추측 가능한. 단어 조합으로 지어라
        // 파파고, 구글 번역기 챗gpt 사용
        // 이름 짓기 매우 중요

        // 코드 정렬 (심심할 때마다 눌러)
        // alt + ctrl + L


        Scanner scan = new Scanner(System.in); // 메모리 차지 때문에 밖에다 만드는게 좋음
        ArrayList<String> titles = new ArrayList<>();
        ArrayList<String> contents = new ArrayList<>();


        while (true) {

            System.out.print("명령어 : ");

            String command = scan.nextLine();
            if (command.equals("exit")) {

                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요.");
                titles.add(scan.nextLine());

                System.out.print("게시물 내용을 입력해주세요.");
                contents.add(scan.nextLine());

                System.out.println("게시물이 등록되었습니다.");

            } else if (command.equals("list")) {
                for (int i = 0; i < titles.size(); i++) {
                    System.out.println("게시물" + (i + 1));
                    System.out.println("제목" + titles.get(i));
                    System.out.println("내용" + contents.get(i));
                    System.out.println("===============");
                }


            } else if (command.equals("update")) {
                System.out.println("수정할 게시물 번호 : ");
                int postNum = scan.nextInt();


            }
        }
    }
}
