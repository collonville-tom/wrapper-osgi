package org.tc.osgi.bundle.spring.conf;

import org.tc.osgi.bundle.utils.interf.conf.AbstractPropertyFile;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;

/**
 * SpringPropertyFile.java.
 * 
 * @author collonville thomas
 * @version
 * @track
 */
public class SpringPropertyFile extends AbstractPropertyFile {

	/**
	 * String BUNDLE_RACINE.
	 */
	public final static String BUNDLE_RACINE = "tc.osgi.bundle.spring.";

	/**
	 * SpringPropertyFile instance.
	 */
	private static SpringPropertyFile instance = null;

	/**
	 * String SPRING_FILE.
	 */
	public static final String SPRING_FILE = "spring";

	/**
	 * getInstance.
	 * 
	 * @return DefaultConfig
	 * @throws MorphConfigException
	 * @throws FieldTrackingAssignementException
	 */
	public static SpringPropertyFile getInstance() {
		if (SpringPropertyFile.instance == null) {
			SpringPropertyFile.instance = new SpringPropertyFile();
		}
		return SpringPropertyFile.instance;
	}

	/**
	 * DefaultConfig constructor.
	 * 
	 * @throws MorphConfigException
	 * @throws FieldTrackingAssignementException
	 */
	private SpringPropertyFile() {
		super(SpringPropertyFile.SPRING_FILE, SpringPropertyFile.class.getClassLoader());
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getBundleRacine()
	 */
	@Override
	public String getBundleRacine() {
		return SpringPropertyFile.BUNDLE_RACINE;
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getConfFile()
	 */
	@Override
	public String getConfFile() {
		return SpringPropertyFile.SPRING_FILE;
	}

	/**
	 * @return String
	 * @see org.tc.osgi.bundle.utils.conf.AbstractPropertyFile#getXMLFile()
	 */
	@Override
	public String getXMLFile() {
		return SpringPropertyFile.getInstance().getConfigDirectory() + getConfFile();

	}

	@Override
	public String getYamlFile() {
		return SpringPropertyFile.getInstance().getConfigDirectory() + getConfFile();
	}

}
