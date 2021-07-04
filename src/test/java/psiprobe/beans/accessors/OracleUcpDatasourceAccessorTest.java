/*
 * Licensed under the GPL License. You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   https://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 *
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE.
 */
package psiprobe.beans.accessors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import oracle.ucp.jdbc.PoolDataSourceImpl;
import oracle.ucp.jdbc.PoolXADataSourceImpl;

/**
 * The Class OracleUcpDatasourceAccessorTest.
 */
public class OracleUcpDatasourceAccessorTest {

    /** The accessor. */
    OracleUcpDatasourceAccessor accessor;

    /** The source. */
    PoolDataSourceImpl source;

    PoolXADataSourceImpl xaSource;
    
    /** The bad source. */
    ComboPooledDataSource badSource;

    /**
     * Before.
     */
    @BeforeEach
    public void before() {
        accessor = new OracleUcpDatasourceAccessor();
        source = new PoolDataSourceImpl();
        xaSource = new PoolXADataSourceImpl();
        badSource = new ComboPooledDataSource();
    }

    /**
     * Can map test.
     */
    @Test
    public void canMapTest() {
        Assertions.assertTrue(accessor.canMap(source));
    }

    /**
     * Can map XA test.
     */
    @Test
    public void canMapXATest() {
        Assertions.assertTrue(accessor.canMap(xaSource));
    }

    /**
     * Cannot map test.
     */
    @Test
    public void cannotMapTest() {
        Assertions.assertFalse(accessor.canMap(badSource));
    }

    /**
     * Gets the info test.
     *
     * @throws Exception the exception
     */
    @Test
    public void getInfoTest() throws Exception {
        accessor.getInfo(source);
    }

}
