package com.example.tpo4.Controllers;

import com.example.tpo4.Models.CartItem;
import com.example.tpo4.Models.Product;
import com.example.tpo4.Respositories.CartRepository;
import com.example.tpo4.Respositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public
class ProductController {

    private ProductRepository productRepository;
    private CartRepository cartRepository;

    public ProductController(ProductRepository productRepository, CartRepository cartRepository) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    @RequestMapping("/products")
    public String getProducts(Model model){
        model.addAttribute( "products", productRepository.findAll());
        return "products";
    }

    @PostMapping("/add-to-cart")
    public String addToCart(@RequestParam("productId") Long productId){
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();

            CartItem cartItem = new CartItem(1, product);

            cartRepository.save(cartItem);
        }
        return "redirect:/products";
    }
}


