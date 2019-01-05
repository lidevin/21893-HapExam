package exam.core.sales.mapper;

import exam.core.sales.dto.OrderSummary;

import java.util.List;

public interface SalesOrderMapper {

    public List<OrderSummary> summary(OrderSummary orderSummary);

    public List<OrderSummary> detail(OrderSummary orderSummary);
}