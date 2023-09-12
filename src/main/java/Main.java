import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

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
//        ArrayList<String> titles = new ArrayList<>();
//        ArrayList<String> contents = new ArrayList<>();

        ArrayList<Article> articles = new ArrayList<>();

        int lastArticleId = 1;

        Article testArticle1 = new Article(1,"테스트 제목1", "테스트 내용 1");
        Article testArticle2 = new Article(2,"테스트 제목2", "테스트 내용 2");
        Article testArticle3 = new Article(3,"테스트 제목3", "테스트 내용 3");

        articles.add(testArticle1);
        articles.add(testArticle2);
        articles.add(testArticle3);

        while (true) {

            System.out.print("명령어 : ");

            String command = scan.nextLine();
            if (command.equals("exit")) {

                System.out.println("프로그램을 종료합니다.");
                break;

            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 :");
                String title = scan.nextLine();

                System.out.print("게시물 내용을 입력해주세요 :");
                String content = scan.nextLine();

                Article article = new Article(lastArticleId, title, content);
                articles.add(article);


                System.out.println("게시물이 등록되었습니다.");
                lastArticleId++;

            } else if (command.equals("list")) {
                for (int i = 0; i < articles.size(); i++) {

                    Article article = articles.get(i);

                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.println("===============");
                }

            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호를 입력해주세요 : ");
                String number = scan.nextLine();
                try{
                    int targetId = Integer.parseInt(number);

                    boolean isExist = false;

                    for (int i = 0; i < articles.size(); i++) {
                        Article article = articles.get(i);

                        if (targetId == article.getId()) {
                            System.out.print("새로운 제목 : ");
                            String newTitle = scan.nextLine();
                            System.out.print("새로운 내용 : ");
                            String newContent = scan.nextLine();

                            Article newArticle = new Article(targetId, newTitle, newContent);

                            articles.set(i, newArticle);
                            System.out.println("수정이 완료되었습니다.");
                            isExist = true;
                        }
                    }


                    if (isExist == false) {
                        System.out.println("없는 게시물입니다.");
                    }

                }catch (NumberFormatException e){
                    System.out.println("숫자를 입력해주세요.");
                }

            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                String number = scan.nextLine();
                try{
                    int targetId = Integer.parseInt(number);


                    boolean isExist = false;

                    for (int i = 0; i < articles.size(); i++) {
                        Article article = articles.get(i);

                        if (targetId == article.getId()) {
                            articles.remove(i);
                            System.out.printf("%d번 게시물이 삭제되었습니다.\n", targetId);

                            isExist = true;
                        }
                    }

                }catch (NumberFormatException e) {
                    System.out.println("숫자를 입력해주세요.");
                }

            } else if (command.equals("detail")) {
                System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
                String number = scan.nextLine();
                try {
                    int target = Integer.parseInt(number);


                    if (0 < target && target <= articles.size()) {
                        Article article = articles.get(target - 1);

                        article.increaseViews();

                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
                        String formattedDate = dateFormat.format(article.getDate());

                        System.out.printf("제목 : %s\n", article.getTitle());
                        System.out.printf("내용 : %s\n", article.getContent());
                        System.out.printf("등록날짜 : %s\n", formattedDate);
                        System.out.printf("조회수 : %d\n",article.getViews());
                    } else {
                        System.out.println("없는 게시물 입니다. ");
                    }


                }catch(NumberFormatException e){
                    System.out.println("숫자를 입력해 주세요.");
                }



            } else if (command.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 : ");
                String keyword = scan.nextLine();

                ArrayList<Article> searchResults = new ArrayList<>();

                for (Article article : articles) {
                    if (article.getTitle().contains(keyword) || article.getContent().contains(keyword)) {
                        searchResults.add(article);
                    }
                }
                if (searchResults.isEmpty()) {
                    System.out.println("검색 결과가 없습니다.");
                } else {
                    System.out.println("검색 결과 : ");
                    for (Article result : searchResults) {
                        System.out.printf("번호 : %d\n", result.getId());
                        System.out.printf("제목 : %s\n", result.getTitle());
                        System.out.println("========================");
                    }
                }
            }
        }
    }
}