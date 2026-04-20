package com.shubham.Product.Cart;

import com.shubham.Product.Products.Products;
import com.shubham.Product.Products.ProductsRepo;
import com.shubham.Product.Users.UserRepo;
import com.shubham.Product.Users.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CartService {
    private  final CartRepo cartRepo;
   private final UserRepo userRepo;
   private  final ProductsRepo productsRepo;

    public Cart addToCart(String username,Long id,int qty){
        Users users=userRepo.findByUsername(username);
        Products products=productsRepo.findById(id).orElseThrow(()->new RuntimeException());

        if (products.getInventory() < 0) {
            throw new RuntimeException();

        }
        Cart cart=new Cart();
        cart.setProducts(products);
        cart.setUsers(users);
        cart.setQty(qty);
        return cartRepo.save(cart);
    }
    public List<Cart> myCart(String username){
        return cartRepo.findByUsersUsername(username);
    }
    public void removeFormCart(String username,Long cid){
        Cart cart=cartRepo.findByUsersUsernameAndId(username,cid);
        if (cart == null) {
            throw new RuntimeException();

        }
         cartRepo.delete(cart);
    }

    public List<CartResponseDto> cartResponseDtoList(String username){
        List<CartResponseDto> cart=new ArrayList<>();
        for(Cart c :cartRepo.findByUsersUsername(username))
        {
            CartResponseDto c1=new CartResponseDto();
            c1.setQty(c.getQty());
            c1.setProductname(c.getProducts().getName());
            c1.setRemainingProduct(c.getProducts().getInventory());

        }
        return cart;
    }
}
