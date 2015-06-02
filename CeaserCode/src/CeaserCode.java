import java.util.Scanner;


public class CeaserCode {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("**********************************************");
		System.out.println("*Цезар Шифър е шифър с отместване на буквите *");
		System.out.println("* със съответния ключ, зададен от потребителя*");
		System.out.println("**********************************************");

			System.out.println("Моля въведете текст, който желаете да бъде кодиран или");
			System.out.println("декодиран (програмата работи само с текст на кирилица)");

			String text = input.nextLine();
			System.out.println("Въведете вашият ключ (с колко да бъде отместен текста) използвайте ");
			System.out.println("положителни стойности за да кодирате текст и отрицателни,за да декодирате");

			int key = input.nextInt();
			while(true){	
			System.out.println(" ! Въведете 1, за да шифровате/дешифровате текста  ");
			System.out.println(" ! Въведете 2, за да видите оригиналния текст ");
			System.out.println(" ! Въведете 0, за да въведете нов текст ");
			System.out.println(" ! Въведете -1, за изход ");
			int choice = input.nextInt();
			switch(choice){
			case -1: 
				System.out.println("Благодаря за вниманието, надявам се че ");
				System.out.println("          сте се забавлявали ");
				System.exit(0);break;
			case 0: 
				main(null);break;
			case 1:
				System.out.println("Вашето кодирано съобщение е: ");
				System.out.println(encrypt(text,key));break;
			case 2:
				System.out.println("Вашият оригинален текст е:");
				System.out.println(decrypt(encrypt(text,key),key));break;
			default:
				System.out.println("Въведете 1, 2 или 0");
			}
			
		}
			
	}
	
	public static String encrypt(String text, int key){
		 String encrypted="";
		    for(int i=0;i<text.length();i++)
		    {
		        int c = text.charAt(i);
		        if(Character.isUpperCase(c))
		        {
		            c = c + (key%32);
		            if(c > 'Я')
		                c = c - 32;
		        }
		        else if(Character.isLowerCase(c))
		        {
		            c = c + (key%32);
		            if(c > 'я')
		                c = c - 32;
		        }
		        encrypted = encrypted + (char) c;
		    }
		    return encrypted;
	}
	
	public static String decrypt(String text,int key)
	{
	    String decrypted="";
	    for(int i=0;i< text.length();i++)
	    {
	        int c= text.charAt(i);
	        if(Character.isUpperCase(c))
	        {
	            c=c-(key%32);
	            if(c < 'А')
	                c = c + 32;
	        }
	        else if(Character.isLowerCase(c))
	        {
	            c = c - (key%32);
	            if(c < 'а')
	                c = c + 32;
	        }
	        decrypted = decrypted + (char) c;
	    }
	    return decrypted;
	}

}
