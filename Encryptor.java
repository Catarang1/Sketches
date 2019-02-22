package sandbox;

public class Encryptor {

	public static Encryption SPL08;
	public static Encryption SPL16;

	public abstract class Encryption {
		private char mark;
		abstract String encrypt(String input);
		abstract String decrypt(String input);
	}

	public static String encrypt(String string, Encryption... encryptions) {
		for(int i = 0; i < encryptions.length; i++) string = encryptions[i].encrypt(string);
		return string;
	}

	public static String decrypt(String string, Encryption... encryptions) {
		for (int i = encryptions.length-1; i > -1; i--) string = encryptions[i].decrypt(string);
		return string;
	}

	static {
		SPL08 = new ShiftBasedEncryption(8, '8');
		SPL16 = new ShiftBasedEncryption(16,'6');
	}
	
	private static class ShiftBasedEncryption extends Encryption{
		private int shift;
		private ShiftBasedEncryption(int shift, char mark) {this.shift = shift;super.mark = mark;}
		private int getShift() {return shift;}

		@Override public String encrypt(String input){
			char[] a = input.toCharArray();
			for (int i = 0; i < a.length; i++) a[i] += getShift()*3;
			return new String(a);
		}

		@Override public String decrypt(String input){
			char[] a = input.toCharArray();
			for (int i = 0; i < a.length; i++) a[i] -= getShift()*3;
			return new String(a);
		};
	}
}
