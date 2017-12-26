package main.com.ssh.shop.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "WHLIST")
public class Whlist {
    private int id;
    private Integer goodid;
    private Integer num;
    private Integer wno;
    private Integer min;

    @Basic
    @Column(name = "Min", nullable = true)
    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    private Goods goods;
    private Warehouse warehouse;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "goodid", nullable = true)
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "wno", nullable = true)
    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "GOODID", nullable = true)
    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    @Basic
    @Column(name = "NUM", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "WNO", nullable = true)
    public Integer getWno() {
        return wno;
    }

    public void setWno(Integer wno) {
        this.wno = wno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Whlist whlist = (Whlist) o;

        if (id != whlist.id) return false;
        if (goodid != null ? !goodid.equals(whlist.goodid) : whlist.goodid != null) return false;
        if (num != null ? !num.equals(whlist.num) : whlist.num != null) return false;
        if (wno != null ? !wno.equals(whlist.wno) : whlist.wno != null) return false;



        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (goodid != null ? goodid.hashCode() : 0);
        result = 31 * result + (num != null ? num.hashCode() : 0);
        result = 31 * result + (wno != null ? wno.hashCode() : 0);

        return result;
    }

    public Whlist(int id, Integer goodid, Integer num, Integer wno, Goods goods, Warehouse warehouse) {
        this.id = id;
        this.goodid = goodid;
        this.num = num;
        this.wno = wno;
        this.goods = goods;
        this.warehouse = warehouse;
    }

    public Whlist() {

    }

    @Override
    public String toString() {
        return "Whlist{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", num=" + num +
                ", wno=" + wno +
                ", min=" + min +
                ", goods=" + goods +
                ", warehouse=" + warehouse +
                '}';
    }
}
