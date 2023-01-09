package com.lonar.vendor.vendorportal.controller;

import java.io.*;
import java.net.*;
import java.io.File;
import java.util.Scanner;

public class TCPFileServer
{
	public static void main(String args[]) throws Exception
	{	//declaring variables
		String clientfile;
		String reply = "";
		//declaring a ServerSocket obj intialising with a socket
		ServerSocket serverSocket = new ServerSocket(12);

		while(!(reply.equals("exit")))
		{	

			//declaring a socket obj and assigning the values
			Socket connectionSocket = serverSocket.accept();

			//Declaring a variable for capturing the message from Client
			//the bufferedReader will buffer an InputStream Obj that will read from the socket
			BufferedReader readerFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream( )));

			//Declaring an output stream for replying to client
			DataOutputStream writeToClient = new DataOutputStream(connectionSocket.getOutputStream( ));
			//BufferedOutputStream writeToClient = new BufferedOutputStream(connectionSocket.getOutputStr eam());

			clientfile = readerFromClient.readLine();

			File directory; // File object referring to the directory.
			String[] files; // Array of file names in the directory.

			directory = new File("C:/LexaApplication/Upload/Images/");

			if (directory.isDirectory() == false)
			{
				if (directory.exists() == false)
					System.out.println("There is no such directory!");
				else
					System.out.println("That file is not a directory.");
			}
			else
			{
				files = directory.list();
				
				File checkfile = new File(clientfile);
				boolean bo = checkfile.exists();
				if (bo == true)
				{
					FileReader fr = new FileReader(checkfile);
					BufferedReader br = new BufferedReader (fr);
					String line ="" ;
					while (line != null)
					{	
					line = br.readLine();
					writeToClient.writeBytes(line + "\n");
					}
					br.close();


				}
				//else
			}
		}
	}
}
