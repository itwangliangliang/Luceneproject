package com.liang;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class SolrJ {
    //创建索引库
    @Test
    public void createIndexs()throws Exception{
        //指定远程服务器地址
        String path ="http://localhost:8080/solr/article";
        //创建服务对象,远程连接solr服务
        SolrServer solrServer = new HttpSolrServer(path);

        SolrInputDocument doc = new SolrInputDocument();
        //向域字段添加内容,必须是schema.xml中已存在的域字段
        doc.addField("id","vbsjkn");
        doc.addField("title","vuishonqkbjfjahidhka");
        //添加索引库
        solrServer.add(doc);
        solrServer.commit();

    }

    //更新索引库
    @Test
    public void updateIndexs()throws Exception{
        //指定远程服务器地址
        String path ="http://localhost:8080/solr/article";
        //创建服务对象,远程连接solr服务
        SolrServer solrServer = new HttpSolrServer(path);

        SolrInputDocument doc = new SolrInputDocument();
        //向域字段添加内容,必须是schema.xml中已存在的域字段
        //同字段的内容,id不变,内容不同就是更新
        doc.addField("id","vbsjkn");
        doc.addField("title","vuishonqkbjfjahidhka");
        //添加索引库
        solrServer.add(doc);
        solrServer.commit();

    }


    //删除索引库
    @Test
    public void deleteIndexs()throws Exception{
        //指定远程服务器地址
        String path ="http://localhost:8080/solr/article";
        //创建服务对象,远程连接solr服务
        SolrServer solrServer = new HttpSolrServer(path);

      //  solrServer.deleteById("title");
        //先查再删
        solrServer.deleteByQuery("title:vuishonqkbjfjahidhka");
        solrServer.commit();
    }





}
