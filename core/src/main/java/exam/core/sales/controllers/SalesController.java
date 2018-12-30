package exam.core.sales.controllers;

import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import exam.core.sales.dto.OrderSummary;
import exam.core.sales.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SalesController extends BaseController {

    @Autowired
    private ISalesService salesService;

    @RequestMapping(value = "/summary/query")
    public ResponseData summary(OrderSummary summary, @RequestParam(defaultValue = DEFAULT_PAGE) int page,
                              @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) int pageSize) {
        ResponseData res = new ResponseData(salesService.summary(summary, page, pageSize));
        System.out.println("data = " + res.getRows());
        return res;
    }

}