package com.shubham.Product.Cart;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/pid/{pid}/qty/{qty}")
    public String addCart(@PathVariable Long pid, Principal principal,@PathVariable int qty){
         cartService.addToCart(principal.getName(),pid,qty);
         return "ADDED";
    }

    @GetMapping
    public List<Cart> getMyCart(Principal principal){
        return cartService.myCart(principal.getName());
    }

    @DeleteMapping("/{id}")
    public String deleteMyCart(Principal principal,@PathVariable Long id){
        cartService.removeFormCart(principal.getName(),id);
        return "CART GOT DELETED";
    }
   public List<CartResponseDto> MyCart(Principal principal){
        return cartService.cartResponseDtoList(principal.getName());

   }


}
