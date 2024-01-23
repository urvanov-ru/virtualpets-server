package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Achievement.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Achievement_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Achievement#code
	 **/
	public static volatile SingularAttribute<Achievement, AchievementCode> code;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Achievement#id
	 **/
	public static volatile SingularAttribute<Achievement, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Achievement
	 **/
	public static volatile EntityType<Achievement> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Achievement#version
	 **/
	public static volatile SingularAttribute<Achievement, Integer> version;

	public static final String CODE = "code";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

