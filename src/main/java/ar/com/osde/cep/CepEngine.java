package ar.com.osde.cep;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import ar.com.osde.model.Event;

/**
 * This is a sample class to launch a rule.
 */
public class CepEngine {

	private final StatefulKnowledgeSession ksession;

	private static CepEngine instance = new CepEngine();

	private CepEngine() {
		super();

		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		kbuilder.add(ResourceFactory.newClassPathResource(
				"TwiterStreamAnalizer.drl", getClass()), ResourceType.DRL);
		if (kbuilder.hasErrors()) {
			System.err.println(kbuilder.getErrors().toString());
		}

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		ksession = kbase.newStatefulKnowledgeSession();

		Runnable r = new Runnable() {
			
			public void run() {

				ksession.fireUntilHalt();

			}
		};

		Thread t = new Thread(r);
		t.start();

	}

	/*
	 * retrun an instance of cep engine
	 */
	public static CepEngine getInstance() {
		return instance;
	}

	/**
	 * inserts an event into the event cloud
	 * **/
	public void addEvent(Event e) {
		ksession.insert(e);
	}

	public void stop() {

		ksession.halt();

	}

}