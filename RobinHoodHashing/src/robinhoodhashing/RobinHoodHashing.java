package robinhoodhashing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RobinHoodHashing {

    public static void main(String[] args) {
        System.out.println("Welcome to RobinHoodHashing By:->\nGHAZANFER ANWAR (16k-3891)\nMOAZZAM MAQSOOD (16k-3868)");
        System.out.println("Enter the size of Hash Table \"prefered odd\":->");
        Scanner inp = new Scanner(System.in);
        //int size = inp.nextInt();
        Hashing hashing = new Hashing(2399);
        LinearProbingHashTable linearprob=new LinearProbingHashTable(2399);
        //Random rnd = new Random(System.currentTimeMillis());
        //int ld=size/10;
        String[] Array = new String[2200]; 
//        for (int i = 0;i<size-ld;i++) {
//            Array[i]=Integer.toString(rnd.nextInt(100000)+100);
//            System.out.println(randomArray[i]);
//        }
        
        int countered=0;
        
        BufferedReader br = null;
        try{	
           br = new BufferedReader(new FileReader("Test.txt"));
	   String contentLine = br.readLine();
	   while (contentLine != null) {
               Array[countered]=contentLine;
               countered++;
	      System.out.println(contentLine);
	      contentLine = br.readLine();
	   }
            System.out.println("\n\n\n\nCOUNTER IS ::"+countered);
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(RobinHoodHashing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RobinHoodHashing.class.getName()).log(Level.SEVERE, null, ex);
        }  
            

      
        long startTime = System.currentTimeMillis();
        hashing.insert(Array);
        long endTime   = System.currentTimeMillis();
        long  totalTime = endTime - startTime;
        System.out.println("\n\n\nTOTAL TIME TAKEN TO INSERT In ROBINHOOD HASHING:"+totalTime+" ms\n\n\n\n");
        startTime = System.currentTimeMillis();
        linearprob.insertArray(Array);
        endTime   = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println("\n\n\nTOTAL TIME TAKEN TO INSERT In LINEAR PROBING:"+totalTime+" ms\n\n\n\n");
        
        
        startTime = System.nanoTime();
        linearprob.lookUp("zone");
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("\n\n\nTOTAL TIME TAKEN TO SEARCH In LINEAR PROBING:"+totalTime+"Nano Seconds\n\n\n\n");
        startTime = System.nanoTime();
        hashing.lookUp("zone");
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("\n\n\nTOTAL TIME TAKEN TO SEARCH In ROBINHOOD HASHING:"+totalTime+"Nano Seconds\n\n\n\n");
        //hashing.printHashTable();
        while(true)
        {
            System.out.println("Press The Operation code\n1:INSERT\n2:LOOKUP\n3:DELETE\n4:PRINT HASH TABLE\n5:LOAD FACTOR\n");
            int x=inp.nextInt();
            switch(x) {
                case 1 :
                    System.out.println("Enter The Element to insert\n");
                    hashing.insert(inp.next());
                   break;

                case 2 :
                    System.out.println("Enter The Element to LookUP\n");
                    int z=hashing.lookUp(inp.next());
                    if(z!=-1)
                    System.out.println("FOUND AT INDEX "+z);
                    else
                    {
                        System.out.println("NOT FOUND");
                    }
                   break;
                
                case 3 :
                    System.out.println("Enter The Element to DELETE\n");
                    boolean del=hashing.delete(inp.next());
                    if(del)
                    System.out.println("DELTED\n ");
                    else
                    {
                        System.out.println("NOT FOUND\n");
                    }
                   break;

                case 4 :
                    hashing.printHashTable();
                   break;
                   
                case 5 :
                    System.out.println(hashing.loadFactor());
                   break;


                   
                default :
                    continue;
             }
        }

        
        
        
    }   
    
}
