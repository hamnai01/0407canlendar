
package calendar;

import java.util.Scanner;

public class start {

   public static void main(String[] args) {      
      //����ڰ� �Է��� ���� ����
      int year = 0;
      int month= 0;
      
      
      //�⵵ �Է¹ޱ�
      Scanner sc = new Scanner(System.in);   
      System.out.println("�⵵ �Է�");   
      year = sc.nextInt();
   
      //�� �Է¹ޱ�
      System.out.println("�� �Է�");   
      month = sc.nextInt();
      
      
      //�ٸ�Ŭ������ �޼ҵ�� �����Ŵ
      make_calendar body = new make_calendar();   
      body.calendar_head(month, year);
      body.make_calendar(month-1, year);
      body.make_calendar(month, year);
      body.make_calendar(month+1, year);
      body.print();

       
      
      
      
      
   }

}