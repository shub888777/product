package com.shubham.Product.Order;

import com.shubham.Product.Cart.Cart;
import com.shubham.Product.Cart.CartRepo;
import com.shubham.Product.Products.Products;
import com.shubham.Product.Products.ProductsRepo;
import com.shubham.Product.Users.UserRepo;
import com.shubham.Product.Users.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepo orderRepo;
    private UserRepo userRepo;
    private CartRepo cartRepo;
    private ProductsRepo productsRepo;

    public Order addToOrder(OrderRequestDto orderRequestDto,String username)
    {
        Cart cart=cartRepo.findByUsersUsernameAndId(username, orderRequestDto.getCartid());
        if (cart!=null) {
            Users users=userRepo.findByUsername(username);
            Products products=productsRepo.findById(cart.getProducts().getId()).get();
            Order order=new Order();
            order.setAddress(orderRequestDto.getAddress());
            order.setPrice(cart.getQty()*cart.getProducts().getPrice());
            order.setProducts(cart.getProducts());
            if (cart.getQty()> products.getInventory()) {
                throw new RuntimeException();
            }
            order.setQty(cart.getQty());
            order.setUsers(users);
            cartRepo.delete(cart);
            products.setInventory(products.getInventory()-cart.getQty());
            productsRepo.save(products);
            return orderRepo.save(order);

        }
        System.out.println("here");
        return new Order();
    }
    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

}
