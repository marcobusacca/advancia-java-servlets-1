package org.java.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.java.db.Pizza;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PizzaIndexServlet
 */
@WebServlet("/")
public class PizzaIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PizzaIndexServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// CREO UN ARRAYLIST DI PIZZE
		List<Pizza> pizzas = new ArrayList<>();
		pizzas.add(new Pizza("Margherita", 5.99));
		pizzas.add(new Pizza("Napoli", 14.99));
		pizzas.add(new Pizza("Romana", 7.99));
		pizzas.add(new Pizza("Americana", 11.99));
		pizzas.add(new Pizza("Capricciosa", 13.99));
		
		// LO AGGIUNGO ALLA SESSION
		request.getSession().setAttribute("pizzas", pizzas);
		
		// RITORNO LA JSP
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/pizzaIndex.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
