// TestDays.java -- Test enum Days of the week

public class TestDays {
   public static void main(String[] args) {
      Days today = Days.monday;
      System.out.println("Today is: " + today);
      System.out.println("Tomorrow is: " + nextDay(today));
   }

   static Days nextDay(Days day) {
      switch(day) {
         case sunday: return(Days.monday);
         case monday: return(Days.tuesday);
         case tuesday: return(Days.wednesday);
         case wednesday: return(Days.thursday);
         case thursday: return(Days.friday);
         case friday: return(Days.saturday);
         default: return(Days.sunday);
      }
   }

   public enum Days {
      sunday, monday, tuesday, wednesday, thursday, friday, saturday
   }
}