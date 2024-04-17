package com.example.tpo4.bootstrap;

import com.example.tpo4.Models.Product;
import com.example.tpo4.Respositories.CartRepository;
import com.example.tpo4.Respositories.OrderRepository;
import com.example.tpo4.Respositories.ProductRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private CartRepository cartRepository;

    public Bootstrap(OrderRepository orderRepository, ProductRepository productRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public void init(){
        List<Product> productList = new ArrayList<>();

        Product product1 = new Product("Mouse", 109, "/myszka.png", "High-performance mouse with ergonomic design for comfortable and precise navigation.");
        productRepository.save(product1);

        Product product2 = new Product("Keyboard", 289, "/klawiatura.jpeg", "Feature-rich keyboard with responsive keys and customizable backlighting for an enhanced typing experience.");
        productRepository.save(product2);

        Product product3 = new Product("Mouse pad", 49, "/podkladka.jpg", "Just a mouse pad");
        productRepository.save(product3);

        Product product4 = new Product("Headset", 449, "/sluchawki.jpg", "Immersive wireless headphones with high-fidelity sound and noise-canceling technology for a superior audio experience on the go.");
        productRepository.save(product4);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        init();
    }
}
