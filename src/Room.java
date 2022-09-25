public class Room {

    private int floor;
    private int roomNo;
    private Occupancy occupancyType;
    private boolean hasAC;
    private boolean isBooked;

    Room(int floor, int roomNo, Occupancy occupancyType, boolean hasAC, boolean isBooked){
        this.floor = floor;
        this.roomNo = roomNo;
        this.occupancyType = occupancyType;
        this.hasAC = hasAC;
        this.isBooked = isBooked;
    }

    public int getFloor(){
        return floor;
    }

    public int getRoomNo(){
        return this.roomNo;
    }

    public Occupancy getOccupancyType(){
        return this.occupancyType;
    }

    public boolean isHasAC(){
        return this.hasAC;
    }

    public boolean isBooked(){
        return this.isBooked;
    }

    public void setBooked(){
        this.isBooked = true;
    }

}
