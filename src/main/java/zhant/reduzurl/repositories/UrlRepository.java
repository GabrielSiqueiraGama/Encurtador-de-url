package zhant.reduzurl.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import zhant.reduzurl.entities.UrlEntity;

public interface UrlRepository extends MongoRepository<UrlEntity, String>{

}
