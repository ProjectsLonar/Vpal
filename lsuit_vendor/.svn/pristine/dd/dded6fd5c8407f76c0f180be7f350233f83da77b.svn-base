package com.lonar.vendor.vendorportal.controller;

import java.io.*;
import java.net.*;

public class TCPFileClient
{ 
	public static void main(String args[]) throws Exception
	{	
	String file = "";
	String serverfile="";

	while(!(file.equals("exit")))	
	{
		BufferedReader readerfromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket("127.0.0.1", 12);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		file = readerfromUser.readLine();
		outToServer.writeBytes(file + '\n');

		BufferedReader readerFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		FileWriter fw= new FileWriter("TCPFileClientcopy1.txt");
		while(!(serverfile.equals(null)))
		{	
			serverfile = readerFromServer.readLine();
			fw.write(serverfile);
		}
		fw.close();
		clientSocket.close();
	}
	}
}
