package zin.main;

import java.io.File;
import java.security.Key;
import java.util.List;

import zin.algorithm.EncryptDecrypt;
import zin.file.ZinFile;
import zin.tools.ZIO;
import zin.tools.ZinConstant;


public class ZinMain {
	static ZinFile file = new ZinFile();
	static public final String NEW_PROJ_PATH = ZinConstant.PROJECT_DIR+"\\..\\ZinNew";
	public static void main(String[] args) throws Exception {
		List<File> files = file.getAllFiles(ZinConstant.PROJECT_DIR, ".java", ".xml");
		Key key = (Key) file.readObject("key");
		for(File f : files){
			String encrypt = file.getStringFromFile(f.getAbsolutePath());
			String newFileName = f.getAbsolutePath().replace(ZinConstant.PROJECT_DIR, NEW_PROJ_PATH);
			newFileName = newFileName.replace(f.getName(), EncryptDecrypt.addAscii(f.getName(), ZIO.getRandomNumber(1, 25)));
			file.write(newFileName, encrypt);
		}
		EncryptDecrypt.getArr();
	}
}
