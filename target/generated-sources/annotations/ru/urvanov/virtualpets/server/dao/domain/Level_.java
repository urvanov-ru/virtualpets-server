package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Level.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Level_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Level#id
	 **/
	public static volatile SingularAttribute<Level, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Level#experience
	 **/
	public static volatile SingularAttribute<Level, Integer> experience;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Level
	 **/
	public static volatile EntityType<Level> class_;

	public static final String ID = "id";
	public static final String EXPERIENCE = "experience";

}

