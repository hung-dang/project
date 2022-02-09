package LHU.project.entities;

import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@ToString
@Entity
@Table(name = "room")
public class Room extends BaseEntitiess{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId",nullable = false)
    private Integer roomId;

    @Column(name = "nameRoom")
    private String nameRoom;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "room")
    private Set<WeekDays> weekdays = new HashSet<>();

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public Set<WeekDays> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(Set<WeekDays> weekdays) {
        this.weekdays = weekdays;
    }
}
