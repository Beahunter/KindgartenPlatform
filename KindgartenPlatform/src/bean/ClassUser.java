package bean;

/**
 * ClassUser entity. @author MyEclipse Persistence Tools
 */

public class ClassUser implements java.io.Serializable {

    // Fields

    private Long id;

    private Long classId;

    private Long userId;

    // Constructors

    /** default constructor */
    public ClassUser() {
    }

    /** full constructor */
    public ClassUser(Long classId, Long userId) {
        this.classId = classId;
        this.userId = userId;
    }

    // Property accessors

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return this.classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}