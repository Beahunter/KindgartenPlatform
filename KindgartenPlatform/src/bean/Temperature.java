package bean;

import java.util.Date;

/**
 * Temperature entity. @author MyEclipse Persistence Tools
 */

public class Temperature implements java.io.Serializable {

    // Fields

    private Long id;

    private Long userId;

    private Integer temperature;

    private Date date;

    private String remark;

    // Constructors

    /** default constructor */
    public Temperature() {
    }

    /** minimal constructor */
    public Temperature(Long userId, Integer temperature) {
        this.userId = userId;
        this.temperature = temperature;
    }

    /** full constructor */
    public Temperature(Long userId, Integer temperature, Date date,
            String remark) {
        this.userId = userId;
        this.temperature = temperature;
        this.date = date;
        this.remark = remark;
    }

    // Property accessors

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTemperature() {
        return this.temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}