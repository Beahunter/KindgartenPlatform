package bean;

import java.util.Date;

/**
 * SignIn entity. @author MyEclipse Persistence Tools
 */

public class SignIn implements java.io.Serializable {

    // Fields

    private Long id;

    private Short type;

    private Long teacherId;

    private Date time;

    private String photo;

    private String remark;

    private Long childId;

    // Constructors

    /** default constructor */
    public SignIn() {
    }

    /** minimal constructor */
    public SignIn(Short type, Long teacherId, Long childId) {
        this.type = type;
        this.teacherId = teacherId;
        this.childId = childId;
    }

    /** full constructor */
    public SignIn(Short type, Long teacherId, Date time, String photo,
            String remark, Long childId) {
        this.type = type;
        this.teacherId = teacherId;
        this.time = time;
        this.photo = photo;
        this.remark = remark;
        this.childId = childId;
    }

    // Property accessors

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Short getType() {
        return this.type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Long getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public Date getTime() {
        return this.time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Long getChildId() {
        return this.childId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

}