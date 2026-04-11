package com.parking;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/parking")
public class ParkingServlet extends HttpServlet {

    private static List<String> slots = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<h2>Available Slots:</h2>");
        for (int i = 1; i <= 10; i++) {
            if (!slots.contains("Slot " + i)) {
                out.println("Slot " + i + " is FREE <br>");
            } else {
                out.println("Slot " + i + " is OCCUPIED <br>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String slot = req.getParameter("slot");

        if (slot != null && !slots.contains(slot)) {
            slots.add(slot);
            resp.getWriter().println("Slot " + slot + " booked successfully!");
        } else {
            resp.getWriter().println("Slot already occupied or invalid!");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String slot = req.getParameter("slot");

        if (slots.remove(slot)) {
            resp.getWriter().println("Slot " + slot + " freed!");
        } else {
            resp.getWriter().println("Slot not found!");
        }
    }
}