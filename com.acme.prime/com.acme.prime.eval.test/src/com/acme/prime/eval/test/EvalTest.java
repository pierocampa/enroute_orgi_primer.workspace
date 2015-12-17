package com.acme.prime.eval.test;

import org.junit.Assert;
import org.junit.Test;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

import com.acme.prime.eval.api.Eval;

/**
 * 
 */

public class EvalTest {

    private final BundleContext context = FrameworkUtil.getBundle(this.getClass()).getBundleContext();
    
    /*
     * Verifies that the bundle context is not null.
     */
    @Test
    public void testContext() throws Exception {
    	Assert.assertNotNull(context);
    }
    
    /*
     * Verifies the Eval OSGi DS is available.
     */
    @Test
    public void testEval() throws Exception {
    	Assert.assertNotNull(getService(Eval.class));
    }
    
    <T> T getService(Class<T> clazz) throws InterruptedException {
    	ServiceTracker<T,T> st = new ServiceTracker<>(context, clazz, null);
    	st.open();
    	return st.waitForService(1000);
    }
}
