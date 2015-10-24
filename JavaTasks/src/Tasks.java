import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Month;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tasks {
	//public static void main(String arg[]){
	void task1(){
	System.out.print("������� ���������� �����: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        try(BufferedReader br = new BufferedReader(
        		new InputStreamReader(System.in))){
            String[] str = new String[n];
        	int lMin = Integer.MAX_VALUE;
        	int lMax = -1;
            for(int i = 0; i < n; i++){
        		str[i] = br.readLine();
        		int currentLenght = str[i].length();
        		if(currentLenght < lMin)
        			lMin = currentLenght;
        		if(currentLenght > lMax)
        			lMax = currentLenght;
        	}
            System.out.println("����������� ����� ������: "+lMin+"\n������������ ����� ������: "+lMax);
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        s.close();
        System.out.println("���������� ������ ���������.");
	}
	
	//public static void main(String arg[]){
	void task2(){
		System.out.print("������� ���������� �����: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        try(BufferedReader br = new BufferedReader(
        		new InputStreamReader(System.in))){
        	String[] str = new String[n];
            for(int i = 0; i < n; i++){
        		str[i] = br.readLine();
        	}
            //����� � n2, ���� ��� �������. ��� n < 10 ����� � ������ ������
            for(int i = 1; i < n; i++){
                String currString = str[i];
                int previos = i - 1;
                    while(previos >= 0 && str[previos].length() > currString.length()){
                        str[previos+1] = str[previos]; //���������
                        str[previos] = currString;
                        previos--;
                    }
            }
            System.out.println("������ �����������:");
            for(int i = 0; i < n; i++){
            	 System.out.println(str[i]);
        	}
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        s.close();
        System.out.println("���������� ������ ���������.");
	}

	//public static void main(String arg[]){
	void task3(){
		System.out.print("������� ���������� �����: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        try(BufferedReader br = new BufferedReader(
        		new InputStreamReader(System.in))){
        	String[] str = new String[n];
            int sumLenght = 0;
        	for(int i = 0; i < n; i++){
        		str[i] = br.readLine();
        		sumLenght+=str[i].length();
            }
            double avgLenght = sumLenght/n; //�������
            System.out.println("������� ����� ������: "+avgLenght);
            System.out.println("����� ���������� �����: ");
            for(int i = 0; i < n; i++){
            	if(str[i].length() < avgLenght)
            		System.out.println("������ "+i+": "+str[i]+" , ������ "+str[i].length());
            }
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        s.close();
        System.out.println("���������� ������ ���������.");
	}

	//public static void main(String arg[]){
	void task4(){
		System.out.print("������� ���������� ����: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("����� ����������� ��� ���������, ��� � ��������� �������� ������.\n������� "+n+" ����(�): ");
        String[] str = new String[n];
        //����� - ��� �� 1�� ������� ��� \n
        int i = 0;
        while (i < n){
        	if(s.hasNext())
        		str[i++] = s.next();
	    }
        System.out.print("������� �����: ");
        for(String element : str)		//������� ������ for
        	System.out.println(element);
        int resultIndex = 0;
        int lMin = Integer.MAX_VALUE; 
        for(i = 0; i < n; i++){
        	String currentStr = str[i];
        	int numberOfUnique = 0; //����� ���������� �������� � ���
        	for(int j = 0; j < currentStr.length();){
        		currentStr = currentStr.replaceAll(""+currentStr.charAt(j), "");
        		numberOfUnique++;
        	}
        	if(numberOfUnique < lMin)
        	{
        		resultIndex = i;
        		lMin = numberOfUnique;
        	}
        }
        System.out.println("����� � ����������� ����������� ��������� ��������: "+str[resultIndex]+
        		", ����� ��������� ��������: "+lMin);
        s.close();
        System.out.println("���������� ������ ���������.");
	}

	//public static void main(String arg[]){
	void task5(){
		System.out.print("������� ���������� ����: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("����� ����������� ��� ���������, ��� � ��������� �������� ������.\n������� "+n+" ����(�): ");
        String[] str = new String[n];
        //����� - ��� �� 1�� ������� ��� \n
        int i = 0;
        while (i < n){
        	if(s.hasNext())
        		str[i++] = s.next();
	    }
        System.out.print("������� �����: \n");
        for(String element : str)		//������� ������ for
        	System.out.println(element);
        //������� Pattern � Matcher, ����� ���.
        Pattern p = Pattern.compile("[a-zA-z]+");
        ArrayList<String> list = new ArrayList<String>();
        for(i = 0; i < n; i++){
        	//��� ������ ������
        	Matcher m = p.matcher(str[i]);
        	if(m.matches())
        		list.add(str[i]);
        }
        System.out.print("������� �����, ���������� ������ ��������� �����:\n");
        for(i = 0;i < list.size(); i++)
        	System.out.println(list.get(i));
        System.out.print("����� ��� �����, ���������� ������ ����� ��������� � �������:\n");
        for(i = 0; i < list.size(); i++){
        	int notVowel = list.get(i).replaceAll("[^aAoOiIuUyYeE]", "").length();
        	int vovel = list.get(i).replaceAll("[aAoOiIuUyYeE]", "").length();
        	if(vovel == notVowel)
        		System.out.println(list.get(i));
        }
        s.close();
        System.out.println("���������� ������ ���������.");
	}
	
	//public static void main(String arg[]){
	void task6(){
			System.out.print("������� ���������� ����: ");
			Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        System.out.println("����� ����������� ��� ���������, ��� � ��������� �������� ������.\n������� "+n+" ����(�): ");
	        String[] str = new String[n];
	        //����� - ��� �� 1�� ������� ��� \n
	        int i = 0;
	        while (i < n){
	        	if(s.hasNext())
	        		str[i++] = s.next();
		    }
	        System.out.print("������� �����: \n");
	        for(String element : str)		//������� ������ for
	        	System.out.println(element);
	        //getBytes()
	        for(i = 0; i < n; i++){
	        	byte bb[] = str[i].getBytes();
	        	boolean wordState = true; //����� - ��������
	        	for(int j = 1; j < bb.length && wordState != false; j++){
	        		if(bb[j]<=bb[j-1])
	        			wordState = false;	//� ������ ���.
	        	}
	        	if(wordState){
	        		System.out.println("������ �����, � ������� ��� ���� �������� ���� � "+
	        							"������� ������� �����������: "+str[i]);
	        		break;
	        	}
	        	if(!wordState && i == n-1)
	        		System.out.println("��� ����, ��������������� �������.");
	        }
	        s.close();
	        System.out.println("���������� ������ ���������.");
		}

	//public static void main(String arg[]){
	void task7(){
		System.out.print("������� ���������� ����: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("����� ����������� ��� ���������, ��� � ��������� �������� ������.\n������� "+n+" ����(�): ");
        String[] str = new String[n];
        //����� - ��� �� 1�� ������� ��� \n
        int i = 0;
        while (i < n){
        	if(s.hasNext())
        		str[i++] = s.next();
	    }
        System.out.print("������� �����: \n");
        for(String element : str)		//������� ������ for
        	System.out.println(element);
        //�������� �� �����, ��� ��� ����� 4 ���� � �������������
        boolean haveAWord = false; //����� - ���
        for(i = 0; i < n && !haveAWord; i++){
        	String currentStr = str[i];
        	int numberOfUnique = 0; //����� ���������� �������� � ���
        	for(int j = 0; j < currentStr.length();){
        		currentStr = currentStr.replaceAll(""+currentStr.charAt(j), "");
        		numberOfUnique++;
        	}
        	if(numberOfUnique == str[i].length())
        	{
                System.out.println("������ �����, � ������� ��� ������� ��������: "+str[i]);
                haveAWord = true;
        	}
        }
        if(!haveAWord)
        	System.out.println("��� �����, ���������������� �������.");
        s.close();
        System.out.println("���������� ������ ���������.");
	}
	
	//public static void main(String arg[]){
	void task8(){
		System.out.print("������� ���������� ����: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("����� ����������� ��� ���������, ��� � ��������� �������� ������.\n������� "+n+" ����(�): ");
        String[] str = new String[n];
        //����� - ��� �� 1�� ������� ��� \n
        int i = 0;
        while (i < n){
        	if(s.hasNext())
        		str[i++] = s.next();
	    }
        System.out.print("������� �����: \n");
        for(String element : str)		//������� ������ for
        	System.out.println(element);
        //�������� �� �����, ��� ��� ����� 5 ���� � �������������
        Pattern p = Pattern.compile("[0-9]+");
        ArrayList<String> list = new ArrayList<String>();
        for(i = 0; i < n; i++){
        	//��� ������ ������
        	Matcher m = p.matcher(str[i]);
        	if(m.matches())
        		list.add(str[i]);
        }
        System.out.print("������� �����, ���������� ������ �����:\n");
        for(i = 0;i < list.size(); i++)
        	System.out.println(list.get(i));
        //������. ������� � �������.
        ArrayList<String> listOfPaly = new ArrayList<String>();
        for(i = 0; i < list.size(); i++){
        	String reverseString = new StringBuilder(list.get(i)).reverse().toString();
        	if(list.get(i).equals(reverseString)){
        		listOfPaly.add(list.get(i));
        		if(listOfPaly.size()==2)
        			break;
        	}
        }
        if(listOfPaly.size() == 0)
        	System.out.println("��� �����, ���������������� �������.");
        else
        	if(listOfPaly.size() == 1)
        		System.out.println("������ � ������������ �����-���������: "+listOfPaly.get(0));
        	else
        		System.out.println("������ �����-���������: "+listOfPaly.get(1));
        s.close();
        System.out.println("���������� ������ ���������.");
	}

	//public static void main(String arg[]){
	void task9(){
		int k = 1;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++)
				System.out.printf("%3s"+" |", k++);
			System.out.print("\n-------------------------\n");
		}
        System.out.println("���������� ������ ���������.");
	}
	
	//����� ��� ��� �����-�����, ���� ����� http://ithappens.me/story/10776
	//�� ������� � �����, ������ ����������� ���������
	//void task10()
	//{
	//	
	//}
	
	//public static void main(String arg[]){
	void task11(){ //11 ������� ��� ������, ������� 12. watta?
		Scanner s = new Scanner(System.in);
        //������ ��� ������� �� ������������ �����.
        int n = 0;
		while(true){
        	System.out.print("������� ����� ������ (1-12): ");
        	try {
                 n = Integer.parseInt(s.next());
                 if(n > 12 || n < 1)
                	 throw new NumberFormatException();
                 else
                	 break;
            } catch (NumberFormatException e) {
            	System.out.println("��������� ����. ���������� ������ ����� �� 1 �� 12");
            }
		}
		//����?? ��������? 
        //System.out.println(Month.of(n)); //���� ������!
		switch(n){
		case 1:
			System.out.println("������");
			break;
		case 2:
			System.out.println("�������");
			break;
		case 3:
			System.out.println("����");
			break;
		case 4:
			System.out.println("������");
			break;
		case 5:
			System.out.println("���");
			break;
		case 6:
			System.out.println("����");
			break;
		case 7:
			System.out.println("����");
			break;
		case 8:
			System.out.println("������");
			break;
		case 9:
			System.out.println("��������");
			break;
		case 10:
			System.out.println("�������");
			break;
		case 11:
			System.out.println("������");
			break;
		case 12:
			System.out.println("�������");
			break;
			
		}
		s.close();
		System.out.println("���������� ������ ���������.");
	}

	//public static void main(String args[]){
	void task12(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// �������, ��� �������� ������� - �����.
		int k = Integer.parseInt(args[1]);// �������, ��� �������� ������� - �����.
		k--;									//� ������ �� ���?
		int[][] matrix = new int[n][n];
		System.out.println("�������� �������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = random.nextInt(2*n)-n;
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
		//������
		for(int i = 1; i < n; i++){
			int line[] = matrix[i];
            int previos = i - 1;
                while(previos >= 0 && matrix[previos][k] > line[k]){
                    matrix[previos+1] = matrix[previos]; //���������
                    matrix[previos] = line;
                    previos--;
                }
        }
		System.out.println("\n������� ����������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.printf("%3s", matrix[i][j]);
			System.out.println();
		}
        System.out.println("���������� ������ ���������.");
	}
	
	//public static void main(String args[]){
	void task13(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// �������, ��� �������� ������� - �����.
		int k = Integer.parseInt(args[1]);// �������, ��� �������� ���������� ������� - �����.
		k--;									//� ������ �� ���?
		int[][] matrix = new int[n][n];
		System.out.println("�������� �������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = random.nextInt(2*n)-n;
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
		//������
		int result[][] = new int[n][n];//�������������� N*N
		for(int i = 0; i < n; i++){
			result[(i+k+1)%n] = matrix[i];
        }
		System.out.println("\n������� ����������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.printf("%3s", result[i][j]);
			System.out.println();
		}
        System.out.println("���������� ������ ���������.");
	}
	
	
	//public static void main(String args[]){
	void task14(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// �������, ��� �������� ������� - �����.
											//� ������ �� ���?
		int[][] matrix = new int[n][n];
		System.out.println("�������� �������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = random.nextInt(2*n)-n;
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
		//������
		int currentResult = 1;
		int maxResult = 1;
		for(int i = 1; i < n*n; i++){
			//System.out.println(matrix[(i-1)/n][(i-1)%n]);
			//����������� �� ������� ��� �� ������, ��������
			if(matrix[(i-1)/n][(i-1)%n] < matrix[i/n][i%n]){
				currentResult++;
			}
			else{
				if(currentResult > maxResult){
					//System.out.println(i); //��� ������������
					maxResult = currentResult;
				}
				currentResult = 1;
			}
		}
		if(currentResult > maxResult) //��������� �������� ��������.
			maxResult = currentResult;
		System.out.println("\n���������� ����� ������������ ��������� �������, ������ ������: "+maxResult);
		System.out.println("���������� ������ ���������.");
		}

	public static void main(String args[]){
	//void task15(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// �������, ��� �������� ������� - �����.
											//� ������ �� ���?
		int[][] matrix = new int[n][n];
		System.out.println("�������� �������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = random.nextInt(2*n)-n;
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
		//������
		int sumBetweenPos = 0;
		boolean sumFlag = false; //����� ����, �� ��� ���� ������������ :(
		for(int i = 0; i < n; i++){
			sumFlag = false;
			for(int j = 0; j < n; j++){
				if(matrix[i][j] > 0)
					if(!sumFlag)
						sumFlag = true;
					else
						break; //����� ������ ���� � ������ ������ �� �� �������.
				
				else
					if(sumFlag)
						sumBetweenPos+=matrix[i][j];
					
			}
		}
		if(sumBetweenPos == 0)System.out.println("\n  ����� ���������, ������������� ����� ������ � \n"
				+ "������ �������������� ���������� ������ ������: "+sumBetweenPos);
		else
			System.out.println("��� ���������, ��������������� �������.");
		System.out.println("���������� ������ ���������.");
		}
}
