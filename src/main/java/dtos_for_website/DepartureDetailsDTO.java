package dtos_for_website;

import generalstuff.FerrySummary;
import generalstuff.LineSummary;

public class DepartureDetailsDTO {
    private final long pricePerPerson, pricePerCar, pricePerLorry, pricePerHeavy, pricePerResident, departureTimeInMilis;
    private final int remainingPeople, remainingCars, remainingLorries, remainingHeavy;
    private final LineSummary lineSummary;
    private final FerrySummary ferrySummary;

    public DepartureDetailsDTO(long pricePerPerson, long pricePerCar, long pricePerLorry, long pricePerHeavy, long pricePerResident, long departureTimeInMilis, int remainingPeople, int remainingCars, int remainingLorries, int remainingHeavy, LineSummary lineSummary, FerrySummary ferrySummary) {
        this.pricePerPerson = pricePerPerson;
        this.pricePerCar = pricePerCar;
        this.pricePerLorry = pricePerLorry;
        this.pricePerHeavy = pricePerHeavy;
        this.pricePerResident = pricePerResident;
        this.departureTimeInMilis = departureTimeInMilis;
        this.remainingPeople = remainingPeople;
        this.remainingCars = remainingCars;
        this.remainingLorries = remainingLorries;
        this.remainingHeavy = remainingHeavy;
        this.lineSummary = lineSummary;
        this.ferrySummary = ferrySummary;
    }

    public long getPricePerPerson() {
        return pricePerPerson;
    }

    public long getPricePerCar() {
        return pricePerCar;
    }

    public long getPricePerLorry() {
        return pricePerLorry;
    }

    public long getPricePerHeavy() {
        return pricePerHeavy;
    }

    public long getPricePerResident() {
        return pricePerResident;
    }

    public long getDepartureTimeInMilis() {
        return departureTimeInMilis;
    }

    public int getRemainingPeople() {
        return remainingPeople;
    }

    public int getRemainingCars() {
        return remainingCars;
    }

    public int getRemainingLorries() {
        return remainingLorries;
    }

    public int getRemainingHeavy() {
        return remainingHeavy;
    }

    public LineSummary getLineSummary() {
        return lineSummary;
    }

    public FerrySummary getFerrySummary() {
        return ferrySummary;
    }
    
}
