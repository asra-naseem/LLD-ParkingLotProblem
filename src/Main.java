//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
      ParkingLot pl = ParkingLot.getInstance(2,2,2);
        Vehcile vh = new Vehcile(VehcileType.CAR);
      ParkingSpot ps = new ParkingSpot(ParkingSpotType.COMPACT,vh,Boolean.TRUE);


      if(pl.parkVehicle(vh)==true)
          System.out.println("Your Vehcile is Parked");
      else
          System.out.println("We were not able to Park your Vehcile");
      System.out.println(pl.unParkVehcile(vh));

        }
    }


