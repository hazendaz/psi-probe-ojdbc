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
package psiprobe.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.codebox.bean.JavaBeanTester;

/**
 * The Class DataSourceInfoTest.
 */
public class DataSourceInfoTest {

  /**
   * Javabean tester.
   */
  @Test
  public void javabeanTester() {
    JavaBeanTester.builder(DataSourceInfo.class).loadData().test();
  }

  /**
   * Test get busy score.
   */
  @Test
  public void busyScore() {
      final DataSourceInfo dataSourceInfo = new DataSourceInfo();
      dataSourceInfo.setBusyConnections(1);
      dataSourceInfo.setMaxConnections(5);
      Assertions.assertEquals(20, dataSourceInfo.getBusyScore());
  }

  /**
   * Test get established score.
   */
  @Test
  public void establishedScore() {
      final DataSourceInfo dataSourceInfo = new DataSourceInfo();
      dataSourceInfo.setEstablishedConnections(1);
      dataSourceInfo.setMaxConnections(5);
      Assertions.assertEquals(20, dataSourceInfo.getEstablishedScore());
  }

}
