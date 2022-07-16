package com.ll.ssg6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== 명언 SSG ===");
        int count = 0;
        List<WiseSaying> wiseSayings = new ArrayList();
        outer :
        while(true){
            System.out.print("명령) ");
            String cmd = sc.nextLine();

            Rq rq = new Rq (cmd);


            switch (rq.getPath()){
                case "종료" :
                    break outer;

                case "등록" :
                    System.out.print("명언 : ");
                    String content = sc.nextLine().trim();
                    System.out.print("작가 : ");
                    String author = sc.nextLine().trim();
                    int id = ++count;
                    WiseSaying wiseSaying = new WiseSaying(id,author,content);
                   wiseSayings.add(wiseSaying);
                    System.out.printf("%d번 명언이 등록되었습니다.\n" , id);
                    break;

                case "목록" :
                    System.out.println("번호  /  작가  /  명언");
                    System.out.println("---------------------");
                    for(int i = wiseSayings.size()-1; i>=0 ; i--){
                        WiseSaying wiseSaying_ = wiseSayings.get(i);
                        System.out.printf("%d  /  %s  /  %s\n", wiseSaying_.id,wiseSaying_.author,wiseSaying_.content);
                    }

                    break;

                case "삭제" :
                    int paramId = rq.getIntParam("id", 0);
                    if(paramId == 0){
                        System.out.println("id를 입력해주세요.");
                        continue ;
                    }

                    WiseSaying wiseSaying__ = null;

                    for( WiseSaying wiseSaying___ : wiseSayings){
                        if(wiseSaying___.id == paramId){
                            wiseSaying__ = wiseSaying___;
                        }
                    }
                    if(wiseSaying__ == null){
                        System.out.printf("%d번 명언은 존재하지않습니다.\n" , paramId);
                    }

                    wiseSayings.remove(wiseSaying__);


                    System.out.printf("%d번 명언이 삭제되었습니다.\n" , paramId);

                    break;
                case "수정" :
                    int paramId_ = rq.getIntParam("id", 0);
                    if(paramId_ == 0){
                        System.out.println("id를 입력해주세요.");
                        continue ;
                    }

                    WiseSaying wiseSaying___ = null;

                    for( WiseSaying wiseSaying____ : wiseSayings){
                        if(wiseSaying____.id == paramId_){
                            wiseSaying___ = wiseSaying____;
                        }
                    }
                    if(wiseSaying___ == null){
                        System.out.printf("%d번 명언은 존재하지않습니다.\n" , paramId_);
                    }

                    System.out.printf("명언(기존) : %s\n", wiseSaying___.content);
                    System.out.print("명언 : ");
                    wiseSaying___.content = sc.nextLine().trim();
                    System.out.printf("작가(기존) : %s\n", wiseSaying___.author);
                    System.out.print("작가 : ");
                    wiseSaying___.author = sc.nextLine().trim();


                    System.out.printf("%d번 명언이 수정되었습니다.\n" , paramId_);

                    break;

            }
        }
    }
}
