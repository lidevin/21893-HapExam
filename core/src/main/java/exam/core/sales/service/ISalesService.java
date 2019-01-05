package exam.core.sales.service;

import exam.core.sales.dto.OmOrderLines;
import exam.core.sales.dto.OrderSummary;

import java.util.List;

public interface ISalesService{

    public List<OrderSummary> summary(OrderSummary summary, int page, int pageSize);

    public List<OrderSummary> detail(OrderSummary summary);

    /**
     * 查询某个订单编号下的相关信息
     * @param summary   查询字段
     * @param pageNum   分页页码
     * @param pageSize  分页每页个数
     * @return
     */
    public List<OmOrderLines> detailItems(OrderSummary summary, int pageNum, int pageSize);
}