package com.example.tpo4.Controllers;

import com.example.tpo4.Models.Order;
import com.example.tpo4.Respositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderConfirmationController {

    private OrderRepository orderRepository;

    public OrderConfirmationController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/finalorder")
    public String showOrderConfirmation(Model model, @RequestParam(value = "id", required = false) Long orderId) {
        if (orderId != null) {
            Order order = orderRepository.findById(orderId).orElse(null);
            if (order != null) {
                model.addAttribute("order", order);
                return "finalorder";
            }
        }
        model.addAttribute("errorMessage", "Invalid order ID");
        return "error";
    }

}
