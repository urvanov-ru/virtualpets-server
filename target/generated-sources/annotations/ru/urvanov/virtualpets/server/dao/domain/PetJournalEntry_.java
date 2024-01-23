package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(PetJournalEntry.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class PetJournalEntry_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetJournalEntry#journalEntry
	 **/
	public static volatile SingularAttribute<PetJournalEntry, JournalEntry> journalEntry;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetJournalEntry#readed
	 **/
	public static volatile SingularAttribute<PetJournalEntry, Boolean> readed;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetJournalEntry#createdAt
	 **/
	public static volatile SingularAttribute<PetJournalEntry, Date> createdAt;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetJournalEntry#id
	 **/
	public static volatile SingularAttribute<PetJournalEntry, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetJournalEntry
	 **/
	public static volatile EntityType<PetJournalEntry> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetJournalEntry#version
	 **/
	public static volatile SingularAttribute<PetJournalEntry, Integer> version;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.PetJournalEntry#pet
	 **/
	public static volatile SingularAttribute<PetJournalEntry, Pet> pet;

	public static final String JOURNAL_ENTRY = "journalEntry";
	public static final String READED = "readed";
	public static final String CREATED_AT = "createdAt";
	public static final String ID = "id";
	public static final String VERSION = "version";
	public static final String PET = "pet";

}

