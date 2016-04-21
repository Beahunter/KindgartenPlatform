package bean;

import java.util.Date;

/**
 * Cookbook entity. @author MyEclipse Persistence Tools
 */

public class Cookbook implements java.io.Serializable {

    // Fields

    private Long id;

    private Long userId;

    private Short type;

    private Date date;

    private String photo;

    private String remark;

    // Constructors

    /** default constructor */
    public Cookbook() {
    }

    /** minimal constructor */
    public Cookbook(Long userId, Short type) {
        this.userId = userId;
        this.type = type;
    }

    /** full constructor */
    public Cookbook(Long userId, Short type, Date date, String photo,
            String remark) {
        this.userId = userId;
        this.type = type;
        this.date = date;
        this.photo = photo;
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

    public Short getType() {
        return this.type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}