package com.example.tpo4.Controllers;

import com.example.tpo4.Models.CartItem;
import com.example.tpo4.Models.Order;
import com.example.tpo4.Models.Product;
import com.example.tpo4.Respositories.CartRepository;
import com.example.tpo4.Respositories.OrderRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    private CartRepository cartRepository;
    private OrderRepository orderRepository;

    public CartController(CartRepository cartRepository, OrderRepository orderRepository) {
        this.cartRepository = cartRepository;
        this.orderRepository = orderRepository;
    }

    @RequestMapping("/carts")
    public String getCart(Model model, @ModelAttribute("errorMessage") String errorMessage){
        List<CartItem> cartItems = (List<CartItem>) cartRepository.findAll();
        model.addAttribute("carts", cartItems);

        double totalPrice = cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        model.addAttribute("totalPrice", totalPrice);

        model.addAttribute("errorMessage", errorMessage);
        return "carts";
    }


    @PostMapping("/carts/delete")
    public String deleteCartItems() {
        cartRepository.deleteAll();

        return "redirect:/carts";
    }

    @PostMapping("/carts/order")
    public String postOrder(@RequestParam("name") String name,
                            @RequestParam("lastName") String lastName,
                            @RequestParam("email") String email,
                            @RequestParam("phone") String phone,
                            @RequestParam("city") String city,
                            @RequestParam("postCode") String postCode,
                            @RequestParam("street") String street){

        List<CartItem> allItems = cartRepository.findAll();

        List<Product> productList = new ArrayList<>();
        for (CartItem item:
             allItems) {
            productList.add(item.getProduct());
            cartRepository.delete(item);
        }
        Order order = new Order(productList, name, lastName, email, phone, city, postCode, street, "Received order");
        orderRepository.save(order);

        return "redirect:/finalorder?id=" + order.getId();
    }

}
