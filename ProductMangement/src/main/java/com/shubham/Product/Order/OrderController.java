package com.shubham.Product.Order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class OrderController
{
    final private OrderService orderService;
    @PostMapping("/addorder")
    public Order addToMyOrder(@RequestBody OrderRequestDto orderRequestDto, Principal p){
        System.out.println("@@@@@@@@@@@@"+orderRequestDto);
        return orderService.addToOrder(orderRequestDto, p.getName());

    }

}
