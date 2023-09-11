import java.sql.SQLOutput;
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


        while (true) {

            System.out.println("메뉴 입력 : ");

            String command = scan.nextLine();
            if(command.equals("exit")){
                System.out.println("프로그램을 종료합니다.");
                break;
            }

        }


    }
}

