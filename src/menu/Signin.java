package menu;

import java.awt.event.ActionEvent;
import java.util.HashMap;

import menu.LOGIN.*;

	

public class Signin {

	public static HashMap<String, String> loginInfo = new HashMap<String, String>() {{
		put("BDDAdmin", "TPAdmin"); put("Etudiant", "TPEtudiant"); put("Enseignant", "TPEnseignant");}};
	
	
	public static boolean checkUsr (String pwd) {
		if (pwd.compareTo("BDDAdmin")==0) return true;
		if (pwd.compareTo("Etudiant")==0) return true;
		if (pwd.compareTo("Enseignant")==0) return true;
		else return false;

	}

	
	public static boolean checkPwd (String pwd) {
		if (pwd.compareTo("admin")==0) return true;
		if (pwd.compareTo("etudiant")==0) return true;
		if (pwd.compareTo("enseignant")==0) return true;
		else return false;

	}
	
}
