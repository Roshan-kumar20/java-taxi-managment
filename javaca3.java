import java.util.*;

interface OLA{
    class Cab{
        int car_number;
        String driver_name;
        boolean availability;
        Cab(int cn, String dn){
            car_number = cn;
            driver_name = dn;
            availability = true;
        }
    }
    public static Cab getCab(Cab obj) {
        return obj;
    }
}

interface UBER{
    class Cab{
        int car_number;
        String driver_name;
        boolean availability;
        Cab(int cn, String dn){
            car_number = cn;
            driver_name = dn;
            availability = true;
        }
    }
    public static Cab getCab(Cab obj) {
        return obj;
    }
}

class Test implements OLA,UBER{
    static ArrayList<OLA.Cab> OL = new ArrayList<>();
    static ArrayList<UBER.Cab> UL = new ArrayList<>();
    static String[][] Rides = {{"OLA", "Messi", "101"},
                               {"UBER", "Ronaldo", "102"},
                               {"UBER", "Neymer", "103"}
                              };
    static Scanner sc = new Scanner(System.in);                          
    public static void main(String[] args) {
        System.out.println("\n\t\t\t************");
        System.out.println("\t\t\t*Taxi Booking Management System*");
        System.out.println("\t\t\t************");
        Test obj = new Test();

        for(String[] X: Rides){
            if(X[0].equals("OLA")){
                OLA.Cab OC = new OLA.Cab(Integer.parseInt(X[2]),X[1]);
                OL.add(OC);
            }
            else if(X[0].equals("UBER")){
                UBER.Cab UC = new UBER.Cab(Integer.parseInt(X[2]), X[1]);
                UL.add(UC);
            }
        }
        
        System.out.println("\n\t\t\tDo you want to check all the available Cabs Right now : [Y/N]");
        char c = sc.next().toLowerCase().toCharArray()[0];
        if(c == 'y'){
            obj.available_cars();
        }
        ///Booking
        int choice1 = 0;
            System.out.println("\n\t\tChoose your cab : ");
            System.out.println("\n\n\t\t1.OLA\n\t\t2.UBER\n\t\t3.Exit");
            choice1 = sc.nextInt();
            if(choice1 == 1){
                ///OLA
                int count = 1;
                for(OLA.Cab O : OL){
                    if(O.availability == true){
                        System.out.println("\t\t\tBooking Available");
                        O.availability = false;
                        break;
                    }
                    count++;
                }
                if(count > OL.size()){
                    System.out.println("\t\t\tSorry! Currently Our drivers are not Available.\n\t\t\tNo bookings Available for OLA");
                    System.exit(0);
                }
            } else if(choice1 == 2){
                ///UBER
                int count = 1;
                for(UBER.Cab U : UL){
                    if(U.availability == true){
                        System.out.println("\t\t\tBooking Available");
                        U.availability = false;
                        break;
                    }
                    count++;
                }   
                if(count > UL.size()){
                    System.out.println("\n\t\t\tSorry! Currently Our drivers are not Available.\n\t\t\tNo bookings Available for UBER");
                    System.exit(0);
                }
            }
            else{///Exit if wrong input is given
                System.exit(0);
            }

        int km = 0;
        System.out.println("\n\n\t\tEnter Your Drop Location : \n\t\t\t1.Jyothi Chowk\n\t\t\t2.Viva Mall\n\t\t\t3.MBD mall\n\t\t\t4.PVR Curo");
        int location = sc.nextInt();
        if(location == 1){
            km = 10;
        } else if(location == 2){
            km = 20;
        } else if(location == 3){
            km = 30;
        } else if(location == 4){
            km = 40;
        } else {
            System.out.println("Please choose correct location : ");
        }
        int cost = obj.cal_price(km);

        System.out.println("\t\t\tYour Fare is : "+ " Rs." + Integer.toString(cost) );
        System.out.println("\n\n\t\t\t *****************");
        System.out.println("\n\t\t\t                 Happy Journey!!!");
    }

    int cal_price(int km){
        int cost = km*10;
        return cost;
    }

    void available_cars() {
        System.out.println("\n\t\t\tAvailable Cars : " + Integer.toString(OL.size() + UL.size()));
        System.out.println("\n\t\t\tOLA");
        for(OLA.Cab O : OL){
            System.out.println("\t\t Driver Name : " + O.driver_name);
            System.out.println("\t\t Car Number  : " + O.car_number);
        }
        System.out.println("\n\t\t\tUBER\n1");
        for(UBER.Cab U : UL){
            System.out.println("\t\t Driver Name : " + U.driver_name);
            System.out.println("\t\t Car Number  : " + U.car_number);
        }
    }

