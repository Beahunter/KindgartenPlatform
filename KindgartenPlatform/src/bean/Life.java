package bean;

import java.util.Date;

/**
 * Life entity. @author MyEclipse Persistence Tools
 */

public class Life implements java.io.Serializable {

    // Fields

    private Long id;

    private Long userId;

    private String photo;

    private String remark;

    private Date time;

    // Constructors

    /** default constructor */
    public Life() {
    }

    /** minimal constructor */
    public Life(Long userId) {
        this.userId = userId;
    }

    /** full constructor */
    public Life(Long userId, String photo, String remark, Date time) {
        this.userId = userId;
        this.photo = photo;
        this.remark = remark;
        this.time = time;
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

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}