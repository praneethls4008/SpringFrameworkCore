package org.springframeworkcore.hibernate.hibernate.concepts.helper;

import java.util.function.Consumer;
import java.util.function.Function;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionManagement {

	// Generic method for queries/operations that return a value
	public static <R> R doInTransactionFunction(Function<Session, R> action) {
		Transaction tx = null;
	    Session session = null;
	    try {
	        session = SessionFactoryUtil.getSessionFactory().openSession();
	        tx = session.beginTransaction();

	        R result = action.apply(session);

	        tx.commit();
	        return result;
	    } catch (Exception e) {
	        if (tx != null && tx.isActive()) {
	            try {
	                tx.rollback();
	            } catch (Exception rollbackEx) {
	                rollbackEx.printStackTrace(); // log rollback failure
	            }
	        }
	        throw e;
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close(); // always close explicitly
	        }
	    }
	}

	// Overload for void operations (no need for return null)
	public static void doInTransactionConsumer(Consumer<Session> action) {
		doInTransactionFunction(session -> {
			action.accept(session);
			return null; // hidden from caller
		});
	}
}
