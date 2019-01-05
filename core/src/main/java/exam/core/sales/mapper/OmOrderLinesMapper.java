package exam.core.sales.mapper;

import com.hand.hap.mybatis.common.Mapper;
import exam.core.sales.dto.OmOrderLines;
import exam.core.sales.dto.OrderSummary;

import java.util.List;

public interface OmOrderLinesMapper extends Mapper<OmOrderLines>{
    public List<OmOrderLines> get(OrderSummary summary);

    public Long maxId();

    public int deleteByHeaderId(Long headerId);
}