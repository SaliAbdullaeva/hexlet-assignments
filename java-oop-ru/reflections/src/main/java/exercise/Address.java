package exercise;


class Address {

    @NotNull/*(description = "Field country must not be null")*/
    private String country;

    @NotNull/*(description = "Field city must not be null")*/
    private String city;

    @NotNull/*(description = "Field street must not be null")*/
    private String street;

    @NotNull/*(description = "Field houseNumber must not be null")*/
    private String houseNumber;
    private String flatNumber;

    Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }
}