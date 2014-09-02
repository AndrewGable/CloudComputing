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
package course.cloud.computing.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.wsaddressing.W3CEndpointReference;
import javax.xml.ws.soap.Addressing;
import javax.xml.ws.BindingType;

@WebService
@Addressing(enabled=true, required=false)
@BindingType(value="http://schemas.xmlsoap.org/wsdl/soap/http")
public interface SOAPService {
	
	@WebMethod
	public String sayHello(String name);
	
	@WebMethod
	public String registerCallback(W3CEndpointReference reference);

}
