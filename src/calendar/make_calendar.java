
package calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class make_calendar {
   
	//1~6주까지의 리스트. 이제 여기에 입력한달의 저번달, 다음달까지의 n주에 해당하는 날들을 집어넣을것.
   List<Object>dayList1  = new ArrayList<Object>();
   List<Integer>dayList2  = new ArrayList<Integer>();
   List<Integer>dayList3  = new ArrayList<Integer>();
   List<Integer>dayList4  = new ArrayList<Integer>();   
   List<Object>dayList5  = new ArrayList<Object>();
   List<Object>dayList6  = new ArrayList<Object>();
//object가 있는 이유: 첫째주랑 마지막주에는 공백도 넣어줘야해서
   
   //캘린더 머리를 만들어주는 메소드
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
            "\t"+"\t"+beforeyear+"년도"+" "+(beforemonth)+"월"
            +"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+year+"년도"+" "+month+"월"
            +"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+"\t"+afteryear+"년도"+" "+(aftermonth)+"월"
            );
      System.out.println();
      System.out.println(
            "일"+"\t"+"월"+"\t"+"화"+"\t"+"수"+"\t"+"목"+"\t"+"금"+"\t"+"토"
                  +"\t"+"\t"+"일"+"\t"+"월"+"\t"+"화"+"\t"+"수"+"\t"+"목"+"\t"+"금"+"\t"+"토"
                  +"\t"+"\t"+"일"+"\t"+"월"+"\t"+"화"+"\t"+"수"+"\t"+"목"+"\t"+"금"+"\t"+"토"
            );
      System.out.println(
            "--------------------------------------------------"+"\t"+"\t"
                  +"--------------------------------------------------"+"\t"+"\t"
                  +"--------------------------------------------------"+"\t"+"\t"
            );
   }
   
   
   //입력받은 달의 시작요일, 마지막날짜 구하기.....
   public void make_calendar( int month, int year) {
      
      Calendar cal = Calendar.getInstance();
      
      if(month==0) {
         year--;
         month=12;
      }else if(month==13) {
         year++;
         month=1;
      }
      
      //이게 입력한 날의 첫번째 날짜를 입력하는거
      //-> 해당 날짜에 대한 요일이 숫자로 리턴. 일요일부터 토요일까지 1부터 시작해서 순차적으로 나타낸다.
      cal.set(year, month-1 ,1);
      int week = cal. get(Calendar.DAY_OF_WEEK);   
      int lastDay =  cal.getActualMaximum(Calendar.DAY_OF_MONTH);
      
      
      dayList(year, month, week, lastDay);
   }
   //make_calendar메소드를 바탕으로 가져온것들을 이용해 리스트에 날짜 집어넣기
   public void dayList(int year, int month, int week, int lastDay) {
   
   
      
      //해당 달의 첫번째 날짜 시작하기 전까지 공백 넣어줌
      for(int i=1; i<week; i++) {
         dayList1.add(".");
      }
      // 첫째주
      for(int i=1; i<=7-week+1; i++) {
         dayList1.add(i);
      }
      
      // 둘째주
      for(int i=7-week+1+1; i<=7-week+1+7; i++) {
         dayList2.add(i);
      }
      //셋째주
      for(int i=7-week+1+1+7; i<=7-week+1+7+7; i++) {
         dayList3.add(i);
      }
      //넷째주
      for(int i=7-week+1+1+7+7; i<=7-week+1+7+7+7; i++) {
         dayList4.add(i);
      }
      
      //마지막주(마지막주가 5주일수도 6주일수도 있어서)
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
      //마지막주에도 공백 찍어줘야해서
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
      //i:21까지 반복하는 이유: i가 3달치 첫째주의 일들만큼 반복되어 출력되어야해서 7*3 =21...
	   
	   //첫째주 프린트
      for(int i=0; i<21; i++) {
         System.out.print(dayList1.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();
      //둘쩨주 프린트
      for(int i=0; i<21; i++) {
         System.out.print(dayList2.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();

      //셋째주 프린트
      for(int i=0; i<21; i++) {
         System.out.print(dayList3.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();
      //넷째주 프린트
      for(int i=0; i<21; i++) {
         System.out.print(dayList4.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();
      //다섯번째주 프린트
      for(int i=0; i<21; i++) {
         System.out.print(dayList5.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      System.out.println();
      //여섯번쩨주 프린트
      for(int i=0; i<dayList6.size(); i++) {
         System.out.print(dayList6.get(i)+"\t");
         if(i%7==6) {
            System.out.print("\t");
         }
      }
      
   }

   
}