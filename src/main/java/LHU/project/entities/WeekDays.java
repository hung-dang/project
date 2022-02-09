package LHU.project.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@ToString
@Entity
@Table(name = "weekDays")
public class WeekDays extends BaseEntitiess{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weekdayId",nullable = false)
    private Integer weekDayId;

    @Column(name = "nameDay")
    private String nameDay;

    @Column(name = "showDays")
    private Date showDays;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roomId",referencedColumnName = "roomId")
    private Room room;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "weekDay")
    private Set<HourInDays> hourInDays = new HashSet<>();

    public Integer getWeekDayId() {
        return weekDayId;
    }

    public void setWeekDayId(Integer weekDayId) {
        this.weekDayId = weekDayId;
    }

    public String getNameDay() {
        return nameDay;
    }

    public void setNameDay(String nameDay) {
        this.nameDay = nameDay;
    }

    public Date getShowDays() {
        return showDays;
    }

    public void setShowDays(Date showDays) {
        this.showDays = showDays;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Set<HourInDays> getHourInDays() {
        return hourInDays;
    }

    public void setHourInDays(Set<HourInDays> hourInDays) {
        this.hourInDays = hourInDays;
    }
}
