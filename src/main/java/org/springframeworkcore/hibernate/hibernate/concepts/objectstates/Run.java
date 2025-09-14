package org.springframeworkcore.hibernate.hibernate.concepts.objectstates;

import org.springframeworkcore.hibernate.hibernate.concepts.helper.PrintToScreenHelper;
import org.springframeworkcore.hibernate.hibernate.concepts.helper.TransactionManagement;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.manytomany.Customer;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service.PassportService;
import org.springframeworkcore.hibernate.hibernate.concepts.relationships.onetoone.service.PersonService;

public class Run {
	public static void main(String[] args) {

		/*
		 * 
		 * Transient → Persistent: Happens via save(), persist(), get(), etc.
		 * 
		 * Persistent → Detached: Happens via session.close(), session.evict(),
		 * session.clear().
		 * 
		 * Persistent → Removed: Happens via delete().
		 * 
		 * Detached → Persistent again: Use session.update() or session.merge().
		 */
		
		
		/*
		 * Transient state - object is in jvm memory but not loaded in session
		 * Definition: An object is created using the new operator, but it is not
		 * associated with Hibernate Session and not saved in the database.
		 * 
		 * Characteristics: - Not tracked by Hibernate. - No database row is linked. -
		 * Changes to object won’t be reflected in DB.
		 */
		
		HibernateObjectStates obj = new HibernateObjectStates();
		obj.setName("pra");
		obj.setHobby("cricket");
		// Up to here obj is in Transient state

		/*
		 * Persistent State
		 * 
		 * Definition: When a transient object is associated with a Hibernate Session,
		 * it becomes persistent.
		 * 
		 * Characteristics: Hibernate tracks it. Any changes made → automatically
		 * synchronized with the database (dirty checking). Has a corresponding DB row.
		 */
		TransactionManagement.doInTransactionConsumer(session -> {
			session.persist(obj);// persistant state

		});

		PrintToScreenHelper.print("get(persistamnce state): " + TransactionManagement.doInTransactionFunction(
				session -> session.createQuery("From HibernateObjectStates", HibernateObjectStates.class).list()// persistant
																												// state
		));

		// session closed -> obj is in detached state, back into to jvm memory

		TransactionManagement.doInTransactionConsumer(session -> {
			session.remove(obj);// removed state -> obj no longer remains in db
		});

		PrintToScreenHelper.print("removed(removed state): " + TransactionManagement.doInTransactionFunction(
				session -> session.createQuery("From HibernateObjectStates", HibernateObjectStates.class).list()// persistant
																												// state
		));

		/*
		 * Detached State
		 * 
		 * Definition: A previously persistent object that is no longer associated with
		 * an active Hibernate session.
		 * 
		 * Characteristics:
		 * 
		 * Data still exists in DB.
		 * 
		 * Object is not tracked anymore.
		 * 
		 * Modifications won’t be auto-saved to DB.
		 * 
		 * How it happens:
		 * 
		 * session.close()
		 * 
		 * session.evict(obj)
		 * 
		 * session.clear()
		 */

	}
}
