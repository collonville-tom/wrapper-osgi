package org.tc.osgi.bundle.spring.module.activator;

import org.apache.log4j.xml.DOMConfigurator;
import org.osgi.framework.BundleContext;
import org.tc.osgi.bundle.spring.conf.SpringPropertyFile;
import org.tc.osgi.bundle.utils.interf.conf.exception.FieldTrackingAssignementException;
import org.tc.osgi.bundle.utils.interf.module.exception.TcOsgiException;
import org.tc.osgi.bundle.utils.interf.module.service.ILoggerUtilsService;
import org.tc.osgi.bundle.utils.interf.module.service.IPropertyUtilsService;
import org.tc.osgi.bundle.utils.interf.module.utils.AbstractTcOsgiActivator;
import org.tc.osgi.bundle.utils.interf.module.utils.TcOsgiProxy;

/**
 * Activator.java.
 *
 * @author Collonville Thomas
 * @version 0.1.0
 **/
public class SpringActivator extends AbstractTcOsgiActivator {

	/**
	 * AptServiceTracker aptServiceTracker.
	 */

	private TcOsgiProxy<IPropertyUtilsService> iPropertyUtilsService;
	private TcOsgiProxy<ILoggerUtilsService> iLoggerUtilsService;

	/**
	 * String orgSpringframeworkOsgiExtenderDependencyBundleName.
	 */
	private String orgSpringFrameworkOsgiExtenderDependencyBundleName;

	/**
	 * getOrgSpringframeworkOsgiExtenderDependencyBundleName.
	 * @return String
	 * @throws FieldTrackingAssignementException
	 */
	public String getOrgSpringFrameworkOsgiExtenderDependencyBundleName() throws FieldTrackingAssignementException {
		if (orgSpringFrameworkOsgiExtenderDependencyBundleName == null) {
			this.iPropertyUtilsService.getInstance().getXMLPropertyFile(SpringPropertyFile.getInstance().getXMLFile()).fieldTraking(this,
				"orgSpringFrameworkOsgiExtenderDependencyBundleName");
		}
		this.iLoggerUtilsService.getInstance().getLogger(SpringActivator.class).debug(
			"Lancement auto du bundle :" + orgSpringFrameworkOsgiExtenderDependencyBundleName);
		return orgSpringFrameworkOsgiExtenderDependencyBundleName;
	}


	@Override
	protected void checkInitBundleUtilsService(BundleContext context) throws TcOsgiException {
		throw new TcOsgiException("checkInitBundleUtilsService not implemented");

	}

	@Override
	protected void initProxys(BundleContext context) throws TcOsgiException {

		this.iPropertyUtilsService = new TcOsgiProxy<IPropertyUtilsService>(context, IPropertyUtilsService.class);
		this.iLoggerUtilsService = new TcOsgiProxy<ILoggerUtilsService>(context, ILoggerUtilsService.class);

	}

	@Override
	protected void initServices(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void detachProxys(BundleContext context) throws TcOsgiException {

	}

	@Override
	protected void detachServices(BundleContext context) throws TcOsgiException {
		this.iLoggerUtilsService.close();
		this.iLoggerUtilsService.close();

	}

	@Override
	protected void beforeStart(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void beforeStop(BundleContext context) throws TcOsgiException {
		this.iLoggerUtilsService.getInstance().getLogger(SpringActivator.class).debug("Stop of utils service tracking");

	}

	@Override
	protected void afterStart(BundleContext context) throws TcOsgiException {
		// http://logging.apache.org/log4j/1.2/manual.html
		// BasicConfigurator.configure();
		DOMConfigurator.configureAndWatch(this.iLoggerUtilsService.getInstance().getLoggerGestionnary().getLog4jPathfile());
		this.iLoggerUtilsService.getInstance().getLogger(SpringActivator.class).debug("Start of utils service tracking");
		this.getIBundleUtilsService().getInstance().getBundleStarter().processOnBundle(context, getOrgSpringFrameworkOsgiExtenderDependencyBundleName());

	}

	@Override
	protected void afterStop(BundleContext context) throws TcOsgiException {
		// TODO Auto-generated method stub

	}
}
