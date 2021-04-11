
package calendar;

import java.util.Scanner;

public class start {

   public static void main(String[] args) {      
      //사용자가 입력할 변수 선언
      int year = 0;
      int month= 0;
      
      
      //년도 입력받기
      Scanner sc = new Scanner(System.in);   
      System.out.println("년도 입력");   
      year = sc.nextInt();
   
      //월 입력받기
      System.out.println("월 입력");   
      month = sc.nextInt();
      
      
      //다른클래스의 메소드들 실행시킴
      make_calendar body = new make_calendar();   
      body.calendar_head(month, year);
      body.make_calendar(month-1, year);
      body.make_calendar(month, year);
      body.make_calendar(month+1, year);
      body.print();

       
      
      
      
      
   }

}