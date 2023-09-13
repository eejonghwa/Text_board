import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in); // 메모리 차지 때문에 밖에다 만드는게 좋음
//        ArrayList<String> titles = new ArrayList<>();
//        ArrayList<String> contents = new ArrayList<>();

        ArrayList<Article> articles = new ArrayList<>();
        ArrayList<UserInfo> userInfos = new ArrayList<>();

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

                        // 댓글
                        System.out.println("댓글:");
                        ArrayList<String> comments = article.getComments();
                        for (int i = 0; i < comments.size(); i++) {
                            System.out.printf("%d. %s\n", i + 1, comments.get(i));
                        }


                        // 상세보기 메뉴추가
                        System.out.println("==================");
                        System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 추천, 3. 수정, 4. 삭제, 5. 목록으로) : ");

                        int detailMenuChoice = Integer.parseInt(scan.nextLine());

                        switch(detailMenuChoice){
                            case 1:
                                System.out.print("댓글 내용을 입력해주세요 : ");
                                article.addComment(scan.nextLine());
                                System.out.println("댓글이 추가되었습니다.");
                                break;
                            case 2:
                                article.like();
                                System.out.println("게시물을 좋아요했습니다.");
                                break;

                            case 3:
                                System.out.print("새로운 제목 : ");
                                article.setTitle(scan.nextLine());
                                System.out.print("새로운 내용 : ");
                                article.setContent(scan.nextLine());
                                System.out.println("게시물이 수정되었습니다.");
                                break;
                            case 4:
                                articles.remove(article);
                                System.out.println("게시물이 삭제되었습니다.");
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("유효하지 않은 메뉴 선택입니다.");
                        }

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
            } else if (command.equals("signup")){
                System.out.println("==== 회원 가입을 진행합니다 ====");
                System.out.print("아이디를 입력해주세요 : ");
                String userId = scan.nextLine();
                System.out.print("비밀번호를 입력해주세요 : ");
                String userPassword = scan.nextLine();
                System.out.print("닉네임을 입력해주세요 : ");
                String nickname = scan.nextLine();
                System.out.println("회원가입이 완료되었습니다.");

                UserInfo userInfo = new UserInfo(userId, userPassword, nickname);
                userInfos.add(userInfo);
            }else if (command.equals("login")){

            }
        }
    }
}