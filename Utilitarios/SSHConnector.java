package open.gcs.sao.indexer.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHConnector {

  private static final String ENTER_KEY = "\n";
  private static final String USERNAME = "oracle11";
  private static final String HOST = "desatools.open.com.co";
  private static final int PORT = 22;
  private static final String PASSWORD = "0r411.d3$.TOOLS";

  private static Session session;

  private static void init(String username, String password, String host, int port)
      throws JSchException, IllegalAccessException {
    if (session == null || !session.isConnected()) {
      JSch jsch = new JSch();

      session = jsch.getSession(username, host, port);
      session.setPassword(password);

      // Parametro para no validar key de conexion.
      session.setConfig("StrictHostKeyChecking", "no");

      session.connect();
    } else {
      throw new IllegalAccessException("Sesion SSH ya iniciada.");
    }
  }

  public static final String executeCommand(String command)
      throws IllegalAccessException, JSchException, IOException {

    init(USERNAME, PASSWORD, HOST, PORT);
    if (session != null && session.isConnected()) {

      // Abrimos un canal SSH. Es como abrir una consola.
      ChannelExec channelExec = (ChannelExec) session.openChannel("exec");

      // Stream de lectura (Stream de entrada)
      InputStream in = channelExec.getInputStream();

      // Ejecutamos el comando.
      channelExec.setCommand(command);
      channelExec.connect();

      // Obtenemos el texto impreso en la consola.
      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
      StringBuilder builder = new StringBuilder();
      String linea;

      while ((linea = reader.readLine()) != null) {
        builder.append(linea);
        builder.append(ENTER_KEY);
      }

      // Cerramos el canal SSH.
      channelExec.disconnect();
      session.disconnect();

      // Retornamos el texto impreso en la consola.
      return builder.toString();
    } else {
      throw new IllegalAccessException("No existe sesion SSH iniciada.");
    }
  }

  public static final String executeCommand(String command, String username, String password,
      String host) throws IllegalAccessException, JSchException, IOException {

    init(username, password, host, PORT);
    if (session != null && session.isConnected()) {

      // Abrimos un canal SSH. Es como abrir una consola.
      ChannelExec channelExec = (ChannelExec) session.openChannel("exec");

      // Stream de lectura (Stream de entrada)
      InputStream in = channelExec.getInputStream();

      // Ejecutamos el comando.
      channelExec.setCommand(command);
      channelExec.connect();

      // Obtenemos el texto impreso en la consola.
      BufferedReader reader = new BufferedReader(new InputStreamReader(in));
      StringBuilder builder = new StringBuilder();
      String linea;

      while ((linea = reader.readLine()) != null) {
        builder.append(linea);
        builder.append(ENTER_KEY);
      }

      // Cerramos el canal SSH.
      channelExec.disconnect();
      session.disconnect();

      // Retornamos el texto impreso en la consola.
      return builder.toString();
    } else {
      throw new IllegalAccessException("No existe sesion SSH iniciada.");
    }
  }

  public static final void copyFile(String filePath, String dest)
      throws IllegalAccessException, JSchException {

    init(USERNAME, PASSWORD, HOST, PORT);
    if (session != null && session.isConnected()) {

      Channel channel = session.openChannel("sftp");
      channel.connect();
      ChannelSftp channelSftp = (ChannelSftp) channel;
      File file = new File(filePath);

      try {
        channelSftp.put(filePath, dest + file.getName());
      } catch (Exception e) {
        e.printStackTrace();
      }

      channelSftp.disconnect();
      session.disconnect();
    } else {
      throw new IllegalAccessException("No existe sesion SSH iniciada.");
    }
  }

  public static final void copyFile(String filePath, String dest, String username, String password,
      String host) throws JSchException, IllegalAccessException {
    init(username, password, host, PORT);
    if (session != null && session.isConnected()) {

      Channel channel = session.openChannel("sftp");
      channel.connect();
      ChannelSftp channelSftp = (ChannelSftp) channel;
      File file = new File(filePath);

      try {
        channelSftp.put(filePath, dest + file.getName());
      } catch (Exception e) {
        e.printStackTrace();
      }

      channelSftp.disconnect();
      session.disconnect();
    } else {
      throw new IllegalAccessException("No existe sesion SSH iniciada.");
    }
  }

  public static final void downloadFile(String dest, String filePath)
      throws IllegalAccessException, JSchException {
    init(USERNAME, PASSWORD, HOST, PORT);
    if (session != null && session.isConnected()) {

      Channel channel = session.openChannel("sftp");
      channel.connect();
      ChannelSftp channelSftp = (ChannelSftp) channel;
      File file = new File(filePath);

      try {
        channelSftp.get(filePath, dest + file.getName());
      } catch (Exception e) {
        e.printStackTrace();
      }

      channelSftp.disconnect();
      session.disconnect();
    } else {
      throw new IllegalAccessException("No existe sesion SSH iniciada.");
    }
  }


  public static final void downloadFile(String dest, String filePath, String username,
      String password, String host) throws IllegalAccessException, JSchException {
    init(username, password, host, PORT);
    if (session != null && session.isConnected()) {

      Channel channel = session.openChannel("sftp");
      channel.connect();
      ChannelSftp channelSftp = (ChannelSftp) channel;
      File file = new File(filePath);

      try {
        channelSftp.get(filePath, dest + file.getName());
      } catch (Exception e) {
        e.printStackTrace();
      }

      channelSftp.disconnect();
      session.disconnect();
    } else {
      throw new IllegalAccessException("No existe sesion SSH iniciada.");
    }
  }
}
