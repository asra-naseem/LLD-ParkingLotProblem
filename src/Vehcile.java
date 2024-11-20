public class Vehcile
{   private int vehcileno;
    private ParkingSpot ps ;
    private VehcileType vt;



    public Vehcile(int vehcileno, ParkingSpot ps, VehcileType vt) {
        this.vehcileno = vehcileno;
        this.ps = ps;
        this.vt = vt;
    }

    public Vehcile(VehcileType vt){
        this.vt=vt;
    }

    public ParkingSpot getParkingSpot() {
        return ps;
    }

    public void setParkingSpot(ParkingSpot ps) {
        this.ps = ps;
    }

    public int getVehcileno() {
        return vehcileno;
    }

    public void setVehcileno(int vehcileno) {
        this.vehcileno = vehcileno;
    }

    public VehcileType getVehcileType() {
        return vt;
    }

    public void setVehcileType(VehcileType vt) {
        this.vt = vt;
    }
}
