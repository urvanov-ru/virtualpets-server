package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(PetAchievement.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class PetAchievement_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetAchievement#wasShown
	 **/
	public static volatile SingularAttribute<PetAchievement, Boolean> wasShown;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetAchievement#achievement
	 **/
	public static volatile SingularAttribute<PetAchievement, Achievement> achievement;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetAchievement#id
	 **/
	public static volatile SingularAttribute<PetAchievement, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetAchievement
	 **/
	public static volatile EntityType<PetAchievement> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetAchievement#version
	 **/
	public static volatile SingularAttribute<PetAchievement, Integer> version;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetAchievement#pet
	 **/
	public static volatile SingularAttribute<PetAchievement, Pet> pet;

	public static final String WAS_SHOWN = "wasShown";
	public static final String ACHIEVEMENT = "achievement";
	public static final String ID = "id";
	public static final String VERSION = "version";
	public static final String PET = "pet";

}

