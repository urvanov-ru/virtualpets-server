package ru.urvanov.virtualpets.server.dao.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Chat.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Chat_ {

	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Chat#addressee
	 **/
	public static volatile SingularAttribute<Chat, User> addressee;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Chat#sender
	 **/
	public static volatile SingularAttribute<Chat, User> sender;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Chat#id
	 **/
	public static volatile SingularAttribute<Chat, Integer> id;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Chat#message
	 **/
	public static volatile SingularAttribute<Chat, String> message;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Chat
	 **/
	public static volatile EntityType<Chat> class_;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Chat#version
	 **/
	public static volatile SingularAttribute<Chat, Integer> version;
	
	/**
	 * @see ru.urvanov.virtualpets.server.dao.domain.Chat#sendTime
	 **/
	public static volatile SingularAttribute<Chat, Date> sendTime;

	public static final String QUERY_FIND_FROM_ID = "findFromId";
	public static final String ADDRESSEE = "addressee";
	public static final String SENDER = "sender";
	public static final String QUERY_FIND_LAST = "findLast";
	public static final String ID = "id";
	public static final String MESSAGE = "message";
	public static final String VERSION = "version";
	public static final String SEND_TIME = "sendTime";

}

