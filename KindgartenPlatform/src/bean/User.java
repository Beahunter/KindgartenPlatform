package bean;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private Short type;
	private String photo;
	private Long phoneNumber;
	private String password;
	private Long classId;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Short type, Long phoneNumber, String password, Long classId) {
		this.type = type;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.classId = classId;
	}

	/** full constructor */
	public User(String name, Short type, String photo, Long phoneNumber,
			String password, Long classId) {
		this.name = name;
		this.type = type;
		this.photo = photo;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.classId = classId;
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

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Long getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getClassId() {
		return this.classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

}