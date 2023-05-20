
package br.inatel.dm110.trabalho.api.interfaces;

import java.util.List;

import br.inatel.dm110.trabalho.api.model.OrderTO;

public interface Order {
    public OrderTO createOrder(OrderTO order);

    public OrderTO updateOrder(String code, OrderTO order);

    public void deleteOrder(String code);

    public List<OrderTO> getOrders(String code, String cpf);

    public OrderTO getOrderById(String code);
}
