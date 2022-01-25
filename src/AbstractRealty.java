public abstract class AbstractRealty {



    public AbstractRealty(String name, String subwayStation, String address, double square, int price, double estimate) {
        this.name = name;
        this.subwayStation = subwayStation;
        this.address = address;
        this.square = square;
        this.price = price;
        this.estimate = estimate;
    }

    public String getName() {
        return name;
    }

    public String getSubwayStation() {
        return subwayStation;
    }

    public String getAddress() {
        return address;
    }

    public double getSquare() {
        return square;
    }

    public int getPrice() {
        return price;
    }

    private String name;
    private String subwayStation;
    private String address;
    private double square;
    private int price;
    private double estimate;


    public double getEstimate() {
        return estimate;
    }


}
