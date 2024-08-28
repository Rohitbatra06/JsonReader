package com.test.bajaj.training;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App 
{
    public static void main( String[] args )
    {
		Scanner cin = new Scanner(System.in) ;
		System.out.print("Enter path of json : ");
		String path = cin.nextLine() ;
		System.out.print("Enter prn : ");
		long prn = cin.nextLong();
		cin.close();
		String destination ="";
		try {
		ObjectMapper objectMapper = new ObjectMapper(); 
        JsonNode jsonNode = objectMapper.readTree(new File(path)); 
        destination = jsonNode.get("destination").asText(); 
		}catch(Exception e) 
		{
			System.out.println(e);
		}
		//System.out.println(prn + "  " + path + "  " + name);
		String str = generateRandomString(8) ;
		String concndString = prn + destination + str ;
		int hashcode = concndString.hashCode() ;
		String out = hashcode + ";" + str ;
		System.out.println(out);
    }
    private static String generateRandomString(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }
        return sb.toString();
    }
    
}
