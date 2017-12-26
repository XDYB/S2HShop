package main.com.ssh.shop.dao.impl;

import main.com.ssh.shop.dao.WhlistDao;
import main.com.ssh.shop.entity.Whlist;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("whlistDao")
public class WhlistDaoImpl extends BaseDaoImpl<Whlist> implements WhlistDao {
    @Override
    public List<Whlist> queryToWhlist(int wno, int page, int size) {
        String hql;
        hql = "from Whlist as w where w.wno =:wno";
        return getSession().createQuery(hql).setInteger("wno", wno).list();

    }

    @Override
    public List<Whlist> searchbyname(String name, int wno, int page, int size) {
        String hql;
        name = name.trim();
        if (name.equals("") || name == null) {
            hql = "from Whlist as w where w.wno =:wno";
            return getSession().createQuery(hql).setInteger("wno", wno).list();
        } else {
            hql = "from Whlist as w where w.wno =:wno and w.goods.name=:name";
            return getSession().createQuery(hql).setInteger("wno", wno).setString("name", name).list();
        }

    }

    @Override
    public void deleteWhlist(int id) {
        String hql = "delete from Whlist as c where c.id = :id";
        getSession().createQuery(hql).setInteger("id", id).executeUpdate();
    }


    @Override
    public Long getCountAll(int wno) {

        String hql = "select count(c) from Whlist c where c.wno=:wno";
        return (Long) getSession().createQuery(hql).setInteger("wno", wno).uniqueResult(); //返回一条记录:总记录数
    }
}
