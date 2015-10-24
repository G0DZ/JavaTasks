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
	System.out.print("Введите количество строк: ");
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
            System.out.println("Минимальная длина строки: "+lMin+"\nМаксимальная длина строки: "+lMax);
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        s.close();
        System.out.println("Завершение работы программы.");
	}
	
	//public static void main(String arg[]){
	void task2(){
		System.out.print("Введите количество строк: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        try(BufferedReader br = new BufferedReader(
        		new InputStreamReader(System.in))){
        	String[] str = new String[n];
            for(int i = 0; i < n; i++){
        		str[i] = br.readLine();
        	}
            //пусть и n2, зато мой любимый. при n < 10 вроде и вообще лучший
            for(int i = 1; i < n; i++){
                String currString = str[i];
                int previos = i - 1;
                    while(previos >= 0 && str[previos].length() > currString.length()){
                        str[previos+1] = str[previos]; //двигаемся
                        str[previos] = currString;
                        previos--;
                    }
            }
            System.out.println("Строки упорядочены:");
            for(int i = 0; i < n; i++){
            	 System.out.println(str[i]);
        	}
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        s.close();
        System.out.println("Завершение работы программы.");
	}

	//public static void main(String arg[]){
	void task3(){
		System.out.print("Введите количество строк: ");
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
            double avgLenght = sumLenght/n; //среднее
            System.out.println("Средняя длина строки: "+avgLenght);
            System.out.println("Вывод подходящих строк: ");
            for(int i = 0; i < n; i++){
            	if(str[i].length() < avgLenght)
            		System.out.println("Строка "+i+": "+str[i]+" , длиной "+str[i].length());
            }
        }
        catch(IOException e){
        	e.printStackTrace();
        }
        s.close();
        System.out.println("Завершение работы программы.");
	}

	//public static void main(String arg[]){
	void task4(){
		System.out.print("Введите количество слов: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Слова разделяются как пробелами, так и символами переноса строки.\nВведите "+n+" слов(а): ");
        String[] str = new String[n];
        //слово - это до 1го пробела или \n
        int i = 0;
        while (i < n){
        	if(s.hasNext())
        		str[i++] = s.next();
	    }
        System.out.print("Введены слова: ");
        for(String element : str)		//пробуем другой for
        	System.out.println(element);
        int resultIndex = 0;
        int lMin = Integer.MAX_VALUE; 
        for(i = 0; i < n; i++){
        	String currentStr = str[i];
        	int numberOfUnique = 0; //число уникальных символов в ней
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
        System.out.println("Слово с минимальным количеством различных символов: "+str[resultIndex]+
        		", число различных символов: "+lMin);
        s.close();
        System.out.println("Завершение работы программы.");
	}

	//public static void main(String arg[]){
	void task5(){
		System.out.print("Введите количество слов: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Слова разделяются как пробелами, так и символами переноса строки.\nВведите "+n+" слов(а): ");
        String[] str = new String[n];
        //слово - это до 1го пробела или \n
        int i = 0;
        while (i < n){
        	if(s.hasNext())
        		str[i++] = s.next();
	    }
        System.out.print("Введены слова: \n");
        for(String element : str)		//пробуем другой for
        	System.out.println(element);
        //изучаем Pattern и Matcher, очень рад.
        Pattern p = Pattern.compile("[a-zA-z]+");
        ArrayList<String> list = new ArrayList<String>();
        for(i = 0; i < n; i++){
        	//для каждой строки
        	Matcher m = p.matcher(str[i]);
        	if(m.matches())
        		list.add(str[i]);
        }
        System.out.print("Выводим слова, содержащие только латинские буквы:\n");
        for(i = 0;i < list.size(); i++)
        	System.out.println(list.get(i));
        System.out.print("Среди них слова, содержащие равное число согласных и гласных:\n");
        for(i = 0; i < list.size(); i++){
        	int notVowel = list.get(i).replaceAll("[^aAoOiIuUyYeE]", "").length();
        	int vovel = list.get(i).replaceAll("[aAoOiIuUyYeE]", "").length();
        	if(vovel == notVowel)
        		System.out.println(list.get(i));
        }
        s.close();
        System.out.println("Завершение работы программы.");
	}
	
	//public static void main(String arg[]){
	void task6(){
			System.out.print("Введите количество слов: ");
			Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        System.out.println("Слова разделяются как пробелами, так и символами переноса строки.\nВведите "+n+" слов(а): ");
	        String[] str = new String[n];
	        //слово - это до 1го пробела или \n
	        int i = 0;
	        while (i < n){
	        	if(s.hasNext())
	        		str[i++] = s.next();
		    }
	        System.out.print("Введены слова: \n");
	        for(String element : str)		//пробуем другой for
	        	System.out.println(element);
	        //getBytes()
	        for(i = 0; i < n; i++){
	        	byte bb[] = str[i].getBytes();
	        	boolean wordState = true; //слово - подходит
	        	for(int j = 1; j < bb.length && wordState != false; j++){
	        		if(bb[j]<=bb[j-1])
	        			wordState = false;	//а теперь нет.
	        	}
	        	if(wordState){
	        		System.out.println("Первое слово, в котором все коды символов идут в "+
	        							"строгом порядке возрастания: "+str[i]);
	        		break;
	        	}
	        	if(!wordState && i == n-1)
	        		System.out.println("Нет слов, удовлетворяющих условию.");
	        }
	        s.close();
	        System.out.println("Завершение работы программы.");
		}

	//public static void main(String arg[]){
	void task7(){
		System.out.print("Введите количество слов: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Слова разделяются как пробелами, так и символами переноса строки.\nВведите "+n+" слов(а): ");
        String[] str = new String[n];
        //слово - это до 1го пробела или \n
        int i = 0;
        while (i < n){
        	if(s.hasNext())
        		str[i++] = s.next();
	    }
        System.out.print("Введены слова: \n");
        for(String element : str)		//пробуем другой for
        	System.out.println(element);
        //работаем на время, так что берем 4 лабу и модернизируем
        boolean haveAWord = false; //слова - нет
        for(i = 0; i < n && !haveAWord; i++){
        	String currentStr = str[i];
        	int numberOfUnique = 0; //число уникальных символов в ней
        	for(int j = 0; j < currentStr.length();){
        		currentStr = currentStr.replaceAll(""+currentStr.charAt(j), "");
        		numberOfUnique++;
        	}
        	if(numberOfUnique == str[i].length())
        	{
                System.out.println("Первое слово, в котором все символы различны: "+str[i]);
                haveAWord = true;
        	}
        }
        if(!haveAWord)
        	System.out.println("Нет слова, удовлетворяющего условию.");
        s.close();
        System.out.println("Завершение работы программы.");
	}
	
	//public static void main(String arg[]){
	void task8(){
		System.out.print("Введите количество слов: ");
		Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Слова разделяются как пробелами, так и символами переноса строки.\nВведите "+n+" слов(а): ");
        String[] str = new String[n];
        //слово - это до 1го пробела или \n
        int i = 0;
        while (i < n){
        	if(s.hasNext())
        		str[i++] = s.next();
	    }
        System.out.print("Введены слова: \n");
        for(String element : str)		//пробуем другой for
        	System.out.println(element);
        //работаем на время, так что берем 5 лабу и модернизируем
        Pattern p = Pattern.compile("[0-9]+");
        ArrayList<String> list = new ArrayList<String>();
        for(i = 0; i < n; i++){
        	//для каждой строки
        	Matcher m = p.matcher(str[i]);
        	if(m.matches())
        		list.add(str[i]);
        }
        System.out.print("Выводим слова, содержащие только цифры:\n");
        for(i = 0;i < list.size(); i++)
        	System.out.println(list.get(i));
        //логика. отразим и сравним.
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
        	System.out.println("Нет слова, удовлетворяющего условию.");
        else
        	if(listOfPaly.size() == 1)
        		System.out.println("Первое и единственное слово-палиндром: "+listOfPaly.get(0));
        	else
        		System.out.println("Второе слово-палиндром: "+listOfPaly.get(1));
        s.close();
        System.out.println("Завершение работы программы.");
	}

	//public static void main(String arg[]){
	void task9(){
		int k = 1;
		for(int i = 0; i < 5; i++){
			for(int j = 0; j < 5; j++)
				System.out.printf("%3s"+" |", k++);
			System.out.print("\n-------------------------\n");
		}
        System.out.println("Завершение работы программы.");
	}
	
	//читал вот это давно-давно, даже нашел http://ithappens.me/story/10776
	//но времени в обрез, делаем максимально упрощенно
	//void task10()
	//{
	//	
	//}
	
	//public static void main(String arg[]){
	void task11(){ //11 задание про месяцы, которых 12. watta?
		Scanner s = new Scanner(System.in);
        //первый раз задание на корректность ввода.
        int n = 0;
		while(true){
        	System.out.print("Введите номер месяца (1-12): ");
        	try {
                 n = Integer.parseInt(s.next());
                 if(n > 12 || n < 1)
                	 throw new NumberFormatException();
                 else
                	 break;
            } catch (NumberFormatException e) {
            	System.out.println("Повторите ввод. Необходимо ввести число от 1 до 12");
            }
		}
		//СВИЧ?? СЕРЬЕЗНО? 
        //System.out.println(Month.of(n)); //одна строка!
		switch(n){
		case 1:
			System.out.println("Январь");
			break;
		case 2:
			System.out.println("Февраль");
			break;
		case 3:
			System.out.println("Март");
			break;
		case 4:
			System.out.println("Апрель");
			break;
		case 5:
			System.out.println("Май");
			break;
		case 6:
			System.out.println("Июнь");
			break;
		case 7:
			System.out.println("Июль");
			break;
		case 8:
			System.out.println("Август");
			break;
		case 9:
			System.out.println("Сентябрь");
			break;
		case 10:
			System.out.println("Октябрь");
			break;
		case 11:
			System.out.println("Ноябрь");
			break;
		case 12:
			System.out.println("Декабрь");
			break;
			
		}
		s.close();
		System.out.println("Завершение работы программы.");
	}

	//public static void main(String args[]){
	void task12(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// считаем, что агрумент размера - верен.
		int k = Integer.parseInt(args[1]);// считаем, что агрумент столбца - верен.
		k--;									//а почему бы нет?
		int[][] matrix = new int[n][n];
		System.out.println("Исходная матрица: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = random.nextInt(2*n)-n;
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
		//логика
		for(int i = 1; i < n; i++){
			int line[] = matrix[i];
            int previos = i - 1;
                while(previos >= 0 && matrix[previos][k] > line[k]){
                    matrix[previos+1] = matrix[previos]; //двигаемся
                    matrix[previos] = line;
                    previos--;
                }
        }
		System.out.println("\nМатрица результата: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.printf("%3s", matrix[i][j]);
			System.out.println();
		}
        System.out.println("Завершение работы программы.");
	}
	
	//public static void main(String args[]){
	void task13(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// считаем, что агрумент размера - верен.
		int k = Integer.parseInt(args[1]);// считаем, что агрумент количества сдвигов - верен.
		k--;									//а почему бы нет?
		int[][] matrix = new int[n][n];
		System.out.println("Исходная матрица: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = random.nextInt(2*n)-n;
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
		//логика
		int result[][] = new int[n][n];//дополнительная N*N
		for(int i = 0; i < n; i++){
			result[(i+k+1)%n] = matrix[i];
        }
		System.out.println("\nМатрица результата: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.printf("%3s", result[i][j]);
			System.out.println();
		}
        System.out.println("Завершение работы программы.");
	}
	
	
	//public static void main(String args[]){
	void task14(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// считаем, что агрумент размера - верен.
											//а почему бы нет?
		int[][] matrix = new int[n][n];
		System.out.println("Исходная матрица: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = random.nextInt(2*n)-n;
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
		//логика
		int currentResult = 1;
		int maxResult = 1;
		for(int i = 1; i < n*n; i++){
			//System.out.println(matrix[(i-1)/n][(i-1)%n]);
			//путешествия по матрице как по строке, например
			if(matrix[(i-1)/n][(i-1)%n] < matrix[i/n][i%n]){
				currentResult++;
			}
			else{
				if(currentResult > maxResult){
					//System.out.println(i); //для тестирования
					maxResult = currentResult;
				}
				currentResult = 1;
			}
		}
		if(currentResult > maxResult) //последняя проверка выпадает.
			maxResult = currentResult;
		System.out.println("\nНаибольшее число возрастающих элементов матрицы, идущих подряд: "+maxResult);
		System.out.println("Завершение работы программы.");
		}

	public static void main(String args[]){
	//void task15(String args[]){
		final Random random = new Random();
		int n = Integer.parseInt(args[0]); 	// считаем, что агрумент размера - верен.
											//а почему бы нет?
		int[][] matrix = new int[n][n];
		System.out.println("Исходная матрица: ");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				matrix[i][j] = random.nextInt(2*n)-n;
				System.out.printf("%3s", matrix[i][j]);
			}
			System.out.println();
		}
		//логика
		int sumBetweenPos = 0;
		boolean sumFlag = false; //плхая идея, но это флаг суммирования :(
		for(int i = 0; i < n; i++){
			sumFlag = false;
			for(int j = 0; j < n; j++){
				if(matrix[i][j] > 0)
					if(!sumFlag)
						sumFlag = true;
					else
						break; //после первой пары в каждой строке мы не считаем.
				
				else
					if(sumFlag)
						sumBetweenPos+=matrix[i][j];
					
			}
		}
		if(sumBetweenPos == 0)System.out.println("\n  Сумма элементов, расположенных между первым и \n"
				+ "вторым положительными элементами каждой строки: "+sumBetweenPos);
		else
			System.out.println("Нет элементов, удовлетворяющих условию.");
		System.out.println("Завершение работы программы.");
		}
}
