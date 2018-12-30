package exam.core.sales.service;

import exam.core.sales.dto.OrderSummary;

import java.util.List;

public interface ISalesService{

    public List<OrderSummary> summary(OrderSummary summary, int page, int pageSize);
}