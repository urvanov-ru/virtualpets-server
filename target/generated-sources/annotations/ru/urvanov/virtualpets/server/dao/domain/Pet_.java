package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.MapAttribute;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Pet.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Pet_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#satiety
	 **/
	public static volatile SingularAttribute<Pet, Integer> satiety;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#education
	 **/
	public static volatile SingularAttribute<Pet, Integer> education;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#achievements
	 **/
	public static volatile MapAttribute<Pet, Achievement, PetAchievement> achievements;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#mood
	 **/
	public static volatile SingularAttribute<Pet, Integer> mood;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#foods
	 **/
	public static volatile MapAttribute<Pet, Food, PetFood> foods;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#drinks
	 **/
	public static volatile MapAttribute<Pet, Drink, PetDrink> drinks;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#loginDate
	 **/
	public static volatile SingularAttribute<Pet, Date> loginDate;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#bow
	 **/
	public static volatile SingularAttribute<Pet, Cloth> bow;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#experience
	 **/
	public static volatile SingularAttribute<Pet, Integer> experience;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#cloths
	 **/
	public static volatile SetAttribute<Pet, Cloth> cloths;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#hat
	 **/
	public static volatile SingularAttribute<Pet, Cloth> hat;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#id
	 **/
	public static volatile SingularAttribute<Pet, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet
	 **/
	public static volatile EntityType<Pet> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#hiddenObjectsGameCount
	 **/
	public static volatile SingularAttribute<Pet, Integer> hiddenObjectsGameCount;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#journalEntries
	 **/
	public static volatile MapAttribute<Pet, JournalEntry, PetJournalEntry> journalEntries;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#sessionKey
	 **/
	public static volatile SingularAttribute<Pet, String> sessionKey;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#teachCount
	 **/
	public static volatile SingularAttribute<Pet, Integer> teachCount;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#level
	 **/
	public static volatile SingularAttribute<Pet, Level> level;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#petType
	 **/
	public static volatile SingularAttribute<Pet, PetType> petType;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#buildCount
	 **/
	public static volatile SingularAttribute<Pet, Integer> buildCount;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#version
	 **/
	public static volatile SingularAttribute<Pet, Integer> version;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#drink
	 **/
	public static volatile SingularAttribute<Pet, Integer> drink;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#buildingMaterials
	 **/
	public static volatile MapAttribute<Pet, BuildingMaterial, PetBuildingMaterial> buildingMaterials;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#createdDate
	 **/
	public static volatile SingularAttribute<Pet, Date> createdDate;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#books
	 **/
	public static volatile SetAttribute<Pet, Book> books;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#name
	 **/
	public static volatile SingularAttribute<Pet, String> name;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#comment
	 **/
	public static volatile SingularAttribute<Pet, String> comment;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#drinkCount
	 **/
	public static volatile SingularAttribute<Pet, Integer> drinkCount;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#user
	 **/
	public static volatile SingularAttribute<Pet, User> user;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#eatCount
	 **/
	public static volatile SingularAttribute<Pet, Integer> eatCount;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Pet#cloth
	 **/
	public static volatile SingularAttribute<Pet, Cloth> cloth;

	public static final String SATIETY = "satiety";
	public static final String EDUCATION = "education";
	public static final String ACHIEVEMENTS = "achievements";
	public static final String MOOD = "mood";
	public static final String FOODS = "foods";
	public static final String DRINKS = "drinks";
	public static final String LOGIN_DATE = "loginDate";
	public static final String BOW = "bow";
	public static final String EXPERIENCE = "experience";
	public static final String CLOTHS = "cloths";
	public static final String HAT = "hat";
	public static final String ID = "id";
	public static final String HIDDEN_OBJECTS_GAME_COUNT = "hiddenObjectsGameCount";
	public static final String JOURNAL_ENTRIES = "journalEntries";
	public static final String SESSION_KEY = "sessionKey";
	public static final String TEACH_COUNT = "teachCount";
	public static final String LEVEL = "level";
	public static final String PET_TYPE = "petType";
	public static final String BUILD_COUNT = "buildCount";
	public static final String VERSION = "version";
	public static final String DRINK = "drink";
	public static final String BUILDING_MATERIALS = "buildingMaterials";
	public static final String CREATED_DATE = "createdDate";
	public static final String BOOKS = "books";
	public static final String NAME = "name";
	public static final String COMMENT = "comment";
	public static final String DRINK_COUNT = "drinkCount";
	public static final String QUERY_FIND_BY_USER_ID = "findByUserId";
	public static final String USER = "user";
	public static final String EAT_COUNT = "eatCount";
	public static final String CLOTH = "cloth";

}

