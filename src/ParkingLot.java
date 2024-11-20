import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;

public class ParkingLot {

    private static ParkingLot singletonInstance;
    private List<CompactType> ct = new ArrayList<>();
    private List<LargeType> lt = new ArrayList<>();
    private List<SmallType> st =new ArrayList<>();
    private int availableCompactType;
    private int availableSmallType;
    private int availableLargeType;

    // Private constructor to prevent instantiation
    private ParkingLot(int availableCompactType, int availableLargeType, int availableSmallType) {
        this.availableCompactType = availableCompactType;
        this.availableLargeType = availableLargeType;
        this.availableSmallType = availableSmallType;
    }

    // Double-checked locking for thread-safe singleton instance creation
    public static ParkingLot getInstance(int availableCompactType, int availableLargeType, int availableSmallType) {
        if (singletonInstance == null) {
            synchronized (ParkingLot.class) {
                if (singletonInstance == null) {
                    singletonInstance = new ParkingLot(availableCompactType, availableLargeType, availableSmallType);
                }
            }
        }
        return singletonInstance;
    }

    // Getters and setters for encapsulation
    public int getAvailableCompactSlots() {
        return availableCompactType;
    }

    public void setAvailableCompactSlots(int availableCompactSlots) {
        this.availableCompactType = availableCompactSlots;
    }

    public int getAvailableLargeSlots() {
        return availableLargeType;
    }

    public void setAvailableLargeSlots(int availableLargeSlots) {
        this.availableLargeType = availableLargeSlots;
    }

    public int getAvailableSmallSlots() {
        return availableSmallType;
    }

    public void setAvailableSmallSlots(int availableSmallSlots) {
        this.availableSmallType = availableSmallSlots;
    }

    // Additional methods like parkVehicle() and removeVehicle() can be added here
    public boolean parkVehicle(Vehcile vh) {
        System.out.println("We are trying to accomodate your request to Park your Vechile of type" + vh.getVehcileType());
        if (vh.getVehcileType().equals(VehcileType.TRUCK)) {
            if (singletonInstance.getAvailableLargeSlots() > 0) {
                parkLargeVehcile(vh);
                return true;
            } else {
                return false;
            }
        } else if (vh.getVehcileType().equals(VehcileType.CAR)) {
            if (singletonInstance.getAvailableCompactSlots() > 0) {
                parkCompactVehcile(vh);
                return true;
            } else if (singletonInstance.getAvailableLargeSlots() > 0) {
                parkLargeVehcile(vh);
                return true;
            } else {
                return false;
            }
        } else if (vh.getVehcileType().equals(VehcileType.BIKE)) {
            if (singletonInstance.getAvailableSmallSlots() > 0) {
                parkSmallVehcile(vh);
                return true;
            } else if (singletonInstance.getAvailableCompactSlots() > 0) {
                parkCompactVehcile(vh);
                return true;
            } else if (singletonInstance.getAvailableLargeSlots() > 0) {
                parkLargeVehcile(vh);
                return true;
            }
            return false;
        }


        return false;


    }

    private void parkLargeVehcile(Vehcile vh) {
        LargeType largeSpot = new LargeType(ParkingSpotType.LARGE, vh, FALSE);
        lt.add(largeSpot);
        availableLargeType--;
    }

    private void parkCompactVehcile(Vehcile vh) {
        CompactType compactSpot = new CompactType(ParkingSpotType.COMPACT, vh, FALSE);
        vh.setParkingSpot(compactSpot);
        ct.add(compactSpot);
        availableCompactType--;
    }

    private void parkSmallVehcile(Vehcile vh) {
        SmallType smallSpot = new SmallType(ParkingSpotType.SMALL, vh, FALSE);
        st.add(smallSpot);
        availableSmallType--;
    }

    public boolean unParkVehcile(Vehcile vh) {
        ParkingSpot ps = vh.getParkingSpot();
        ps.setAvailable(true);
        if (vh.getVehcileType().equals(VehcileType.TRUCK)) {
            if (lt.remove(ps)) {
                availableLargeType++;
                return true;
            } else
                return false;
        }
        if (vh.getVehcileType().equals(VehcileType.CAR)) {
            if (ps.getPst().equals(ParkingSpotType.COMPACT)) {
                if (ct.remove(ps)) {
                    availableCompactType++;
                    return true;
                } else
                    return false;
            }
            if (ps.getPst().equals(ParkingSpotType.LARGE)) {
                if (lt.remove(ps)) {
                    availableLargeType++;
                    return true;
                } else
                    return false;

            }
        }
        if (vh.getVehcileType().equals(VehcileType.BIKE)) {
            if (ps.getPst().equals(ParkingSpotType.COMPACT)) {
                if (ct.remove(vh)) {
                    availableCompactType++;
                    return true;
                } else
                    return false;

            }
            if (ps.getPst().equals(ParkingSpotType.LARGE)) {
                if (lt.remove(vh)) {
                    availableLargeType++;
                    return true;
                } else
                    return false;

            }
            if (ps.getPst().equals(ParkingSpotType.SMALL)) {
                if (st.remove(vh)) {
                    availableSmallType++;
                    return true;
                } else
                    return false;

            }
        }

        return false;
    }
}
