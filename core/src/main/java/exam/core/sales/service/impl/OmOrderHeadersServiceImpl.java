package exam.core.sales.service.impl;

import com.hand.hap.core.IRequest;
import com.hand.hap.mybatis.common.Criteria;
import com.hand.hap.system.dto.BaseDTO;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.IBaseService;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import exam.core.sales.mapper.OmOrderHeadersMapper;
import exam.core.sales.mapper.OmOrderLinesMapper;
import exam.core.sales.service.IOmOrderLinesService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import exam.core.sales.dto.OmOrderHeaders;
import exam.core.sales.service.IOmOrderHeadersService;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderHeadersServiceImpl extends BaseServiceImpl<OmOrderHeaders> implements IOmOrderHeadersService{

    @Autowired
    private OmOrderHeadersMapper orderHeadersMapper;

    private volatile Long maxHeaderId = null;

    @Override
    public List<OmOrderHeaders> batchUpdate(IRequest request, OmOrderHeaders orderHeaders) {
        IBaseService<OmOrderHeaders> self = ((IBaseService<OmOrderHeaders>) AopContext.currentProxy());
        if(orderHeaders.get__status() == DTOStatus.ADD){
            //生成id
            if(maxHeaderId == null && (maxHeaderId = orderHeadersMapper.maxId())==null){
                maxHeaderId = 1L;
            }else{
                maxHeaderId++;
            }
            orderHeaders.setHeaderId(maxHeaderId);
            orderHeaders.setCreatedBy(request.getUserId());
            orderHeaders.setObjectVersionNumber(1L);
            orderHeaders.setCreationDate(new Date());
            self.insert(request, orderHeaders);
            System.out.println("orderHeaders -> " + orderHeaders);
        }else if(orderHeaders.get__status() == DTOStatus.UPDATE){
            self.updateByPrimaryKeySelective(request, orderHeaders);
        }else{
            return null;
        }
        List<OmOrderHeaders> list = new ArrayList<>(1);
        list.add(orderHeaders);
        return list;
    }

    @Autowired
    private OmOrderLinesMapper orderLinesMapper;

    @Override
    public int deleteByPrimaryKey(OmOrderHeaders record) {
        int count = super.deleteByPrimaryKey(record);
        count += orderLinesMapper.deleteByHeaderId(record.getHeaderId());
        return count;
    }
}