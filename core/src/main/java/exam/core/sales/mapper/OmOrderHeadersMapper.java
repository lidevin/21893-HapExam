package exam.core.sales.mapper;

import com.hand.hap.mybatis.common.Mapper;
import exam.core.sales.dto.OmOrderHeaders;

public interface OmOrderHeadersMapper extends Mapper<OmOrderHeaders>{

    public Long maxId();
}