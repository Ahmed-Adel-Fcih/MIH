package service.basic;

import java.util.List;

import domain.basic.BasicEntity;


public interface BasicDaoInterface <T> {

	BasicEntity addEntity(BasicEntity Entity);
	BasicEntity deleteEntity(BasicEntity Entity);
	BasicEntity updateEntity(BasicEntity updatedEntity);
	Object findEntityById(int entityId,Class<T>className);
    List<BasicEntity> findAllEntities(Class className);

	  
}
//01126889011 mo
//01129629396 had
