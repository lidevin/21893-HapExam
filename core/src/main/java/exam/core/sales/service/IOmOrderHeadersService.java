package exam.core.sales.service;

import com.hand.hap.core.IRequest;
import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.IBaseService;
import exam.core.sales.dto.OmOrderHeaders;

import java.util.List;

public interface IOmOrderHeadersService extends IBaseService<OmOrderHeaders>, ProxySelf<IOmOrderHeadersService>{

    List<OmOrderHeaders> batchUpdate(IRequest iRequest, OmOrderHeaders orderHeaders);
}