/**
 * Created by andrea on 03/09/15.
 */
public class ListManager {
    public static void main (String[] args){
        StringList stringList = null;

        String[] signatures = FileManager.manageStrings();
        int l = signatures.length;
        for (int i =0; i < l;++i){
            stringList=insertIntoList(signatures[i], stringList);
        }
        String virusSignature = "29ec390297887a38f33ea50b4092a1c0";
        System.out.println("il virus con md5 29ec390297887a38f33ea50b4092a1c0 e' stato trovato "+signatureSearch(virusSignature,stringList));
        String fakeSignature = "ciaoaaaaaaaaaaa";
        System.out.println("falso allarme con md5 ciaoaaaaaaaaaaa, la firma non e' presente nella lista:  "+signatureSearch(fakeSignature,stringList));
    }
    public static StringList insertIntoList (String st, StringList sl ){
        if (sl==null)
            sl=new StringList(st, null);
        else if ( st.compareTo(sl.info)<0){
            sl = new StringList (st, sl);
        }
        else
            orderedInsert (st, sl);
        return sl;
    }
    public static StringList orderedInsert (String st, StringList sl){
        StringList app=sl;
        boolean inserted=false;
        while (app.next!=null && !inserted){
            if (st.compareTo(app.next.info)<0){
                app.next= new StringList(st, app.next);
                inserted=true;
            }
            else app=app.next;
        }
        if (!inserted)
            app.next= new StringList(st, null);
        return sl;
    }

    public static boolean signatureSearch (String sign, StringList sl){
        while (sl!=null) {
            if (sign.compareTo(sl.info) == 0)
                return true;

            sl=sl.next;
        }
        return false;

    }
}
