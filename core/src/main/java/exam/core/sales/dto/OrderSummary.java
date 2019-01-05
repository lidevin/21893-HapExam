package exam.core.sales.dto;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

/**
 * @author desheng.li@hand-china.com
 * @date 2018/12/29
 */
public class OrderSummary implements Serializable {
    private Long companyId; //公司ID
    @Length(max = 240)
    private String companyName; //公司名称

    private Long customerId; //客户ID
    @Length(max = 240)
    private String customerName; //客户名称

    private Long headerId; //订单头ID
    @Length(max = 60)
    private String orderNumber; //订单编号
    private Date orderDate; //订单日期
    @Length(max = 30)
    private String orderStatus; //订单状态
    private Long orderMoney;//订单金额

    private Long inventoryItemId; //物料ID
    @Length(max = 60)
    private String itemCode; //物料编码


    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getHeaderId() {
        return headerId;
    }

    public void setHeaderId(Long headerId) {
        this.headerId = headerId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderMoney() {
        return orderMoney;
    }

    public void setOrderMoney(Long orderMoney) {
        this.orderMoney = orderMoney;
    }

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @Override
    public String toString() {
        return "OrderSummary{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", headerId=" + headerId +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderMoney=" + orderMoney +
                ", inventoryItemId=" + inventoryItemId +
                ", itemCode='" + itemCode + '\'' +
                '}';
    }
}
