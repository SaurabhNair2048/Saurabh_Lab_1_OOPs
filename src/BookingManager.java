public class BookingManager {

    private static Hotel hotel = new Hotel();

    public String bookRoom(String occupancyType, boolean needAC, int floor){
        Room room = null;
        switch(occupancyType.toLowerCase()){
            case "double":
                room = hotel.bookRoom(Occupancy.DOUBLE, needAC, floor);
                break;

            case "triple":
                room = hotel.bookRoom(Occupancy.TRIPLE, needAC, floor);
                break;

            default:
                room = hotel.bookRoom(Occupancy.SINGLE, needAC, floor);
        }
        return getBookingResult(room, occupancyType, needAC);
    }

    private String getBookingResult(Room room, String occupancyType, boolean needAC){
        StringBuilder strb = new StringBuilder();
        if(room==null){
            switch (occupancyType.toLowerCase()){
                case "double":
                    strb.append("Double occupancy ");
                    break;

                case "triple":
                    strb.append("Triple occupancy ");
                    break;

                default:
                    strb.append("Single occupancy ");
            }
            if(needAC){
                strb.append("AC room ");
            }
            strb.append("not available");

        } else {
            int roomNo = room.getRoomNo();
            int floorNo = room.getFloor();
            Occupancy occupancy = room.getOccupancyType();
            boolean hasAC = room.isHasAC();
            int price = getPrice(occupancy, hasAC);
            strb.append("Room number: " + roomNo+", ");
            switch(floorNo){
                case 1:
                    strb.append("first floor, ");
                    break;
                case 2:
                    strb.append("second floor, ");
                    break;
            }
            if(hasAC){
                strb.append("air conditioned, ");
            } else {
                strb.append("non-air conditioned, ");
            }
            switch (occupancy){
                case DOUBLE:
                    strb.append("double occupancy, ");
                    break;
                case TRIPLE:
                    strb.append("triple occupancy, ");
                    break;
                default:
                    strb.append("single occupancy, ");
            }
            strb.append("estimated: Rs. "+price+"/day");

        }

        return strb.toString();
    }

    private int getPrice(Occupancy occupancy, boolean hasAC){
        int cost = 0;
        switch(occupancy){
            case DOUBLE:
                cost=3000;
                break;
            case TRIPLE:
                cost=4000;
                break;
            default:
                cost=2000;
        }
        cost+=hasAC?1000:0;
        return cost;
    }
}
