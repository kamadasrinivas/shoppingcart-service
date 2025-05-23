package com.example.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    
    @Autowired
    private CartService cartService;
    
    @PostMapping
    public Cart createCart() {
        return cartService.createCart();
    }
    
    @GetMapping("/{cartId}")
    public Cart getCart(@PathVariable Long cartId) {
        return cartService.getCart(cartId);
    }
    
    @PostMapping("/{cartId}/items")
    public Cart addToCart(
            @PathVariable Long cartId,
            @RequestParam Long productId,
            @RequestParam int quantity) {
        return cartService.addToCart(cartId, productId, quantity);
    }
    
    @DeleteMapping("/{cartId}/items/{productId}")
    public Cart removeFromCart(
            @PathVariable Long cartId,
            @PathVariable Long productId) {
        return cartService.removeFromCart(cartId, productId);
    }
}