package cn.com.dreamcraft.heritane.ticket;

public class singleJourneyTicket extends Ticket { // 单程票票卡

    private Boolean isFareStorage; // 是否为储值式单程票
    private String entryZone; // 入口站
    private String destZone; // 出口站
    private long faresStoraged; // 储值式单程票储值余额

    public Boolean isFareStorage() {return isFareStorage;}
    public String getEntryZone() {return entryZone;}
    public String getDestZone() {return destZone;}
    public long getFaresStoraged() {return faresStoraged;}
}
