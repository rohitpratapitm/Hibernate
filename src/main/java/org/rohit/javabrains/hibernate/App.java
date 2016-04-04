package org.rohit.javabrains.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.rohit.javabrains.hibernate.model.Address;
import org.rohit.javabrains.hibernate.model.FourWheeler;
import org.rohit.javabrains.hibernate.model.TwoWheeler;
import org.rohit.javabrains.hibernate.model.UserDetails;
import org.rohit.javabrains.hibernate.model.Vehicle;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
        
    	Address homeAddress = new Address();
    	homeAddress.setCity("Gwalior");
    	homeAddress.setState("MP");
    	
    	Address officeAddress = new Address();
    	officeAddress.setCity("Hyd");
    	officeAddress.setState("AP");

        Vehicle vehicleCar = new Vehicle();
        vehicleCar.setVehicleName("Car");
        
        Vehicle vehicleJeep = new Vehicle();
        vehicleJeep.setVehicleName("Jeep");
        
        TwoWheeler vehicleBike = new TwoWheeler();
        vehicleBike.setVehicleName("Bike");
        vehicleBike.setSteeringHandle("Handle");
        
        
        FourWheeler vehiclePorsche = new FourWheeler();
        vehiclePorsche.setVehicleName("Porsche");
        vehiclePorsche.setSterringWheel("Steering");
        
    	UserDetails userDetails = new UserDetails();
        userDetails.setUserName("Rohit");
        userDetails.getListOfAddresses().add(homeAddress);
        userDetails.getListOfAddresses().add(officeAddress);
        userDetails.getVehicle().add(vehicleCar);
        userDetails.getVehicle().add(vehicleJeep);
        userDetails.getVehicle().add(vehicleBike);
        userDetails.getVehicle().add(vehiclePorsche);
        
        vehicleCar.getUser().add(userDetails);
        vehicleJeep.getUser().add(userDetails);
        vehicleBike.getUser().add(userDetails);
        vehicleBike.getUser().add(userDetails);
        //save
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
//        session.persist(userDetails);
        session.save(vehicleCar);
        session.save(vehicleJeep);
        session.save(vehicleBike);
        session.save(vehiclePorsche);
        session.getTransaction().commit();
        session.close();
        
        session = sessionFactory.openSession();
        userDetails = null;
        session.beginTransaction();
        userDetails = (UserDetails)session.get(UserDetails.class, 1L);
        session.close();
       
        
    }
}
