package exam.core.sales.service.impl;

import com.github.pagehelper.PageHelper;
import exam.core.sales.dto.OrderSummary;
import exam.core.sales.mapper.OrderSummaryMapper;
import exam.core.sales.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SalesServiceImpl implements ISalesService {

    @Autowired
    private OrderSummaryMapper orderSummaryMapper;
    @Override
    public List<OrderSummary> summary(OrderSummary summary, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return orderSummaryMapper.get(summary);
    }
}