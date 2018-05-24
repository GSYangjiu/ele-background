package com.yangmiemie.ele.config;

import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Yang.
 * Email : vincent1094259423@yahoo.com
 * Date  : 2018-05-23 09:50
 * Description:
 */
@Component("mgTemplate")
public class MgTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    private final static Logger LOGGER = LoggerFactory.getLogger(MgTemplate.class);

    public MongoCollection<Document> getCollection(String collectionName) {
        LOGGER.info("MongoDb连接成功");
        return mongoTemplate.getCollection(collectionName);
    }
}
