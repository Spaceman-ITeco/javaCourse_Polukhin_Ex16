public class CommercialEstate extends AbstractRealty
{
    public CommercialEstate(String name, String subwayStation, String address, EstateType estateType, double square, int price,  double estimate) {
        super(name,subwayStation,address,square,price, estimate);
        this.estateType = estateType;
    }
    enum EstateType{SHOP,CAFE,WAREHOUSE,GARAGE,WORKSHOP,FACTORY,GAS_STATION,CINEMA,OFFICE,HOTEL}

    public EstateType getEstateType() {
        return estateType;
    }

    final EstateType estateType;
}
