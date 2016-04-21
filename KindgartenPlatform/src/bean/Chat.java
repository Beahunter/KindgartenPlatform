package bean;

/**
 * Chat entity. @author MyEclipse Persistence Tools
 */

public class Chat implements java.io.Serializable {

    // Fields

    private Long id;

    private Long senderId;

    private Long classId;

    private String content;

    private Short type;

    // Constructors

    /** default constructor */
    public Chat() {
    }

    /** minimal constructor */
    public Chat(Long senderId, Long classId, Short type) {
        this.senderId = senderId;
        this.classId = classId;
        this.type = type;
    }

    /** full constructor */
    public Chat(Long senderId, Long classId, String content, Short type) {
        this.senderId = senderId;
        this.classId = classId;
        this.content = content;
        this.type = type;
    }

    // Property accessors

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSenderId() {
        return this.senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getClassId() {
        return this.classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
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

}