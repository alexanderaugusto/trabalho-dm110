package br.inatel.dm110.trabalho.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.trabalho.api.model.Order;
import br.inatel.dm110.trabalho.api.service.OrderService;

@RequestScoped
public class OrderServiceImpl implements OrderService {
    @Override
    public Order storeOrder(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'storeOrder'");
    }

    @Override
    public Order updateOrder(String code, Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOrder'");
    }

    @Override
    public void deleteOrder(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteOrder'");
    }

    @Override
    public List<Order> getOrders(String code, String cpf) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrders'");
    }

    @Override
    public Order getOrderById(String code) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderById'");
    }
}
