package cn.wfy.vo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description TODO
 * @auther wfy
 * @since 2020/9/13
 */
@Entity
@Table(name = "soul")
public class Soul implements Serializable {
    @Id
    private Integer id;
    @Column(length = 300)
    private String title;
    @Column(length = 100)
    private String hits;

    public Soul() {
    }

    public Soul(Integer id, String title, String hits) {
        this.id = id;
        this.title = title;
        this.hits = hits;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHits() {
        return hits;
    }

    public void setHits(String hits) {
        this.hits = hits;
    }
}
