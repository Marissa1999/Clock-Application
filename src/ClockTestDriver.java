
public class ClockTestDriver
{

   public static void print(Clock clockValue, String description)
   {
      System.out.printf("%s   %s%n", clockValue, description);
   }

   public static void main(String[] args)
   {

      // Test default constructor + constructor with 3 params
      Clock wall_clock = new Clock(); // 00:00:00
      assert (wall_clock.equals(new Clock(0, 0, 0)));
      print(wall_clock, "wall_clock: default constructor + constructor with 3 params ok");

      // Test  setMinute + setSecond
      wall_clock.setMinute(59);
      wall_clock.setSecond(58);
      assert (wall_clock.equals(new Clock(0, 59, 58)));
      print(wall_clock, "wall_clock: setMinute + setSecond ok");

      // Test switchToStandardTime + isAmPmEnabled
      wall_clock.switchToStandardTime();
      assert (wall_clock.isAmPmEnabled());
      print(wall_clock, "wall_clock: switchToStandardTime + isAmPmEnabled ok");

      // Test hideSeconds + isSecondsDisplayed
      wall_clock.hideSeconds();
      assert (!wall_clock.isSecondsDisplayed());
      print(wall_clock, "wall_clock: hideSeconds + isSecondsDisplayed ok");

     // Test hideSeconds + isSecondsDisplayed
      wall_clock.showSeconds();
      assert (wall_clock.isSecondsDisplayed());
      print(wall_clock, "wall_clock: showSeconds + isSecondsDisplayed ok");

      // Test showSeconds + isSecondsDisplayed
      wall_clock.switchToMilitaryTime();
      assert (!wall_clock.isAmPmEnabled());
      print(wall_clock, "wall_clock: switchToMilitaryTime + isAmPmEnabled ok");

      // Test switchToStandardTime
      wall_clock.switchToStandardTime();
      assert (wall_clock.isAmPmEnabled());
      print(wall_clock, "wall_clock: switchToStandardTime  ok");

      // Test  tickHour(-1)
      wall_clock.tickHour(-1); // back one hour
      assert (wall_clock.equals(new Clock(23, 59, 58)));
      print(wall_clock, "wall_clock: tickHour(-1) ok");

      // Test ctor with 1 param
      System.out.printf("%n");
      Clock table_clock = new Clock(13);
      print(table_clock, "table_clock: ctor with 1 param ok");
      assert (table_clock.equals(new Clock(13, 0, 0)));
      
      // Test precedes
      if( wall_clock.precedes(table_clock))
      {
         System.out.printf("%s precedes %s%n", wall_clock, table_clock);
      }
      else
      {
         System.out.printf("%s does not precede %s%n", wall_clock, table_clock);
      }

        // Test precedes
      if( table_clock.precedes(wall_clock))
      {
         System.out.printf("%s precedes %s%n", table_clock, wall_clock);
      }
      else
      {
         System.out.printf("%s does not precede %s%n", table_clock, wall_clock);
      }
      // Test setMinute(58), tickMinute(1), setSecond(57), tickSecond(1),
      // Test ctor with 3 params
      table_clock.setMinute(58);
      table_clock.tickMinute(1);
      table_clock.setSecond(57);
      table_clock.tickSecond(1);
      assert (table_clock.equals(new Clock(13, 59, 58))); // constructor with 3 params
      print(table_clock, "table_clock: setMinute(58), tickMinute(1), setSecond(57), tickSecond(1) ok");

      // Test tickMinute(10)
      table_clock.tickMinute(10); // forward 10 minutes
      assert (table_clock.equals(new Clock(14, 9, 58)));
      print(table_clock, "table_clock: tickMinute(10) ok");

      // Test tickMinute(-10)
      table_clock.tickMinute(-10); // backward 10 minutes
      assert (table_clock.equals(new Clock(13, 59, 58)));
      print(table_clock, "table_clock:tickMinute(-10) ok");

      // Test hideSeconds(), switchToStandardTime
      table_clock.hideSeconds(); // backward 10 minutes
      table_clock.switchToStandardTime();
      print(table_clock, "table_clock: hideSeconds(), switchToStandardTime()");

      // Test tickHour(-38)
      table_clock.tickHour(-38);
      assert (table_clock.equals(new Clock(23, 59, 58)));
      print(table_clock, "table_clock:  tickHour(-38)");

      // Test ctor with 2 params
      System.out.printf("%n");
      Clock floor_clock = new Clock(23, 52);
      assert (floor_clock.equals(new Clock(23, 52, 0)));
      print(floor_clock, "floor_clock: ctor with 2 params ok");

     // Test set_seconds(58)
     floor_clock.setSecond(58);
     assert (floor_clock.equals(new Clock(23, 52, 58)));
     print(floor_clock, "floor_clock: set_seconds(58) ok");

      // Test tickMinute(-53)
      floor_clock.tickMinute(-53);
      assert (floor_clock.equals(new Clock(22, 59, 58)));
      print(floor_clock, "floor_clock: tickMinute(-53) ok");

      // Test tickHour(49)
      floor_clock.tickHour(49);
      assert (floor_clock.equals(new Clock(23, 59, 58)));
      print(floor_clock, "floor_clock: tickHour(49) ok");
      
      // Test ctor with 3 params
      System.out.printf("%n");
      Clock mantel_clock = new Clock(floor_clock);
      assert (mantel_clock.equals(floor_clock));
      print(mantel_clock, "mantel_clock: copy constructor, equals ok");
      mantel_clock.hideSeconds();
      print(mantel_clock, "mantel_clock: disabled seconds");

      System.out.println("");
      System.out.printf("| wall_clock  | table_clock | floor_clock | mantel_clock|\n");
      System.out.printf("| %11s | %11s | %11s | %11s |\n", wall_clock, table_clock, floor_clock, mantel_clock);
      // let the clocks tick for 5 seconds
      for (int i = 1; i <= 5; ++i)
      {
         floor_clock.tickSecond(1);
         wall_clock.tickSecond(1);
         table_clock.tickSecond(1);
         mantel_clock.tickSecond(1);
         System.out.printf("| %11s | %11s | %11s | %11s |\n", wall_clock, table_clock, floor_clock, mantel_clock);
      }

      System.out.println("");
      int secondsToTick_a = 59 * 60 + 55; // 59 minutes and 55 seconds
      floor_clock.tickSecond(secondsToTick_a);
      wall_clock.tickSecond(secondsToTick_a);
      table_clock.tickSecond(secondsToTick_a);
      mantel_clock.tickSecond(secondsToTick_a);

      System.out.printf("| %11s | %11s | %11s | %11s |\n", wall_clock, table_clock, floor_clock, mantel_clock);
      // let the clocks tick for 5 seconds
      for (int i = 1; i <= 5; ++i)
      {
         floor_clock.tickSecond(1);
         wall_clock.tickSecond(1);
         table_clock.tickSecond(1);
         mantel_clock.tickSecond(1);
         System.out.printf("| %11s | %11s | %11s | %11s |\n", wall_clock, table_clock, floor_clock, mantel_clock);
      }

      System.out.println("");
      int secondsToTick_b = 10 * 3600 + 59 * 60 + 55; // 10 hours and 59 minutes and 55 seconds
      floor_clock.tickSecond(secondsToTick_b);
     wall_clock.tickSecond(secondsToTick_b);
      table_clock.tickSecond(secondsToTick_b);
      mantel_clock.tickSecond(secondsToTick_b);

      System.out.printf("| %11s | %11s | %11s | %11s |\n", wall_clock, table_clock, floor_clock, mantel_clock);
      // let the clocks tick for 5 seconds
      for (int i = 1; i <= 5; ++i)
      {
         floor_clock.tickSecond(1);
         wall_clock.tickSecond(1);
         table_clock.tickSecond(1);
         mantel_clock.tickSecond(1);
         System.out.printf("| %11s | %11s | %11s | %11s |\n", wall_clock, table_clock, floor_clock, mantel_clock);
      }

      System.out.println("");
      // tick 59 minutes and 55 seconds
      floor_clock.tickSecond(secondsToTick_a);
      wall_clock.tickSecond(secondsToTick_a);
      table_clock.tickSecond(secondsToTick_a);
      mantel_clock.tickSecond(secondsToTick_a);

      System.out.printf("| %11s | %11s | %11s | %11s |\n", wall_clock, table_clock, floor_clock, mantel_clock);
      // let the clocks tick for 5 seconds
      for (int i = 1; i <= 5; ++i)
      {
         floor_clock.tickSecond(1);
         wall_clock.tickSecond(1);
         table_clock.tickSecond(1);
         mantel_clock.tickSecond(1);
         System.out.printf("| %11s | %11s | %11s | %11s |\n", wall_clock, table_clock, floor_clock, mantel_clock);
     }
   }
}
