package org.camunda.bpm.getstarted.bikeServiceapproval;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class ProcessRequestDelegate implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("BikeService-REQUESTS");

	public void execute(DelegateExecution execution) throws Exception {
		boolean monCon = false;
		LOGGER.info("=============================================================");
		LOGGER.info("\nCustomer ID : " + execution.getVariable("customerId"));
		LOGGER.info("\nMonth : " + execution.getVariable("mon"));
		Double month = (Double) execution.getVariable("mon");
		if (month > 3.0) {
			monCon = true;
			LOGGER.info("\n Bike service is Approved.");
		} else {
			monCon = false;
			LOGGER.info("\n Bike service is Rejected because month less then 3.");
		}
		LOGGER.info("=============================================================");
		execution.setVariable("approved", monCon);
	}
}
