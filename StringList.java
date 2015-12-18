/**
 * Created by andrea on 03/09/15.
 */
public class StringList {
    String info;
    StringList next;
    public StringList (String info, StringList next){
        this.info = info;
        this.next = next;
    }


    public static boolean stCompare (String[] fileContent, String signature){
        int l=fileContent.length;
        int i=0;
        boolean flag=false;
        for (;i<l;++i){
            if(fileContent[i].compareTo(signature)==0)
                return true;


            else {
                return false;
            }

        }
        return false;

    }


    public static boolean greaterThan (String s1, String s2){
        boolean flag = false;
        int i=0;
        if (s1.length()==0 && s2.length()==0)
            flag = true;
        else if (s1.length()>s2.length())
            flag = true;
        else {
            if (s1.length() == s2.length()) {

                while (i < s1.length() - 1 && i < s2.length() - 1) {
                    if (s1.charAt(i) > s2.charAt(i))
                        flag = true;
                    ++i;
                }
            }
        }
        return flag;
    }
    public static void stringExchange (String[] fileC){
        int l=fileC.length, i =0;
        String tmp;
        while (i<l-1){
           if(greaterThan(fileC[i],fileC[i+1])) {
                tmp = fileC[i];
                fileC[i] = fileC[i + 1];
                fileC[i + 1] = tmp;
            }
            ++i;
        }

    }
}
