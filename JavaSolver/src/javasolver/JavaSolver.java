/*
OPEN SOURCE !!
 */
package javasolver;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import sun.misc.BASE64Decoder;

/**
 *
 * @author FMAGAZU
 */
public class JavaSolver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        
        final String[] emojis = {"😀", "😁", "😂", "🤣", "😃", "😄", "😅", "😆", "😉", "😊", "😋", "😎", "😍", "😘", "😗", "😙", "😚", "☺", "🙂", "🤗", "🤩", "🤔", "🤨", "😐", "😑", "😶", "🙄", "😏", "😣", "😥", "😮", "🤐", "😯", "😪", "😫", "😴", "😌", "😛", "😜", "😝", "🤤", "😒", "😓", "😔", "😕", "🙃", "🤑", "😲", "☹", "🙁", "😖", "😞", "😟", "😤", "😢", "😭", "😦", "😧", "😨", "😩", "🤯", "😬", "😰", "😱", "😳", "🤪", "😵", "😡", "😠", "🤬", "😷", "🤒", "🤕", "🤢", "🤮", "🤧", "😇", "🤠", "🤡", "🤥", "🤫", "🤭", "🧐", "🤓", "😈", "👿", "👹", "👺", "💀", "☠", "👻", "👽", "👾", "🤖", "💩", "😺", "😸", "😹", "😻", "😼", "😽", "🙀", "😿", "😾", "🙈", "🙉", "🙊", "👶", "👶🏻", "👶🏼", "👶🏽", "👶🏾", "👶🏿", "🧒", "🧒🏻", "🧒🏼", "🧒🏽", "🧒🏾", "🧒🏿", "👦", "👦🏻", "👦🏼", "👦🏽", "👦🏾", "👦🏿", "👧", "👧🏻", "👧🏼", "👧🏽", "👧🏾", "👧🏿", "🧑", "🧑🏻", "🧑🏼", "🧑🏽", "🧑🏾", "🧑🏿", "👨", "👨🏻", "👨🏼", "👨🏽", "👨🏾", "👨🏿", "👩", "👩🏻", "👩🏼", "👩🏽", "👩🏾", "👩🏿", "🧓", "🧓🏻", "🧓🏼", "🧓🏽", "🧓🏾", "🧓🏿", "👴", "👴🏻", "👴🏼", "👴🏽", "👴🏾", "👴🏿", "👵", "👵🏻", "👵🏼", "👵🏽", "👵🏾", "👵🏿", "👨‍⚕️", "👨🏻‍⚕️", "👨🏼‍⚕️", "👨🏽‍⚕️", "👨🏾‍⚕️", "👨🏿‍⚕️", "👩‍⚕️", "👩🏻‍⚕️", "👩🏼‍⚕️", "👩🏽‍⚕️", "👩🏾‍⚕️", "👩🏿‍⚕️", "👨‍🎓", "👨🏻‍🎓", "👨🏼‍🎓", "👨🏽‍🎓", "👨🏾‍🎓", "👨🏿‍🎓", "👩‍🎓", "👩🏻‍🎓", "👩🏼‍🎓", "👩🏽‍🎓", "👩🏾‍🎓", "👩🏿‍🎓", "👨‍🏫", "👨🏻‍🏫", "👨🏼‍🏫", "👨🏽‍🏫", "👨🏾‍🏫", "👨🏿‍🏫", "👩‍🏫", "👩🏻‍🏫", "👩🏼‍🏫", "👩🏽‍🏫", "👩🏾‍🏫", "👩🏿‍🏫", "👨‍⚖️", "👨🏻‍⚖️", "👨🏼‍⚖️", "👨🏽‍⚖️", "👨🏾‍⚖️", "👨🏿‍⚖️", "👩‍⚖️", "👩🏻‍⚖️", "👩🏼‍⚖️", "👩🏽‍⚖️", "👩🏾‍⚖️", "👩🏿‍⚖️", "👨‍🌾", "👨🏻‍🌾", "👨🏼‍🌾", "👨🏽‍🌾", "👨🏾‍🌾", "👨🏿‍🌾", "👩‍🌾", "👩🏻‍🌾", "👩🏼‍🌾", "👩🏽‍🌾", "👩🏾‍🌾", "👩🏿‍🌾", "👨‍🍳", "👨🏻‍🍳", "👨🏼‍🍳", "👨🏽‍🍳", "👨🏾‍🍳", "👨🏿‍🍳", "👩‍🍳", "👩🏻‍🍳", "👩🏼‍🍳", "👩🏽‍🍳", "👩🏾‍🍳", "👩🏿‍🍳", "👨‍🔧", "👨🏻‍🔧", "👨🏼‍🔧", "👨🏽‍🔧", "👨🏾‍🔧", "👨🏿‍🔧", "👩‍🔧", "👩🏻‍🔧", "👩🏼‍🔧", "👩🏽‍🔧", "👩🏾‍🔧", "👩🏿‍🔧", "👨‍🏭", "👨🏻‍🏭", "👨🏼‍🏭", "👨🏽‍🏭", "👨🏾‍🏭", "👨🏿‍🏭", "👩‍🏭", "👩🏻‍🏭", "👩🏼‍🏭", "👩🏽‍🏭", "👩🏾‍🏭", "👩🏿‍🏭", "👨‍💼", "👨🏻‍💼", "👨🏼‍💼", "👨🏽‍💼", "👨🏾‍💼", "👨🏿‍💼", "👩‍💼", "👩🏻‍💼", "👩🏼‍💼", "👩🏽‍💼", "👩🏾‍💼", "👩🏿‍💼", "👨‍🔬", "👨🏻‍🔬", "👨🏼‍🔬", "👨🏽‍🔬", "👨🏾‍🔬", "👨🏿‍🔬", "👩‍🔬", "👩🏻‍🔬", "👩🏼‍🔬", "👩🏽‍🔬", "👩🏾‍🔬", "👩🏿‍🔬", "👨‍💻", "👨🏻‍💻", "👨🏼‍💻", "👨🏽‍💻", "👨🏾‍💻", "👨🏿‍💻", "👩‍💻", "👩🏻‍💻", "👩🏼‍💻", "👩🏽‍💻", "👩🏾‍💻", "👩🏿‍💻", "👨‍🎤", "👨🏻‍🎤", "👨🏼‍🎤", "👨🏽‍🎤", "👨🏾‍🎤", "👨🏿‍🎤", "👩‍🎤", "👩🏻‍🎤", "👩🏼‍🎤", "👩🏽‍🎤", "👩🏾‍🎤", "👩🏿‍🎤", "👨‍🎨", "👨🏻‍🎨", "👨🏼‍🎨", "👨🏽‍🎨", "👨🏾‍🎨", "👨🏿‍🎨", "👩‍🎨", "👩🏻‍🎨", "👩🏼‍🎨", "👩🏽‍🎨", "👩🏾‍🎨", "👩🏿‍🎨", "👨‍✈️", "👨🏻‍✈️", "👨🏼‍✈️", "👨🏽‍✈️", "👨🏾‍✈️", "👨🏿‍✈️", "👩‍✈️", "👩🏻‍✈️", "👩🏼‍✈️", "👩🏽‍✈️", "👩🏾‍✈️", "👩🏿‍✈️", "👨‍🚀", "👨🏻‍🚀", "👨🏼‍🚀", "👨🏽‍🚀", "👨🏾‍🚀", "👨🏿‍🚀", "👩‍🚀", "👩🏻‍🚀", "👩🏼‍🚀", "👩🏽‍🚀", "👩🏾‍🚀", "👩🏿‍🚀", "👨‍🚒", "👨🏻‍🚒", "👨🏼‍🚒", "👨🏽‍🚒", "👨🏾‍🚒", "👨🏿‍🚒", "👩‍🚒", "👩🏻‍🚒", "👩🏼‍🚒", "👩🏽‍🚒", "👩🏾‍🚒", "👩🏿‍🚒", "👮", "👮🏻", "👮🏼", "👮🏽", "👮🏾", "👮🏿", "👮‍♂️", "👮🏻‍♂️", "👮🏼‍♂️", "👮🏽‍♂️", "👮🏾‍♂️", "👮🏿‍♂️", "👮‍♀️", "👮🏻‍♀️", "👮🏼‍♀️", "👮🏽‍♀️", "👮🏾‍♀️", "👮🏿‍♀️", "🕵", "🕵🏻", "🕵🏼", "🕵🏽", "🕵🏾", "🕵🏿", "🕵️‍♂️", "🕵🏻‍♂️", "🕵🏼‍♂️", "🕵🏽‍♂️", "🕵🏾‍♂️", "🕵🏿‍♂️", "🕵️‍♀️", "🕵🏻‍♀️", "🕵🏼‍♀️", "🕵🏽‍♀️", "🕵🏾‍♀️", "🕵🏿‍♀️", "💂", "💂🏻", "💂🏼", "💂🏽", "💂🏾", "💂🏿", "💂‍♂️", "💂🏻‍♂️", "💂🏼‍♂️", "💂🏽‍♂️", "💂🏾‍♂️", "💂🏿‍♂️", "💂‍♀️", "💂🏻‍♀️", "💂🏼‍♀️", "💂🏽‍♀️", "💂🏾‍♀️", "💂🏿‍♀️", "👷", "👷🏻", "👷🏼", "👷🏽", "👷🏾", "👷🏿", "👷‍♂️", "👷🏻‍♂️", "👷🏼‍♂️", "👷🏽‍♂️", "👷🏾‍♂️", "👷🏿‍♂️", "👷‍♀️", "👷🏻‍♀️", "👷🏼‍♀️", "👷🏽‍♀️", "👷🏾‍♀️", "👷🏿‍♀️", "🤴", "🤴🏻", "🤴🏼", "🤴🏽", "🤴🏾", "🤴🏿", "👸", "👸🏻", "👸🏼", "👸🏽", "👸🏾", "👸🏿", "👳", "👳🏻", "👳🏼", "👳🏽", "👳🏾", "👳🏿", "👳‍♂️", "👳🏻‍♂️", "👳🏼‍♂️", "👳🏽‍♂️", "👳🏾‍♂️", "👳🏿‍♂️", "👳‍♀️", "👳🏻‍♀️", "👳🏼‍♀️", "👳🏽‍♀️", "👳🏾‍♀️", "👳🏿‍♀️", "👲", "👲🏻", "👲🏼", "👲🏽", "👲🏾", "👲🏿", "🧕", "🧕🏻", "🧕🏼", "🧕🏽", "🧕🏾", "🧕🏿", "🧔", "🧔🏻", "🧔🏼", "🧔🏽", "🧔🏾", "🧔🏿", "👱", "👱🏻", "👱🏼", "👱🏽", "👱🏾", "👱🏿", "👱‍♂️", "👱🏻‍♂️", "👱🏼‍♂️", "👱🏽‍♂️", "👱🏾‍♂️", "👱🏿‍♂️", "👱‍♀️", "👱🏻‍♀️", "👱🏼‍♀️", "👱🏽‍♀️", "👱🏾‍♀️", "👱🏿‍♀️", "🤵", "🤵🏻", "🤵🏼", "🤵🏽", "🤵🏾", "🤵🏿", "👰", "👰🏻", "👰🏼", "👰🏽", "👰🏾", "👰🏿", "🤰", "🤰🏻", "🤰🏼", "🤰🏽", "🤰🏾", "🤰🏿", "🤱", "🤱🏻", "🤱🏼", "🤱🏽", "🤱🏾", "🤱🏿", "👼", "👼🏻", "👼🏼", "👼🏽", "👼🏾", "👼🏿", "🎅", "🎅🏻", "🎅🏼", "🎅🏽", "🎅🏾", "🎅🏿", "🤶", "🤶🏻", "🤶🏼", "🤶🏽", "🤶🏾", "🤶🏿", "🧙", "🧙🏻", "🧙🏼", "🧙🏽", "🧙🏾", "🧙🏿", "🧙‍♀️", "🧙🏻‍♀️", "🧙🏼‍♀️", "🧙🏽‍♀️", "🧙🏾‍♀️", "🧙🏿‍♀️", "🧙‍♂️", "🧙🏻‍♂️", "🧙🏼‍♂️", "🧙🏽‍♂️", "🧙🏾‍♂️", "🧙🏿‍♂️", "🧚", "🧚🏻", "🧚🏼", "🧚🏽", "🧚🏾", "🧚🏿", "🧚‍♀️", "🧚🏻‍♀️", "🧚🏼‍♀️", "🧚🏽‍♀️", "🧚🏾‍♀️", "🧚🏿‍♀️", "🧚‍♂️", "🧚🏻‍♂️", "🧚🏼‍♂️", "🧚🏽‍♂️", "🧚🏾‍♂️", "🧚🏿‍♂️", "🧛", "🧛🏻", "🧛🏼", "🧛🏽", "🧛🏾", "🧛🏿", "🧛‍♀️", "🧛🏻‍♀️", "🧛🏼‍♀️", "🧛🏽‍♀️", "🧛🏾‍♀️", "🧛🏿‍♀️", "🧛‍♂️", "🧛🏻‍♂️", "🧛🏼‍♂️", "🧛🏽‍♂️", "🧛🏾‍♂️", "🧛🏿‍♂️", "🧜", "🧜🏻", "🧜🏼", "🧜🏽", "🧜🏾", "🧜🏿", "🧜‍♀️", "🧜🏻‍♀️", "🧜🏼‍♀️", "🧜🏽‍♀️", "🧜🏾‍♀️", "🧜🏿‍♀️", "🧜‍♂️", "🧜🏻‍♂️", "🧜🏼‍♂️", "🧜🏽‍♂️", "🧜🏾‍♂️", "🧜🏿‍♂️", "🧝", "🧝🏻", "🧝🏼", "🧝🏽", "🧝🏾", "🧝🏿", "🧝‍♀️", "🧝🏻‍♀️", "🧝🏼‍♀️", "🧝🏽‍♀️", "🧝🏾‍♀️", "🧝🏿‍♀️", "🧝‍♂️", "🧝🏻‍♂️", "🧝🏼‍♂️", "🧝🏽‍♂️", "🧝🏾‍♂️", "🧝🏿‍♂️", "🧞", "🧞‍♀️", "🧞‍♂️", "🧟", "🧟‍♀️", "🧟‍♂️", "🙍", "🙍🏻", "🙍🏼", "🙍🏽", "🙍🏾", "🙍🏿", "🙍‍♂️", "🙍🏻‍♂️", "🙍🏼‍♂️", "🙍🏽‍♂️", "🙍🏾‍♂️", "🙍🏿‍♂️", "🙍‍♀️", "🙍🏻‍♀️", "🙍🏼‍♀️", "🙍🏽‍♀️", "🙍🏾‍♀️", "🙍🏿‍♀️", "🙎", "🙎🏻", "🙎🏼", "🙎🏽", "🙎🏾", "🙎🏿", "🙎‍♂️", "🙎🏻‍♂️", "🙎🏼‍♂️", "🙎🏽‍♂️", "🙎🏾‍♂️", "🙎🏿‍♂️", "🙎‍♀️", "🙎🏻‍♀️", "🙎🏼‍♀️", "🙎🏽‍♀️", "🙎🏾‍♀️", "🙎🏿‍♀️", "🙅", "🙅🏻", "🙅🏼", "🙅🏽", "🙅🏾", "🙅🏿", "🙅‍♂️", "🙅🏻‍♂️", "🙅🏼‍♂️", "🙅🏽‍♂️", "🙅🏾‍♂️", "🙅🏿‍♂️", "🙅‍♀️", "🙅🏻‍♀️", "🙅🏼‍♀️", "🙅🏽‍♀️", "🙅🏾‍♀️", "🙅🏿‍♀️", "🙆", "🙆🏻", "🙆🏼", "🙆🏽", "🙆🏾", "🙆🏿", "🙆‍♂️", "🙆🏻‍♂️", "🙆🏼‍♂️", "🙆🏽‍♂️", "🙆🏾‍♂️", "🙆🏿‍♂️", "🙆‍♀️", "🙆🏻‍♀️", "🙆🏼‍♀️", "🙆🏽‍♀️", "🙆🏾‍♀️", "🙆🏿‍♀️", "💁", "💁🏻", "💁🏼", "💁🏽", "💁🏾", "💁🏿", "💁‍♂️", "💁🏻‍♂️", "💁🏼‍♂️", "💁🏽‍♂️", "💁🏾‍♂️", "💁🏿‍♂️", "💁‍♀️", "💁🏻‍♀️", "💁🏼‍♀️", "💁🏽‍♀️", "💁🏾‍♀️", "💁🏿‍♀️", "🙋", "🙋🏻", "🙋🏼", "🙋🏽", "🙋🏾", "🙋🏿", "🙋‍♂️", "🙋🏻‍♂️", "🙋🏼‍♂️", "🙋🏽‍♂️", "🙋🏾‍♂️", "🙋🏿‍♂️", "🙋‍♀️", "🙋🏻‍♀️", "🙋🏼‍♀️", "🙋🏽‍♀️", "🙋🏾‍♀️", "🙋🏿‍♀️", "🙇", "🙇🏻", "🙇🏼", "🙇🏽", "🙇🏾", "🙇🏿", "🙇‍♂️", "🙇🏻‍♂️", "🙇🏼‍♂️", "🙇🏽‍♂️", "🙇🏾‍♂️", "🙇🏿‍♂️", "🙇‍♀️", "🙇🏻‍♀️", "🙇🏼‍♀️", "🙇🏽‍♀️", "🙇🏾‍♀️", "🙇🏿‍♀️", "🤦", "🤦🏻", "🤦🏼", "🤦🏽", "🤦🏾", "🤦🏿", "🤦‍♂️", "🤦🏻‍♂️", "🤦🏼‍♂️", "🤦🏽‍♂️", "🤦🏾‍♂️", "🤦🏿‍♂️", "🤦‍♀️", "🤦🏻‍♀️", "🤦🏼‍♀️", "🤦🏽‍♀️", "🤦🏾‍♀️", "🤦🏿‍♀️", "🤷", "🤷🏻", "🤷🏼", "🤷🏽", "🤷🏾", "🤷🏿", "🤷‍♂️", "🤷🏻‍♂️", "🤷🏼‍♂️", "🤷🏽‍♂️", "🤷🏾‍♂️", "🤷🏿‍♂️", "🤷‍♀️", "🤷🏻‍♀️", "🤷🏼‍♀️", "🤷🏽‍♀️", "🤷🏾‍♀️", "🤷🏿‍♀️", "💆", "💆🏻", "💆🏼", "💆🏽", "💆🏾", "💆🏿", "💆‍♂️", "💆🏻‍♂️", "💆🏼‍♂️", "💆🏽‍♂️", "💆🏾‍♂️", "💆🏿‍♂️", "💆‍♀️", "💆🏻‍♀️", "💆🏼‍♀️", "💆🏽‍♀️", "💆🏾‍♀️", "💆🏿‍♀️", "💇", "💇🏻", "💇🏼", "💇🏽", "💇🏾", "💇🏿", "💇‍♂️", "💇🏻‍♂️", "💇🏼‍♂️", "💇🏽‍♂️", "💇🏾‍♂️", "💇🏿‍♂️", "💇‍♀️", "💇🏻‍♀️", "💇🏼‍♀️", "💇🏽‍♀️", "💇🏾‍♀️", "💇🏿‍♀️", "🚶", "🚶🏻", "🚶🏼", "🚶🏽", "🚶🏾", "🚶🏿", "🚶‍♂️", "🚶🏻‍♂️", "🚶🏼‍♂️", "🚶🏽‍♂️", "🚶🏾‍♂️", "🚶🏿‍♂️", "🚶‍♀️", "🚶🏻‍♀️", "🚶🏼‍♀️", "🚶🏽‍♀️", "🚶🏾‍♀️", "🚶🏿‍♀️", "🏃", "🏃🏻", "🏃🏼", "🏃🏽", "🏃🏾", "🏃🏿", "🏃‍♂️", "🏃🏻‍♂️", "🏃🏼‍♂️", "🏃🏽‍♂️", "🏃🏾‍♂️", "🏃🏿‍♂️", "🏃‍♀️", "🏃🏻‍♀️", "🏃🏼‍♀️", "🏃🏽‍♀️", "🏃🏾‍♀️", "🏃🏿‍♀️", "💃", "💃🏻", "💃🏼", "💃🏽", "💃🏾", "💃🏿", "🕺", "🕺🏻", "🕺🏼", "🕺🏽", "🕺🏾", "🕺🏿", "👯", "👯‍♂️", "👯‍♀️", "🧖", "🧖🏻", "🧖🏼", "🧖🏽", "🧖🏾", "🧖🏿", "🧖‍♀️", "🧖🏻‍♀️", "🧖🏼‍♀️", "🧖🏽‍♀️", "🧖🏾‍♀️", "🧖🏿‍♀️", "🧖‍♂️", "🧖🏻‍♂️", "🧖🏼‍♂️", "🧖🏽‍♂️", "🧖🏾‍♂️", "🧖🏿‍♂️", "🧗", "🧗🏻", "🧗🏼", "🧗🏽", "🧗🏾", "🧗🏿", "🧗‍♀️", "🧗🏻‍♀️", "🧗🏼‍♀️", "🧗🏽‍♀️", "🧗🏾‍♀️", "🧗🏿‍♀️", "🧗‍♂️", "🧗🏻‍♂️", "🧗🏼‍♂️", "🧗🏽‍♂️", "🧗🏾‍♂️", "🧗🏿‍♂️", "🧘", "🧘🏻", "🧘🏼", "🧘🏽", "🧘🏾", "🧘🏿", "🧘‍♀️", "🧘🏻‍♀️", "🧘🏼‍♀️", "🧘🏽‍♀️", "🧘🏾‍♀️", "🧘🏿‍♀️", "🧘‍♂️", "🧘🏻‍♂️", "🧘🏼‍♂️", "🧘🏽‍♂️", "🧘🏾‍♂️", "🧘🏿‍♂️", "🛀", "🛀🏻", "🛀🏼", "🛀🏽", "🛀🏾", "🛀🏿", "🛌", "🛌🏻", "🛌🏼", "🛌🏽", "🛌🏾", "🛌🏿", "🕴", "🕴🏻", "🕴🏼", "🕴🏽", "🕴🏾", "🕴🏿", "🗣", "👤", "👥", "🤺", "🏇", "🏇🏻", "🏇🏼", "🏇🏽", "🏇🏾", "🏇🏿", "⛷", "🏂", "🏂🏻", "🏂🏼", "🏂🏽", "🏂🏾", "🏂🏿", "🏌", "🏌🏻", "🏌🏼", "🏌🏽", "🏌🏾", "🏌🏿", "🏌️‍♂️", "🏌🏻‍♂️", "🏌🏼‍♂️", "🏌🏽‍♂️", "🏌🏾‍♂️", "🏌🏿‍♂️", "🏌️‍♀️", "🏌🏻‍♀️", "🏌🏼‍♀️", "🏌🏽‍♀️", "🏌🏾‍♀️", "🏌🏿‍♀️", "🏄", "🏄🏻", "🏄🏼", "🏄🏽", "🏄🏾", "🏄🏿", "🏄‍♂️", "🏄🏻‍♂️", "🏄🏼‍♂️", "🏄🏽‍♂️", "🏄🏾‍♂️", "🏄🏿‍♂️", "🏄‍♀️", "🏄🏻‍♀️", "🏄🏼‍♀️", "🏄🏽‍♀️", "🏄🏾‍♀️", "🏄🏿‍♀️", "🚣", "🚣🏻", "🚣🏼", "🚣🏽", "🚣🏾", "🚣🏿", "🚣‍♂️", "🚣🏻‍♂️", "🚣🏼‍♂️", "🚣🏽‍♂️", "🚣🏾‍♂️", "🚣🏿‍♂️", "🚣‍♀️", "🚣🏻‍♀️", "🚣🏼‍♀️", "🚣🏽‍♀️", "🚣🏾‍♀️", "🚣🏿‍♀️", "🏊", "🏊🏻", "🏊🏼", "🏊🏽", "🏊🏾", "🏊🏿", "🏊‍♂️", "🏊🏻‍♂️", "🏊🏼‍♂️", "🏊🏽‍♂️", "🏊🏾‍♂️", "🏊🏿‍♂️", "🏊‍♀️", "🏊🏻‍♀️", "🏊🏼‍♀️", "🏊🏽‍♀️", "🏊🏾‍♀️", "🏊🏿‍♀️", "⛹", "⛹🏻", "⛹🏼", "⛹🏽", "⛹🏾", "⛹🏿", "⛹️‍♂️", "⛹🏻‍♂️", "⛹🏼‍♂️", "⛹🏽‍♂️", "⛹🏾‍♂️", "⛹🏿‍♂️", "⛹️‍♀️", "⛹🏻‍♀️", "⛹🏼‍♀️", "⛹🏽‍♀️", "⛹🏾‍♀️", "⛹🏿‍♀️", "🏋", "🏋🏻", "🏋🏼", "🏋🏽", "🏋🏾", "🏋🏿", "🏋️‍♂️", "🏋🏻‍♂️", "🏋🏼‍♂️", "🏋🏽‍♂️", "🏋🏾‍♂️", "🏋🏿‍♂️", "🏋️‍♀️", "🏋🏻‍♀️", "🏋🏼‍♀️", "🏋🏽‍♀️", "🏋🏾‍♀️", "🏋🏿‍♀️", "🚴", "🚴🏻", "🚴🏼", "🚴🏽", "🚴🏾", "🚴🏿", "🚴‍♂️", "🚴🏻‍♂️", "🚴🏼‍♂️", "🚴🏽‍♂️", "🚴🏾‍♂️", "🚴🏿‍♂️", "🚴‍♀️", "🚴🏻‍♀️", "🚴🏼‍♀️", "🚴🏽‍♀️", "🚴🏾‍♀️", "🚴🏿‍♀️", "🚵", "🚵🏻", "🚵🏼", "🚵🏽", "🚵🏾", "🚵🏿", "🚵‍♂️", "🚵🏻‍♂️", "🚵🏼‍♂️", "🚵🏽‍♂️", "🚵🏾‍♂️", "🚵🏿‍♂️", "🚵‍♀️", "🚵🏻‍♀️", "🚵🏼‍♀️", "🚵🏽‍♀️", "🚵🏾‍♀️", "🚵🏿‍♀️", "🏎", "🏍", "🤸", "🤸🏻", "🤸🏼", "🤸🏽", "🤸🏾", "🤸🏿", "🤸‍♂️", "🤸🏻‍♂️", "🤸🏼‍♂️", "🤸🏽‍♂️", "🤸🏾‍♂️", "🤸🏿‍♂️", "🤸‍♀️", "🤸🏻‍♀️", "🤸🏼‍♀️", "🤸🏽‍♀️", "🤸🏾‍♀️", "🤸🏿‍♀️", "🤼", "🤼‍♂️", "🤼‍♀️", "🤽", "🤽🏻", "🤽🏼", "🤽🏽", "🤽🏾", "🤽🏿", "🤽‍♂️", "🤽🏻‍♂️", "🤽🏼‍♂️", "🤽🏽‍♂️", "🤽🏾‍♂️", "🤽🏿‍♂️", "🤽‍♀️", "🤽🏻‍♀️", "🤽🏼‍♀️", "🤽🏽‍♀️", "🤽🏾‍♀️", "🤽🏿‍♀️", "🤾", "🤾🏻", "🤾🏼", "🤾🏽", "🤾🏾", "🤾🏿", "🤾‍♂️", "🤾🏻‍♂️", "🤾🏼‍♂️", "🤾🏽‍♂️", "🤾🏾‍♂️", "🤾🏿‍♂️", "🤾‍♀️", "🤾🏻‍♀️", "🤾🏼‍♀️", "🤾🏽‍♀️", "🤾🏾‍♀️", "🤾🏿‍♀️", "🤹", "🤹🏻", "🤹🏼", "🤹🏽", "🤹🏾", "🤹🏿", "🤹‍♂️", "🤹🏻‍♂️", "🤹🏼‍♂️", "🤹🏽‍♂️", "🤹🏾‍♂️", "🤹🏿‍♂️", "🤹‍♀️", "🤹🏻‍♀️", "🤹🏼‍♀️", "🤹🏽‍♀️", "🤹🏾‍♀️", "🤹🏿‍♀️", "👫", "👬", "👭", "💏", "👩‍❤️‍💋‍👨", "👨‍❤️‍💋‍👨", "👩‍❤️‍💋‍👩", "💑", "👩‍❤️‍👨", "👨‍❤️‍👨", "👩‍❤️‍👩", "👪", "👨‍👩‍👦", "👨‍👩‍👧", "👨‍👩‍👧‍👦", "👨‍👩‍👦‍👦", "👨‍👩‍👧‍👧", "👨‍👨‍👦", "👨‍👨‍👧", "👨‍👨‍👧‍👦", "👨‍👨‍👦‍👦", "👨‍👨‍👧‍👧", "👩‍👩‍👦", "👩‍👩‍👧", "👩‍👩‍👧‍👦", "👩‍👩‍👦‍👦", "👩‍👩‍👧‍👧", "👨‍👦", "👨‍👦‍👦", "👨‍👧", "👨‍👧‍👦", "👨‍👧‍👧", "👩‍👦", "👩‍👦‍👦", "👩‍👧", "👩‍👧‍👦", "👩‍👧‍👧", "🤳", "🤳🏻", "🤳🏼", "🤳🏽", "🤳🏾", "🤳🏿", "💪", "💪🏻", "💪🏼", "💪🏽", "💪🏾", "💪🏿", "👈", "👈🏻", "👈🏼", "👈🏽", "👈🏾", "👈🏿", "👉", "👉🏻", "👉🏼", "👉🏽", "👉🏾", "👉🏿", "☝", "☝🏻", "☝🏼", "☝🏽", "☝🏾", "☝🏿", "👆", "👆🏻", "👆🏼", "👆🏽", "👆🏾", "👆🏿", "🖕", "🖕🏻", "🖕🏼", "🖕🏽", "🖕🏾", "🖕🏿", "👇", "👇🏻", "👇🏼", "👇🏽", "👇🏾", "👇🏿", "✌", "✌🏻", "✌🏼", "✌🏽", "✌🏾", "✌🏿", "🤞", "🤞🏻", "🤞🏼", "🤞🏽", "🤞🏾", "🤞🏿", "🖖", "🖖🏻", "🖖🏼", "🖖🏽", "🖖🏾", "🖖🏿", "🤘", "🤘🏻", "🤘🏼", "🤘🏽", "🤘🏾", "🤘🏿", "🤙", "🤙🏻", "🤙🏼", "🤙🏽", "🤙🏾", "🤙🏿", "🖐", "🖐🏻", "🖐🏼", "🖐🏽", "🖐🏾", "🖐🏿", "✋", "✋🏻", "✋🏼", "✋🏽", "✋🏾", "✋🏿", "👌", "👌🏻", "👌🏼", "👌🏽", "👌🏾", "👌🏿", "👍", "👍🏻", "👍🏼", "👍🏽", "👍🏾", "👍🏿", "👎", "👎🏻", "👎🏼", "👎🏽", "👎🏾", "👎🏿", "✊", "✊🏻", "✊🏼", "✊🏽", "✊🏾", "✊🏿", "👊", "👊🏻", "👊🏼", "👊🏽", "👊🏾", "👊🏿", "🤛", "🤛🏻", "🤛🏼", "🤛🏽", "🤛🏾", "🤛🏿", "🤜", "🤜🏻", "🤜🏼", "🤜🏽", "🤜🏾", "🤜🏿", "🤚", "🤚🏻", "🤚🏼", "🤚🏽", "🤚🏾", "🤚🏿", "👋", "👋🏻", "👋🏼", "👋🏽", "👋🏾", "👋🏿", "🤟", "🤟🏻", "🤟🏼", "🤟🏽", "🤟🏾", "🤟🏿", "✍", "✍🏻", "✍🏼", "✍🏽", "✍🏾", "✍🏿", "👏", "👏🏻", "👏🏼", "👏🏽", "👏🏾", "👏🏿", "👐", "👐🏻", "👐🏼", "👐🏽", "👐🏾", "👐🏿", "🙌", "🙌🏻", "🙌🏼", "🙌🏽", "🙌🏾", "🙌🏿", "🤲", "🤲🏻", "🤲🏼", "🤲🏽", "🤲🏾", "🤲🏿", "🙏", "🙏🏻", "🙏🏼", "🙏🏽", "🙏🏾", "🙏🏿", "🤝", "💅", "💅🏻", "💅🏼", "💅🏽", "💅🏾", "💅🏿", "👂", "👂🏻", "👂🏼", "👂🏽", "👂🏾", "👂🏿", "👃", "👃🏻", "👃🏼", "👃🏽", "👃🏾", "👃🏿", "👣", "👀", "👁", "👁️‍🗨️", "🧠", "👅", "👄", "💋", "💘", "❤", "💓", "💔", "💕", "💖", "💗", "💙", "💚", "💛", "🧡", "💜", "🖤", "💝", "💞", "💟", "❣", "💌", "💤", "💢", "💣", "💥", "💦", "💨", "💫", "💬", "🗨", "🗯", "💭", "🕳", "👓", "🕶", "👔", "👕", "👖", "🧣", "🧤", "🧥", "🧦", "👗", "👘", "👙", "👚", "👛", "👜", "👝", "🛍", "🎒", "👞", "👟", "👠", "👡", "👢", "👑", "👒", "🎩", "🎓", "🧢", "⛑", "📿", "💄", "💍", "💎", "🐵", "🐒", "🦍", "🐶", "🐕", "🐩", "🐺", "🦊", "🐱", "🐈", "🦁", "🐯", "🐅", "🐆", "🐴", "🐎", "🦄", "🦓", "🦌", "🐮", "🐂", "🐃", "🐄", "🐷", "🐖", "🐗", "🐽", "🐏", "🐑", "🐐", "🐪", "🐫", "🦒", "🐘", "🦏", "🐭", "🐁", "🐀", "🐹", "🐰", "🐇", "🐿", "🦔", "🦇", "🐻", "🐨", "🐼", "🐾", "🦃", "🐔", "🐓", "🐣", "🐤", "🐥", "🐦", "🐧", "🕊", "🦅", "🦆", "🦉", "🐸", "🐊", "🐢", "🦎", "🐍", "🐲", "🐉", "🦕", "🦖", "🐳", "🐋", "🐬", "🐟", "🐠", "🐡", "🦈", "🐙", "🐚", "🦀", "🦐", "🦑", "🐌", "🦋", "🐛", "🐜", "🐝", "🐞", "🦗", "🕷", "🕸", "🦂", "💐", "🌸", "💮", "🏵", "🌹", "🥀", "🌺", "🌻", "🌼", "🌷", "🌱", "🌲", "🌳", "🌴", "🌵", "🌾", "🌿", "☘", "🍀", "🍁", "🍂", "🍃", "🍇", "🍈", "🍉", "🍊", "🍋", "🍌", "🍍", "🍎", "🍏", "🍐", "🍑", "🍒", "🍓", "🥝", "🍅", "🥥", "🥑", "🍆", "🥔", "🥕", "🌽", "🌶", "🥒", "🥦", "🍄", "🥜", "🌰", "🍞", "🥐", "🥖", "🥨", "🥞", "🧀", "🍖", "🍗", "🥩", "🥓", "🍔", "🍟", "🍕", "🌭", "🥪", "🌮", "🌯", "🥙", "🥚", "🍳", "🥘", "🍲", "🥣", "🥗", "🍿", "🥫", "🍱", "🍘", "🍙", "🍚", "🍛", "🍜", "🍝", "🍠", "🍢", "🍣", "🍤", "🍥", "🍡", "🥟", "🥠", "🥡", "🍦", "🍧", "🍨", "🍩", "🍪", "🎂", "🍰", "🥧", "🍫", "🍬", "🍭", "🍮", "🍯", "🍼", "🥛", "☕", "🍵", "🍶", "🍾", "🍷", "🍸", "🍹", "🍺", "🍻", "🥂", "🥃", "🥤", "🥢", "🍽", "🍴", "🥄", "🔪", "🏺", "🌍", "🌎", "🌏", "🌐", "🗺", "🗾", "🏔", "⛰", "🌋", "🗻", "🏕", "🏖", "🏜", "🏝", "🏞", "🏟", "🏛", "🏗", "🏘", "🏙", "🏚", "🏠", "🏡", "🏢", "🏣", "🏤", "🏥", "🏦", "🏨", "🏩", "🏪", "🏫", "🏬", "🏭", "🏯", "🏰", "💒", "🗼", "🗽", "⛪", "🕌", "🕍", "⛩", "🕋", "⛲", "⛺", "🌁", "🌃", "🌄", "🌅", "🌆", "🌇", "🌉", "♨", "🌌", "🎠", "🎡", "🎢", "💈", "🎪", "🎭", "🖼", "🎨", "🎰", "🚂", "🚃", "🚄", "🚅", "🚆", "🚇", "🚈", "🚉", "🚊", "🚝", "🚞", "🚋", "🚌", "🚍", "🚎", "🚐", "🚑", "🚒", "🚓", "🚔", "🚕", "🚖", "🚗", "🚘", "🚙", "🚚", "🚛", "🚜", "🚲", "🛴", "🛵", "🚏", "🛣", "🛤", "⛽", "🚨", "🚥", "🚦", "🚧", "🛑", "⚓", "⛵", "🛶", "🚤", "🛳", "⛴", "🛥", "🚢", "✈", "🛩", "🛫", "🛬", "💺", "🚁", "🚟", "🚠", "🚡", "🛰", "🚀", "🛸", "🛎", "🚪", "🛏", "🛋", "🚽", "🚿", "🛁", "⌛", "⏳", "⌚", "⏰", "⏱", "⏲", "🕰", "🕛", "🕧", "🕐", "🕜", "🕑", "🕝", "🕒", "🕞", "🕓", "🕟", "🕔", "🕠", "🕕", "🕡", "🕖", "🕢", "🕗", "🕣", "🕘", "🕤", "🕙", "🕥", "🕚", "🕦", "🌑", "🌒", "🌓", "🌔", "🌕", "🌖", "🌗", "🌘", "🌙", "🌚", "🌛", "🌜", "🌡", "☀", "🌝", "🌞", "⭐", "🌟", "🌠", "☁", "⛅", "⛈", "🌤", "🌥", "🌦", "🌧", "🌨", "🌩", "🌪", "🌫", "🌬", "🌀", "🌈", "🌂", "☂", "☔", "⛱", "⚡", "❄", "☃", "⛄", "☄", "🔥", "💧", "🌊", "🎃", "🎄", "🎆", "🎇", "✨", "🎈", "🎉", "🎊", "🎋", "🎍", "🎎", "🎏", "🎐", "🎑", "🎀", "🎁", "🎗", "🎟", "🎫", "🎖", "🏆", "🏅", "🥇", "🥈", "🥉", "⚽", "⚾", "🏀", "🏐", "🏈", "🏉", "🎾", "🎱", "🎳", "🏏", "🏑", "🏒", "🏓", "🏸", "🥊", "🥋", "🥅", "🎯", "⛳", "⛸", "🎣", "🎽", "🎿", "🛷", "🥌", "🎮", "🕹", "🎲", "♠", "♥", "♦", "♣", "🃏", "🀄", "🎴", "🔇", "🔈", "🔉", "🔊", "📢", "📣", "📯", "🔔", "🔕", "🎼", "🎵", "🎶", "🎙", "🎚", "🎛", "🎤", "🎧", "📻", "🎷", "🎸", "🎹", "🎺", "🎻", "🥁", "📱", "📲", "☎", "📞", "📟", "📠", "🔋", "🔌", "💻", "🖥", "🖨", "⌨", "🖱", "🖲", "💽", "💾", "💿", "📀", "🎥", "🎞", "📽", "🎬", "📺", "📷", "📸", "📹", "📼", "🔍", "🔎", "🔬", "🔭", "📡", "🕯", "💡", "🔦", "🏮", "📔", "📕", "📖", "📗", "📘", "📙", "📚", "📓", "📒", "📃", "📜", "📄", "📰", "🗞", "📑", "🔖", "🏷", "💰", "💴", "💵", "💶", "💷", "💸", "💳", "💹", "💱", "💲", "✉", "📧", "📨", "📩", "📤", "📥", "📦", "📫", "📪", "📬", "📭", "📮", "🗳", "✏", "✒", "🖋", "🖊", "🖌", "🖍", "📝", "💼", "📁", "📂", "🗂", "📅", "📆", "🗒", "🗓", "📇", "📈", "📉", "📊", "📋", "📌", "📍", "📎", "🖇", "📏", "📐", "✂", "🗃", "🗄", "🗑", "🔒", "🔓", "🔏", "🔐", "🔑", "🗝", "🔨", "⛏", "⚒", "🛠", "🗡", "⚔", "🔫", "🏹", "🛡", "🔧", "🔩", "⚙", "🗜", "⚗"};
        String encryptedMsg= "aef50f04292af2f4c063967bab63ba2a3c2804399e65ba3f61f061f924a9baf1U2FsdGVkX1+Uq+uFrMLmcEQ0YtYelIQnAmf7jpg75d2MwCUDhmtX2nW5Q3ccjXMEXK5rO50YWfd4LcFF3SlirE3nVckeQf5TNu8RSOzJSGS2hOEXNlz1/hLeyEcEtby0vVQTGXhMMFTdKial0/p+Kj17NbWPMLfy9WUYhHf3lAFuAg/1k4322yMV4y4NeIFPoNESRaBrbn2P2DcsSOZEDLfhh9WyXX323oyQqN/tBtNSAQ9P9QGQq1mCg1Fxidp70ep4ycx0fobAOLmxwmJfoUtcuZgn+XKaO78DTxErUcvJ8FTQt8O24t+ezSqPaWkUs/xT2vIJmZIxw6RSf6bSKdHwtP8Gxawk+7ZNS7tkdhcvg0li95lM83GUlMjKEYPJ9GFLD5k8CuqJdk6CO2ILCQMzhHuwHZLSmSR9Xyepak38n9qEBNiERGxWLU6T1GsvrQd3W07RQBgS1fWIOSU+vXrwlY0eUlPxKwwEOQEq/7DHFHecrPRv4eYWc14NnQAIOVjdbNgcyOse2BHCToo4UCxoxDu3+3e7buR2fVGj0qeolVL6fb8TKWGccDH72Z0NJxxskkgjZQBeEACxbmFwkdBKJjQZDIddTtXCLprLsKvtW8W9KQl/BfS723P8OJqkjoKxDKCsC4zGWvSPkE89Qg==";
         String actualKey = "✈🍓";     
        String encryptedHMAC = encryptedMsg.substring(0, 64);
        String encryptedHTML = encryptedMsg.substring(64);
        
        final Charset utf8 = Charset.forName("UTF8");
        final Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        
        byte[] decryptedHMAC;
        SecretKeySpec secret_key;
        String passphrase;
                
       
            for(int j = 0; j < emojis.length; j+=1){
                for(int k = 0; k < emojis.length; k+=1){    
                    
                   actualKey = emojis[j]+emojis[k];
                   passphrase = getSHA256Hash(actualKey);
                   secret_key= new javax.crypto.spec.SecretKeySpec(hexStringToByteArray(passphrase), "HmacSHA256");
                   sha256_HMAC.init(secret_key);
                   decryptedHMAC = sha256_HMAC.doFinal(encryptedHTML.getBytes("UTF-8"));

                    if( bytesToHex(decryptedHMAC).equals(encryptedHMAC) )
                    {    
                       System.out.println("actual key is " + actualKey );
                       System.out.println("decrypted hmac is " + bytesToHex(decryptedHMAC));
                       j = 3000;
                       break;
                    }
                }
                System.out.println(j);
        }
 
         
    }
    
    public static byte[] hexStringToByteArray(String s) {

        int len = s.length();
        byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }

        return data;
    }
    
    public static String bytesToHex(byte[] in) {
        final StringBuilder builder = new StringBuilder();
        for(byte b : in) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
    
    public static String decrypt(String encryptedData, SecretKeySpec sKey) throws Exception { 
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, sKey);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);

        return decryptedValue;
    }
    
    public static String stringToHex(String base) throws UnsupportedEncodingException
    {
        return String.format("%040x", new BigInteger(1, base.getBytes(StandardCharsets.UTF_8)));
    }
  

     public static String hmacSha256(String KEY, String VALUE) {
        return hmacSha(KEY, VALUE, "HmacSHA256");
    }

    private static String hmacSha(String KEY, String VALUE, String SHA_TYPE) {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(KEY.getBytes("UTF-8"), SHA_TYPE);
            Mac mac = Mac.getInstance(SHA_TYPE);
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(VALUE.getBytes("UTF-8"));

            byte[] hexArray = {
                    (byte)'0', (byte)'1', (byte)'2', (byte)'3',
                    (byte)'4', (byte)'5', (byte)'6', (byte)'7',
                    (byte)'8', (byte)'9', (byte)'a', (byte)'b',
                    (byte)'c', (byte)'d', (byte)'e', (byte)'f'
            };
            byte[] hexChars = new byte[rawHmac.length * 2];
            for ( int j = 0; j < rawHmac.length; j++ ) {
                int v = rawHmac[j] & 0xFF;
                hexChars[j * 2] = hexArray[v >>> 4];
                hexChars[j * 2 + 1] = hexArray[v & 0x0F];
            }
            return new String(hexChars);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    
    
     /**
     * Returns a hexadecimal encoded SHA-256 hash for the input String.
     * @param data
     * @return 
     */
    public static String getSHA256Hash(String data) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return bytesToHex(hash); // make it printable
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
        /**
     * gets the AES encryption key. In your actual programs, this should be safely
     * stored.
     * @return
     * @throws Exception 
     */
    public static SecretKey getSecretEncryptionKey() throws Exception{
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(128); // The AES key size in number of bits
        SecretKey secKey = generator.generateKey();
        return secKey;
    }
    
    /**
     * Encrypts plainText in AES using the secret key
     * @param plainText
     * @param secKey
     * @return
     * @throws Exception 
     */
    public static byte[] encryptText(String plainText,SecretKey secKey) throws Exception{
		// AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secKey);
        byte[] byteCipherText = aesCipher.doFinal(plainText.getBytes());
        return byteCipherText;
    }
    
    /**
     * Decrypts encrypted byte array using the key used for encryption.
     * @param byteCipherText
     * @param secKey
     * @return
     * @throws Exception 
     */
    public static String decryptText(byte[] byteCipherText, SecretKey secKey) throws Exception {
		// AES defaults to AES/ECB/PKCS5Padding in Java 7
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secKey);
        byte[] bytePlainText = aesCipher.doFinal(byteCipherText);
        return new String(bytePlainText);
    }
    
    /*
    public static byte[] doTheSHA throws Exception(String text)
    {

    }
    */
    
    
}
