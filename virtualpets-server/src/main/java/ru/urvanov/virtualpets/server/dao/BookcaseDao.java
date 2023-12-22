/**
 * 
 */
package ru.urvanov.virtualpets.server.dao;

import ru.urvanov.virtualpets.server.domain.Bookcase;

/**
 * @author fedya
 *
 */
public interface BookcaseDao {
    Bookcase findById(Integer id);
    Bookcase findFullById(Integer id);
}
