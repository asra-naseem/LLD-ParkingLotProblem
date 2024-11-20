public class ParkingSpot {
    private ParkingSpot ps;
    private ParkingSpotType pst;
   private Vehcile vh;
   private boolean isAvailable=true;
   public ParkingSpot(ParkingSpotType pst , Vehcile vh, Boolean isAvailable){
        this.pst=pst;
        this.vh=vh;
        this.isAvailable=isAvailable;
    }

    public ParkingSpot getParkingSpot() {
        return ps;
    }

    public void setPs(ParkingSpot ps) {
        this.ps = ps;
    }

    public ParkingSpotType getPst() {
        return pst;
    }

    public void setPst(ParkingSpotType pst) {
        this.pst = pst;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Vehcile getVh() {
        return vh;
    }

    public void setVh(Vehcile vh) {
        this.vh = vh;
    }
}
