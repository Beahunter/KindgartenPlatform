package bean;

import java.util.Date;

/**
 * Study entity. @author MyEclipse Persistence Tools
 */

public class Study implements java.io.Serializable {

	// Fields

	private Long id;
	private Long teacherId;
	private String content;
	private Date date;
	private Integer subjectId;
	private Integer classId;

	// Constructors

	/** default constructor */
	public Study() {
	}

	/** minimal constructor */
	public Study(Long teacherId, Integer subjectId, Integer classId) {
		this.teacherId = teacherId;
		this.subjectId = subjectId;
		this.classId = classId;
	}

	/** full constructor */
	public Study(Long teacherId, String content, Date date, Integer subjectId,
			Integer classId) {
		this.teacherId = teacherId;
		this.content = content;
		this.date = date;
		this.subjectId = subjectId;
		this.classId = classId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getSubjectId() {
		return this.subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getClassId() {
		return this.classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

}