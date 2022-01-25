public class Flat extends  AbstractRealty {
    public Flat(String name, String subwayStation, String address, RoomNumber rooms, double square, int price, double estimate) {
        super(name, subwayStation, address, square, price, estimate);
        this.rooms = rooms;
    }

    public RoomNumber getRooms() {
        return rooms;
    }


    RoomNumber rooms;

    enum RoomNumber {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIFTH(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10);
        private int rooms;
        RoomNumber(int rooms) {
            this.rooms = rooms;
        }
        public int getRooms() {
            return rooms;
        }

    }
}