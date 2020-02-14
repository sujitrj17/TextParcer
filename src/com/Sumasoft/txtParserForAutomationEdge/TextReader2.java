package com.Sumasoft.txtParserForAutomationEdge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextReader2 {


	
	static Map<String, Integer> checkBoucedPerYear = new HashMap<String, Integer>();
	static ArrayList<String> chequeBounceRemarks = new ArrayList<>();
	public static final String[] BOUNCED_CHEQUES_DETAILS_headers = {"CHEQUE NO","CHEQUE DATE","AMOUNT","CHEQUE UPDATED DATE","NO. OF BOUNCE","REASON"};

	
	public static void main(String[] args) {

//	 	File fileName = new File("/home/sumasoft/POC's/AUtomatioEdgeTextReaderPOC/Statement of Account/15-08-18/Statement_Of_Account_TN3000CD0002407.txt"); 
		File fileName = new File("/home/sumasoft/POC's/AUtomatioEdgeTextReaderPOC/Statement_Of_Account_WB3078CD0012069.txt");		
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) 
		{
		   // main while starts
			while (true) 
		    {
		      
		      String line = reader.readLine();
		        
		      // first condtiom
	          if (line == null) 
	          {
	        	  break;
	          }
	          
	          //second condition
	          else if (line.contains("RESIDENCE ADDRESS:")) //Get Customer Name
	          {
	        	line =  reader.readLine();
	           	  System.out.println("Customer Name :- "+ line);
           	  }
	          
	          // third condn
	          else if (line.contains("Net Overdue")) //Get Net Overdue
	          {
	        	  String netOverdue = null;
	        	  String netOverdueLine = null;
	           	  for (int i = 0; i < 3; i++) 
	           	  {
	           		netOverdueLine = reader.readLine();
	           		//System.out.println(netOverdueLine);
	           	  }
	           	  //System.out.println("Net Overdue Line :- "+netOverdueLine.toString());

	           	  
	           	  //netOverdueLine = netOverdueLine.replace(" ", " ");
	           	  String[] arr_netOverdue =netOverdueLine.toString().split(" ");
	           	  netOverdue = arr_netOverdue[arr_netOverdue.length-1];
	           	  System.out.println("Net Overdue Amount :- "+netOverdue);

           	  }
	          
	          //fourth condn
	          else if (line.contains("INST DUE DATE")) //1. Get Total Number of Installmwnt paid  2.Get Received Amount
	          {
	        	  int noOfInstallment = 0;
	        	  String noOfInstallmentLine = null;   	  
	           	  int counter = 0;

	           	  
	        	  do 
	        	  {
	        		  noOfInstallmentLine = reader.readLine();
	        		  System.out.println(noOfInstallmentLine);
	        		  
	        		  noOfInstallmentLine = noOfInstallmentLine.replaceAll("\\s+", "#");
	        		  String[] arr_installmenAmount =noOfInstallmentLine.toString().split("#");
	        	
	        		  if (noOfInstallmentLine.substring(0, 1).contains("-")) 
	        		  {
			           	  counter++;
			           	  //System.out.println(counter);
	        		  }
	        		  else
	        		  {
			           	  //System.out.println(noOfInstallmentLine);
		        		  System.out.println("Due Amount :- "+arr_installmenAmount[3]);
	        			  if(arr_installmenAmount[3].equals("0.00")) 
	        			  {
	        				  //System.out.println("Invalid installment");
	        				  
	        			  }
	        			  else
	        			  {
	        				  String[] arr_receivedDate =arr_installmenAmount[4].toString().split("/"); //arr_installmenAmount[4] is REC DATE
	        				   
	        		          Calendar calendar = Calendar.getInstance();	        		          
	        		          int todaysDate = calendar.get(Calendar.DAY_OF_MONTH); //get todays date
	        		          
		        			  if (arr_receivedDate[0].trim().equals("07") && todaysDate == 07) //arr_receivedDate[0] is REC DAY
		        			  {
		        				  System.out.println("Received Date :- "+arr_installmenAmount[4]);
		        			  }
		        			  else
		        			  {
			        			  noOfInstallment++;   
		        			  }
		        		}
	        			//noOfInstallment = Integer.parseInt(noOfInstallmentLine.substring(0, 1));
	        		  }
	        	  } 
	        	  while (counter == 1);
	           	  System.out.println("noOfInstallment :- "+noOfInstallment);

	           	  System.out.println("\n\n\n\n\n\n");
           	  }
	          
	          /**fifth condn**/
//	          else if (line.contains("CHEQUE NO")) //1. Get Total Cheque bounced
//	          {
//       			  ArrayList<String> arrlst_chequeBounceYear = new ArrayList<>();;
////	        	  String noOfchequeBounceLine = null;   	  
//	           	  int counter = 0;
//	           	  String noOfchequeBounceLine = reader.readLine();
//
//	           	  /**CHEQUE NO while start**/
//	           	  while (noOfchequeBounceLine.contains("CHEQUE BOUNCED CHARGES"));
//	        	  {
//	           		  
//	           		  if (noOfchequeBounceLine == null || noOfchequeBounceLine == "" || noOfchequeBounceLine.isEmpty() || noOfchequeBounceLine.substring(0, 1).contains("-")) 
//	           		  {							
//		           		  //System.out.println("Null"+noOfchequeBounceLine+"##");
//	           			  continue;
//	           		  }
//	           		  else 
//	           		  {
//	           			  
//	           			  if (noOfchequeBounceLine.contains("FUNDS INSUFFICIENT") == true) 
//	           			  {
//	           				  System.out.println(noOfchequeBounceLine);
//	           				  
//	           				  noOfchequeBounceLine = noOfchequeBounceLine.replaceAll("\\s+", "#");
//	           				  
//	           				  if (noOfchequeBounceLine == null || noOfchequeBounceLine == "" || noOfchequeBounceLine.isEmpty() || noOfchequeBounceLine.substring(0, 1).contains("-")) 
//			           		  {
//	           					  if (noOfchequeBounceLine.contains("For any queries"))break;
//		           			  					
//			           			  continue;
//			           		  }
//	           				  else
//	           				  {
//	           					  String[] arr_chequeBounced =noOfchequeBounceLine.toString().split("#");
//	           					  //System.out.println(arr_chequeBounced[3]);
//	           					  
//	           					  String[] arr_chequeUpdatedDate =arr_chequeBounced[3].toString().split("/");
//	           					  //System.out.println(arr_chequeUpdatedDate[2]);
//	           					  
//	           					  arrlst_chequeBounceYear.add(arr_chequeUpdatedDate[2]);
//	           				  }
//	           				  
//	           				  if (noOfchequeBounceLine.contains("For any queries") || noOfchequeBounceLine.contains("CHEQUE BOUNCED CHARGES")) 
//		           			  {
//		           				  break;
//		           			  }
//			           		  counter++;
//	           			  }
//	           		  }	  
//	           	
//	        	  } 
//	        	  /**CHEQUE NO while ends***/
//	        	  
//       			  System.out.println("Total Cheque Bounced count is :- "+counter);  
//       			  //System.out.println(arrlst_chequeBounceYear);
//       			  
//       			  //Check count of cheque bounce in each year
//       			  countYears_chequeBounce(arrlst_chequeBounceYear);
//       			  System.out.println(chequeBounceRemarks);
//       			  
//       		           			  
//	           	  //break;
//	          }
	          /***fifth else if ends***/
	       
				/** sixth condtion for check bounce start **/
				else if (line.contains("BOUNCED CHEQUES DETAILS")) {
						reader.readLine();
						reader.readLine();
						reader.readLine();
						line = reader.readLine();
						
					while (line.contains("ACH")) {
							String[] checkDetailsLine = line.replaceAll("\\s+", "#").split("#");
							String lastIntr = "";
							
							for(int i=5; i<checkDetailsLine.length; i++) {
								lastIntr = lastIntr +" "+ checkDetailsLine[i];
							}
							checkDetailsLine[5] = lastIntr;
							for(int i=6; i<checkDetailsLine.length; i++) {
								checkDetailsLine[i]="";
							}
							
							String year = checkDetailsLine[1].split("/")[2];
							Integer yearCount = checkBoucedPerYear.get(year) == null ? 0 : checkBoucedPerYear.get(year);
							checkBoucedPerYear.put(year, yearCount + 1);
							String fin = "";
							for(int i=0; i<BOUNCED_CHEQUES_DETAILS_headers.length; i++) {
								fin = fin + BOUNCED_CHEQUES_DETAILS_headers[i]+"="+checkDetailsLine[i]+" ";
							}
							System.out.println(fin);
							
							line = reader.readLine();
						}

					System.out.println(checkBoucedPerYear);
				}
				/** sixth sujit condtion for check bounce ends **/

				/** seventh condtion for mobile number start **/
				else if (line.contains("MOBILE NUMBER")) {
					String mobileNo = line.replaceAll("\\s+", "#").split("#")[4];
					System.out.println("Mobile No:"+mobileNo);
				}
	          /** seventh condtion for mobile no ends **/


		    }
			// main while ends
			
	    } 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		}
	
		
	
	
//	public static ArrayList<String> countYears_chequeBounce(ArrayList<String> list) 
//    { 
//        // hashmap to store the frequency of element 
//        Map<String, Integer> hm = new HashMap<String, Integer>(); 
//  
//        for (String i : list) 
//        { 
//            Integer j = hm.get(i); 
//            hm.put(i, (j == null) ? 1 : j + 1); 
//        } 
//  
//        // displaying the occurrence of elements in the arraylist 
//        for (Map.Entry<String, Integer> val : hm.entrySet()) 
//        { 
//            String data =  val.getValue() + " cheque bounce in "+ val.getKey() + " year";
//            chequeBounceRemarks.add(data);
//        }
//        return chequeBounceRemarks;
//    }
	

}
