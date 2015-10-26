import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

	//public static void main(String args[]){
	void task15(String args[]){
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
		System.out.println("\n  ����� ���������, ������������� ����� ������ � \n"
				+ "������ �������������� ���������� ������ ������: "+sumBetweenPos);
		System.out.println("���������� ������ ���������.");
		}
	
	public static void main(String args[]){
	//UNCOMPLETE
	//void task16(String args[]){
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
		int tempElement = 0;
		for(int i = 0; i < (n+1)/2; i++){ 
			for (int j = i; j < n-i; j++){
				tempElement = matrix[i][j];
				matrix[i][j] = matrix[i][n-j];
				matrix[i][n-j] = matrix[n-i][n-j];
				matrix[n-i][n-j] = matrix[n-i][j];
				matrix[i][n-j] = tempElement;
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
	//void task17()
	//{
	//	
	//}
	
	//public static void main(String args[]){
	void task18(String args[]){
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
		int lMax = Integer.MIN_VALUE;
		ArrayList<Integer> listRow = new ArrayList<Integer>(n);
		ArrayList<Integer> listColumn = new ArrayList<Integer>(n);
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] > lMax){
					listRow.clear();
					listColumn.clear();
					listRow.add(i);
					listColumn.add(j);
					lMax = matrix[i][j];
				}
				if(matrix[i][j] == lMax){
					if(!listRow.contains(i))
						listRow.add(i);
					if(!listColumn.contains(j))
						listColumn.add(j);
				}
			}
		}
		System.out.println("\n������������ �������: "+lMax);
		System.out.print("������, ��� ����������:");
		for(int i = 0; i < listRow.size(); i++)
			System.out.print(listRow.get(i)+" ");
		System.out.println();
		System.out.print("�������, ��� ����������:");
		for(int i = 0; i < listColumn.size(); i++)
			System.out.print(listColumn.get(i)+" ");
		System.out.println();
		int[][] result = new int[n][n];
		System.out.println("\n������� ����������: ");
		int k = 0; 
		int m = 0;
		for(int i = 0; i < n; i++){
			if(!listRow.contains(i)){
				m = 0;
				for(int j = 0; j < n; j++){
					if(!listColumn.contains(j)){
						result[k][m] = matrix[i][j];
						m++;
					}
				}
			k++;
			}
		}
		for(int i = 0; i < n-listRow.size(); i++){
			for(int j = 0; j < n-listColumn.size(); j++)
				System.out.printf("%3s", result[i][j]);
			System.out.println();
		}
        System.out.println("���������� ������ ���������.");
	}

	//public static void main(String args[]){
	void task19(String args[]){
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
		//������� ����, ������ 18 ����
		ArrayList<Integer> listRow = new ArrayList<Integer>(n);
		ArrayList<Integer> listColumn = new ArrayList<Integer>(n);
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] == 0){
					if(!listRow.contains(i))
						listRow.add(i);
					if(!listColumn.contains(j))
						listColumn.add(j);
				}
			}
		}
		System.out.print("\n������, ���������� 0: ");
		for(int i = 0; i < listRow.size(); i++)
			System.out.print(listRow.get(i)+" ");
		System.out.print("\n�������, ���������� 0: ");
		for(int i = 0; i < listColumn.size(); i++)
			System.out.print(listColumn.get(i)+" ");
		if(n-listRow.size() == 0 || n-listColumn.size() == 0){
			System.out.println("����������� ������� - ���������� ����� 0");
		}
		else{
			int[][] result = new int[n-listRow.size()][n-listColumn.size()];
			System.out.println("\n\n������� ����������: ");
			int k = 0; 
			int m = 0;
			for(int i = 0; i < n; i++){
				if(!listRow.contains(i)){
					m = 0;
					for(int j = 0; j < n; j++){
						if(!listColumn.contains(j)){
							result[k][m] = matrix[i][j];
							m++;
						}
					}
				k++;
				}
			}
			for(int i = 0; i < n-listRow.size(); i++){
				for(int j = 0; j < n-listColumn.size(); j++)
					System.out.printf("%3s", result[i][j]);
				System.out.println();
			}
		}
        System.out.println("���������� ������ ���������.");
	}
	
	//public static void main(String args[]){
	//void task20(String args[]){
	//	
	//}
	
	//public static void main(String args[]){
	void task21(String args[]){
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
		int k = 0;
		int temp = 0;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
			{
				if(matrix[i][j] == 0){
					k = n-1; //��������� ������� ������
					if(matrix[i][k] != 0){
						//�����
						for(int ex = j; ex < k; ex++){
							temp = matrix[i][ex];
							matrix[i][ex] = matrix[i][ex+1];
							matrix[i][ex+1] = temp;
						}
					}
					else
						k--;
				}
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
	void task22(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// �������, ��� �������� ������� - �����.
											//� ������ �� ���?
		//�����, ����������� double
		double[][] matrix = new double[n][n];
		System.out.println("�������� �������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = -n + (2*n)*random.nextDouble();
				System.out.printf("%6.2f", matrix[i][j]);
			}
			System.out.println();
		}
		//������
		int[][] result = new int[n][n];
		System.out.println("\n������� ����������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				result[i][j] = (int)Math.round(matrix[i][j]);
				System.out.printf("%3s", result[i][j]);
			}
			System.out.println();
		}
        System.out.println("���������� ������ ���������.");
	}
	
	//public static void main(String args[]){
	void task23(String args[]){
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
		//���, ����������, ����: �������/�������� - ������ ����� ������� � �����
		int[] minRows = new int[n]; //�������� ���� ���������, ��������� � ������
		int[] maxColumns = new int[n]; //�������� ���� ���������, �� �������� � �������
		int minMax = 0; 		//��� ����������� ��������
		//���������� ��������
		for (int i = 0; i < n; i++){
		    minMax = matrix[i][0];
		    for (int j = 1; j < n; j++)
		        if (matrix[i][j] < minMax){ 
		        	minMax= matrix[i][j]; 
		        	}
		    minRows[i] = minMax;    
		}
		//��������� � �������� 
		for (int j = 0; j < n; j++){
		    minMax = matrix[0][j];
		    for (int i = 1; i < n; i++)
		        if (matrix[i][j] > minMax){ 
		        	minMax= matrix[i][j]; 
		        	}
		    maxColumns[j] = minMax;    
		}
		int count = 0; //����� �������� �����
		for (int i = 0; i < n; i++){
		    for (int j = 0; j < n; j++ ){
		        if (matrix[i][j] == minRows[i] && matrix[i][j] == maxColumns[j]){
		            System.out.printf("\n[%s][%s]=%s", i, j, matrix[i][j]);
		            count++;
		        }
		    }
		}
		System.out.println("\n����� �������� �����: "+count);
        System.out.println("���������� ������ ���������.");
	}
	
	//public static void main(String args[]){
	void task24(String args[]){
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
		//���������� ������ ����, ��������
		int[] summary = new int[n];
		for(int i = 0; i < n; i++){
			summary[i] = 0;
			for(int j = 0; j < n; j++){
				summary[i]+=matrix[i][j];
			}
		}
		for(int i = 1; i < n; i++){
            int currString[] = matrix[i].clone(); //������� ���������� clone ��� �������
            int previos = i - 1;
                while(previos >= 0 && summary[previos] > summary[i]){
                	matrix[previos+1] = matrix[previos]; //���������
                	matrix[previos] = currString.clone();
                    previos--;
                }
        }
		System.out.println("\n������� ����������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
        System.out.println("���������� ������ ���������.");
	}
	
	//public static void main(String args[]){
	void task25(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// �������, ��� �������� ������� - �����.
											//� ������ �� ���?
		//��������� ������ �����������
		if(n == Integer.MAX_VALUE){
			System.out.println("������������ �������� �������, �����");
			return;
		}
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
		//��������, ������ ������ � �����
		int[][] result = new int[n+2][n+2];
		for(int i = 0; i < n+2; i++){
			for(int j = 0; j < n+2; j++){
				if(i == 0 || i == n+1 || j == 0 || j == n+1)
					result[i][j] = Integer.MAX_VALUE;
				else
					result[i][j] = matrix[i-1][j-1];
			}
		}
		for(int i = 0; i < n+2; i++){
			for(int j = 0; j < n+2; j++){
				System.out.printf("%3s", result[i][j]);
			}
			System.out.println();
		}
		int count = 0; //����� ���. ���
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j < n+1; j++){
				if(result[i][j] < result[i-1][j-1] &&
						result[i][j] < result[i][j-1] &&
						result[i][j] < result[i-1][j] &&
						result[i][j] < result[i+1][j] &&
						result[i][j] < result[i][j+1] &&
						result[i][j] < result[i+1][j+1] &&
						result[i][j] < result[i+1][j-1] &&
						result[i][j] < result[i-1][j+1]){
					count++;
					System.out.printf("������ ��������� ������� � ����������� "
							+ "[%s][%s]=%s", i-1, j-1, result[i][j]+"\n");
				}
			}
		}
		System.out.println("����� ��������� ���������: "+count);
        System.out.println("���������� ������ ���������.");
	}
		
	//public static void main(String args[]){
	void task26(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// �������, ��� �������� ������� - �����.
											//� ������ �� ���?
		//��������� ������ �����������
		if(n == Integer.MAX_VALUE){
			System.out.println("������������ �������� �������, �����");
			return;
		}
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
		//��������, ������ ������ � �����
		int[][] result = new int[n+2][n+2];
		for(int i = 0; i < n+2; i++){
			for(int j = 0; j < n+2; j++){
				if(i == 0 || i == n+1 || j == 0 || j == n+1)
					result[i][j] = Integer.MAX_VALUE;
				else
					result[i][j] = matrix[i-1][j-1];
			}
		}
		for(int i = 0; i < n+2; i++){
			for(int j = 0; j < n+2; j++){
				System.out.printf("%3s", result[i][j]);
			}
			System.out.println();
		}
		int count = 0; //����� ���. ���
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		for(int i = 1; i < n+1; i++){
			for(int j = 1; j < n+1; j++){
				if(result[i][j] > result[i-1][j-1] &&
						result[i][j] > result[i][j-1] &&
						result[i][j] > result[i-1][j] &&
						result[i][j] > result[i+1][j] &&
						result[i][j] > result[i][j+1] &&
						result[i][j] > result[i+1][j+1] &&
						result[i][j] > result[i+1][j-1] &&
						result[i][j] > result[i-1][j+1]){
					count++;
					list.add(result[i][j]);
					System.out.printf("������ ��������� �������� � ����������� "
							+ "[%s][%s]=%s", i, j, result[i][j]+"\n");
				}
			}
		}
		int lMax = Integer.MIN_VALUE;
		for(int i = 0; i < list.size(); i++){
			if(list.get(i) > lMax)
				lMax = list.get(i);
		}
		System.out.println("����� ��������� ����������: "+count);
		if(list.size() != 0)
			System.out.println("���������� �� ���: "+lMax);
        System.out.println("���������� ������ ���������.");
	}

	//public static void main(String args[]){
	void task27(String args[]){
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
		//������ 24 ����
		int[] summary = new int[n];
		int result[][] = new int[n][n]; //����� ������� ������� = ������
		for(int j = 0; j < n; j++){
			summary[j] = 0;
			for(int i = 0; i < n; i++){
				summary[j]+=Math.abs(matrix[i][j]);
				result[j][i] = matrix[i][j];
			}
		}
		for(int i = 0; i < n; i++){
			System.out.printf("%3s", summary[i]);
		}
		for(int i = 1; i < n; i++){
            int currString[] = result[i].clone(); //������� ���������� clone ��� �������
            int previos = i - 1;
                while(previos >= 0 && summary[previos] > summary[i]){
                	result[previos+1] = result[previos]; //���������
                	result[previos] = currString.clone();
                    previos--;
                }
        }
		//������� = ������, ������ �������
		for(int j = 0; j < n; j++){
			for(int i = 0; i < n; i++){
				matrix[j][i] = result[i][j];
			}
		}
		System.out.println("\n������� ����������: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
        System.out.println("���������� ������ ���������.");
	}
}