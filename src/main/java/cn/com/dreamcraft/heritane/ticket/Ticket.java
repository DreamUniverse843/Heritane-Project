package cn.com.dreamcraft.heritane.ticket;

public class Ticket{

    private String UUID; // 卡 UUID
    private long createTime; // 卡开卡时间
    private long expireTime; // 卡过期时间
    private long cardType; // 卡类型
    private String cardOwner; // 卡所有者(开卡人)

    public long getCreateTime() { return createTime;}
    public long getExpireTime() {return expireTime;}
    public long getCardType() {return cardType;}
    public String getCardOwner() {return cardOwner;}

}
