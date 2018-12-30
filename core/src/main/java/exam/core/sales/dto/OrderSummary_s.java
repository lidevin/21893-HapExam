package exam.core.sales.dto;

/**
 * @author desheng.li@hand-china.com
 * @date 2018/12/29
 */
public class OrderSummary_s {

    private ArCustomers arCustomers;
    private InvInventoryItems invInventoryItems;
    private OrgCompanys orgCompanys;
    private OmOrderHeaders  omOrderHeaders;
    private OmOrderLines omOrderLines;

    public ArCustomers getArCustomers() {
        return arCustomers;
    }

    public void setArCustomers(ArCustomers arCustomers) {
        this.arCustomers = arCustomers;
    }

    public InvInventoryItems getInvInventoryItems() {
        return invInventoryItems;
    }

    public void setInvInventoryItems(InvInventoryItems invInventoryItems) {
        this.invInventoryItems = invInventoryItems;
    }

    public OrgCompanys getOrgCompanys() {
        return orgCompanys;
    }

    public void setOrgCompanys(OrgCompanys orgCompanys) {
        this.orgCompanys = orgCompanys;
    }

    public OmOrderHeaders getOmOrderHeaders() {
        return omOrderHeaders;
    }

    public void setOmOrderHeaders(OmOrderHeaders omOrderHeaders) {
        this.omOrderHeaders = omOrderHeaders;
    }

    public OmOrderLines getOmOrderLines() {
        return omOrderLines;
    }

    public void setOmOrderLines(OmOrderLines omOrderLines) {
        this.omOrderLines = omOrderLines;
    }

    @Override
    public String toString() {
        return "OrderSummary{" +
                "arCustomers=" + arCustomers +
                ", invInventoryItems=" + invInventoryItems +
                ", orgCompanys=" + orgCompanys +
                ", omOrderHeaders=" + omOrderHeaders +
                ", omOrderLines=" + omOrderLines +
                '}';
    }
}
