package softuni.exam.service;



import softuni.exam.models.entities.Passenger;

import java.io.IOException;


public interface PassengerService {

    boolean areImported();

    String readPassengersFileContent() throws IOException;
	
	String importPassengers() throws IOException;

	Passenger getPassengerByEmail(String email);

	String getPassengersOrderByTicketsCountDescendingThenByEmail();
}
