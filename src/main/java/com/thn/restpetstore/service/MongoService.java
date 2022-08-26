package com.thn.restpetstore.service;

import com.mongodb.client.gridfs.model.GridFSFile;
import com.thn.restpetstore.entity.Car;
import com.thn.restpetstore.mongo.MongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MongoService {

    private final MongoRepository mongoRepository;

    private final GridFsTemplate gridFsTemplate;

    @Autowired
    public MongoService(MongoRepository mongoRepository, GridFsTemplate gridFsTemplate) {
        this.mongoRepository = mongoRepository;
        this.gridFsTemplate = gridFsTemplate;
    }

    public void save(Car car) {
        mongoRepository.save(car);
    }

    public String save(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename()).toLowerCase();
        try {
            int i = 1;
            String fileNameTemp = fileName;
            while (getFileIfExist(fileName) != null) {
                fileName = i + "_" + fileNameTemp;
                i++;
            }

            gridFsTemplate.store(file.getInputStream(), fileName, file.getContentType());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileName;
    }

    public GridFsResource getFileResource(String fileName) {
        GridFsResource resource = null;
        GridFSFile file = getFileIfExist(fileName);
        if (file != null) {
            resource = gridFsTemplate.getResource(file);
        }
        return resource;
    }

    public void delete(String fileName) {
        gridFsTemplate.delete(new Query(GridFsCriteria.whereFilename().is(fileName)));
    }

    private GridFSFile getFileIfExist(String filename) {
        if (filename == null) return null;

        return gridFsTemplate
                .find(new Query((GridFsCriteria.whereFilename().is(filename))))
                .first();
    }
}
