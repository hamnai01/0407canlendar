
package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class make_calendar {
   
	//1~6�ֱ����� ����Ʈ. ���� ���⿡ �Է��Ѵ��� ������, �����ޱ����� n�ֿ� �ش��ϴ� ������ ���������.
   List<Object>dayList1  = new ArrayList<Object>();
   List<Integer>dayList2  = new ArrayList<Integer>();
   List<Integer>dayList3  = new ArrayList<Integer>();
   List<Integer>dayList4  = new ArrayList<Integer>();   
   List<Object>dayList5  = new ArrayList<Object>();
   List<Object>dayList6  = new ArrayList<Object>();
//object�� �ִ� ����: ù°�ֶ� �������ֿ��� ���鵵 �־�����ؼ�
   
   //Ķ���� �Ӹ��� ������ִ� �޼ҵ�
   public void calendar_head(int month, int year) {
      
      int beforemonth =0;
      int beforeyear = 0;
      int aftermonth=0;
      int afteryear=0;
      
      if(month-1 ==0) {
         beforeyear = year-1;
         beforemonth=12;
      }else if(month+1==13){
         beforeyear = year-1;
         beforemonth=12;
         afteryear= year+1;
         aftermonth= 1;
      
      }else {
         beforeyear=year;
         afteryear=year;
         aftermonth=month+1;
         beforemonth= month-1;
      }
      
      System.out.println();
      System.out.println();      
      System.out.println(
            "\t"+"\t"+beforeyear+"�⵵"+" "+(beforemonth)+"��"
            +"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+year+"�⵵"+" "+month+"��"
            +"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+afteryear+"�⵵"+" "+(aftermonth)+"��"
            );
      System.out.println();
      System.out.println(
            "��"+"\t"+"��"+"\t"+"ȭ"+"\t"+"��"+"\t"+"��"+"\t"+"��"+"\t"+"��"
                  +"\t"+"\t"+"��"+"\t"+"��"+"\t"+"ȭ"+"\t"+"��"+"\t"+"��"+"\t"+"��"+"\t"+"��"
                  +"\t"+"\t"+"��"+"\t"+"��"+"\t"+"ȭ"+"\t"+"��"+"\t"+"��"+"\t"+"��"+"\t"+"��"
            );
      System.out.println(
            "--------------------------------------------------"+"\t"+"\t"
                  +"--------------------------------------------------"+"\t"+"\t"
                  +"--------------------------------------------------"+"\t"+"\t"
            );
   }
   
   
   //�Է¹��� ���� ���ۿ���, ��������¥ ���ϱ�.....
   public void make_calendar( int month, int year) {
      
      Calendar cal = Calendar.getInstance();
      
      if(month==0) {
         year--;
         month=12;
      }else if(month==13) {
         year++;
         month=1;
      }
      
      //�̰� �Է��� ���� ù��° ��¥�� �Է��ϴ°�
      //-> �ش� ��¥�� ���� ������ ���ڷ� ����. �Ͽ��Ϻ��� ����ϱ��� 1���� �����ؼ� ���������� ��Ÿ����.
      cal.set(year, month-1 ,1);
      int week = cal. get(Calendar.DAY_OF_WEEK);   
      int lastDay =  cal.getActualMaximum(Calendar.DAY_OF_MONTH);
      
      
      dayList(year, month, week, lastDay);
   }
   //make_calendar�޼ҵ带 �������� �����°͵��� �̿��� ����Ʈ�� ��¥ ����ֱ�
   public void dayList(int year, int month, int week, int lastDay) {
   
   
      
      //�ش� ���� ù��° ��¥ �����ϱ� ������ ���� �־���
      for(int i=1; i<week; i++) {
         dayList1.add(".");
      }
      // ù°��
      for(int i=1; i<=7-week+1; i++) {
         dayList1.add(i);
      }
      
      // ��°��
      for(int i=7-week+1+1; i<=7-week+1+7; i++) {
         dayList2.add(i);
      }
      //��°��
      for(int i=7-week+1+1+7; i<=7-week+1+7+7; i++) {
         dayList3.add(i);
      }
      //��°��
      for(int i=7-week+1+1+7+7; i<=7-week+1+7+7+7; i++) {
         dayList4.add(i);
      }
      
      //��������(�������ְ� 5���ϼ��� 6���ϼ��� �־)
      if(lastDay<7-week+1+1+7+7+7+7) {   
         for(int i=7-week+1+1+7+7+7; i<=lastDay; i++) {
            dayList5.add(i);
         }
         for(int i=0; i<7 ;i++) {
            dayList6.add(".");
         }
      }else {
         for(int i=7-week+1+1+7+7+7; i<=7-week+1+1+7+7+7+7; i++) {
            dayList5.add(i);
         }

         for(int i=7-week+1+1+7+7+7+7; i<=lastDay; i++) {
            dayList6.add(i);
         }
      }
      //�������ֿ��� ���� �������ؼ�
      if(dayList5.size()%7!=0) {
         for(int j=0; j<=dayList5.size()%7; j++) {
            dayList5.add(".");
         }
      }
      
      if(dayList6.size()%7!=0) {
         for(int j=0; j<=dayList6.size()%7; j++) {
            dayList6.add(".");
         }
      }
      
      
   }
   
   public void print() {
      //i:21���� �ݺ��ϴ� ����: i�� 3��ġ ù°���� �ϵ鸸ŭ �ݺ��Ǿ� ��µǾ���ؼ� 7*3 =21...
	   
	   //ù°�� ����Ʈ
      for(int i=0; i<21; i++) {
         System.out.print(dayList1.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();
      //������ ����Ʈ
      for(int i=0; i<21; i++) {
         System.out.print(dayList2.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();

      //��°�� ����Ʈ
      for(int i=0; i<21; i++) {
         System.out.print(dayList3.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();
      //��°�� ����Ʈ
      for(int i=0; i<21; i++) {
         System.out.print(dayList4.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();
      //�ټ���°�� ����Ʈ
      for(int i=0; i<21; i++) {
         System.out.print(dayList5.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();
      //���������� ����Ʈ
      for(int i=0; i<dayList6.size(); i++) {
         System.out.print(dayList6.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      
   }

   
}