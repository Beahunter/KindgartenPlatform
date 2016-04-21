package bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

    // Fields

    private Long id;

    private String name;

    private Short type;

    private Integer classId;

    private String photo;

    // Constructors

    /** default constructor */
    public User() {
    }

    /** minimal constructor */
    public User(Short type, Integer classId) {
        this.type = type;
        this.classId = classId;
    }

    /** full constructor */
    public User(String name, Short type, Integer classId, String photo) {
        this.name = name;
        this.type = type;
        this.classId = classId;
        this.photo = photo;
    }

    // Property accessors

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getType() {
        return this.type;
    }

    public void setType(Short type) {
        this.type = type;
    }

    public Integer getClassId() {
        return this.classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

}