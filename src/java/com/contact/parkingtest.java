package com.parking;

import com.parking.dao.ParkingDAO;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void testParking() {
        ParkingDAO dao = new ParkingDAO();
        String result = dao.parkVehicle("AP01AB1234");

        assertTrue(result.contains("Parked"));
    }
}