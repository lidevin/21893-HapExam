package exam.core.sales.service.impl;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.dto.BaseDTO;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.service.IBaseService;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import exam.core.sales.dto.OmOrderLines;
import exam.core.sales.mapper.OmOrderLinesMapper;
import exam.core.sales.service.IOmOrderLinesService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class OmOrderLinesServiceImpl extends BaseServiceImpl<OmOrderLines> implements IOmOrderLinesService{

//    private volatile Long maxLineId = null;
    @Autowired
    private OmOrderLinesMapper linesMapper;
    @Override
    public List<OmOrderLines> batchUpdate(IRequest request, List<OmOrderLines> list) {
        IBaseService<OmOrderLines> self = ((IBaseService<OmOrderLines>) AopContext.currentProxy());

        for (OmOrderLines t : list) {
//            if(t.get__status() == null) throw new RuntimeException("status不能为null");
            switch (t.get__status()) {
                case DTOStatus.ADD:
                    /*if(maxLineId == null || (maxLineId=linesMapper.maxId()) == null){
                        maxLineId = 1L;
                    }else{
                        maxLineId++;
                    }*/
                    t.setLineId(null);
                    System.out.println("batchUpdate -> lineId = " + t.getLineId());
                    t.setCreatedBy(request.getUserId());
                    t.setObjectVersionNumber(1L);
                    t.setCreationDate(new Date());
                    self.insertSelective(request, t);
                    break;
                case DTOStatus.UPDATE:
                    if (useSelectiveUpdate()) {
                        self.updateByPrimaryKeySelective(request, t);
                    } else {
                        self.updateByPrimaryKey(request, t);
                    }
                    break;
                case DTOStatus.DELETE:
                    self.deleteByPrimaryKey(t);
                    break;
                default:
                    break;
            }
        }
        return list;
    }
}