package com.example.tpo4.Controllers;

import com.example.tpo4.Models.Order;
import com.example.tpo4.Respositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public
class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/orders")
    public String getOrder(Model model){
        model.addAttribute( "orders", orderRepository.findAll());
        return "orders";
    }

    @RequestMapping(value = "/orders/details", method = RequestMethod.POST)
    public String getOrderDetails(@RequestParam("orderId") Long orderId, Model model) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()) {
            model.addAttribute("order", order);
            return "orderDetails";
        } else {
            return "errororder";
        }
    }
}
