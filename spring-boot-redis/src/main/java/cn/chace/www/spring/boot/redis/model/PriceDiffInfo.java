package cn.chace.www.spring.boot.redis.model;


import java.io.Serializable;

/**
 * Model类：房价差值信息
 *
 * @author chenx
 * @date 2016/11/29
 */
public class PriceDiffInfo implements Serializable {

    private static final long serialVersionUID = -949804023546859256L;

    private String hotelCode;

    private String hotelName;

    private Integer classicRoomId;

    private String classicRoomName;

    private double hotelRoomPrice;

    private double selfHotelRoomPrice;

    private int rule;

    private double minValue;

    private double maxValue;

    private long checkInDate;

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public Integer getClassicRoomId() {
        return classicRoomId;
    }

    public void setClassicRoomId(Integer classicRoomId) {
        this.classicRoomId = classicRoomId;
    }

    public double getHotelRoomPrice() {
        return hotelRoomPrice;
    }

    public void setHotelRoomPrice(double hotelRoomPrice) {
        this.hotelRoomPrice = hotelRoomPrice;
    }

    public double getSelfHotelRoomPrice() {
        return selfHotelRoomPrice;
    }

    public void setSelfHotelRoomPrice(double selfHotelRoomPrice) {
        this.selfHotelRoomPrice = selfHotelRoomPrice;
    }

    public String getClassicRoomName() {
        return classicRoomName;
    }

    public void setClassicRoomName(String classicRoomName) {
        this.classicRoomName = classicRoomName;
    }

    public int getRule() {
        return rule;
    }

    public void setRule(int rule) {
        this.rule = rule;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public long getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(long checkInDate) {
        this.checkInDate = checkInDate;
    }
}
