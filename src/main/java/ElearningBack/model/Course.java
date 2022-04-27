package ElearningBack.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Courses")
@AllArgsConstructor
@Data
public class Course implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;

    @Column(name="title")
    @NotEmpty
    @Size(min = 2, message ="name should have at least 2 characters!")
    private String title;

    @Column(name = "year", nullable = false)
    private int year;

    /**
     * Teacher who teach this subject.
     */

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    /**
     * Student who learn this subject.
     */
  /**  @JsonIgnore
    @ManyToMany(mappedBy = "coursesS", fetch = FetchType.LAZY)
    private Collection<Student> studentsss;

    /**
     * Groups who learn this subject.

    @JsonIgnore
    @ManyToMany(mappedBy = "coursesG", fetch = FetchType.EAGER)
    private Collection<Groupe> groupsss; **/

    public Course(String title, int year, Teacher teacher) {
        this.title = title;
        this.year = year;
        this.teacher = teacher;
    }
    /**
     * Course time in Timetable.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "Monday")
    private Collection<TimeTable> lessonM ;

    @JsonIgnore
    @OneToMany(mappedBy = "Tusday")
    private Collection<TimeTable> lessonTu ;

    @JsonIgnore
    @OneToMany(mappedBy = "Wednesday")
    private Collection<TimeTable> lessonW ;

    @JsonIgnore
    @OneToMany(mappedBy = "Thirsday")
    private Collection<TimeTable> lessonTi ;

    @JsonIgnore
    @OneToMany(mappedBy = "Friday")
    private Collection<TimeTable> lessonMF ;

    public Course() {
    }

    public Long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Long idCourse) {
        this.idCourse = idCourse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

   /** @JsonIgnore
    public Collection<Student> getStudents() {
        return studentsss;
    }

    public void setStudents(Collection<Student> studentsss) {
        this.studentsss = studentsss;
    }

    @JsonIgnore
    public Collection<Groupe> getGroupsss() {
        return groupsss;
    }

    public void setGroupsss(Collection<Groupe> groupsss) {
        this.groupsss = groupsss;
    }**/

    @JsonIgnore
    public Collection<TimeTable> getLessonM() {return lessonM;}

    public void setLessonM(Collection<TimeTable> lessonM) {this.lessonM = lessonM;}

    @JsonIgnore
    public Collection<TimeTable> getLessonTu() {return lessonTu;}

    public void setLessonTu(Collection<TimeTable> lessonTu) {this.lessonTu = lessonTu;}

    @JsonIgnore
    public Collection<TimeTable> getLessonW() {return lessonW;}

    public void setLessonW(Collection<TimeTable> lessonW) {this.lessonW = lessonW;}

    @JsonIgnore
    public Collection<TimeTable> getLessonTi() {return lessonTi; }

    public void setLessonTi(Collection<TimeTable> lessonTi) {this.lessonTi = lessonTi;}

    @JsonIgnore
    public Collection<TimeTable> getLessonMF() {return lessonMF;}

    public void setLessonMF(Collection<TimeTable> lessonMF) {this.lessonMF = lessonMF; }
}
