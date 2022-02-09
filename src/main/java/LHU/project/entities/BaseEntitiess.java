package LHU.project.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import java.util.Date;

@ToString
@RequiredArgsConstructor
@MappedSuperclass
public class BaseEntitiess {

    @Column(name="createdAt")
    private Date createdAt;

    @Column(name ="updateAt")
    private Date updateAt;

    @Column(name="image",length = 4000)
    private String image;

    @Column(name="title",length = 4000)
    private String title;

    @Column(name="smallDesc",length = 4000)
    private String smallDesc;

    @Column(name="bigDesc",length = 4000)
    private String bigDesc;

    @Column(name = "status")
    private Byte status;

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSmallDesc() {
        return smallDesc;
    }

    public void setSmallDesc(String smallDesc) {
        this.smallDesc = smallDesc;
    }

    public String getBigDesc() {
        return bigDesc;
    }

    public void setBigDesc(String bigDesc) {
        this.bigDesc = bigDesc;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
