package com.graymatter;

import java.sql.SQLException;
import java.util.List;

public interface PersonInterface {

	List<PersonClass> getAllPersonsInfo() throws ClassNotFoundException, SQLException;
	PersonClass getPersonById(int id) throws ClassNotFoundException, SQLException;
	PersonClass addPerson(PersonClass person) throws ClassNotFoundException, SQLException;;
	PersonClass updatePerson(PersonClass person,int id) throws ClassNotFoundException, SQLException;;
	PersonClass deletePerson(int id) throws ClassNotFoundException, SQLException;;

}