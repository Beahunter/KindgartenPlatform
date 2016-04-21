package bean;

import java.util.Date;

/**
 * Homework entity. @author MyEclipse Persistence Tools
 */

public class Homework implements java.io.Serializable {

	// Fields

	private Long id;
	private Long teacherId;
	private String content;
	private Date date;
	private Long classId;

	// Constructors

	/** default constructor */
	public Homework() {
	}

	/** minimal constructor */
	public Homework(Long teacherId) {
		this.teacherId = teacherId;
	}

	/** full constructor */
	public Homework(Long teacherId, String content, Date date, Long classId) {
		this.teacherId = teacherId;
		this.content = content;
		this.date = date;
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

	public Long getClassId() {
		return this.classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

}