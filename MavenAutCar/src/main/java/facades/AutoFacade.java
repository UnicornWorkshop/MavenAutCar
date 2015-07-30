package facades;

import org.springframework.stereotype.Component;

import entities.Auto;

@Component
public class AutoFacade extends AbstractFacade<Auto> implements GenericFacade<Auto> {
	
	public void add(Auto item) {		
		getService().add(item);
	}
	
}
