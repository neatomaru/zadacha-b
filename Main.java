
public class Main {
    public static void main(String[] args) {
        String number = "8380011223344";
        int step = 0;

        String revnumber = number;

        revnumber = new StringBuffer(number).reverse().toString();



        System.out.println("Изначальный номер: " + number);
        while(revnumber.length() > 10 && countChar(revnumber, '8') != 0 && revnumber.lastIndexOf('8') > 9) {

            int pos = 0;
            if(countChar(revnumber, '8') == 2 && revnumber.lastIndexOf('8') >9) {

                revnumber = deleteSymb(revnumber, '8', pos);
                step++;
            }

            else if (((countChar(revnumber, '8') > 2 && revnumber.lastIndexOf('8') >9)) || (countChar(revnumber, '8') == 1))
            {
                int index = revnumber.indexOf('8');
                revnumber = removeCharAt(revnumber, index);
                step++;
            }







        }
        number = new StringBuffer(revnumber).reverse().toString();
        System.out.println("Конечный результат: " + number);
        if(step % 2 != 0) {
            System.out.println("Победил Вася(первый игрок)");
        }
        else System.out.println("Победил Петя(второй игрок)");
    }

    private static String removeCharAt(String s, int pos) {

        return s.substring(0, pos) + s.substring(pos + 1);

    }

    private static int countChar(String str, char c)
    {
        int count = 0;

        for(int i=0; i < str.length(); i++)
        {    if(str.charAt(i) == c)
            count++;
        }

        return count;
    }

    private static String deleteSymb(String str, char c, int pos) {

            if(str.charAt(pos) != '8') {
                str = removeCharAt(str, pos);

            }
            else {

                deleteSymb(str, c, ++pos);

            }
        return str;
        }


    }




