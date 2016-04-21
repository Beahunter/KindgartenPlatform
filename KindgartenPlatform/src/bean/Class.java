package bean;

/**
 * Class entity. @author MyEclipse Persistence Tools
 */

public class Class implements java.io.Serializable {

    // Fields

    private Long id;

    private String name;

    private Integer number;

    // Constructors

    /** default constructor */
    public Class() {
    }

    /** full constructor */
    public Class(String name, Integer number) {
        this.name = name;
        this.number = number;
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

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}