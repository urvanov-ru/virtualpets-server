package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(JournalEntry.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class JournalEntry_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.JournalEntry#code
	 **/
	public static volatile SingularAttribute<JournalEntry, JournalEntryType> code;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.JournalEntry#id
	 **/
	public static volatile SingularAttribute<JournalEntry, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.JournalEntry
	 **/
	public static volatile EntityType<JournalEntry> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.JournalEntry#version
	 **/
	public static volatile SingularAttribute<JournalEntry, Integer> version;

	public static final String CODE = "code";
	public static final String ID = "id";
	public static final String VERSION = "version";

}

