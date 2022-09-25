import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BookingManager bkmg = new BookingManager();
        Scanner s = new Scanner(System.in);
        while(true){
            System.out.println("Enter 1 to proceed or anything else to quit");
            String ip1 = s.next();
            if(ip1.equals("1")){
                System.out.println("Enter occupancy: single, double or triple - Defaults to Single : ");
                String occupancy = s.next().toLowerCase();
                if(occupancy.equals("double")){
                    System.out.println("Double occupancy selected");
                } else if(occupancy.equals("triple")){
                    System.out.println("Triple occupancy selected");
                } else {
                    System.out.println("Single occupancy selected");
                }

                System.out.println("Do you need AC in the room? Enter yes or no - Defaults to no : ");
                String inAC = s.next().toLowerCase();
                boolean needAC = false;
                if(inAC.equals("yes")){
                    needAC = true;
                }

                System.out.println("Floor preference if any? Enter value between 1 and 2 - Defaults to No Preference");
                String floor = s.next();
                if(floor.equals("1") || floor.equals("2")){
                    System.out.println(bkmg.bookRoom(occupancy, needAC, Integer.parseInt(floor)));
                } else {
                    System.out.println(bkmg.bookRoom(occupancy, needAC, Integer.MIN_VALUE));
                }
            } else {
                break;
            }
        }
    }
}
