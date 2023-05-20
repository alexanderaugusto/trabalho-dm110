package br.inatel.dm110.trabalho.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import br.inatel.dm110.trabalho.api.interfaces.OrderLocal;
import br.inatel.dm110.trabalho.api.model.OrderTO;
import br.inatel.dm110.trabalho.api.service.OrderService;

@RequestScoped
public class OrderServiceImpl implements OrderService {
    @EJB
	private OrderLocal orderBean;

    @Override
    public OrderTO storeOrder(OrderTO order) {
        return orderBean.createOrder(order);
    }

    @Override
    public OrderTO updateOrder(String code, OrderTO order) {
        return orderBean.updateOrder(code, order);
    }

    @Override
    public void deleteOrder(String code) {
        orderBean.deleteOrder(code);
    }

    @Override
    public List<OrderTO> getOrders(String code, String cpf) {
        return orderBean.getOrders(code, cpf);
    }

    @Override
    public OrderTO getOrderById(String code) {
        return orderBean.getOrderById(code);
    }
}
