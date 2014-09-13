/*                                                                                                                                                                                      
 * Licensed under Apache Software Foundation V2 license agreement.  
 * See the NOTICE file distributed with this work for additional 
 * information regarding copyright ownership.  The ASF licenses this 
 * file to you under the Apache License, Version 2.0 (the                                                                                                                                    
 * "License"); you may not use this file except in compliance                                                                                                                          
 * with the License.  You may obtain a copy of the License at                                                                                                                          
 *                                                                                                                                                                                      
 *  http://www.apache.org/licenses/LICENSE-2.0                                                                                                                                         
 *                                                                                                                                                                                      
 * Unless required by applicable law or agreed to in writing,                                                                                                                          
 * software distributed under the License is distributed on an                                                                                                                          
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY                                                                                                                              
 * KIND, either express or implied.  See the License for the                                                                                                                            
 * specific language governing permissions and limitations                                                                                                                              
 * under the License.
 *
 *
 * Copyright(c) 2012-2014, Vijay Dialani. ALL RIGHTS RESERVED.
 *                                                                                                                                                                 
 */

package course.cloud.computing.rest;

import com.sun.grizzly.http.SelectorThread;
import com.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
import org.glassfish.grizzly.http.server.HttpServer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * App class.
 * 
 */
public class App {
	HttpServer server;
	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://localhost:9090/myapp/";

	/**
	 * Main method.
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		final SelectorThread server = startServer();
		System.out.println(String.format(
				"Jersey app started with WADL available at "
						+ "%sapplication.wadl\nHit enter to stop it...",
				BASE_URI));
		System.in.read();
		server.stopEndpoint();
	}

	private static SelectorThread startServer()
			throws IllegalArgumentException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> initParams = new HashMap<String, String>();
		initParams.put("com.sun.jersey.config.property.packages",
				"course.cloud.computing.rest");
		SelectorThread factory = GrizzlyWebContainerFactory.create(BASE_URI, initParams);
		return factory;
	}
}
