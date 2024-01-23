package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Room.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Room_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#refrigeratorX
	 **/
	public static volatile SingularAttribute<Room, Integer> refrigeratorX;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#bookcaseY
	 **/
	public static volatile SingularAttribute<Room, Integer> bookcaseY;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#refrigeratorY
	 **/
	public static volatile SingularAttribute<Room, Integer> refrigeratorY;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#journalOnFloor
	 **/
	public static volatile SingularAttribute<Room, Boolean> journalOnFloor;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#petId
	 **/
	public static volatile SingularAttribute<Room, Integer> petId;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#version
	 **/
	public static volatile SingularAttribute<Room, Integer> version;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#machineWithDrinksY
	 **/
	public static volatile SingularAttribute<Room, Integer> machineWithDrinksY;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#machineWithDrinksX
	 **/
	public static volatile SingularAttribute<Room, Integer> machineWithDrinksX;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#boxNewbie2
	 **/
	public static volatile SingularAttribute<Room, Boolean> boxNewbie2;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#boxNewbie1
	 **/
	public static volatile SingularAttribute<Room, Boolean> boxNewbie1;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#bookcase
	 **/
	public static volatile SingularAttribute<Room, Bookcase> bookcase;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#machineWithDrinks
	 **/
	public static volatile SingularAttribute<Room, MachineWithDrinks> machineWithDrinks;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#boxNewbie3
	 **/
	public static volatile SingularAttribute<Room, Boolean> boxNewbie3;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room
	 **/
	public static volatile EntityType<Room> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#refrigerator
	 **/
	public static volatile SingularAttribute<Room, Refrigerator> refrigerator;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Room#bookcaseX
	 **/
	public static volatile SingularAttribute<Room, Integer> bookcaseX;

	public static final String REFRIGERATOR_X = "refrigeratorX";
	public static final String BOOKCASE_Y = "bookcaseY";
	public static final String REFRIGERATOR_Y = "refrigeratorY";
	public static final String JOURNAL_ON_FLOOR = "journalOnFloor";
	public static final String PET_ID = "petId";
	public static final String VERSION = "version";
	public static final String MACHINE_WITH_DRINKS_Y = "machineWithDrinksY";
	public static final String MACHINE_WITH_DRINKS_X = "machineWithDrinksX";
	public static final String BOX_NEWBIE2 = "boxNewbie2";
	public static final String BOX_NEWBIE1 = "boxNewbie1";
	public static final String BOOKCASE = "bookcase";
	public static final String MACHINE_WITH_DRINKS = "machineWithDrinks";
	public static final String BOX_NEWBIE3 = "boxNewbie3";
	public static final String REFRIGERATOR = "refrigerator";
	public static final String BOOKCASE_X = "bookcaseX";

}

