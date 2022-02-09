package LHU.project.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "weekDays_hours")
public class HourInDays  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId",nullable = false)
    private Integer roomId;

    @Column(name = "nameHours")
    private String nameHours;


    @Column(name = "showTimes")
    private Date showTimes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "weekdaysId",referencedColumnName = "weekdayId")
    private WeekDays weekDay;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getNameHours() {
        return nameHours;
    }

    public void setNameHours(String nameHours) {
        this.nameHours = nameHours;
    }

    public Date getShowTimes() {
        return showTimes;
    }

    public void setShowTimes(Date showTimes) {
        this.showTimes = showTimes;
    }

    public WeekDays getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(WeekDays weekDay) {
        this.weekDay = weekDay;
    }
}
