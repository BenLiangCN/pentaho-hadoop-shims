/*******************************************************************************
 *
 * Pentaho Big Data
 *
 * Copyright (C) 2002-2015 by Pentaho : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.hadoop.shim.mapr410.delegatingShims;

import java.io.InputStream;
import java.io.OutputStream;

import org.pentaho.hadoop.shim.ShimVersion;
import org.pentaho.hadoop.shim.mapr410.authorization.HadoopAuthorizationService;
import org.pentaho.hadoop.shim.mapr410.authorization.HasHadoopAuthorizationService;
import org.pentaho.hadoop.shim.spi.SnappyShim;

public class DelegatingSnappyShim implements SnappyShim, HasHadoopAuthorizationService {
  private SnappyShim delegate;

  @Override
  public void setHadoopAuthorizationService( HadoopAuthorizationService hadoopAuthorizationService ) {
    delegate = hadoopAuthorizationService.getShim( SnappyShim.class );
  }

  @Override
  public boolean isHadoopSnappyAvailable() {
    return delegate.isHadoopSnappyAvailable();
  }

  @Override
  public ShimVersion getVersion() {
    return delegate.getVersion();
  }

  @Override
  public InputStream getSnappyInputStream( InputStream in ) throws Exception {
    return delegate.getSnappyInputStream( in );
  }

  @Override
  public InputStream getSnappyInputStream( int bufferSize, InputStream in ) throws Exception {
    return delegate.getSnappyInputStream( bufferSize, in );
  }

  @Override
  public OutputStream getSnappyOutputStream( OutputStream out ) throws Exception {
    return delegate.getSnappyOutputStream( out );
  }

  @Override
  public OutputStream getSnappyOutputStream( int bufferSize, OutputStream out ) throws Exception {
    return delegate.getSnappyOutputStream( bufferSize, out );
  }
}
