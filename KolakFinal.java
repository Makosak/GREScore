import java.util.*;	
import java.io.*;

/* GRE Score Conversion Final Program
By Marynia Kolak
March 10, 2012 */

public class KolakFinal
{
	public static void main(String[]args) throws IOException
	{
    // Create a new file and print the heading to show what data equals.
    PrintWriter outputFile = new
        PrintWriter("GRESCoreStudents.txt");
        outputFile.print("Last Name, First Name, Date Taken, ");
        outputFile.print("V Prior, V Current, V %Rank");
        outputFile.println(", Q Prior, Q Current, Q %Rank");
        outputFile.close();
        
    
        if (Welcome()== true)
            
        {
            int number;     //Loop control variable
            int studentNumber;   // Max records to collect
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the number of students. ");
            studentNumber = scan.nextInt();
            
            for (number = 1; number <= studentNumber; number++)
            {
                //Get the name of the student.
                student();
             
                //Using appropriate scoring method, write both score to file.
                if (dateTaken()== true)
                {
                    VerbaltoPrior();
                    QuanttoPrior();
                }
                else
                {
                    VerbaltoCurrent();
                    QuanttoCurrent();
                }
                
            }
        }
        
        else
        {
            int input = 0;
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter '1' to quit. ");
            System.out.print("Enter '2' to continue: ");
            input = scan.nextInt();
            
            while (input !=1)
            {
                //Get the name of the student.
                student();
                
                //Using appropriate scoring method, write both scores to file.
                if (dateTaken()== true)
                {
                    VerbaltoPrior();
                    QuanttoPrior();
                }
                else
                {
                    VerbaltoCurrent();
                    QuanttoCurrent();
                }
                
                System.out.print("Enter '1' to quit. ");
                System.out.print("Enter '2' to continue: ");
                input = scan.nextInt();
            
        }
        }
    }
    

    /////////////////////////////////////////////////////////////////////////////////////
    
    //This Welcome() method introduces the program to the user.
    //@prompt Asks user how many students they have to enter.
    //@return Boolean that indicates the user knows the number of records to enter, or not.
    
    public static boolean Welcome() throws IOException
    {
        Scanner scan = new Scanner(System.in);
        int decision = 0;
        boolean bool = false;
        
        //Print welcome to user.
        System.out.println("Welcome to the GRE Conversion Program.");
        System.out.println("Scores will be convered according to ");
        System.out.println("concordance tables provided by ETS in 2011. ");
        System.out.println(" ");
        System.out.println("GREs taken before August 1, 2011 are scored ");
        System.out.println("using the prior format, and GREs taken after ");
        System.out.println("are scored using the current format. ");
        System.out.println(" ");
        System.out.println("Date will be stored in a file entitled ");
        System.out.println("'GREScoreStudents.txt'. ");
        
        System.out.println(" ");
        System.out.println("Do you know how many students you have to enter? ");
        System.out.println("Press 1 for Yes, or 2 for No. ");
        decision = scan.nextInt();
        
        if ((decision == 1))
            bool = true;
        
        return bool;
    }
    
    
	
////////////////////////////////////////////////////////////////////////////////


	//   This student method gets the name of student; writes it to file.
    // @prompt User enters name
    // @returns Full Student Name

	public static String student() throws IOException
	{
		
	Scanner scan = new Scanner(System.in);	
	System.out.println("Please enter the student's last name:");
	String studentLast = scan.nextLine();
	System.out.println("Please enter the student's first name");
	String studentFirst = scan.nextLine();
	
	String studentFullName = studentLast + ", " +studentFirst;
	
	//Print information to file
	FileWriter fwriter = new FileWriter("GREScoreStudents.txt", true);
	PrintWriter outputFile = new PrintWriter(fwriter);
	outputFile.print(studentFullName + ", ");
	outputFile.close();
	
	//DEBUG
	//System.out.print(studentFullName);
	
	return studentFullName;
	}


////////////////////////////////////////////////////////////////////////////////

	
	// The greDate method prompts the user to enter the date the 
	//student took the GRE. 
	//@return bool -> true = Scores are in Current Scale
	// 		> false = Scores are in Prior Scale.
	
	
	public static boolean dateTaken() throws IOException
	{
	  Scanner scan = new Scanner(System.in);
  	  int month, day, year;
  	  
  	  System.out.println("Please enter the month MM: ");
  	  month = scan.nextInt();
  	  System.out.println("Please enter the day DD: ");
  	  day = scan.nextInt();
  	  System.out.println("Please enter a year YYYY: ");
  	  year=scan.nextInt();
  	  System.out.println("You chose: " + month +" " + day + " "+ year);
  	 
  	//Convert numbers to text.
	String greYear =  " ";
	String greMonth = " ";
	String greDay = " ";
	
	greYear = Integer.toString(year);
	greMonth = Integer.toString(month);
	greDay = Integer.toString(day);
	
	String greDate = greMonth + "/" + greDay + "/" + greYear;
	
	//Print information to file
	FileWriter fwriter = new FileWriter("GREScoreStudents.txt", true);
	PrintWriter outputFile = new PrintWriter(fwriter);
	outputFile.print(greDate + ", ");
	outputFile.close();
	
	System.out.println("You entered " + greDate ); 
  	  
 	//If GRE taken after 8/2011, score will be on Current Scale (=true).
 	boolean bool = false;
	if ((year == 2011) && (month >= 8))
	{	//DEBUG
		//System.out.println("true");
		bool = true;
	}
	else if (year >2011)
		bool = true;
		
	return bool;
  }
  
////////////////////////////////////////////////////////////////////////////////
  
  	//The VerbaltoPrior method converts scores in Current Scale to Prior.
  	//@return The score using the prior scale.
  
  
    public static int VerbaltoPrior() throws IOException
  {
	int priorVerbal=0, currentVerbal=0, percentilRank=0;
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Please enter the Verbal score: ");
	currentVerbal = scan.nextInt();	
	
	switch (currentVerbal)
	{
	case 170:
		priorVerbal = 800;
		percentilRank = 99;
		break;
	case 169:
		priorVerbal = 750;
		percentilRank = 99;
		break;
	case 168:
		priorVerbal = 730;
		percentilRank = 98;
		break;
	case 167:
		priorVerbal = 710;
		percentilRank = 98;
		break;
	case 166:
		priorVerbal = 700;
		percentilRank = 97;
		break;
	case 165:
		priorVerbal = 690;
		percentilRank = 96;
		break;
	case 164:
		priorVerbal = 670;
		percentilRank = 94;
		break;
	case 163:
		priorVerbal = 650;
		percentilRank = 93;
		break;
	case 162:
		priorVerbal = 640;
		percentilRank = 90;
		break;
	case 161:
		priorVerbal = 620;
		percentilRank = 89;
		break;
	case 160:
		priorVerbal = 610;
		percentilRank = 86;
		break;
	case 159:
		priorVerbal = 590;
		percentilRank = 84;
		break;
	case 158:
		priorVerbal = 580;
		percentilRank = 79;
		break;
	case 157:
		priorVerbal = 560;
		percentilRank = 77;
		break;
	case 156:
		priorVerbal = 550;
		percentilRank = 72;
		break;
	case 155:
		priorVerbal = 530;
		percentilRank = 69;
		break;
	case 154:
		priorVerbal = 520;
		percentilRank = 64;
		break;
	case 153:
		priorVerbal = 500;
		percentilRank = 62;
		break;
	case 152:
		priorVerbal = 490;
		percentilRank = 56;
		break;
	case 151:
		priorVerbal = 470;
		percentilRank = 51;
		break;
	case 150:
		priorVerbal = 450;
		percentilRank = 48;
		break;
	case 149:
		priorVerbal = 440;
		percentilRank = 42;
		break;
	case 148:
		priorVerbal = 420;
		percentilRank = 40;
		break;
	case 147:
		priorVerbal = 410;
		percentilRank = 36;
		break;
	case 146:
		priorVerbal = 400;
		percentilRank = 31;
		break;
	case 145:
		priorVerbal = 380;
		percentilRank = 28;
		break;
	case 144:
		priorVerbal = 370;
		percentilRank = 26;
		break;
	case 143:
		priorVerbal = 360;
		percentilRank = 21;
		break;
	case 142:
		priorVerbal = 340;
		percentilRank = 18;
		break;
	case 141:
		priorVerbal = 330;
		percentilRank = 16;
		break;
	case 140:
		priorVerbal = 320;
		percentilRank = 13;
		break;
	case 139:
		priorVerbal = 310;
		percentilRank = 10;
		break;
	case 138:
		priorVerbal = 300;
		percentilRank = 8;
		break;
	case 137:
		priorVerbal = 290;
		percentilRank = 6;
		break;
	case 135:
		priorVerbal = 280;
		percentilRank = 4;
		break;
	case 134:
		priorVerbal = 270;
		percentilRank = 3;
		break;		
	case 133:
		priorVerbal = 260;
		percentilRank = 2;
		break;	
	case 132:
		priorVerbal = 250;
		percentilRank = 1;
		break;
	case 131:
		priorVerbal = 240;
		percentilRank = 1;
		break;	
	case 130:
		priorVerbal = 230;
		percentilRank = 1;
		break;	
	default:
		System.out.print("The number you entered is invalid. ");
		System.out.println("Please enter a number between 130 and 170.");
		System.exit(0);
	}
	
	//Print information to file
	FileWriter fwriter = new FileWriter("GREScoreStudents.txt", true);
	PrintWriter outputFile = new PrintWriter(fwriter);
	outputFile.print(priorVerbal + ", ");
	outputFile.print(currentVerbal + ", ");
	outputFile.close();
	
	System.out.print("The verbal score is " );
	System.out.print( + currentVerbal + " in the current scale and ");
	System.out.print( + priorVerbal + " in the prior scale. ");
	System.out.println("The percentile ranking is " + percentilRank+ ".");
	
	return priorVerbal;
  }
	
////////////////////////////////////////////////////////////////////////////////
  
    	//The QuanttoPrior method converts scores in Current Scale to Prior.
  	//@return The score using the prior scale.
  	
  public static int  QuanttoPrior() throws IOException
  {
	int priorQuant=0, currentQuant=0, percentilRank=0;
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Please enter the quantitative score: ");
	currentQuant = scan.nextInt();	
	
	switch (currentQuant)
	{
	case 166:
		priorQuant = 800;
		percentilRank = 94;
		break;
	case 164:
		priorQuant = 790;
		percentilRank = 91;
		break;
	case 163:
		priorQuant = 780;
		percentilRank = 88;
		break;
	case 161:
		priorQuant = 770;
		percentilRank = 86;
		break;
	case 160:
		priorQuant = 760;
		percentilRank = 84;
		break;
	case 159:
		priorQuant = 750;
		percentilRank = 82;
		break;
	case 158:
		priorQuant = 740;
		percentilRank = 79;
		break;
	case 157:
		priorQuant = 730;
		percentilRank = 77;
		break;
	case 156:
		priorQuant = 720;
		percentilRank = 74;
		break;
	case 155:
		priorQuant = 710;
		percentilRank = 69;
		break;
	case 154:
		priorQuant = 690;
		percentilRank = 67;
		break;
	case 153:
		priorQuant = 680;
		percentilRank = 65;
		break;
	case 152:
		priorQuant = 670;
		percentilRank = 61;
		break;
	case 151:
		priorQuant = 650;
		percentilRank = 56;
		break;
	case 150:
		priorQuant = 630;
		percentilRank = 53;
		break;
	case 149:
		priorQuant = 620;
		percentilRank = 49;
		break;
	case 148:
		priorQuant = 600;
		percentilRank = 44;
		break;
	case 147:
		priorQuant = 580;
		percentilRank = 40;
		break;
	case 146:
		priorQuant = 560;
		percentilRank = 36;
		break;
	case 145:
		priorQuant = 540;
		percentilRank = 32;
		break;
	case 144:
		priorQuant = 520;
		percentilRank = 26;
		break;
	case 143:
		priorQuant = 490;
		percentilRank = 22;
		break;
	case 142:
		priorQuant = 470;
		percentilRank = 19;
		break;
	case 141:
		priorQuant = 450;
		percentilRank = 16;
		break;
	case 140:
		priorQuant = 420;
		percentilRank = 12;
		break;
	case 139:
		priorQuant = 390;
		percentilRank = 10;
		break;
	case 138:
		priorQuant = 370;
		percentilRank = 7;
		break;
	case 137:
		priorQuant = 340;
		percentilRank = 6;
		break;
	case 136:
		priorQuant = 320;
		percentilRank = 4;
		break;
	case 135:
		priorQuant = 290;
		percentilRank = 3;
		break;
	case 134:
		priorQuant = 270;
		percentilRank = 2;
		break;
	case 133:
		priorQuant = 250;
		percentilRank = 1;
		break;
	case 132:
		priorQuant = 230;
		percentilRank = 1;
		break;
	case 131:
		priorQuant = 210;
		percentilRank = 1;
		break;
	default:
		System.out.print("The number you entered is invalid. ");
		System.out.println("Please enter a number between 131 and 166.");
		System.exit(0);
	}
	
	//Print information to file
	FileWriter fwriter = new FileWriter("GREScoreStudents.txt", true);
	PrintWriter outputFile = new PrintWriter(fwriter);
	outputFile.print(priorQuant + ", ");
	outputFile.println(currentQuant);
	outputFile.close();
	
	System.out.print("The quantitative score is " );
	System.out.print( + currentQuant + " in the current scale and ");
	System.out.print( + priorQuant + " in the prior scale. ");
	System.out.println("The percentile ranking is " + percentilRank + ". ");
	
	return priorQuant;
  }
////////////////////////////////////////////////////////////////////////////////

  	//The VerbaltoCurrent method converts scores in Prior Scale to Current.
  	//@return The score using the current score.
  
  
    public static int VerbaltoCurrent() throws IOException
  {
	int priorVerbal=0, currentVerbal=0, percentilRank=0;
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Please enter the Verbal score: ");
	priorVerbal = scan.nextInt();	
	
	switch (priorVerbal)
	{
	case 800:
	case 790:
	case 780:
	case 770:
	case 760:
		currentVerbal = 170;
		percentilRank = 99;
		break;
	case 750:
	case 740:
		currentVerbal = 169;
		percentilRank = 99;
		break;
	case 730:
	case 720:
		currentVerbal = 168;
		percentilRank = 98;
		break;
	case 710:
		currentVerbal = 167;
		percentilRank = 98;
		break;
	case 700:
		currentVerbal = 166;
		percentilRank = 97;
		break;
	case 690:
	case 680:
		currentVerbal = 165;
		percentilRank = 96;
		break;
	case 670:
	case 660:
		currentVerbal = 164;
		percentilRank = 94;
		break;
	case 650:
		currentVerbal = 163;
		percentilRank = 93;
		break;
	case 640:
	case 630:
		currentVerbal = 162;
		percentilRank = 90;
		break;
	case 620:
		currentVerbal = 161;
		percentilRank = 89;
		break;
	case 610:
	case 600:
		currentVerbal = 160;
		percentilRank = 86;
		break;
	case 590:
		currentVerbal = 159;
		percentilRank = 84;
		break;
	case 580:
	case 570:
		currentVerbal = 158;
		percentilRank = 79;
		break;
	case 560:
		currentVerbal = 157;
		percentilRank = 77;
		break;
	case 550:
	case 540:
		currentVerbal = 156;
		percentilRank = 72;
		break;
	case 530:
		currentVerbal = 155;
		percentilRank = 69;
		break;
	case 520:
	case 510:
		currentVerbal = 154;
		percentilRank = 64;
		break;
	case 500:
		currentVerbal = 153;
		percentilRank = 62;
		break;
	case 490:
	case 480:
		currentVerbal = 152;
		percentilRank = 56;
		break;
	case 470:
	case 460:
		currentVerbal = 151;
		percentilRank = 51;
		break;
	case 450:
		currentVerbal = 150;
		percentilRank = 48;
		break;
	case 440:
	case 430:
		currentVerbal = 149;
		percentilRank = 42;
		break;
	case 420:
		currentVerbal = 148;
		percentilRank = 40;
		break;
	case 410:
		currentVerbal = 147;
		percentilRank = 36;
		break;
	case 400:
	case 390:
		currentVerbal = 146;
		percentilRank = 31;
		break;
	case 380:
		currentVerbal = 145;
		percentilRank = 28;
		break;
	case 370:
		currentVerbal = 144;
		percentilRank = 26;
		break;
	case 360:
	case 350:
		currentVerbal = 143;
		percentilRank = 21;
		break;
	case 340:
		currentVerbal = 142;
		percentilRank = 18;
		break;
	case 330:
		currentVerbal = 141;
		percentilRank = 16;
		break;
	case 320:
		currentVerbal = 140;
		percentilRank = 13;
		break;
	case 310:
		currentVerbal = 139;
		percentilRank = 10;
		break;
	case 300:
		currentVerbal = 138;
		percentilRank = 8;
		break;
	case 290:
		currentVerbal = 137;
		percentilRank = 6;
		break;
	case 280:
		currentVerbal = 135;
		percentilRank = 4;
		break;
	case 270:
		currentVerbal = 134;
		percentilRank = 3;
		break;		
	case 260:
		currentVerbal = 133;
		percentilRank = 2;
		break;	
	case 250:
		currentVerbal = 132;
		percentilRank = 1;
		break;
	case 240:
		currentVerbal = 131;
		percentilRank = 1;
		break;	
	case 230:
	case 220:
	case 210:
	case 200:
		currentVerbal = 130;
		percentilRank = 1;
		break;	
	default:
		System.out.print("The number you entered is invalid.");
		System.out.println("Please enter a number between 200 and 800.");
		System.exit(0);
	}
	
	//Print information to file
	FileWriter fwriter = new FileWriter("GREScoreStudents.txt", true);
	PrintWriter outputFile = new PrintWriter(fwriter);
	outputFile.print(priorVerbal + ", ");
	outputFile.print(currentVerbal + ", ");
	outputFile.close();
	
	System.out.print("The verbal score is " );
	System.out.print( + currentVerbal + " in the current scale and ");
	System.out.print( + priorVerbal + " in the prior scale. ");
	System.out.println("The percentile ranking is " + percentilRank+ ".");
	
	return currentVerbal;
  }
	

////////////////////////////////////////////////////////////////////////////////


  	//The QuanttoCurrent method converts scores in Prior Scale to Current.
  	//@return The score using the current score.
  	
  public static int QuanttoCurrent() throws IOException
  {
	int priorQuant=0, currentQuant=0, percentilRank=0;
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Please enter the quantitative score: ");
	priorQuant = scan.nextInt();	
	
	switch (priorQuant)
	{
	case 800:
		currentQuant = 166;
		percentilRank = 94;
		break;
	case 790:
		currentQuant = 164;
		percentilRank = 91;
		break;
	case 780:
		currentQuant = 163;
		percentilRank = 88;
		break;
	case 770:
		currentQuant = 161;
		percentilRank = 86;
		break;
	case 760:
		currentQuant = 160;
		percentilRank = 84;
		break;
	case 750:
		currentQuant = 159;
		percentilRank = 82;
		break;
	case 740:
		currentQuant = 158;
		percentilRank = 79;
		break;
	case 730:
		currentQuant = 157;
		percentilRank = 77;
		break;
	case 720:
		currentQuant = 156;
		percentilRank = 74;
		break;
	case 710:
	case 700:
		currentQuant = 155;
		percentilRank = 69;
		break;
	case 690:
		currentQuant = 154;
		percentilRank = 67;
		break;
	case 680:
		currentQuant = 153;
		percentilRank = 65;
		break;
	case 670:
	case 660:
		currentQuant = 152;
		percentilRank = 61;
		break;
	case 650:
	case 640:
		currentQuant = 151;
		percentilRank = 56;
		break;
	case 630:
		currentQuant = 150;
		percentilRank = 53;
		break;
	case 620:
	case 610:
		currentQuant = 149;
		percentilRank = 49;
		break;
	case 600:
	case 590:
		currentQuant = 148;
		percentilRank = 44;
		break;
	case 580:
	case 570:
		currentQuant = 147;
		percentilRank = 40;
		break;
	case 560:
	case 550:
		currentQuant = 146;
		percentilRank = 36;
		break;
	case 540:
	case 530:
		currentQuant = 145;
		percentilRank = 32;
		break;
	case 520:
	case 510:
	case 500:
		currentQuant = 144;
		percentilRank = 26;
		break;
	case 490:
	case 480:
		currentQuant = 143;
		percentilRank = 22;
		break;
	case 470:
	case 460:
		currentQuant = 142;
		percentilRank = 19;
		break;
	case 450:
	case 440:
	case 430:
		currentQuant = 141;
		percentilRank = 16;
		break;
	case 420:
	case 410:
	case 400:
		currentQuant = 140;
		percentilRank = 12;
		break;
	case 390:
	case 380:
		currentQuant = 139;
		percentilRank = 10;
		break;
	case 370:
	case 360:
	case 350:
		currentQuant = 138;
		percentilRank = 7;
		break;
	case 340:
	case 330:
		currentQuant = 137;
		percentilRank = 6;
		break;
	case 320:
	case 310:
	case 300:
		currentQuant = 136;
		percentilRank = 4;
		break;
	case 290:
	case 280:
		currentQuant = 135;
		percentilRank = 3;
		break;
	case 270:
	case 260:
		currentQuant = 134;
		percentilRank = 2;
		break;
	case 250:
	case 240:
		currentQuant = 133;
		percentilRank = 1;
		break;
	case 230:
	case 220:
		currentQuant = 132;
		percentilRank = 1;
		break;
	case 210:
	case 200:
		currentQuant = 131;
		percentilRank = 1;
		break;
	default:
		System.out.print("The number you entered is invalid. ");
		System.out.println("Please enter a number between 200 and 800.");
		System.exit(0);
	}
	
	//Print information to file
	FileWriter fwriter = new FileWriter("GREScoreStudents.txt", true);
	PrintWriter outputFile = new PrintWriter(fwriter);
	outputFile.print(priorQuant + ", ");
	outputFile.println(currentQuant);
	outputFile.close();
	
	System.out.print("The quantitative score is " );
	System.out.print( + currentQuant + " in the current scale and ");
	System.out.print( + priorQuant + " in the prior scale. ");
	System.out.println("The percentile ranking is " + percentilRank + ". ");
	
	return currentQuant;
  }

////////////////////////////////////////////////////////////////////////////////

	
}
