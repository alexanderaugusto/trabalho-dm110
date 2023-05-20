package br.inatel.dm110.trabalho.order.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.inatel.dm110.trabalho.api.interfaces.OrderLocal;
import br.inatel.dm110.trabalho.api.model.OrderTO;
import br.inatel.dm110.trabalho.order.entities.OrderEntity;

@Stateless
@Local(OrderLocal.class)
public class OrderBean implements OrderLocal {
    @PersistenceContext(unitName = "trabalho_dm110_pu")
    private EntityManager entityManager;

    @Override
    public OrderTO createOrder(OrderTO order) {
        order.setCode(generateRandomCode());
        OrderEntity orderEntity = new OrderEntity(order.getCode(), order.getProductCode(), order.getCpf(), order.getAmount(), order.getDate(), order.getValue());
        entityManager.persist(orderEntity);
        return order;
    }

    @Override
    public OrderTO updateOrder(String code, OrderTO order) {
        OrderEntity orderEntity = entityManager.find(OrderEntity.class, code);

        orderEntity.setProductCode(order.getProductCode() != null ? order.getProductCode() : orderEntity.getProductCode());
        orderEntity.setCpf(order.getCpf() != null ? order.getCpf() : orderEntity.getCpf());
        orderEntity.setAmount(order.getAmount() != 0 ? order.getAmount() : orderEntity.getAmount());
        orderEntity.setDate(order.getDate() != null ? order.getDate() : orderEntity.getDate());
        orderEntity.setValue(order.getValue() != 0 ? order.getValue() : orderEntity.getValue());

        entityManager.merge(orderEntity);

        order.setCode(orderEntity.getCode());
        order.setProductCode(orderEntity.getProductCode());
        order.setCpf(orderEntity.getCpf());
        order.setAmount(orderEntity.getAmount());
        order.setDate(orderEntity.getDate());
        order.setValue(orderEntity.getValue());

        return order;
    }

    @Override
    public void deleteOrder(String code) {
        OrderEntity orderEntity = entityManager.find(OrderEntity.class, code);
        entityManager.remove(orderEntity);
    }

    @Override
    public List<OrderTO> getOrders(String code, String cpf) {

        List<OrderEntity> ordersEntity = new ArrayList<>();

        if (code == null && cpf == null) {
            ordersEntity = entityManager.createQuery("from OrderEntity o", OrderEntity.class).getResultList();
        } else {
            ordersEntity = entityManager.createQuery("from OrderEntity o where o.code like :code or o.cpf like :cpf", OrderEntity.class)
                    .setParameter("code", "%" + code + "%")
                    .setParameter("cpf", "%" + cpf + "%")
                    .getResultList();
        }

        List<OrderTO> orders = new ArrayList<>();

        for (OrderEntity orderEntity : ordersEntity) {
            orders.add(new OrderTO(orderEntity.getCode(), orderEntity.getProductCode(), orderEntity.getCpf(), orderEntity.getAmount(), orderEntity.getDate(), orderEntity.getValue()));
        }

        return orders;
    }

    @Override
    public OrderTO getOrderById(String code) {
        OrderEntity orderEntity = entityManager.find(OrderEntity.class, code);
        OrderTO order = new OrderTO(orderEntity.getCode(), orderEntity.getProductCode(), orderEntity.getCpf(), orderEntity.getAmount(), orderEntity.getDate(), orderEntity.getValue());
        return order;
    }

    private String generateRandomCode() {
        return String.valueOf(new Date().getTime());
    }
}