package cn.train.mapper;

import cn.train.enity.ContactInfo;

public interface ContactInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContactInfo record);

    int insertSelective(ContactInfo record);

    ContactInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContactInfo record);

    int updateByPrimaryKey(ContactInfo record);
}