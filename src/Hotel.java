public class Hotel {

    private static Room[][] rooms = new Room[2][];

    static {
        Room r101 = new Room(1, 101, Occupancy.SINGLE, true, false);
        Room r102 = new Room(1, 102, Occupancy.DOUBLE, true, false);
        Room r103 = new Room(1, 103, Occupancy.DOUBLE, false, false);
        Room r201 = new Room(2, 201, Occupancy.SINGLE, true, false);
        Room r202 = new Room(2, 202, Occupancy.SINGLE, false, false);
        Room r203 = new Room(2, 203, Occupancy.DOUBLE, true, false);
        Room r204 = new Room(2, 204, Occupancy.TRIPLE, true, false);

        rooms[0] = new Room[]{r101, r102, r103};
        rooms[1] = new Room[]{r201, r202, r203, r204};
    }

    Room bookRoom(Occupancy occupancyType, boolean needAC, int floor){
        if(floor != Integer.MIN_VALUE){
            if(floor > 0 && floor <= rooms.length){
                for(int j=0; j<rooms[floor-1].length; j++){
                    if(occupancyType == rooms[floor-1][j].getOccupancyType() && needAC==rooms[floor-1][j].isHasAC() && !rooms[floor-1][j].isBooked()){
                        rooms[floor-1][j].setBooked();
                        return rooms[floor-1][j];
                    }
                }
                return null;
            } else {
                return null;
            }
        } else {
            for(int i =0; i<rooms.length; i++){
                for(int j=0; j<rooms[i].length; j++){
                    if(occupancyType == rooms[i][j].getOccupancyType() && needAC==rooms[i][j].isHasAC() && !rooms[i][j].isBooked()){
                        rooms[i][j].setBooked();
                        return rooms[i][j];
                    }
                }
            }
            return null;
        }
    }



}
