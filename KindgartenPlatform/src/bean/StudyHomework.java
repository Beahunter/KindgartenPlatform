package bean;

import java.util.Date;

/**
 * StudyHomework entity. @author MyEclipse Persistence Tools
 */

public class StudyHomework implements java.io.Serializable {

    // Fields

    private Long id;

    private Long userId;

    private String content;

    private Short type;

    private Date date;

    // Constructors

    /** default constructor */
    public StudyHomework() {
    }

    /** minimal constructor */
    public StudyHomework(Long userId, Short type) {
        this.userId = userId;
        this.type = type;
    }

    /** full constructor */
    public StudyHomework(Long userId, String content, Short type, Date date) {
        this.userId = userId;
        this.content = content;
        this.type = type;
        this.date = date;
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

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
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

}