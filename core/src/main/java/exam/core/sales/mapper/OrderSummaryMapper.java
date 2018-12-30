package exam.core.sales.mapper;

import exam.core.sales.dto.OrderSummary;

import java.util.List;

public interface OrderSummaryMapper {

    public List<OrderSummary> get(OrderSummary orderSummary);
}