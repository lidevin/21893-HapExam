package exam.core.sales.controllers;

import com.hand.hap.core.IRequest;
import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.BaseDTO;
import com.hand.hap.system.dto.DTOStatus;
import com.hand.hap.system.dto.ResponseData;
import exam.core.sales.dto.OmOrderHeaders;
import exam.core.sales.dto.OmOrderLines;
import exam.core.sales.dto.OrderSummary;
import exam.core.sales.service.IOmOrderHeadersService;
import exam.core.sales.service.IOmOrderLinesService;
import exam.core.sales.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SalesController extends BaseController {

    @Autowired
    private ISalesService salesService;
    ////////////////汇总////////////////
    @RequestMapping(value = "/summary/query")
    public ResponseData summary(OrderSummary summary, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize) {
        return new ResponseData(salesService.summary(summary, page, pageSize));
    }

    ////////////////明细////////////////
    /////////header/////////
    @RequestMapping(value = "/detail/query")
    public ResponseData query(HttpServletRequest request,OrderSummary summary) {
        return new ResponseData(salesService.detail(summary));
    }

    @Autowired
    private IOmOrderHeadersService orderHeadersService;
    @RequestMapping(value = "/detail/submit")
    public ResponseData submit(HttpServletRequest request, OmOrderHeaders orderHeaders, BindingResult result) {
        ResponseData responseData;
        System.out.println("status --> " + ((BaseDTO)orderHeaders).get__status());
        if(orderHeaders.getHeaderId() == null){//通过检查
            orderHeaders.setHeaderId(0L);
            orderHeaders.set__status(DTOStatus.ADD);
        }else{
            orderHeaders.set__status(DTOStatus.UPDATE);
        }
        responseData = check(request, orderHeaders, result);
        IRequest iRequest = this.createRequestContext(request);
        if(responseData.isSuccess()){
            List<OmOrderHeaders> list = orderHeadersService.batchUpdate(iRequest, orderHeaders);
            if(list == null){
                responseData.setSuccess(false);
                responseData.setMessage("修改失败");
            }else{
                responseData.setRows(list);
            }

        }
        return responseData;
    }
    /*@RequestMapping(value = "/detail/status")
    public ResponseData status(HttpServletRequest request, OmOrderHeaders orderHeaders) {
        orderHeadersService.status(this.createRequestContext(request), orderHeaders)
        return responseData;
    }*/

    @RequestMapping(value = "/detail/delete")
    public ResponseData delete(OmOrderHeaders orderHeaders) {
        orderHeadersService.deleteByPrimaryKey(orderHeaders);


        return new ResponseData(true);
    }

    /////////lines/////////
    @Autowired
    private IOmOrderLinesService orderLinesService;
    @RequestMapping(value = "/detail/items")
    public ResponseData items(OrderSummary summary, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize) {
        return new ResponseData(salesService.detailItems(summary, page, pageSize));
    }
    @RequestMapping(value = "/detail/items/pdf")
    public ResponseData itemsPdf(OrderSummary summary, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize) {
        salesService.detailItems(summary, page, pageSize);
        return new ResponseData();
    }

    @RequestMapping(value = "/detail/items/submit")
    public ResponseData itemsSubmit(HttpServletRequest request, @RequestBody List<OmOrderLines> orderLines, BindingResult result) {
        for (OmOrderLines line:orderLines) {
            if(line.getLineId() == null){
                line.setLineId(0L);
            }
        }
        ResponseData responseData = check(request, orderLines, result);
        if(responseData.isSuccess()){
            responseData.setRows(orderLinesService.batchUpdate(this.createRequestContext(request), orderLines));
        }
        return responseData;
    }

    @RequestMapping(value = "/detail/items/remove")
    public ResponseData itemsDelete(@RequestBody List<OmOrderLines> orderLines){
        orderLinesService.batchDelete(orderLines);
        return new ResponseData(true);
    }

    //检查数据
    private ResponseData check(HttpServletRequest request, Object obj, BindingResult result){
        this.getValidator().validate(obj, result);
        if (result.hasErrors()) {
            ResponseData responseData = new ResponseData(false);
            responseData.setMessage(getErrorMessage(result, request));
            return responseData;
        }
        return new ResponseData(true);
    }
}