package exam.core.sales.service.impl;

import com.github.pagehelper.PageHelper;
import exam.core.sales.dto.OmOrderLines;
import exam.core.sales.dto.OrderSummary;
import exam.core.sales.mapper.OmOrderHeadersMapper;
import exam.core.sales.mapper.OmOrderLinesMapper;
import exam.core.sales.mapper.SalesOrderMapper;
import exam.core.sales.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SalesServiceImpl implements ISalesService {

    @Autowired
    private SalesOrderMapper orderSummaryMapper;
    @Override
    public List<OrderSummary> summary(OrderSummary summary, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return orderSummaryMapper.summary(summary);
    }

    @Autowired
    private OmOrderHeadersMapper headersMapper;

    @Override
    public List<OrderSummary> detail(OrderSummary summary) {
        return orderSummaryMapper.detail(summary);
    }

    @Autowired
    private OmOrderLinesMapper linesMapper;
    @Override
    public List<OmOrderLines> detailItems(OrderSummary summary, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        return linesMapper.get(summary);
    }
}