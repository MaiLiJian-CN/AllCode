import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.util.Base64;

public class HelloWorld {
    public static void main(String []args) throws Exception {

        String cipherText = "mq4s/zhZQcd3VPf8qNKVJLpiD2QkR06IAQGXYBlgZXCEFbr2/KdBlbUYF5IO8Sy/0T+TiLSmKzUKBOmV3MapbtgKck4AsVMeiHVVicKZSKlz6MGqzqbAhULXd0+vHwObEaBA8OdKP+bjPgKR1iUA29ihdwf/QVbFSk7C/1IL2aa2DHN/5UznqszOXmxlQa/Svq099PdJaVtSQfDCB5OIf8JAaTyNMnRx7RgnpOjxuApaODnDalXsKndRyv0aUUOYp2EG8f5NG2OW76YsgXWcjDOT0YicFn2K3JK6QGGkF514u8XeVjXXK7g89+dELCt1lrLHIYxyHxmtXbZ1xTihX6TLw13EOgDid/bZkPDnlOU= mq4s/zhZQcd3VPf8qNKVJDsZgW9vLpzHXR/ds2eQ4vv+m5l9AITT2A1oXTn+r/dILOVS6m/9mQbEinqQBpPpxo9ryGyfdtAXdQAaG6iDmAvT+vz0ohL29b8ElAY0CPaSSP6yCmKXn7VwL+mGsvFh/fofQ+MKrwgdznVUC57jbkG0lc1R6yfdtgQi9PjRA6FB6SZlE4nc30547e5/bVIrJzyUZ+WeHBAk2lE7TD5tgfDCkd/zYdOQOTcBUgormEjgT8RiXn5+U5zwDifHL4rUv/wdjK/+hALhuJWuLcP6p7qy00N7N5hd8g3nnSpNHw7eSEeIrCIF1rt79upLsznlgM3IOOTnly0KnpP47NCbQe8= mq4s/zhZQcd3VPf8qNKVJMqqJANmUlfuyRS/Cc/Zq4kgi9YdhxWfszX+wJzNw8KUF+hKPSjvr/QIXxKaxFzzG59cN8BtjfaNCP4YQgrxDZmIG84znmlLcxEZaW2CNkrF5jKQaGAqy2Q9m1dAVshaBw/KYr3nV9AQ+6h6ijVGyebGqYQJlUMEG2CiCS35wbpm9i9aQ4LM57haMxhuXbZeHKmiy9h3i9K1FxfG6CtSwadKSINJ1hCZWpsg64rYm0D+PBDViFfR78qvuoJ/aWMbGekiFyyZtIyRcOkmDVC419kHcC3iUfmWk3pFyF3+XsOKm5vaFQjuv3W7im21LwQeMbRa4S1KGqEVUUSHpu6HGj8=";

        String key = "ks9KUrbWJj46AftX"; //∫⁄∂¥°¢¿◊ˆ™°¢√€∑‰Õ®”√√‹‘ø
        //key = "awdtif20190619ti"; //–˝∑Á√‹‘ø

        String[] strArray=cipherText.split(" ");
        for (String text : strArray) {
            System.out.println(decrypt(text,key));
        }
    }
    public static String decrypt(String str, String str2) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/NoPadding");
        byte[] bytes = str2.getBytes(Charset.forName("UTF-8"));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        byte[] bytes2 = str2.getBytes(Charset.forName("UTF-8"));
        instance.init(2, secretKeySpec, new IvParameterSpec(bytes2));
        byte[] doFinal = instance.doFinal(Base64.getDecoder().decode(str));
        return new String(doFinal, Charset.forName("UTF-8"));
    }
}
