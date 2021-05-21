package cn.wfy.service.impl;

import cn.wfy.dao.SharesRepository;
import cn.wfy.entity.SellOut;
import cn.wfy.entity.Shares;
import cn.wfy.service.ShareService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @Description TODO
 * @auther wfy
 * @since 2021/3/28
 */
@Service(value = "shareService")
@Transactional(rollbackFor = Exception.class)
public class ShareServiceImpl implements ShareService {
    @Resource
    private SharesRepository sharesRepository;

    @Override
    public void insert(Shares shares) {
        Shares save = sharesRepository.save(shares);
    }


    private EntityManager entityManager;

    @Transactional(rollbackFor = Exception.class)
    public void addBatch(List<SellOut> list) {
        for (SellOut sellOut : list) {
            entityManager.persist(sellOut);//insert插入操作
        }
        entityManager.flush();
        entityManager.clear();
    }

    @Transactional(rollbackFor = Exception.class)
    public void addBatch1(Shares shares) {
        entityManager.persist(shares);//insert插入操作
        entityManager.flush();
        entityManager.clear();
    }
}
