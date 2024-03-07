package org.java.servlet;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.java.db.Pizza;
import org.java.db.PizzaOrderItem;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class PizzaCheckoutServlet
 */
@WebServlet("/checkout")
public class PizzaCheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaCheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.sendRedirect(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// RICHIAMO L'ARRAYLIST DELLE PIZZE DALLA SESSION
		List<Pizza> pizzas = (List<Pizza>) request.getSession().getAttribute("pizzas");
		
		// CREO L'ARRAYLIST DELLE PIZZE SELEZIONATE
		List<Pizza> selectedPizzas = new ArrayList<>();
		
		// OTTENGO LA LISTA DEI NOMI DELLE PIZZE SELEZIONATE IN PRECEDENZA
        String[] selectedPizzasNames = request.getParameterValues("selectedPizzasNames");
    	
        // CICLO I NOMI DELLE PIZZE SELEZIONATE IN PRECEDENZA
    	for (String name : selectedPizzasNames) {
    		
    		// PER OGNI NOME, CONTROLLO CHE SIA CONTENUTO ALL'INTERNO DELL'ARRAYLIST DELLE PIZZE
    		for (Pizza pizza : pizzas) {
    			
    			if (pizza.getName().equals(name)) {
    				
    				// AGGIUNGO L'ELEMENTO ALL'ARRAYLIST DELLE PIZZE SELEZIONATE
    				selectedPizzas.add(pizza);
    				break;
    			}
    		}
    	}
    	
        // CREO L'ARRAYLIST CON LE PIZZE SELEZIONATE ORDINATE PER QUANTITA
        List<PizzaOrderItem> selectedPizzasOrderItem = new ArrayList<>();
        
        // CICLO L'ARRAYLIST DELLE PIZZE SELEZIONATE
        for (int i = 0; i < selectedPizzas.size(); i++) {
        	
        	// ESTRAGGO L'ELEMENTO CORRENTE
        	Pizza pizza = selectedPizzas.get(i);
        	
        	// INIZIALIZZO LA "PIZZA_ORDER_ITEM"
        	PizzaOrderItem pizzaOrderItem = null;
        	
        	// CONTROLLO SE L'ELEMENTO CORRENTE È GIA STATO INSERITO
        	for (PizzaOrderItem item : selectedPizzasOrderItem) {
        		
				if(item.getPizza().getName().equals(pizza.getName())) {
					pizzaOrderItem = item;
					break;
				}
			}
        	
        	if(pizzaOrderItem != null) {
            	// SE LA PIZZA È GIA PRESENTE, INCREMENTO LA QUANTITA
        		pizzaOrderItem.increaseQuantity();
        		// AGGIORNO IL SUBTOTALE
        		pizzaOrderItem.refreshSubtotal();
        	} else {
        		// ALTRIMENTI, CREO UNA NUOVA "PIZZA_ORDER_ITEM"
        		pizzaOrderItem = new PizzaOrderItem(pizza, 1);
        	 	// AGGIUNGO L'ELEMENTO ALLA LISTA
            	selectedPizzasOrderItem.add(pizzaOrderItem);
        	}
		}
        
    	// INIZIALIZZO IL PREZZO TOTALE DELLE PIZZE SELEZIONATE
    	double totalPrice = 0;
    	
    	// CALCOLO IL PREZZO TOTALE DELLE PIZZE SELEZIONATE
    	for (PizzaOrderItem pizzaOrderItem : selectedPizzasOrderItem) {
    		totalPrice += pizzaOrderItem.getSubtotal();
		}
    	
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String formattedTotalPrice = decimalFormat.format(totalPrice);
    	
        request.setAttribute("selectedPizzas", selectedPizzas);
        request.setAttribute("selectedPizzasOrderItem", selectedPizzasOrderItem);
        request.setAttribute("formattedTotalPrice", formattedTotalPrice);

        // RITORNO LA JSP
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/pizzaCheckout.jsp");
        dispatcher.forward(request, response);
	}

}
