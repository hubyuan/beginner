package cn.wfy.dao;


import cn.wfy.entity.IpInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IpInfoDao extends JpaRepository<IpInfo, Long> {
}