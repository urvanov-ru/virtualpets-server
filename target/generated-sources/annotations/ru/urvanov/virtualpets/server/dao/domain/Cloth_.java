package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Cloth.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Cloth_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Cloth#clothType
	 **/
	public static volatile SingularAttribute<Cloth, ClothType> clothType;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Cloth#id
	 **/
	public static volatile SingularAttribute<Cloth, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Cloth
	 **/
	public static volatile EntityType<Cloth> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Cloth#version
	 **/
	public static volatile SingularAttribute<Cloth, Integer> version;

	public static final String CLOTH_TYPE = "clothType";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

