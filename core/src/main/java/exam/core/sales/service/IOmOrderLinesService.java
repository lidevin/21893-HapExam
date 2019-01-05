package exam.core.sales.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import exam.core.sales.dto.OmOrderLines;
import exam.core.sales.dto.OrderSummary;

import java.util.List;

public interface IOmOrderLinesService extends IBaseService<OmOrderLines>, ProxySelf<IOmOrderLinesService>{
}