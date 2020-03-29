package open.gcs.sao.indexer.util;

import java.io.File;
import java.io.IOException;
import org.zeroturnaround.zip.ZipUtil;
import com.jcraft.jsch.JSchException;

public class LoadObjects {

  private static final String USERNAME = "contconf11";
  private static final String HOST = "saopvcs.open.com.co";
  private static final int PORT = 22;
  private static final String PASSWORD = "c0ntc0nf.11g";

  public static final void load() {
    // llevo la lista de objetos al servidor
    // Ejecuto el shell que crea el .zip
    String pathZip = "Fte_OpenSmarflex.zip";
    try {
      File dir = new File(Configuration.pathObjectSources);
      dir.delete();
      SSHConnector.copyFile(Configuration.pathLocal + "ListOfFiles.lst",
          Configuration.pathServerTmp, USERNAME, PASSWORD, HOST);
      SSHConnector.executeCommand("cd " + Configuration.pathServerTmp + "; sh load_objects.sh",
          USERNAME, PASSWORD, HOST);
      SSHConnector.downloadFile(Configuration.pathLocal, Configuration.pathServerTmp + pathZip,
          USERNAME, PASSWORD, HOST);

      File file = new File(Configuration.pathLocal + pathZip);
      // Extraigo el .zip
      ZipUtil.unpack(file, new File(Configuration.pathLocal));

      file.delete();

    } catch (IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (JSchException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
