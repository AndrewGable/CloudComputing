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

package course.cloud.computing.sockets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private static Socket clientSocket;

	public static void main(String[] args) {
		if (args.length < 2) {
			usage();
			System.exit(-1);
		}
		int portNumber = Integer.parseInt(args[1]);
		String hostName = args[0];
		try {
			clientSocket = new Socket(hostName, portNumber);
			System.out.println("Connected to server, lets chat ....");
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
					true);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					clientSocket.getInputStream()));

			BufferedReader stdIn = new BufferedReader(new InputStreamReader(
					System.in));
			
			BufferedWriter writer = new BufferedWriter(new PrintWriter(System.out));

			ReceiverThread receiver = new ReceiverThread(in, writer);
			Thread thread1 = new Thread(receiver);
			thread1.start();
			
			SenderThread sender = new SenderThread(stdIn, out);
			Thread thread2 = new Thread(sender);
			thread2.start();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void usage() {
		System.out.println("Usage: java course.cloud.computing.sockets.Client [hostname] [port]");
	}

}
